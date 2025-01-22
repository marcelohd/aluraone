package dev.marcelohd.forumhub.modules.topicos.entities;

import dev.marcelohd.forumhub.modules.topicos.dto.TopicoDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
public class Topico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;
    private LocalDateTime dataCriacao;
    private boolean status;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "topico")
    private Usuario autor;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Resposta> respostas;

    public Topico(@Valid TopicoDTO topico) {

    }

    public Topico(@Valid TopicoDTO topico, Usuario usuario, Curso curso) {
        this.titulo = topico.titulo();
        this.mensagem = topico.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = true;
        this.autor = usuario;
        this.curso = curso;
    }
}
