package dev.marcelohd.forumhub.modules.topicos.controller;


import dev.marcelohd.forumhub.modules.topicos.dto.DadosListagemTopico;
import dev.marcelohd.forumhub.modules.topicos.dto.TopicoDTO;
import dev.marcelohd.forumhub.modules.topicos.entities.Topico;
import dev.marcelohd.forumhub.modules.topicos.repository.CursoRepository;
import dev.marcelohd.forumhub.modules.topicos.repository.TopicoRepository;
import dev.marcelohd.forumhub.modules.topicos.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastraTopico(@RequestBody @Valid TopicoDTO topico, UriComponentsBuilder builder){
        var usuario = usuarioRepository.getReferenceById(UUID.fromString(topico.autorId()));
        var curso = cursoRepository.getReferenceById(UUID.fromString(topico.autorId()));
        var novoTopico = new Topico(topico,usuario, curso);
        repository.save(novoTopico);

        var uri = builder.path("/topicos/{id}").buildAndExpand(novoTopico.getId()).toUri();

        return ResponseEntity.created(uri).body(novoTopico);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pageable<DadosListagemTopico>> listagemTopico(@PageableDefault Pageable page){
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastraTopico(@RequestBody TopicoDTO topico){
        System.out.println(topico);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastraTopico(@RequestBody TopicoDTO topico){
        System.out.println(topico);
        return ResponseEntity.ok().body("");
    }
}
