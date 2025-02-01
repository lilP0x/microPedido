package com.example.pedido.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductoClient {
    private final WebClient webClient;

    // Constructor para configurar la URL base del otro microservicio
    public ProductoClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/productos").build();
    }

    // Método para obtener un producto por su ID
    public Mono<String> obtenerProducto(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }
}
