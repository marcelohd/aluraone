package dev.marcelohd.alura.literarua.principal;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

import dev.marcelohd.alura.literarua.model.Autor;
import dev.marcelohd.alura.literarua.model.Livro;
import dev.marcelohd.alura.literarua.service.InternetConnector;
import dev.marcelohd.alura.literarua.service.LivrosService;

public class Principal{
    private Scanner teclado = new Scanner(System.in);

    private LivrosService service;


    public Principal(){

    }

    public Principal(LivrosService service){
        this.service = service;

    }

    public void exibeMenu(){
        int opcao = -1;

        do{
            System.out.println("\n=====================================================");
           
            System.out.println("1 - Buscar livro pelo título");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado ano");
            System.out.println("5 - Listar livros em um determinado idioma\n");
            System.out.println("0 - Sair");

            System.out.println("=====================================================");
            try{
                opcao = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");

                switch (opcao) {
                    case 1:
                        buscarLivroPeloTitulo();
                        break;
                    case 2:
                        listarLivrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivosPorPeriodo();
                        break;
                    case 5:
                        listaLivrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Até breve !!!");
                        System.exit(0);
                        break;
                
                }
            } catch ( IllegalArgumentException | InputMismatchException e){
                System.out.println("O valor informado não é um numero!!!");
                System.exit(0);
            }
        } while (opcao!=0);
    }

    private void buscarLivroPeloTitulo(){
        System.out.println("Digite o nome do livro");
        var nomeLivro = teclado.nextLine();
        Livro livroBuscado = service.buscaLivro(nomeLivro);
        if(service.estaNaLista(livroBuscado)){
            service.salvarLivro(livroBuscado);
        } else {
            String autores = livroBuscado.getAutores().stream().map(autor -> autor.getNome()).collect(Collectors.joining(" - "));
            System.out.printf("O livro '%s' e autor '%s' ja existe na base de dados\n", livroBuscado.getTitulo(), autores);
        }
    }

    private void listarLivrosRegistrados(){
        service.listaLivros();
    }

    private void listarAutoresRegistrados(){
        service.listaAutoresRegistrados();
    }

    private void listarAutoresVivosPorPeriodo(){
        System.out.println("Insira o ano que deseja pesquisar");
        var anoBusca = teclado.nextInt();
        teclado.nextLine();
        service.listaAutoresVivosPorPeriodo(anoBusca);
    }

    private void listaLivrosPorIdioma(){
        String opcoes = """
                Insira o idioma para realizar a busca
                es - espanhol
                en - Ingles
                fr - francês
                pt - português
                """;
        System.out.println("Insira o idioma que deseja pesquisar\n" + opcoes);
        var idioma = teclado.nextLine();
        service.listaLivrosPorIdioma(idioma);
    }
}