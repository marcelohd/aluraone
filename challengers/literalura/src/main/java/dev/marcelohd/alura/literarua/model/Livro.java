package dev.marcelohd.alura.literarua.model;

import dev.marcelohd.alura.literarua.model.api.DadosGutendex;
import dev.marcelohd.alura.literarua.model.api.DadosLivro;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity (name = "livros")
public class Livro {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "livro")
    private List<Autor> autores;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "livro")
    private List<Idioma> idiomas;
    private Integer downloads;

    public Livro(){ }

    public Livro(DadosLivro livro){
        this.titulo = livro.titulo();
        this.autores = livro.autores().stream().map( a -> new Autor(a.nomeAutor(),this,a.anoNascimento(), a.anoFalecimento())).collect(Collectors.toList());
        this.idiomas = livro.idiomas().stream().map( id -> new Idioma(id,this)).collect(Collectors.toList());
        this.downloads = livro.downloads();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutor(List<Autor> autor) {
        this.autores = autor;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        String joinIdiomas = " ";
        String joinAtores = " ";
        if(getAutores().size()==1){
            joinAtores = getAutores().get(0).getNome();
        } else {
            joinIdiomas = getAutores().stream()
                    .map(autor -> autor.getNome())
                    .collect(Collectors.joining("- "));
        }

        if(getIdiomas().size() == 1){
            joinIdiomas = getIdiomas().get(0).getNomeIdioma();
        } else {
            joinIdiomas = getIdiomas().stream()
                                      .map(idioma -> idioma.getNomeIdioma())
                                      .collect(Collectors.joining(", "));
        }
          return
                "---------------- LIVRO  ---------------\n"+
                "Titulo=" + titulo + '\n' +
                "Autor=" + joinAtores + '\n' +
                "Idiomas=" + joinIdiomas + '\n' +
                "Número de downloads=" + downloads+ + '\n' +
                "\n---------------------------------------\n";
    }
}
