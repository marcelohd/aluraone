package br.dev.marcelohd.conversor.moedas.dominio;

import java.util.List;

public class CurrencyCodeDTO {

    private List<List<String>> supported_codes;

    public List<List<String>> getSupported_codes() {
        return supported_codes;
    }

}
