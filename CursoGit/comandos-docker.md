# Principais comandos

## Como iniciar um container? (Que ainda não existe)

```
    docker run NOME-DA IMAGEM

    docker run docker/getting-started 
```
## para listar os container que estão em execução

```
    docker ps
```
## se eu quiser parar a execução de um container

```
    docker stop NOMEDOCONTAINER
    Ex: docker stop funny_boyd
```
    docker stop funny_boyd 
```

# Se eu quiser iniciar um container que já existe:

```
    docker start NOMEDOCONTAINER
    Ex: docker start funny_boyd
```

# Para remover um container:

Obs: o container deve estar parado!!!!!

```
    docker run NOMEDOCONTAINER
    Ex: docker rm funny_boyd
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

    docker exec -it NOMEDOCONTAINER /bin/bash

    /bin/bash (terminal) é o comando que vamos executar quando ao entrar no container 
    -it -> 'modo interativo'

    Ex: docker exec -it hello-word /bin/bash
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