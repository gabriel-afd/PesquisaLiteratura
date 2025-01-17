# Pesquisa Literatura

Este repositório contém o projeto **Pesquisa Literatura**, desenvolvido para facilitar a organização e o gerenciamento de informações relacionadas à literatura, como livros, autores e publicações. O projeto utiliza tecnologias modernas e segue boas práticas de desenvolvimento.

## Funcionalidades

- Cadastro de livros com informações detalhadas (título, autor, ISBN, ano de publicação, etc.).
- Gerenciamento de autores e suas respectivas publicações.
- Consulta e organização de livros por categorias, localização e idioma.
- Integração com APIs externas para buscar informações adicionais sobre livros (opcional).

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Boot**: Framework para construção de aplicações web e APIs RESTful.
- **MySQL**: Banco de dados utilizado para armazenar as informações de livros e autores.
- **Hibernate**: Framework de ORM para gerenciamento das entidades no banco de dados.
- **Gson**: Biblioteca para serialização e desserialização de objetos JSON.

## Estrutura do Projeto

### Banco de Dados

A estrutura da tabela principal é definida da seguinte forma:

```sql
CREATE TABLE livros (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) DEFAULT NULL,
    name VARCHAR(255) DEFAULT NULL,
    nationality VARCHAR(255) DEFAULT NULL,
    isbn VARCHAR(255) DEFAULT NULL,
    year INT DEFAULT NULL,
    location VARCHAR(255) DEFAULT NULL,
    category TINYINT DEFAULT NULL,
    language VARCHAR(255) DEFAULT NULL
);
```

- `title`: Título do livro.
- `name`: Nome do autor.
- `nationality`: Nacionalidade do autor.
- `isbn`: Código ISBN do livro.
- `year`: Ano de publicação.
- `location`: Localização do livro na biblioteca.
- `category`: Categoria do livro (armazenada como um valor numérico).
- `language`: Idioma do livro.

### Classes e Estrutura do Código

O projeto possui as seguintes classes principais:

- **Livro**: Representa a entidade de um livro.
- **Autor**: Representa a entidade de um autor.
- **LivroDTO**: Objeto de transferência de dados para interação com a API.
- **LivrosController**: Controlador responsável por gerenciar as requisições relacionadas a livros.
- **DadosAutor** e **DadosPublicacao**: Classes auxiliares para manipulação de dados.

### Endpoints

- `POST /livros`: Cadastro de um novo livro.
- `GET /livros`: Consulta de livros cadastrados.
- `PUT /livros/{id}`: Atualização de dados de um livro existente.
- `DELETE /livros/{id}`: Exclusão de um livro do sistema.

## Configuração do Ambiente

1. Clone este repositório:
   ```bash
   git clone https://github.com/gabriel-afd/PesquisaLiteratura.git
   ```

2. Configure o banco de dados MySQL:
   - Crie um banco de dados chamado `pesquisa_literatura`.
   - Atualize as credenciais de conexão no arquivo `application.properties`.

3. Instale as dependências e inicie o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo para colaborar:

1. Faça um fork deste repositório.
2. Crie uma nova branch para sua funcionalidade ou correção:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m "Adiciona minha funcionalidade"
   ```
4. Envie suas alterações para o GitHub:
   ```bash
   git push origin minha-feature
   ```
5. Abra um pull request.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para mais informações.

## Contato

Caso tenha dúvidas ou sugestões, entre em contato:

- **Autor**: Gabriel AFD
- **GitHub**: [gabriel-afd](https://github.com/gabriel-afd)

