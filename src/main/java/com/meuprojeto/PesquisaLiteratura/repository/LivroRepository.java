package com.meuprojeto.PesquisaLiteratura.repository;

import com.meuprojeto.PesquisaLiteratura.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livros,Long> {

    @Query("SELECT l FROM Livros l WHERE l.idiomas = :idioma")
    List<Livros> abreviacaoIdioma(@Param("idioma") String idioma);
}
