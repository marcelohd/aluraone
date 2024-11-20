package br.dev.marcelohd.conversor.moedas.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.dev.marcelohd.conversor.moedas.dominio.CurrencyCode;
import br.dev.marcelohd.conversor.moedas.dominio.CurrencyCodeDTO;
import br.dev.marcelohd.conversor.moedas.util.Log;
import br.dev.marcelohd.conversor.moedas.dominio.Currency;

public class ExchangeRateService {
    private List<Log> logs;
    private static final String URL = "https://v6.exchangerate-api.com/v6/";
    private static final String PATH_CODE = "/codes";
    private static final String API_KEY = "afd4ed7db1b3670efd0a0e41";// "your_api_key";

    public ExchangeRateService(){
        this.logs = new ArrayList<>();
    }

    public void doConversion(String moedaBase, String moedaDestino, Double quantidade){
        Log log = new Log();
        String responde = doRequest(URL+API_KEY+"/pair/"+moedaBase+"/"+moedaDestino+"/");
        var moeda = new Gson().fromJson(responde, Currency.class);
        Double resultConversion = calc(quantidade, moeda.getConversion_rate());

        System.out.printf("Valor %s [%s] corresponde ao valor final de =>>> %s [%s]\n",quantidade,moeda.getCurrencyBase(),resultConversion,moeda.getCurrencyTarget());
    
        log.setCurrency(moeda);
        log.setAmount(quantidade);
        log.setResult(resultConversion);
        log.setData(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        logs.add(log);
    
    }


    public List<CurrencyCode> currencySupported(){
        String response = doRequest(URL+API_KEY+PATH_CODE);
        List<CurrencyCode> currencyCodes = new ArrayList<>();
        CurrencyCodeDTO currencyCodeDTO = new Gson().fromJson(response, CurrencyCodeDTO.class);

        List<List<String>> listaLista = currencyCodeDTO.getSupported_codes();
        
        for (List<String> lista : listaLista) {
            CurrencyCode currencyCode = new CurrencyCode(lista.get(0),lista.get(1));
            currencyCodes.add(currencyCode);
        }

        return currencyCodes;
        
    }

    //A API JA FAZ A CONVERSAO DE UM DERTERMINADO VALOR
    private Currency directConversion(String moedaBase, String moedaDestino, double quantidade){
        String resposta =  doRequest(URL+API_KEY+"/pair/"+moedaBase+"/"+moedaDestino+"/"+String.valueOf(quantidade));

        return new Gson().fromJson(resposta, Currency.class);
    }

    // Faz requisicao
    private String doRequest(String URL){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;
        HttpResponse<String> response;
        String body = "";
        try {
            request = HttpRequest.newBuilder().uri(new URI(URL)).build();
            response = httpClient.send(request, BodyHandlers.ofString());
            body = response.body().toString();
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return body;
    }

    private Double calc(Double amount, Double rating){
        return amount * rating;
    }

    public void writeLogFile(){
        String nameFile = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))+".txt";
        try {
            FileWriter fileWriter = new FileWriter(nameFile);
            for (Log l : logs) {
                String linha = ("No dia " + l.getData() + " foi realizado a conversao de " + l.getCurrency().getCurrencyBase() + " para " + l.getCurrency().getCurrencyTarget() +" Cotacao do dia " +
                l.getCurrency().getConversion_rate() + " quantidade a converter " + l.getAmount() + " valor da conversão " + l.result +"\n");
                fileWriter.write(linha);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
