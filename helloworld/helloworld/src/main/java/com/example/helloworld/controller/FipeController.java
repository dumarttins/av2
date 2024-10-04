package com.example.helloworld.controller;

import com.example.helloworld.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FipeController {

    @Autowired
    private FipeService fipeService;

    // Endpoint para obter a lista de marcas
    @GetMapping("/marcas")
    public Mono<String> getMarcas() {
        return fipeService.getMarcas();
    }

    // Endpoint para obter modelos de uma marca específica
    @GetMapping("/marcas/{marcaId}/modelos")
    public Mono<String> getModelosByMarca(@PathVariable String marcaId) {
        return fipeService.getModelosByMarca(marcaId);
    }

    // Endpoint para consultar os anos de um modelo específico
    @GetMapping("/marcas/{marcaId}/modelos/{modeloId}/anos/{ano}")
    public Mono<String> getAnoByModelo(
            @PathVariable String marcaId,
            @PathVariable String modeloId,
            @PathVariable String ano) {
        return fipeService.getAnoByModelo(marcaId, modeloId, ano);
    }
}
