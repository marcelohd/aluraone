package dev.marcelohd.forumhub.modules.topicos.repository;

import dev.marcelohd.forumhub.modules.topicos.entities.Topico;
import dev.marcelohd.forumhub.modules.topicos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
