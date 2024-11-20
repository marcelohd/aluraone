package br.dev.marcelohd.conversor.moedas.controller;

import br.dev.marcelohd.conversor.moedas.dominio.CurrencyCode;
import br.dev.marcelohd.conversor.moedas.service.ExchangeRateService;

public class Conversor {
    
    private ExchangeRateService exchangeRateService;

    public Conversor(){
        this.exchangeRateService = new ExchangeRateService();
    }

    public void converte(String currencyBase,String currencyTarget, Double amount){
        exchangeRateService.doConversion(currencyBase, currencyTarget, amount);
    }

    public void currencySupported(){
        System.out.println("\nMoedas suportadas\n");
        for (CurrencyCode currency : exchangeRateService.currencySupported()) {
            System.out.println("Codigo : " + currency.getCode() + " - Nome : " + currency.getName());
        }
    }

    public void showLogs(){
        exchangeRateService.writeLogFile();
    }
}
