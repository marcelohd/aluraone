package br.com.alura.minhasmusicas.modelo;

public class Audio {

    private String titulo;
    private int    duracaoMinutos = 0;
    private int totalReproducoes;
    private int totalCurtidas;
    private int classificacao;
    private int totalCompartilhamentos;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    
    public int getTotalReproducoes() {
        return totalReproducoes;
    }
    
    public int getTotalCurtidas() {
        return totalCurtidas;
    }
    
    public int getClassificacao() {
        return classificacao;
    }
    
    public int getTotalCompartilhamentos() {
        return totalCompartilhamentos;
    }

    public void curtir(){
        this.totalCurtidas++;
    }

    public void reproduz(){
        this.totalReproducoes++;
    }

    public void compartilhar(){
        this.totalCompartilhamentos++;
    }
    


}