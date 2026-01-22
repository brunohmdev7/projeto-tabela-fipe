package com.example.tabelaFipe.service;

public interface IConverteDados {
    <T> T converteDados(String json, Class<T> classe);
}
