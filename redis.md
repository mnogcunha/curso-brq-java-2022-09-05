# Para instalar Redis no Docker

### Baixar a imagem do Redis (Docker)

```
    docker pull redis
```

### Rodar container do Redis

```
    docker network create -d bridge redis-network

    docker run --name redis -d -p 6379:6379 -it --network=redis-network redis:latest
    
    docker run --name redis-commander -d --env REDIS_HOSTS=redis -p 8081:8081 --network=redis-network rediscommander/redis-commander:latest
```

### Entrar dentro do container do Redis

```
    docker exec -it redis /bin/bash
```


### Dentro do container Redis, entrar na redis client

```
    redis-cli
```

# Trabalhando com chaves no Redis

### criar uma chave

```
    SET name "fgv" 
```

### retornar o valor de uma chave

```
    GET name
```

### deletar uma chave

```
    DEL name
```

### padrões de chaves

```
    SET hello 1 
    SET hillo 2
    SET hallo 3
    SET heello 4
    SET hllo 5
```

Para buscar as chaves atraés de REGEX

```
    keys h?llo
```

### ver tipo do dado da chave

```
    type name
```

# Listas

- RPUSH : insere a direita da lista

```
    RPUSH mylist "hello"
```

- LPUSH : insere a esquerda da lista

```
    RPUSH mylist "world"
```

- LRANGE mylist 0 -1 : retorna os elementos armazenados em uma lista

```
    lrange mylist 0 -1
```


- RPUSHX mylist "World" (Insere um valor a direita da lista apenas se a chave existir)
- LPUSHX mylist "World" (Insere um valor a esquerda da lista apenas se a chave existir)
- LSET mylist 0 "four" (Seta um elemento no índice especificado.)
- LINDEX mylist 0 (Retorna o elemento no índice especificado)
- LLEN mylist (Retorna o tamanho da lista )
- LREM mylist 2 "hello" (Remove as primeiras ocorrências de um elemento em uma lista)

# Publish/Subscribe

Em um terminal:

```
    docker exec -it redis /bin/bash

    redis-cli

    SUBSCRIBE redisChat  
```

Em outro terminal:

```
    docker exec -it redis /bin/bash

    redis-cli

    PUBLISH redisChat "Redis is a great caching technique"  
```
