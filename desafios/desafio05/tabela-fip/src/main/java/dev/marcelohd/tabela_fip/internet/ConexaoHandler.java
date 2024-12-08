package dev.marcelohd.tabela_fip.internet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoHandler {

    public String[] requisicao (String target){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = null;
        HttpResponse<String> httpResponse = null;
        try {
            httpRequest = HttpRequest.newBuilder().uri(new URI(target)).build();
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        return new String[]{String.valueOf(httpResponse.statusCode()),httpResponse.body()};
    }
}
