package com.meuprojeto.PesquisaLiteratura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resultados {
    List<DadosLivros> livros;

    public List<DadosLivros> getLivros() {
        return livros;
    }

    public void setLivros(List<DadosLivros> livros) {
        this.livros = livros;
    }
}
