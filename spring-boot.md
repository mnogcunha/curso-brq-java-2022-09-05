
# Maven

É um gerenciador de dependências

Observar arquivo pom.xml


# Dependências :

## spring-boot-starter-web

Para criar a camada de exposição do serviço (aka, permitir export nossos endpoint)

Um endpoint é um recurso que podemos disponibilizar para uso (ex: /professores da grande porte)

## spring-boot-devtools

Ajuda a aumentar a velocidade de desenvolvimento dos micro serviços, como por exemplo, o auto restart do mesmo quando m código é alterado

## spring-boot-starter-test

Responsável por fazer testes unitários na aplicação.

Um teste unitário é um teste que testa individualmente cada trecho de código.
Este teste é automatiza e criado pelo desenvolvedor da aplicação.

Veremos neste curso.

# Design Patterns (Padrões de Projeto)

São padrões estipulados por uma comunidade com o objetivo de auxiliar a desenvolver uma arquitetura de software padronizada e que evite "certos problemas"

Utilizamos padrões de projetos para evitar erros conhecidos e também facilitar o entendimento do projeto

## No cenário de estrutura de uma aplicação, temos o padrão de projeto conhecido como MVC

### MVC : Model , View, Controller

O MVC divide a nossa aplicação em 3 grandes camadas, com responsabilidades específica.

- Na camada Model encontramos as regras de negócio e acesso ao banco de dados
- Na camada View, é a parte de visualização para o usuário (não veremos neste curso)
- Na camada controller, encontramos a ligação entre as camadas Model e View

### Anotações em JAVA

Anotações no JAVA possui o objetivo de sinalizar para o compilador a real funcionalidade da classe ou parâmetro ou da variável

OBS: toda anotação em JAVA começa com a **@**

### Anotações do Spring Boot

- @RestController : anotação que permite a classe em questão manipular requisições do tipo REST

Obs: todo endpoint da camada de controller deve ser mapeado com um método

### Lombok

O Lombok é um boilerplate que gera código repetitivo em tempo de execução.

Em geral geramos os construtores, getters, setters e  o método toString()

O Lombok é usado com anotações:

- @Data: faz o papel dos Getters, Setters e toString
- @AllArgsConstructor : criar o construtor com todos os atributos da classe
- @NoArgsConstructor : cria o construtor vazio
- @RequestBody permite capturar os dados vindo do body da requisição e converter para um objeto JAVA


# ORM

Object Relational Mapping : mapeamento objeto (JAVA) relacional (Banco SQL)

Existem vários ORMs, o que mais se destaca é o Hibernate

O Hibernate é uma ferramente que permite usar objetos JAVA e manipular os daos em um
banco de dados

# Algumas anotações

@Autowired
@Services
@Repositories
@Entity
@Table
@Column
@RestCotroller
@GeneratedValue


# Métodos em JAVA

modificadorDeAcesso retorno nomeDoMetodo (parametros){

}

Ex: public int soma(int a, int b)
soma(1,4)
1 e 4 são parâmetros


public : modificadorDeAcesso
int : retorno
soma: nomeDoMetodo
int a, int b : parametros

# Exercício - dia 22 de outubro

## Passo a Passo para fazer

Objetivo: Criar CRUD de professor

campos (colunas): id, nome, cpf, salário, telefone

1-) entrar no https://start.spring.io para criar a estrutura básica de um projeto.
nome sugestão: ms03

group: nome invertido da empresa: com.brq
artifact: nome do projeto (ms3)
escolher java 11
escolher MAVEN

2-) no passo 1, escolher as dependências corretas
(spring web, jpa,  mysql, lombok)

Add dependências spring validator e object mapper manualmente no pom.xml

3-) baixar o zip gerado no passo anterior e extrair o zip
dentro da pasta do seu repositório git

4-) abrir projeto do passo 3 no IntelliJ

5-) Criar novo banco de dados no DBeaer

6-) criar tabelas no DBeaer do passo 5

7-) configurar banco de dados no projeto spring boot
(no arquivo application.properties)

8-) Criar camada de model e suas entidades
(não esquecer das entidades)

9-) criar camada repository (repositories)
OBS: é uma interface

10-) criar camada service (services) - classe

11-) criar camada de controller (controllers)- classe

12-) criar collection no POSTMAN
Com todos os VERBOS

