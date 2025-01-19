package dev.marcelohd.alura.literarua.service;

import dev.marcelohd.alura.literarua.model.Livro;
import dev.marcelohd.alura.literarua.model.api.DadosGutendex;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class InternetConnector {
    private static final String URL = "https://gutendex.com/books/?search=";

     public Livro obterDados(String busca) {
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL+busca.replace(" ", "%20")))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        String json = response.body();
        JsonToClass j = new JsonToClass();
        var t = j.converte(json,DadosGutendex.class);
        //System.out.println(t.livros().get(0).toString());

        return new Livro(t.livros().get(0));
    }


}