package br.com.alura.minhasmusicas.modelo;

public class Preferencias {

    public static Preferencias getInstance(){
        return new Preferencias();
    }
    
    public void inclui(Audio audio){

        if(audio.getClassificacao() >= 8){
            System.out.println(audio.getTitulo() + " é considerado sucesso");
        } else {
            System.out.println(audio.getTitulo() + " boa opção para ouvir");
        }
    }
}
