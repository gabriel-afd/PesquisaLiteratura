package com.meuprojeto.PesquisaLiteratura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String autor;
    private String idiomas;
    private Integer downloads;

    public Autores nomeAutor(DadosLivros dadosLivros){
        DadosAutor dadosAutor = dadosLivros.autor().get(0);
        return new Autores(dadosAutor);
    }

    private String selecionaIdioma(List<String> idiomas){
        return idiomas.get(0);
    }


    public Livros(DadosLivros dadosLivros){
        this.title = dadosLivros.titulo();
        this.autor = nomeAutor(dadosLivros).getName();
        this.idiomas = selecionaIdioma(dadosLivros.idiomas());
        this.downloads = dadosLivros.downloads();
    }

    @ManyToOne
    private Autores autores;

    public Livros(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return  "  Titulo: ='" + title + '\'' +
                ", Autor: " + autor + '\'' +
                ", Idiomas: '" + idiomas + '\'' +
                ", Downloads: " + downloads;

    }
}
