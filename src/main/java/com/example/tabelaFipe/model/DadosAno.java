package com.example.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAno(@JsonAlias("codigo") String codigo,
                       @JsonAlias("nome") String nome) {

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nome: " + nome + "\n";
    }
}
