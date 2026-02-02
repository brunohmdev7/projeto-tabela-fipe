package com.example.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(@JsonAlias("Valor") String valor,
                           @JsonAlias("Marca") String marca,
                           @JsonAlias("Modelo") String modelo,
                           @JsonAlias("AnoModelo") Integer ano,
                           @JsonAlias("Combustivel") String combustivel) {

    @Override
    public String toString() {
        return "== Dados do veículo == \n" +
                "Valor: " + valor + "\n" +
                "Marca: " + marca +"\n" +
                "Modelo: " + modelo +"\n" +
                "Ano: " +  ano +"\n" +
                "Combustível: " + combustivel + "\n";
    }
}
