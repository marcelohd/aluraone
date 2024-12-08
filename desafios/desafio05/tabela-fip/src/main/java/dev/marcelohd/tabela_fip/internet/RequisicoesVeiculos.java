package dev.marcelohd.tabela_fip.internet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.marcelohd.tabela_fip.modelo.Dados;
import dev.marcelohd.tabela_fip.modelo.Marca;
import dev.marcelohd.tabela_fip.modelo.Modelo;
import dev.marcelohd.tabela_fip.modelo.Veiculo;
import dev.marcelohd.tabela_fip.service.ConverteDados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RequisicoesVeiculos {
    private static final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private String urlMarca = "";
    private String urlModelo = "";
    private String urlAnoModelo = "";
    private String urlVeiculoPorAno = "";

    private ConexaoHandler handler;
    private ConverteDados converteDados;
    private ObjectMapper mapper = new ObjectMapper();

    public RequisicoesVeiculos(){
        handler = new ConexaoHandler();
        converteDados = new ConverteDados();

    }

    public List<Dados> buscarMarcas(String tipoVeiculo) {
        urlMarca = URL_BASE+tipoVeiculo.concat("/marcas");
        String [] resultado = handler.requisicao(urlMarca);
        if(resultado[0].equalsIgnoreCase("200")){
            var marcas = converteDados.obterLista(resultado[1],Dados.class);
            return marcas;
        } else {
            return new ArrayList<>();
        }
    }

    public Modelo buscarModelos(Integer codigoModelo){
        urlModelo = urlMarca+"/"+codigoModelo+"/modelos";
        String [] resultado = handler.requisicao(urlModelo);

        if(resultado[0].equalsIgnoreCase("200")){
            var modelos = converteDados.obterDados(resultado[1], Modelo.class);
            return modelos;
        } else {
            return null;
        }
    }

    public List<Dados> buscarAnoAvaliacoes(Integer anoModelo){
        urlAnoModelo = urlModelo+"/"+anoModelo+"/anos";
        String [] resultado = handler.requisicao(urlAnoModelo);

        if(resultado[0].equalsIgnoreCase("200")){
            var anosAvalicao = converteDados.obterLista(resultado[1], Dados.class);
            return anosAvalicao;
        } else {
            return null;
        }
    }

    public Veiculo buscarVeiculoPorAno(String anoVeiculo){
        urlVeiculoPorAno= urlAnoModelo+"/"+anoVeiculo;
        String [] resultado = handler.requisicao(urlVeiculoPorAno);

        if(resultado[0].equalsIgnoreCase("200")){
            var veiculo = converteDados.obterDados(resultado[1], Veiculo.class);
            return veiculo;
        } else {
            return null;
        }
    }
}
