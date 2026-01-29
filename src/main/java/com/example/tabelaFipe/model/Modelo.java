package com.example.tabelaFipe.model;

import java.util.List;

public class Modelo {
    private List<String> modelos;
    private int codigo;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nome: " + nome + "\n";
    }
}

