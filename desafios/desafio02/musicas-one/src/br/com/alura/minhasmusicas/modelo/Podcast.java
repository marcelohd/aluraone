package br.com.alura.minhasmusicas.modelo;

public class Podcast extends Audio {

    private String apresentador;
    private String descricao;
    private String convidado;

    public String getApresentador() {
        return apresentador;
    }
    
    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getConvidado() {
        return convidado;
    }
    
    public void setConvidado(String convidado) {
        this.convidado = convidado;
    }

    @Override
    public int getClassificacao() {
        if(this.getTotalCurtidas() > 500) {
            return 10;
        } else {
            return 8;
        }
    }

    
}
