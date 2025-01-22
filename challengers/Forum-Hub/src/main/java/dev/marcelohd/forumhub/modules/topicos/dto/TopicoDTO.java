package dev.marcelohd.forumhub.modules.topicos.dto;

public record TopicoDTO(
        String titulo,
        String mensagem,
        String autorId,
        String cursoId
) {
}
