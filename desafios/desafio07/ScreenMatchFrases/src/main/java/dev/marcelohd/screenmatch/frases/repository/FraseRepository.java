package dev.marcelohd.screenmatch.frases.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.marcelohd.screenmatch.frases.model.Frase;


public interface FraseRepository extends JpaRepository<Frase, UUID> {
 
    @Query("SELECT f FROM Frase f ORDER BY function('RANDOM') LIMIT 1")
    Optional<Frase> obterFrasesAleatorias();

}
