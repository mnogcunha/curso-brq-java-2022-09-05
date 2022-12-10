# Principais comandos

## Como iniciar um container (que ainda não existe)?

```
    docker run NOME-DA IMAGEM

    EX: docker run docker/getting-started
```

## para listar os container que estão em execução

```
    docker ps
```

# Se eu quiser parar a execuçõ de um container:

```
    docker stop NOMEDOCONTAINER
    Ex: docker stop elated_poitras
```

# Se eu quiser iniciar um container que já existe:

```
    docker start NOMEDOCONTAINER
    Ex: docker start elated_poitras
```

# Para remover um container:

Obs: o container deve estar parado!!!!!

```
    docker run NOMEDOCONTAINER
    Ex: docker rm elated_poitras
```

# Eu posso estipular o nome de um container

Obs: exemplo na criação do container
O nome da imagem sempre precisa ser o último parâmetro do docker run

```
    docker run  --nane NOMEDOCONTAINERDESEJO NOMEDAIMAGEM
    Ex: docker run --name hello-world docker/getting-started
```

# redirecionar a requisição da máquina hospedeira para um container docker

Obs: exemplo na criação do container


```
    docker run  --name NOMEDOCONTAINERDESEJO -p PORTA-HOSPEDEIRO:PORTA-CONTAINER  NOMEDAIMAGEM

    docker run  --name NOMEDOCONTAINERDESEJO -p PORTA-EXTERNA:PORTA-INTERNA  NOMEDAIMAGEM

    Ex: docker run --name hello-world -p 80:80  docker/getting-started

    docker run --name hello-word -p 80:80 -p 8000:80 docker/getting-started
```

# Como podemos acessar o terminal de um container?

Obs: o container deve estar em execução

```

    docker exec -it NOMEDOCONTAINER /bin/sh

    /bin/bash (terminal) é o comando que vamos executar quando ao entrar no container 
    -it -> 'modo interativo'

    Ex: docker exec -it hello-word /bin/sh
```

# Comandos Linux

```
    ls -> listar arquivos e pastas no Linux
    cd -> entrar dentro de uma pasta
    pwd -> mostrar em qual diretório nós estamos 
    cd .. -> voltar um nível no sistema de diretório
    mkdir -> criando uma pasta 
    touch -> criar um arquivo vazio
    cd / -> voltar para o diretório raiz
```
# dentro do container, iremos criar uma pasta

```
    mkdir pasta1
```

Para sair do container, digite:         exit

# Removendo o container para verificar o que acontece com o seu conteúdo

```
    docker stop hello-word
    docker rm hello-word
```

# Subindo um novo container da mesma imagem

```
    docker run --name hello-world -p 80:80 -p 8000:80  docker/getting-started
    docker exec -it hello-world /bin/sh
```

# Como podemos fazer para ao deletar um container, não perdermos dados do mesmo?

Resp: usando o conceito de volume, em que é um mecanismo parar salvar arquivos persistentes e compartilhar arquivos e dados entre os containers

${PWD} retorna o endereço de onde estamos


```
    docker run -v PASTA_DO_HOSPEDEIRO:PASTA_DO_CONTAINER

    Ex: 
    docker rm hello-world
    
    docker run --name hello-world -p 80:80 -p 8000:80 -v ${PWD}/meu-volume:/meu-volume-container docker/getting-started

    docker exec -it hello-world /bin/sh

    docker run --name hello-world -p 80:80 -p 8000:80 -v ${PWD}/meu-volume:/meu-volume-container

# Comandos para volumes

Para entrar dentro do container e dentro da pasta **meu-volume-container**

```
    docker exec -it hello-world /bin/bash
    cd meu-volume-container/
```

Criar arquivo **arquivo.txt**

```
    touch arquivo.txt
```

Observar mudança no arquivo **arquivo.txt**

```
    tail -f arquivo.txt 
```

## subindo o banco MySQL via container

Mapeando porta 3306, usuário **root** e senha **root**

```
    docker run -d --name=mysql-java -p 3306:3306 --env="MYSQL_ROOT_PASSWORD=root" -v ${PWD}/mysql-datadir:/var/lib/mysql    mysql
```

## Para acessar o banco de dados via terminal

```
    docker exec -it mysql-java /bin/bash
    mysql -uroot -proot
```

## Executando comandos SQLs

```
    create database db_correntista;
    use db_correntista;
    create table cuentas ( cd_contas int primary key auto_increment, nombre varchar(40) );
```

# aula criando imagem

Para criar nossa própria imagem: 

## para criar nossa própria imagem

```
    cd nginx
    docker build -t brq-nginx:latest .
```

# para criar um container oracle

```
    docker run -d -p 49161:1521 -e ORACLE_ALLOW_REMOTE=true  -e ORACLE_PASSWORD=oracle -e RELAX_SECURITY=1 --name oracle-xe-11g -e TZ=BR epiclabs/docker-oracle-xe-11g
```