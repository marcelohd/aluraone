package dev.marcelohd.forumhub.modules.topicos.repository;

import dev.marcelohd.forumhub.modules.topicos.entities.Topico;
import org.hibernate.validator.cfg.defs.UUIDDef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicoRepository extends JpaRepository<Topico, UUID> {
}
