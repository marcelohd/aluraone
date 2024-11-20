package br.dev.marcelohd.conversor.moedas;

import java.util.Scanner;

import br.dev.marcelohd.conversor.moedas.controller.Conversor;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Conversor conversor = new Conversor();

        int opcao = 0;
        double amount = 0;
        
        while(opcao!=9){
            menu();
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor que deseja converter :");
                    amount = input.nextDouble();
                    conversor.converte("USD","ARS",amount);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja converter :");
                    amount = input.nextDouble();
                    conversor.converte("ARS","USD",amount);
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja converter :");
                    amount = input.nextDouble();
                    conversor.converte("USD","BRL",amount);
                    break;
                case 4:
                    System.out.println("Digite o valor que deseja converter :");
                    amount = input.nextDouble();
                    conversor.converte("BRL","USD",amount);
                    break;
                case 5:
                    System.out.println("Digite o valor que deseja converter :");
                    amount = input.nextDouble();
                    conversor.converte("USD","COP",amount);
                    break;
                case 6:
                    System.out.println("Digite o valor que deseja converter :");
                    amount = input.nextDouble();
                    conversor.converte("COP","USD",amount);
                    break;
                case 7:
                    System.out.println("Verifique os codigos disponiveis no menu escolhendo a 8");
                    System.out.println("Digite o codigo da moeda base que deseja converter : ex USD");
                    String base = input.next();
                    System.out.println("Digite o codigo da moeda alvo que deseja converter : ex BRL");
                    String alvo = input.next();
                    System.out.println("Digite o valor que deseja converter :");
                    amount = input.nextDouble();
                    conversor.converte(base, alvo, amount);
                    break;
                
                case 8:
                    conversor.currencySupported();
                    break;
                case 9:
                    conversor.showLogs();
                    System.out.println("Arquivo de logs criado na pasta");
                    
                    break;
            
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }


    public static void menu(){
    
        System.out.println("***************************************************************************************");
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]\n\n");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileiro");
        System.out.println("4) Real brasileiro =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Conversao personalizada De Para");
        System.out.println("8) Moedas suportadas");
        System.out.println("9) Sair");
        System.out.println("***************************************************************************************\n\n");
    }
}
