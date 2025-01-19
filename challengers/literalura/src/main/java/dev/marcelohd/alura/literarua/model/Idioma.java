package dev.marcelohd.alura.literarua.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity (name = "idioma")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nomeIdioma;
    @ManyToOne
    private Livro livro;

    public Idioma(){}

    public Idioma(String nomeIdioma, Livro livro){
        this.nomeIdioma = nomeIdioma;
        this.livro = livro;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeIdioma() {
        return nomeIdioma;
    }

    public void setNomeIdioma(String nomeIdioma) {
        this.nomeIdioma = nomeIdioma;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }


}
