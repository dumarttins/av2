package com.example.helloworld.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FipeService {

    private final WebClient webClient;

    public FipeService() {
        this.webClient = WebClient.builder()
            .baseUrl("https://parallelum.com.br/fipe/api/v1/carros")
            .build();
    }

    // Método para obter a lista de marcas
    public Mono<String> getMarcas() {
        return this.webClient
            .get()
            .uri("/marcas")
            .retrieve()
            .bodyToMono(String.class);
    }

    // Método para obter modelos de uma marca específica
    public Mono<String> getModelosByMarca(String marcaId) {
        return this.webClient
            .get()
            .uri("/marcas/{marcaId}/modelos", marcaId)
            .retrieve()
            .bodyToMono(String.class);
    }

    // Método para consultar os anos de um modelo específico
    public Mono<String> getAnoByModelo(String marcaId, String modeloId, String ano) {
        return this.webClient
            .get()
            .uri("/marcas/{marcaId}/modelos/{modeloId}/anos/{ano}", marcaId, modeloId, ano)
            .retrieve()
            .bodyToMono(String.class);
    }
}
