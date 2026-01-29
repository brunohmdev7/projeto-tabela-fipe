package com.example.tabelaFipe.model;

public class Modelo {
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

