package com.example.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CodigoAno(@JsonAlias("codigo") String codigo) {

    @Override
    public String toString() {
        return codigo;
    }
}
