# GIT

1-) git add

adiciona as modifições ou novos arquivos
para que o GIT comece a versionar os mesmos

ex: git add index.html

2-) git commit

adiciona nas moficações para o repositório local

ex: git commit -m "criando nosso primeiro arquivo"

3-) git push

Enviar as modifições do repositório local para o
repositório remoto

4-) criar nova branch

checkout (apontar para outra branch)

comando: git checkout -b nova-branch

5-) pull

Recupera e atualiza todas as alterações que estão no
repositório remoto e não estão no repositório local.

6-) MERGE

Possibilita enviar as alterações da branch atualiza
para uma branch em questão

obs: devemos estar observando a branch de destino e
usar o merge para a branch de origem

git merge nova-branch

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

## API

APIs são mecanismos que permitem que dois componentes de software se comuniquem usando um conjunto de definições e protocolos. Por exemplo, o sistema de software do instituto meteorológico contém dados meteorológicos diários. O aplicativo meteorológico em seu telefone "fala" com este sistema por meio de APIs e mostra atualizações meteorológicas diárias no telefone.


### Anotações em JAVA

Anotações no JAVA possui o objetivo de sinalizar para o compilador a real funcionalidade da classe ou parâmetro ou da variável

OBS: toda anotação em JAVA começa com a **@**

### Anotações do Spring Boot

- **@RestController:** anotação que permite a classe em questão manipular requisições do tipo REST

Obs: todo endpoint da camada de controller deve ser mapeado com um método

### Lombok

O Lombok é um boilerplate que gera código repetitivo em tempo de execução.

Em geral geramos os construtores, getters, setters e  o método toString()

O Lombok é usado com anotações:

- **@Data:** faz o papel dos Getters, Setters e toString
- **@AllArgsConstructor:** criar o construtor com todos os atributos da classe
- **@NoArgsConstructor:** cria o construtor vazio
- **@RequestBody:** permite capturar os dados vindo do body da requisição e converter para um objeto JAVA

## JPA

A especificação JPA define o mapeamento relacional de objetos internamente, em vez de depender das implementações de mapeamento específicas do fornecedor. A JPA representa uma simplificação do modelo de programação de persistência. A especificação JPA define explicitamente o mapeamento relacional de objetos, em vez de depender das implementações de mapeamento específicas do fornecedor.

# ORM

Object Relational Mapping : mapeamento objeto (JAVA) relacional (Banco SQL)

Existem vários ORMs, o que mais se destaca é o Hibernate

O Hibernate é uma ferramente que permite usar objetos JAVA e manipular os daos em um
banco de dados

# Algumas anotações do Spring Boot

A Injeção de Dependência é uma técnica de desenvolvimento utilizada para evitar o alto nível de acoplamento de código, ou seja, quando os componentes de uma aplicação dependem muito uns dos outros. Utilizando a injeção de dependências, o framework fica responsável por "injetar" as dependências que iremos utilizar de um determinado componente declarado.

- **@Autowired:** é a anotação mais utiliza com relação a injeção de dependências. Como o próprio nome diz, o Autowired, indica um ponto na qual a injeção automática deve ser aplicada.  Lembrando que é necessário que a classe a ser injetada pelo Spring esteja anotado com Component (@Component) ou uma de suas especialidades (@Service, @Repository ou @Controller).
- **@Component:** é um estereótipo genérico para qualquer componente gerenciado pelo Spring
- **@Service:** faz anotações de classes na camada de serviço (em geral ficam regras de negócio da nossa aplicação)
- **@Repository:** anota classes na camada de persistência, que atuará como um repositório de banco de dados
- **@Entity:**  é utilizada para informar que uma classe também é uma entidade. A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados, onde os dados de objetos desse tipo poderão ser persistidos.
- **@Table:** anotação permite que você especifique os detalhes da tabela que será usada para persistir a entidade no banco de dados
- **@Column:** é utilizado para especificar a coluna mapeada para uma propriedade ou campo persistente. Se nenhuma anotação de coluna for especificada, os valores padrão serão aplicados.
- **@RestCotroller:** indica que a classe é um controller que permtite criar uma interface API REST.
- **@GeneratedValue:** é utilizada para informar a estratégia de geração do valor do identificador único da entidade será gerenciada pelo provedor de persistência.
- **GenerationType.IDENTITY:** Informamos ao provedor de persistência que os valores a serem atribuídos ao identificador único serão gerados pela coluna de auto incremento do banco de dados. Assim, um valor para o identificador é gerado para cada registro inserido no banco. Alguns bancos de dados podem não suportar essa opção.
- **@Id:** é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária da respectiva tabela no banco de dados.
- **@ControllerAdvice**: permite manipular exceções de forma global. Para cada tipo de exceção, podemos manipular desde o status até a mensagem de retorno.
- **@Slf4j**: é uma abstração JAVA para criar **logging** das aplicações de uma forma simples
- **@Value**:  anotação que permite injetar valores em campos (variáveis JAVA) dentro dos beans gerenciados pelo Spring (@Component, @Service, @Repository, @RestController).
# DTO

Data Transfer Object **(DTO)** ou simplesmente Transfer Object é um padrão de projetos bastante usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

## Validação de dados na camada controller

Colocamos anotações sobre os atributos da classe DTO

- **@NotNull:** campo não pode ser nulo
- **@NotEmpty:** não pode ser vazio


# Métodos em JAVA

```
modificadorDeAcesso retorno nomeDoMetodo (parametros){

}
```

Ex:
```
public int soma(int a, int b)
```

soma(1,4) ->  1 e 4 são parâmetros

```
public : modificadorDeAcesso
int : retorno
soma: nomeDoMetodo
int a, int b : parametros
```

# Exercício - dia 22 de outubro

## Passo a Passo para fazer

**Objetivo:** Criar CRUD de professor

**Campos (colunas):** id, nome, cpf, salário, telefone

1-) entrar no https://start.spring.io para criar a estrutura básica de um projeto. Nome sugestão: **ms03**

**group:** nome invertido da empresa: com.brq
**artifact:** nome do projeto (ms3)
**escolher java 11**
**escolher MAVEN**

2-) no passo 1, escolher as dependências corretas
(spring web, jpa,  mysql, lombok)

Adicionar dependências spring validator e object mapper manualmente no pom.xml

3-) baixar o zip gerado no passo anterior e extrair o zip dentro da pasta do seu repositório git

4-) abrir projeto do passo 3 no IntelliJ

5-) criar novo banco de dados no DBeaer

6-) criar tabelas no DBeaer do passo 5

7-) configurar banco de dados no projeto spring boot (no arquivo application.properties)

8-) criar camada de model e suas entidades (não esquecer das entidades)

9-) criar camada repository (repositories)

**OBS: é uma interface**

10-) criar camada service (services) - classe

11-) criar camada de controller (controllers)- classe

12-) criar collection no POSTMAN com todos os VERBOS

# Relacionamentos JPA

# 1 para N (@OneToMany e @ManyToOne)

- criar relacionamento entre as classes JAVA com as anotações @OneToMany e @ManyToOne nas respectivas entidades
- Na entidade (tabela de dados) que possui a chave estrangeira, colocar a anotação @JoinTable
- Na outra entidade, usar o mapped by

# 1-1 (@OneToOne)

- criar relacionamento entre as classes JAVA com as anotações @OneToOne
- Na entidade (tabela de dados) que possui a chave estrangeira, colocar a anotação @JoinTable
- Na outra entidade, usar o mapped by

# @Component

Antes de podermos entender o valor de **@Component**, primeiro precisamos entender um pouco sobre o Spring ApplicationContext.

Spring ApplicationContext é onde Spring mantém instâncias de objetos que ele identificou para serem gerenciados e distribuídos automaticamente. Estes são chamados de **BEANS** (@Beans).

O gerenciamento do bean e a injeção de dependência são alguns dos principais recursos do Spring.

Usando o princípio de Inversão de Controle, o Spring coleta as instâncias do bean de nosso aplicativo e os usam no momento apropriado. Podemos mostrar as dependências dos bean para Spring sem precisar lidar com a configuração e instanciação desses objetos.

A capacidade de usar anotações como **@Autowired** para injetar beans gerenciados pelo Spring em nosso aplicativo é uma força motriz para a criação do nosso código no Spring.


- @Component

@Component é uma anotação que permite o Spring detectar automaticamente nossos beans personalizados.
Em outras palavras, sem ter que escrever nenhum código explícito, o Spring irá:

- Examinar nosso aplicativo para classes anotadas com @Component
- Instanciar e injetae quaisquer dependências especificadas neles (com classes dos objetos @Component)
- Injetar os objetos na nossa aplicação sempre que necessário

# Apache Camel

- A mensagem contém dados que serão transferidos para uma rota. Cada mensagem tem um identificador exclusivo e é construído a partir de um corpo, cabeçalhos e anexos.

- **Exchange** é criado quando uma mensagem é recebida por um consumidor durante o processo de roteamento. Este permite capturar dados da mensagem trocada entre a rota.

- **Endpoint** é um canal através do qual o sistema pode receber ou enviar uma mensagem. Ele pode se referir a um URI de serviço da Web, URI de fila, arquivo, endereço de e-mail, etc.

- **Processor** é uma interface Java que é usada para adicionar lógica de integração personalizada a uma rota. Ele contém um único método de processo usado para pré-formar a lógica de negócios personalizada em uma mensagem recebida por um consumidor.


# Fluxo "normal" de desenvolvimento

1-) Criar a camada de model (mapear o banco de dados em classes JAVA)

2-) Criar a camada de repository (camada de acesso ao banco de dados)

3-) Criar a camada de services

4-) Criar os controllers e os DTOS, junto com a validação de dados

5-) Criar testes unitários

# Algumas dependências:

- **Para validação, podemos utilizar a :**
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
- **Para converter objetos(DTO -> Model e Model -> DTO), podemo usar a:**
```
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
  <version>2.4.4</version>
</dependency>
```
- **Para usar o JPA (especificação) : Hibernate (implementa a especificação)**
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
- **Para usar o Swagger:**
```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```
- **Para usar o driver do banco de dados relacional:**
```
<!-- Dependência do driver do MySQL para o JAVA-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```
```
<!-- Dependência do driver do PostgreSQL para o JAVA-->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.5.0</version>
</dependency>
```
- **Para criar o relatório dos testes unitários e enviar para o SonarQube (ferramenta de qualidade de código)**
```
<!-- Dependência do Jacoco: testes unitários -->
<dependency>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.6</version>
</dependency>
```
```
<!-- dependência para ActiveMQ para Spring -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-activemq</artifactId>
    <version>2.7.5</version>
</dependency>
```

# Fluxo "normal" de usar/testar a aplicação

1-) Partir do Postman (ou outro client de REST) com o verbo e endpoint correto

# FAQs

- Qual o papel do POM?
  resp: quando utilizamos o gerenciador de dependências MAVEN, temos que
  colocar todas as dependências (bibliotecas) no arquivo pom.xml, que está na raiz do projeto.
- ENUM?
  resp: São campos que possuem um valor fixo pré-definidos na aplicação
- Mapper?
  resp: quando queremos criar um conversor de tipos de objetos no JAVA. Ex: criar um conversor de tipo de dados de DTO para Model
- Config?
  resp: um pacote que guarda configuração atributos das dependências do nosso projeto. Ex: criamos um arquivo config para guardar as configurações do swagger.

# Testes Unitários

Objetivo: testar individualmente nosso código-fonte para garantir e testar a qualidade de nosso código

- @SprintBootTest: fornece um jeito de iniciar o Spring Boot para utilizar/realizar os testes unitários da classe
- @ExtendWith: uma anotação do JUnit (framework de teste) para rodar os testes unitários. No nosso caso utilizamos a classe SpringExtension para rodar os testes unitários seguindo uma extensão do spring boot

O ato de **MOCKAR** pode ser observado como **SIMULAR**.

- @MockBean: usamos esta anotação para especificar que este objeto vai ser mockado (simunado) pelo framework de teste.

- BDD: Behavior Driven Development (Desenvolvimento Orientado a Comportamento): é um processo para auxiliar a especificação e execução de testes.

As palavras chaves são:

- dado que
- quando
- então

Exemplo:

- Cenário: retornar um usuário da minha aplicação

- Dado que : queira retornar o usuário de ID 1
- Quando: eu fizer a chamada para o serviço
- Então: terei os dados do usuário com ID 1