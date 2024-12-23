package com.meuprojeto.PesquisaLiteratura.principal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuprojeto.PesquisaLiteratura.model.*;
//import com.meuprojeto.PesquisaLiteratura.model.Livros;
import com.meuprojeto.PesquisaLiteratura.repository.AutoresRepository;
import com.meuprojeto.PesquisaLiteratura.repository.LivroRepository;
import com.meuprojeto.PesquisaLiteratura.service.ConsumoApi;
import com.meuprojeto.PesquisaLiteratura.service.ConversorDados;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private ConsumoApi consumo = new ConsumoApi();
    private ConversorDados conversor = new ConversorDados();
    private Scanner leitura = new Scanner(System.in);
    private ObjectMapper mapper = new ObjectMapper();
    private final String ENDERECO = "https://gutendex.com/books/?search=";


    private LivroRepository repositorio;
    private AutoresRepository autoresRepositorio;

    private List<Livros> livros;
    private List<Autores> autores;

    public Principal(LivroRepository repositorio, AutoresRepository autoresRepositorio) {
        this.repositorio = repositorio;
        this.autoresRepositorio = autoresRepositorio;
    }

    public void exibeMenu(){

        var opcao = -1;
        while (opcao !=0){
            var menu = """
                    1- buscar livros
                    2- listar livros registrados
                    3- listar autores registrados
                    4- listar autores vivos em um determinado ano
                    5- listar livros em um determinado idioma
                    0- Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    buscarLivros();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    autoresVivosEmDeterminadoAno();
                    break;
                case 5:
                    listarLivrosIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

            }
        }
    }


    private void buscarLivros(){
        System.out.println("Digite o nome do livro para a busca: ");
        var nomeLivro = leitura.nextLine().toLowerCase();
        var json = consumo.obterDados(ENDERECO+nomeLivro.replace(" ","+"));
        var dados = conversor.converterDados(json, Results.class);
        DadosLivros dadosLivros = dados.results().get(0);
        Livros livros = new Livros(dadosLivros);
        repositorio.save(livros);
        Autores autores = new Autores().selecionaAutor(dadosLivros);
        autoresRepositorio.save(autores);
        System.out.println(livros);

    }


    private void listarLivros() {
        livros = repositorio.findAll();
        livros.stream()
                .sorted(Comparator.comparing(Livros::getTitle))
                .forEach(System.out::println);
    }

    private void listarAutores() {
        autores = autoresRepositorio.findAll();
        autores.stream()
                .sorted(Comparator.comparing(Autores::getName))
                .forEach(System.out::println);



    }

    private void autoresVivosEmDeterminadoAno() {
        System.out.println("Insira o ano");
        Integer ano = leitura.nextInt();
        autores = autoresRepositorio.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(ano,ano);

        autores.stream()
                .sorted(Comparator.comparing(Autores::getName))
                .forEach(System.out::println);
    }

    //Aqui foi utilizado query
    private void listarLivrosIdioma() {

        System.out.println("Informe a abreviação do idioma, ex: 'pt','en','fr'");
        String idioma = leitura.nextLine().toLowerCase();
        livros = repositorio.abreviacaoIdioma(idioma);

        if(livros.isEmpty()){
            System.out.println("Nenhum livro encontrado para este idioma");
        } else {
            livros.forEach(System.out::println);
        }
    }



}
