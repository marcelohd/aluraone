package br.dev.marcelohd.compra.principal;

import java.util.Scanner;

import br.dev.marcelohd.compra.modelo.CartaoCredito;
import br.dev.marcelohd.compra.modelo.Compra;
import br.dev.marcelohd.compra.modelo.Produto;

public class PrincipalOO{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o limite do cartão :");
        Double limite = entrada.nextDouble();

        CartaoCredito cartaoCredito = new CartaoCredito(limite);
        Compra compra = new Compra(cartaoCredito);
        int opc = 1;
        while (opc != 0) {
            System.out.println("Digite a descricao da compra");
            String nomeProduto = entrada.next();
            System.out.println("Digite o valor da compra");
            Double precoProduto = entrada.nextDouble();
            Produto produto = new Produto(nomeProduto, precoProduto);
            compra.realizarCompra(produto);
            System.out.println("Digite (0) para sair ou (1) para continuar");
            opc = entrada.nextInt();

            if(opc == 0){
                compra.getCarrinhoOrdenadoPorValor();
                cartaoCredito.getSaldoPorMensagem();
            }
        } 
    }
}