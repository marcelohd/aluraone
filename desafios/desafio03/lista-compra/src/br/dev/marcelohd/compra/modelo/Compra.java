package br.dev.marcelohd.compra.modelo;

public class Compra {
    
    private Carrinho carrinho;
    private CartaoCredito cartaoCredito;

    public Compra (CartaoCredito cartaoCredito){
        this.carrinho = new Carrinho();
        this.cartaoCredito = cartaoCredito;
    }

    public void realizarCompra(Produto produto){
     if(cartaoCredito.getSaldo() > produto.getPreco()){
      //if((carrinho.getValorTotal() + produto.getPreco()) <= cartaoCredito.getLimite()){
        carrinho.add(produto);
        cartaoCredito.valorUtilizadoNaCompra(produto.getPreco());
        System.out.println("Compra realizada com sucesso!");
      } else {
        System.out.println("Saldo insuficiente");
        carrinho.imprimeLista();
        cartaoCredito.getSaldoPorMensagem();
      }
    }

    public void getCarrinhoOrdenadoPorValor(){
        carrinho.ordenarPorValor();
        carrinho.imprimeLista();
    }

    public void getCarrinhoOrdenadoPorNome(){
        carrinho.ordenarPorNome();
        carrinho.imprimeLista();
    }

    
}
