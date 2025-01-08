package dev.marcelohd.screen.music.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID  id;
    private String titulo;
    @ManyToOne
    private Album album;


    public Musica(){}

    public Musica(String nomeMusica, Album album) {
        this.titulo = nomeMusica;
        this.album = album;
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
    
    public Album getAlbum() {
        return album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Artista= " + album.getArtista().getNome() +", nome=" + titulo +  ", album=" + album.getNomeAlbum();
    }
    


    
}
