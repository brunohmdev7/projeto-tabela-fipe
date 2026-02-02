package com.example.tabelaFipe.app;

import com.example.tabelaFipe.model.*;
import com.example.tabelaFipe.service.ConsumoApi;
import com.example.tabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
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
        var jsonMarcas = conversor.obterLista(consumoApi.consumir(urlBase), DadosMarca.class);
        System.out.println(jsonMarcas.toString());

        System.out.println("Digite o código da marca escolhida: \n");
        String codigoMarca = teclado.nextLine();
        urlBase += "/" + codigoMarca + "/modelos";
        var jsonModelos = consumoApi.consumir(urlBase);
        DadosModelo dadosModelo = conversor.converteDados(jsonModelos, DadosModelo.class);
        System.out.println(dadosModelo.toString());

        System.out.println("Digite o nome do modelo que deseja consultar: ");
        String nomeModelo = teclado.nextLine();
        List<Modelo> modelosEncontrados;
        modelosEncontrados = dadosModelo.buscarNomeModelo(nomeModelo);
        modelosEncontrados.forEach(System.out::println);

        System.out.println("Digite o código do modelo escolhido: ");
        int codigoModelo = teclado.nextInt();
        teclado.nextLine();
        urlBase += "/" + codigoModelo + "/anos";
        var jsonAnos = consumoApi.consumir(urlBase);
        List<CodigoAno> codigosAnos = conversor.obterLista(jsonAnos, CodigoAno.class);
        List<DadosVeiculo> veiculosSelecionados = new ArrayList<>();
        String resetUrl = urlBase;
        for (CodigoAno codigoAno : codigosAnos) {
            urlBase = resetUrl;
            urlBase += "/" + codigoAno;
            var jsonVeiculo = consumoApi.consumir(urlBase);
            DadosVeiculo dadosVeiculo = conversor.converteDados(jsonVeiculo, DadosVeiculo.class);
            veiculosSelecionados.add(dadosVeiculo);
        }

        veiculosSelecionados.forEach(System.out::println);



    }
}
