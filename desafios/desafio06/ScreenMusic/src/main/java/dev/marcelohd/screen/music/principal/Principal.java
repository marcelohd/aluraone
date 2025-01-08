package dev.marcelohd.screen.music.principal;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import dev.marcelohd.screen.music.model.Album;
import dev.marcelohd.screen.music.model.Artista;
import dev.marcelohd.screen.music.model.Genero;
import dev.marcelohd.screen.music.model.Musica;
import dev.marcelohd.screen.music.model.TipoAlbum;
import dev.marcelohd.screen.music.repository.ArtistaRepository;

public class Principal {
    private Artista artista;
    private ArtistaRepository repository;
    private Scanner leitor = new Scanner(System.in);
    Scanner sc = new Scanner(System.in,"ISO-8859-1");
    LocalDate hoje = LocalDate.now();


    public Principal(ArtistaRepository eRepository){
        this.repository = eRepository;
    }

    private void exibeMenu(){
        System.out.println("\n*** Screen Sound Músicas ***");
        String texto = """

                1- Cadastrar artistas
                2- Cadastrar músicas 
                3- Listar músicas 
                4- Buscar músicas
                5- Pesquisar dados sobre um artista


                0- Sair

                """;
        System.out.println(texto);
    }

    public void controle(){
        int opcao = -1;
        while(opcao != 0){
            try {
                exibeMenu();
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (NumberFormatException | InputMismatchException  e) {
                System.out.println("Utilize somente as opções do menu");
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisaDadosChatGPT();
                    break;
                case 0:
                    System.out.println("Até breve");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha uma opção do menu");
                    break;
            }
        }
    }
    

    
    public void cadastrarArtista(){
        System.out.println(" *** Cadastramento de Artistas *** ");
        System.out.println("Digite o nome do artista");
        var nome = leitor.nextLine();
        System.out.println("Digite o genero conforme abaixo\n");
        Genero.mostraTodos();
        System.out.println("\n");
        //var genero = Genero.valueOf(leitor.nextLine().toUpperCase());
        var genero = Genero.fromString(leitor.nextLine());
        Artista artista = new Artista();
        artista.setNome(nome);
        artista.setGenero(genero);
        System.out.println("Novo artista cadastrado !!!");
        System.out.printf("Nome: %s, Genero: %s\n",artista.getNome(),artista.getGenero());
        repository.save(artista);

    }

    public void cadastrarMusica(){
        System.out.println(" *** Cadastramento de Musicas *** ");
        System.out.println("Digite o nome do artista");
        var nome = leitor.nextLine();
        pesquisarArtista(nome);
        System.out.printf("Nome: %s, Genero: %s :",artista.getNome(),artista.getGenero());
        artista.getDiscografia().stream().forEach(a -> System.out.printf("Album: %s\n",a.getNomeAlbum()));
        if(!artista.getDiscografia().isEmpty()){
            System.out.println("Escolha o album para inserir a musica");
            var albumBuscado =  leitor.nextLine();
            var ab = artista.getDiscografia()
                    .stream()
                    .filter(e -> e.getNomeAlbum().toLowerCase().contains(albumBuscado.toLowerCase()))
                    .findFirst();
            if(ab.isPresent()){
                System.out.println("\nAlbum encontrado " + ab.get().getNomeAlbum());
                var musica = cadastraNovaMusica(ab.get());
                ab.get().getMusicas().addAll(musica);
                artista.getDiscografia().add(ab.get());
                repository.save(artista);
            } else {
                System.out.println("\nAlbum nâo encontrado " + albumBuscado);
                dataBindingAndSave();
            }
            
        } else {
            System.out.println("\nAlbum nâo encontrado " );
            dataBindingAndSave();
        }
       
        

    }

    public void listarMusicas(){
        List<Artista> musicas = repository.findAll();
         musicas.stream()
            .forEach(d -> d.getDiscografia().stream()
                                            .forEach(m -> m.getMusicas().stream()
                                                                        .forEach( i -> System.out.printf("Artista: %s Album: %s Musica: %s\n",d.getNome(),m.getNomeAlbum() ,i.getTitulo()))));
        
                                                                    
    }

    public void buscarMusicasPorArtista(){
        
        System.out.println("Digite : 1 - Para pesquisar por trecho nome da musica");
        System.out.println("Digite : 2 - Para pesquisar por nome do artista");
        var opcao = leitor.nextInt();
        leitor.nextLine();
        switch (opcao) {
            case 1:
                System.out.println("Digite o trecho da musica");
                var trechoMusica = leitor.nextLine();
                var musicasOne = repository.buscarMusicas(trechoMusica);
                musicasOne.stream().forEach(System.out::println);
                break;
            case 2:
                System.out.println("Digite o nome da artista");
                var nomeArtista = leitor.nextLine();
                var musicasTwo = repository.buscarMusicasPorNomeArtista(nomeArtista);
                musicasTwo.stream().forEach(System.out::println);
                break;

        }
        
    }

    public void pesquisarArtista(String nome){
        var artistaEncontrato = repository.findByNomeContainingIgnoreCase(nome);
        if(artistaEncontrato.isPresent()){
          artista = artistaEncontrato.get();
        } else {
            System.out.println("Nenhum artista encontrato para a busca");
           cadastrarArtista();
        }
    }

    private Album cadastraNovoAlbum(){
        System.out.println(" *** Insira os dados do album *** ");
        System.out.println("Digite o nome do album");
        var nomeAlbum = leitor.nextLine();
        System.out.println("\nDigite o tipo do album");
        TipoAlbum.mostraTodos();
        var tipoAlbum = TipoAlbum.fromString(leitor.nextLine());
        System.out.println("\nDigite o nome da gravadora do album");
        var nomeGravadora = leitor.nextLine();
        var album = new Album(artista,nomeAlbum,tipoAlbum,nomeGravadora);
        return album;
    }

    private Set<Musica> cadastraNovaMusica(Album album){
        Set<Musica> musicas = new HashSet<>();
        int opcao = -1;
        Musica musica;
        do{
            System.out.println(" *** Insira os dados da musica *** ");
            System.out.println("Digite o nome do musica");
            var nomeMusica = leitor.nextLine();
            musica = new Musica(nomeMusica,album);
            musicas.add(musica);
            System.out.println("\n\nDeseja cadastar mais musicas ? 1 - Sim, 2 - Nâo ");
            opcao = leitor.nextInt();
            leitor.nextLine();
        }while(opcao!=2);
        return musicas;
    }

    private void dataBindingAndSave(){
        var album = cadastraNovoAlbum();
        var musica = cadastraNovaMusica(album);
        album.getMusicas().addAll(musica);
        artista.getDiscografia().add(album);
        
        repository.save(artista);
    }

    public void pesquisaDadosChatGPT(){

    }
}
