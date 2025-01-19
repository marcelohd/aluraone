package dev.marcelohd.alura.literarua.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DadosAutor(
    @JsonAlias(value = "name") String nomeAutor,
    @JsonAlias(value = "birth_year") String anoNascimento,
    @JsonAlias(value = "death_year") String anoFalecimento
    ) { }