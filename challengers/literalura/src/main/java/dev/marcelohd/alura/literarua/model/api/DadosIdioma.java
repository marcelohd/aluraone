package dev.marcelohd.alura.literarua.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DadosIdioma(
    @JsonAlias(value = "languages") List<String> nomeIdioma
) { }