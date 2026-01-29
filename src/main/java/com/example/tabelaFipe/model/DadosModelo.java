package com.example.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelo(@JsonAlias("modelos") List<Modelo> modelos) {

    public List<Modelo> buscarNomeModelo(String nomeModelo) {
        return modelos.stream()
                .filter(m -> m.getNome().toLowerCase().contains(nomeModelo.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return modelos.stream()
                .map(Modelo::toString)
                .collect(Collectors.joining(", "));
    }
}

