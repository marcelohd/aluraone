package br.dev.marcelohd.compra.modelo;

public class Produto implements Comparable<Produto> {

    private String nome;
    private double preco;

    public Produto(String nome,double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return this.getNome().compareTo(outroProduto.getNome());
    }

    @Override
    public String toString() {
        return "Descricao = " + nome.toUpperCase() + ", preco R$" + preco;
    }

    
}
