package br.dev.marcelohd.compra.principal;

import java.util.Scanner;

import br.dev.marcelohd.compra.modelo.Carrinho;
import br.dev.marcelohd.compra.modelo.Produto;

public class PrincipalNormal {

    public static void main(String[] args) throws Exception {
        // Instanciando objeto para pegar a entrada do teclado
        Scanner entrada = new Scanner(System.in);
        // Criando um novo produto
        Produto produto;
        // Criando e instanciando um novo carrinho
        Carrinho carrinho = new Carrinho();

        int opc = 1;
        System.out.println("Digite o limite do cartão :");
        Double limite = entrada.nextDouble();
        // Se o valor do cartao de credito for menor ou igual a zero a compra nao
        // ocorrerá

        if (limite > 0) {
            while(opc!=0){
                        System.out.println("Digite a descricao da compra");
                        String nomeProduto = entrada.next();
                        System.out.println("Digite o valor da compra");
                        Double precoProduto = entrada.nextDouble();
                        if ((carrinho.getValorTotal() + precoProduto) <= limite) {
                            if (precoProduto > 0 && !nomeProduto.isEmpty()) {
                                System.out.println("Compra realizada !!");
                                produto = new Produto(nomeProduto, precoProduto);
                                carrinho.add(produto);
                                limite -= produto.getPreco();
                            } else {
                                System.out.println("Valor ou descricao invalido");
                            }
                        } else {
                            System.out.println("Compra nao realizada, valor excede o limite do cartao");
                            carrinho.ordenarPorValor();
                            carrinho.imprimeLista();
                            System.out.println("SALDO DO CARTÃO R$ :" + limite);
                        }

                System.out.println("Digite (0) para sair ou (1) para continuar");
                opc = entrada.nextInt();
                if(opc == 0) {
                    carrinho.ordenarPorValor();
                    carrinho.imprimeLista();
                }
            } //while (opc != 0);

        } else {
            System.out.println("Limite invalido");
        }

    }
}