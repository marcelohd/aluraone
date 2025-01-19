package dev.marcelohd.alura.literarua.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToClass {
    private ObjectMapper mapper = new ObjectMapper();

    public  <T> T converte(String json, Class<T> classe){
        try{
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e){
            throw  new RuntimeException(e);
        }
    }
}
