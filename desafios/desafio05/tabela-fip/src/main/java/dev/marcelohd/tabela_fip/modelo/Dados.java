package dev.marcelohd.tabela_fip.modelo;

public class Dados implements Comparable <Dados> {

    private String codigo;
    private String  nome;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public int compareTo(Dados another) {
        return getCodigo().compareTo(another.getCodigo());
    }
}
