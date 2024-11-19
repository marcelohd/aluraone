package br.dev.marcelohd.compra.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Carrinho {

    private List<Produto> lista;// lista de produtos

    public Carrinho(){
        this.lista = new ArrayList<>();
    }
    public void add(Produto produto){
        lista.add(produto);
    }

    public void remove(Produto produto){
        if (lista.size() > 0) {
            lista.remove(produto);
        } else{
            System.out.println("Carrinho vazio");
        }   
    }

    public void ordenarPorNome(){
        Collections.sort(this.lista);
    }

    public void ordenarPorValor(){
        this.lista.sort(Comparator.comparing(Produto::getPreco));
    }

    public double getValorTotal(){
        double total = 0;
        if (!lista.isEmpty()) {
            for (Produto produto : lista) {
                total += produto.getPreco(); 
            }
        }
        return total;
    }

    public void imprimeLista(){
        System.out.println();
        if(!lista.isEmpty()){
            System.out.println("************************************************************");
            System.out.println("                   COMPRAS REALIZADAS :                     \n");
            for (Produto produto : lista) {
                System.out.println(produto);
            }
            System.out.println("\n************************************************************\n");
        }   
    }
}
