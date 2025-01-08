package dev.marcelohd.screen.music.model;


public enum Genero {


    POP("Pop"),
    ROCK("Rock"),
    HIP_HOP("Hip Hop"),
    DANCE ("Dance"),
    COUNTRY ("Country"),
    SERTANEJO ("Sertanejo"),
    BLUES ("Blues"),
    FUNK ("Funk"),
    ELETRO ("Eletronica");
   

    private String nome;

    private Genero(String nomeGenero){
        this.nome = nomeGenero;
    }

    public static void mostraTodos(){
        for(Genero genero :  Genero.values()){
            System.out.printf("%s ", genero);
        }
    }


    public static Genero fromString(String busca){
        for (Genero genero : Genero.values()) {
            if (genero.nome.equalsIgnoreCase(busca)) {
                return genero;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + busca);
    }


}