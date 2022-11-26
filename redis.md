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

# Redis Hash

Baseado em:

```
    https://www.digitalocean.com/community/tutorials/how-to-manage-hashes-in-redis
```

Um hash Redis é um tipo de dados que representa um mapeamento entre um campo de string e um valor de string. Os hashes podem conter muitos pares de valores de campo e são projetados para não ocupar muito espaço, tornando-os ideais para representar objetos de dados.

Para criar um hash, execute o comando hset. Este comando aceita o nome da chave de hash, a string de campo e a string de valor correspondente como argumentos:

```
    hset poet:Verlaine nationality French
```

Você pode determinar se existe um campo para um determinado hash com o comando hexists:

```
    hexists poet:Verlaine nationality
```

Para retornar o valor de um campo, execute o comando hget seguido da chave hash e do campo cujo valor você deseja recuperar

```
    hget poet:Verlaine nationality
```

Para obter uma lista de todos os campos contidos em um determinado hash, execute o comando hkeys:

```
    hkeys poet:Verlaine
```

Por outro lado, execute hvals para recuperar uma lista de valores contidos em um hash

```
    hvals poet:Verlaine
```

Para retornar uma lista de todos os campos mantidos por um hash e seus valores associados, execute hgetall:

```
    hgetall poet:Verlaine
```