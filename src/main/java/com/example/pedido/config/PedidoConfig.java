package com.example.pedido.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PedidoConfig {

    @Value("http://localhost:8081/productos")
    private String productoServiceUrl;

    @Bean
    public WebClient productoWebClient(WebClient.Builder builder) {
        return builder.baseUrl(productoServiceUrl).build();
    }
}
