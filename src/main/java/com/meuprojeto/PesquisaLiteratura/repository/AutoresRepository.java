package com.meuprojeto.PesquisaLiteratura.repository;

import com.meuprojeto.PesquisaLiteratura.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutoresRepository extends JpaRepository<Autores, Long> {

    List<Autores> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(Integer birthYear, Integer deathYear);
}
