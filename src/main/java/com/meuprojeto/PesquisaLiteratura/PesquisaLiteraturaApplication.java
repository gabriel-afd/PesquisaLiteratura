package com.meuprojeto.PesquisaLiteratura;

import com.meuprojeto.PesquisaLiteratura.principal.Principal;
import com.meuprojeto.PesquisaLiteratura.repository.AutoresRepository;
import com.meuprojeto.PesquisaLiteratura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PesquisaLiteraturaApplication implements CommandLineRunner {
	@Autowired
	private LivroRepository repositorio;
	@Autowired
	private AutoresRepository autoresRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(PesquisaLiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio,autoresRepositorio);
		principal.exibeMenu();
	}
}
