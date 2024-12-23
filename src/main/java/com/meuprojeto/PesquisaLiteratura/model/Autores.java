package com.meuprojeto.PesquisaLiteratura.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    public Autores(DadosAutor dadosAutor){
        this.name = dadosAutor.nome();
        this.birthYear = dadosAutor.dataNascimento();
        this.deathYear = dadosAutor.dataMorte();
    }

    @OneToMany(mappedBy = "autores",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Livros> livros;

    public Autores(){}

    public Autores selecionaAutor(DadosLivros dadosLivros){
        DadosAutor dadosAutor = dadosLivros.autor().get(0);
        return new Autores(dadosAutor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return birthYear;
    }

    public void setBirth_year(Integer birth_year) {
        this.birthYear = birth_year;
    }

    public Integer getDeath_year() {
        return deathYear;
    }

    public void setDeath_year(Integer death_year) {
        this.deathYear = death_year;
    }

    @Override
    public String toString() {
        return
                ", name='" + name + '\'' +
                ", birth_year=" + birthYear +
                ", death_year=" + deathYear;
    }
}
