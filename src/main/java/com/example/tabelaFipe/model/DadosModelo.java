package com.example.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelo(@JsonAlias("modelos") List<Modelo> modelos) {

    @Override
    public String toString() {
        return modelos.stream()
                .map(Modelo::toString)
                .collect(Collectors.joining(", "));
    }
}

