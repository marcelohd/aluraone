package br.dev.marcelohd.compra.modelo;

public class CartaoCredito {
    
    private double limite;
    private double saldo;

    public CartaoCredito(double limite){
        if(limite <= 0){
            System.out.println("Valor de limite invalido");
        } else {
            this.limite = limite;
            this.saldo = limite;
        }
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void getSaldoPorMensagem(){
        System.out.println("Saldo do cartão: R$ " + this.saldo);
    }

    protected void valorUtilizadoNaCompra(double valor){
        saldo -= valor;
    }



}
