package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import model.Endereco;

public class ApiService {
    private static final String endereco="https://viacep.com.br/ws/";

    public Endereco buscaCep(String pesquisa) throws IOException, InterruptedException{
        return conectaApi(pesquisa);
    }

    private Endereco converteEndereco(String result){
        //Convertendo o resultado em objeto
        Gson gson = new Gson();
        var endereco = gson.fromJson(result, Endereco.class);
        return endereco;
    }
    private Endereco conectaApi(String cep) throws IOException, InterruptedException{
        // Efetuando acesso a api
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco.concat(cep).concat("/json")))
                        .build();

       HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
       return converteEndereco(response.body());
    }
}
