package dev.marcelohd.tabela_fip.modelo;

public class Marca implements Comparable <Marca> {

    private Integer codigo;
    private String  nome;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cód: " + getCodigo() + " Descrição : " + getNome() + "\n";
    }

    @Override
    public int compareTo(Marca another) {
        return getNome().compareTo(another.getNome());
    }
}
