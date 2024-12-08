package dev.marcelohd.tabela_fip.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Modelo {

    private List<Dados> modelos = new ArrayList<>();
    private List<Dados> anos = new ArrayList<>();

    public List<Dados> getModelos() {
        return modelos;
    }

    public void setModelos(List<Dados> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "modelos=" + modelos +
                '}';
    }
}
