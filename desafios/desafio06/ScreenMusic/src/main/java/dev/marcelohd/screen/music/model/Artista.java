package dev.marcelohd.screen.music.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity (name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID  id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @OneToMany(mappedBy = "artista",fetch = FetchType.EAGER,targetEntity = Album.class)
    @Cascade(CascadeType.ALL)
    private Set<Album> discografia = new HashSet<>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Genero getGenero() {
        return genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public Set<Album> getDiscografia() {
        return discografia;
    }
    
    public void setDiscografia(Set<Album> discografia) {
        this.discografia = discografia;
    }

    @Override
    public String toString() {
        return "Artista [nome=" + nome + ", genero=" + genero + ", discografia="
                + discografia + "]";
    }

    
    
}
