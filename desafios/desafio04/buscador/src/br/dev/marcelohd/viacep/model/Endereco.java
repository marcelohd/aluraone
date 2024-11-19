package model;

public class Endereco{
    
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private int ibge;
    private int ddd;


    public String getCep() {
        return cep;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public String getLocalidade() {
        return localidade;
    }
    
    public String getUf() {
        return uf;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public String getRegiao() {
        return regiao;
    }
    
    public int getIbge() {
        return ibge;
    }
    
    
    public int getDdd() {
        return ddd;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro="
                + bairro + ", localidade=" + localidade + ", uf=" + uf + ", estado=" + estado + ", regiao=" + regiao
                + ", ibge=" + ibge + ", ddd=" + ddd + "]";
    }
    
    
}
