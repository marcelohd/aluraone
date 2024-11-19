package br.com.alura.minhasmusicas;

import br.com.alura.minhasmusicas.modelo.Musica;
import br.com.alura.minhasmusicas.modelo.Podcast;
import br.com.alura.minhasmusicas.modelo.Preferencias;

public class Main {
    public static void main(String[] args) {
        
        Musica  musica = new Musica();
        musica.setTitulo("Forever");
        musica.setArtista("Kiss");

        for(int i = 0; i < 1000 ; i++){
            musica.reproduz();
        }

        for(int i = 0; i < 1000 ; i++){
            musica.curtir();
        }

        for(int i = 0; i < 1000 ; i++){
            musica.compartilhar();
        }

        Podcast  podcast = new Podcast();
        podcast.setTitulo("JJ Podcast Numero 123");
        podcast.setApresentador("Joel Jota");
        podcast.setConvidado("Caio");

        for(int i = 0; i < 1000 ; i++){
            podcast.reproduz();
        }

        for(int i = 0; i < 1000 ; i++){
            podcast.curtir();
        }

        for(int i = 0; i < 1000 ; i++){
            podcast.compartilhar();
        }

        Preferencias preferencias = Preferencias.getInstance();
        preferencias.inclui(musica);
        preferencias.inclui(podcast);
    }
}
