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

```
    docker run  --nane NOMEDOCONTAINERDESEJO NOMEDAIMAGEM
    Ex: docker run --name hello-world  docker/getting-started
```
# redirecionar a requisição da máquina hospedeira para um container docker

Obs: exemplo na criação do container

```
    docker run  --name NOMEDOCONTAINERDESEJO -p PORTA-HOSPEDEIRO:PORTA-CONTAINER  NOMEDAIMAGEM
    Ex: docker run --name hello-world -p 80:80  docker/getting-started
```