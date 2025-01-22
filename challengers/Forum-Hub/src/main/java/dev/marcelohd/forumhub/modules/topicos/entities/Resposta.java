package dev.marcelohd.forumhub.modules.topicos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Resposta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String mensagem;
    private Topico topico;
    private LocalDateTime dataCriacao;
    @NotBlank
    @ManyToOne
    private Usuario autor;
    @NotBlank
    private String solucao;
}
