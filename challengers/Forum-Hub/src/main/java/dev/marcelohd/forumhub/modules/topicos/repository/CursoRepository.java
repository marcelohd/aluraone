package dev.marcelohd.forumhub.modules.topicos.repository;

import dev.marcelohd.forumhub.modules.topicos.entities.Curso;
import dev.marcelohd.forumhub.modules.topicos.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
}
