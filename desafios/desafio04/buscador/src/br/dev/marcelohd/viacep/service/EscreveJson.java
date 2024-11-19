package service;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Endereco;

public class EscreveJson {
    
    public void escreverJson(Endereco endereco){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter escritor = new FileWriter(endereco.getCep().concat(".json"));
            escritor.write(gson.toJson(endereco));
            escritor.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
