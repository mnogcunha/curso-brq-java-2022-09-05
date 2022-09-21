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