package br.dev.marcelohd.conversor.moedas.util;

import java.time.LocalDateTime;

import br.dev.marcelohd.conversor.moedas.dominio.Currency;

public class Log {

    public Currency currency;
    public double amount;
    public double result;
    private String data;
    
    public Currency getCurrency() {
        return currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    } 

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }
    
}
