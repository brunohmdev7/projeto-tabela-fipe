package com.example.tabelaFipe.app;

import com.example.tabelaFipe.model.DadosMarca;
import com.example.tabelaFipe.service.ConsumoApi;
import com.example.tabelaFipe.service.ConverteDados;

import java.util.Scanner;

public class Application {
    Scanner teclado = new Scanner(System.in);
    private String urlBase = "https://parallelum.com.br/fipe/api/v1/";
    ConsumoApi consumoApi = new ConsumoApi();
    ConverteDados conversor =  new ConverteDados();

    public void menuPrincipal() {
        System.out.println("---MENU---");
        System.out.println("Selecione a opção abaixo que você deseja consultar:");
        System.out.println("1. Carros");
        System.out.println("2. Motos");
        System.out.println("3. Caminhões\n");

        String opcaoVeiculo =  teclado.nextLine();
        urlBase += opcaoVeiculo.toLowerCase();
        urlBase += "/marcas";

        var json = conversor.converteDados(consumoApi.consumir(urlBase), DadosMarca.class);

    }
}
