package dev.marcelohd.tabela_fip.main;

import dev.marcelohd.tabela_fip.internet.RequisicoesVeiculos;
import dev.marcelohd.tabela_fip.modelo.Dados;
import dev.marcelohd.tabela_fip.modelo.Veiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    RequisicoesVeiculos requisicoesVeiculos = new RequisicoesVeiculos();
    Scanner teclado = new Scanner(System.in);

    public void iniciar() {
        exibeMenu();
        String opcao = teclado.nextLine().toLowerCase();
        if(opcao.length()>=3) {
            if (opcao.contains("car")) {
                opcao = "carros";
            } else if (opcao.contains("mot")) {
                opcao = "motos";
            } else {
                opcao = "caminhoes";
            }
            marcas(opcao);
            modelos();
            anosAvaliacao();
        } else {
            System.out.println("Digite ao menos 3 caractres das opcoes");
        }

    }

    public void exibeMenu(){
        System.out.println("********************************************************************************************");
        System.out.println("**************************                    OPÇÕES                   *********************");
        System.out.println("********************************************************************************************");
        System.out.println("Carros \nMotos \nCaminhoes ");
        System.out.println("********************************************************************************************");
        System.out.println("Digite uma das opções para consultar : ");
    }

    private void marcas(String opcao){
        var marcas = requisicoesVeiculos.buscarMarcas(opcao);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::getCodigo))
                .forEach(v -> System.out.println("Cód : " + v.getCodigo() + " Descrição : " + v.getNome()));
    }

    private void modelos(){
        System.out.println("Informe o código da marca para consulta : ");
        String modelo = teclado.nextLine().toLowerCase();
        var modelos = requisicoesVeiculos.buscarModelos(Integer.valueOf(modelo));

        modelos.getModelos().stream()
                .sorted(Comparator.comparing(Dados::getCodigo))
                .forEach(v -> System.out.println("Cód : " + v.getCodigo() + " Descrição : " + v.getNome()));


        System.out.println("Informe o nome do modelo para consulta : ");
        String busca = teclado.nextLine().toLowerCase();

        List<Dados> filtrados = modelos.getModelos().stream()
                .filter(b -> b.getNome().toUpperCase().contains(busca.toUpperCase()))
                .collect(Collectors.toList());

        filtrados.stream()
                .sorted(Comparator.comparing(Dados::getCodigo))
                .forEach(v -> System.out.println("Cód : " + v.getCodigo() + " Descrição : " + v.getNome()));
    }

    private void anosAvaliacao(){
        System.out.println("Informe o código da modelo para consulta : ");
        String anoModelo = teclado.nextLine().toLowerCase();
        var anos = requisicoesVeiculos.buscarAnoAvaliacoes(Integer.valueOf(anoModelo));
        //anos.stream().forEach(a -> System.out.println("Cód : " + a.getCodigo() + " Descrição : " + a.getNome()));

        List<Veiculo> veiculos = new ArrayList<>();
        for(int i = 0; i < anos.size(); i ++){
            veiculos.add(veiculos(anos.get(i).getCodigo()));
        }
        System.out.println("Todos os veiculos filtrados com avaliações por ano");
        veiculos.stream().forEach(System.out::println);
    }

    private Veiculo veiculos(String anoVeiculo){
        return requisicoesVeiculos.buscarVeiculoPorAno(anoVeiculo);
    }
}
