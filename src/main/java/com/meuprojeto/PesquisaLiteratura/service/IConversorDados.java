package com.meuprojeto.PesquisaLiteratura.service;

public interface IConversorDados {
    <T> T converterDados(String json, Class<T> classe);
}
