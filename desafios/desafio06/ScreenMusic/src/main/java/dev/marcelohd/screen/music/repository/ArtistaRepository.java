package dev.marcelohd.screen.music.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.marcelohd.screen.music.model.Artista;
import dev.marcelohd.screen.music.model.Musica;

public interface ArtistaRepository extends JpaRepository<Artista,UUID>{
    
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);
    //@Query("SELECT m FROM artistas a JOIN a.discografia d Join d.musicas m WHERE d.artista =:artista AND m.titulo ILIKE %:buscaMusica%")
    //List<Musica> buscarMusicasPorArtistaETrecho(Artista artista, String buscaMusica);
    @Query("SELECT m FROM artistas a JOIN a.discografia d Join d.musicas m WHERE m.titulo ILIKE %:buscaMusica%")
    List<Musica> buscarMusicas(String buscaMusica);
    @Query("SELECT m FROM artistas a JOIN a.discografia d Join d.musicas m WHERE a.nome ILIKE %:nomeArtista%")
    List<Musica> buscarMusicasPorNomeArtista(String nomeArtista);


}
