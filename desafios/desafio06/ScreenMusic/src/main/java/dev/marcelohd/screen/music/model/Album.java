package dev.marcelohd.screen.music.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "albuns")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID  id;
    @ManyToOne
    private Artista artista;
    private String nomeAlbum;
    @Enumerated(EnumType.STRING)
    private TipoAlbum  tipoAlbum;
    private LocalDate anoAlbum;
    private String nomeGravadora;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Musica.class)
    private Set<Musica> musicas = new HashSet<>();

    public Album(){ }

    public Album(Artista artista, String nomeAlbum, TipoAlbum tipoAlbum, String nomeGravadora1) {
        this.artista = artista;
        this.nomeAlbum = nomeAlbum;
        this.anoAlbum = LocalDate.now();
        this.tipoAlbum = tipoAlbum;
        this.nomeGravadora = nomeGravadora;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Artista getArtista() {
        return artista;
    }
    
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    public String getNomeAlbum() {
        return nomeAlbum;
    }
    
    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }
    
    public TipoAlbum getTipoAlbum() {
        return tipoAlbum;
    }
    
    public void setTipoAlbum(TipoAlbum tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }
    
    public LocalDate getAnoAlbum() {
        return anoAlbum;
    }
    
    public void setAnoLancamento(LocalDate anoAlbum) {
        this.anoAlbum = anoAlbum;
    }
    
    public String getNomeGravadora() {
        return nomeGravadora;
    }
    
    public void setNomeGravadora(String nomeGravadora) {
        this.nomeGravadora = nomeGravadora;
    }
    
    public Set<Musica> getMusicas() {
        return musicas;
    }
    
    public void setMusicas(Set<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return " nomeAlbum=" + nomeAlbum + ", tipoAlbum=" + tipoAlbum
                + ", anoLancamento=" + anoAlbum + ", gravadora=" + nomeGravadora + ", musicas=" + musicas + "]";
    }

    

}
