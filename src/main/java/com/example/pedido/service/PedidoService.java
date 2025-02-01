package com.example.pedido.service;

import com.example.pedido.client.ProductoClient;
import com.example.pedido.model.Pedido;
import com.example.pedido.repository.PedidoRepository;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoClient productoClient;

    public Pedido crearPedido(Pedido pedido) {
        for (Long idProducto : pedido.getProductosIds()) {
            Mono<String> producto = productoClient.obtenerProducto(idProducto);

            producto.subscribe(response -> System.out.println("Producto encontrado: " + response),
                               error -> System.out.println("Error al obtener producto: " + error.getMessage()));
        }

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }
}
