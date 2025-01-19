package dev.marcelohd.alura.literarua.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.marcelohd.alura.literarua.model.Idioma;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
        @JsonAlias(value = "title") String titulo,
        @JsonAlias(value = "authors") List<DadosAutor> autores,
        @JsonAlias(value = "languages") List<String> idiomas,
        @JsonAlias(value = "download_count") Integer downloads
) { }