package dev.marcelohd.alura.literarua.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;
@Entity (name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Livro livro;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    public Autor(){}

    public Autor(String nome, Livro livro, String anoNascimento, String anoFalecimento){
        this.nome = nome;
        this.livro = livro;
        this.anoNascimento = Integer.valueOf(anoNascimento).intValue();
        this.anoFalecimento = Integer.valueOf(anoFalecimento).intValue();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    @Override
    public String toString() {
        return  "---------------- Autores Registrados  ---------------\n"+
                "Nome=" + nome + '\n' +
                "Ano de nascimento=" + anoNascimento + '\n' +
                "Ano de falecimento=" + anoFalecimento+'\n' +
                "------------------------------------------------------\n";
    }
}

