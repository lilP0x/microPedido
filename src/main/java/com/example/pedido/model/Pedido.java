package com.example.pedido.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;

    @ElementCollection  // Permite almacenar una lista de elementos primitivos en JPA
    private List<Long> productosIds = new ArrayList<>();

    // Constructores
    public Pedido() {}

    public Pedido(String cliente, List<Long> productosIds) {
        this.cliente = cliente;
        this.productosIds = productosIds;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Long> getProductosIds() {
        return productosIds;
    }

    public void setProductosIds(List<Long> productosIds) {
        this.productosIds = productosIds;
    }
}
