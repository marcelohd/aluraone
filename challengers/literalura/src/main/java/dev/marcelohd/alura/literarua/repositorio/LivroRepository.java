package dev.marcelohd.alura.literarua.repositorio;

import dev.marcelohd.alura.literarua.model.Autor;
import dev.marcelohd.alura.literarua.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    Optional<Livro> findByTituloContainingIgnoreCase(String nomeLivro);

    // Consulta para retornar todos os autores de um livro
    @Query(nativeQuery = true, value = "SELECT a.id,a.nome,a.ano_falecimento, a.ano_nascimento,a.livro_id FROM LIVROS l INNER JOIN AUTORES a ON a.LIVRO_ID = l.id")
    List<Autor> buscarAutoresPorLivro();

}
