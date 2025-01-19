package dev.marcelohd.alura.literarua.service;

import dev.marcelohd.alura.literarua.model.Autor;
import dev.marcelohd.alura.literarua.model.Livro;
import dev.marcelohd.alura.literarua.repositorio.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class LivrosService {

    private List<Livro> livros;
    private InternetConnector internetConnector;
    LivroRepository repository;

    public LivrosService(LivroRepository repository){
        this.repository = repository;
        this.internetConnector = new InternetConnector();
        atualizaLista();
    }

    public Livro buscaLivro(String busca) {
        return internetConnector.obterDados(busca);
    }

    public void salvarLivro(Livro livro){
        repository.save(livro);
        atualizaLista();
    }

    private void atualizaLista(){
        this.livros = repository.findAll();
    }

    public boolean estaNaLista(Livro livro){
        atualizaLista();
        var l = livros.stream().filter(li-> li.getTitulo().toLowerCase().equals(livro.getTitulo().toLowerCase())).collect(Collectors.toSet());
        if(l.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public void listaLivros() {
        atualizaLista();
        livros.stream().forEach( System.out::println);
    }

    public void listaAutoresRegistrados(){
        List<Autor> autors = repository.buscarAutoresPorLivro();
        autors.stream().forEach(System.out::println);
    }

    public void listaAutoresVivosPorPeriodo(Integer anoBuscado){
        List<Autor> autors = repository.buscarAutoresPorLivro();

        System.out.println();
        autors.stream().filter(l-> l.getAnoNascimento()>=anoBuscado || l.getAnoFalecimento()<=anoBuscado  ).forEach(System.out::println);

    }

    public void listaLivrosPorIdioma(String idioma){
        atualizaLista();
        var livrosPorIdioma = livros.stream()
                                    .filter(livro -> livro.getIdiomas().get(0).getNomeIdioma().equalsIgnoreCase(idioma))
                                    .toList();
        if(livrosPorIdioma.size()!=0){
            livrosPorIdioma.forEach(System.out::println);
        } else {
            System.out.println("Não existem livros nesse idioma no banco de dados");
        }
    }
}
