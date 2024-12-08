package dev.marcelohd.tabela_fip.service;

import java.util.List;

public interface JsonHandler {
    //Tratando objeto
    <T> T obterDados(String json,Class<T> classe);
    // Tratando lista
    <T> List<T> obterLista(String json, Class<T> classe);
}
