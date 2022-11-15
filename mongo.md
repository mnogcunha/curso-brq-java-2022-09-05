# Aula Mongo

## Docker

Mongo Compass (client):
```
    https://downloads.mongodb.com/compass/mongodb-compass-1.33.1-win32-x64.exe
```

Mongo container:

```
    docker run --name mongo -p 27017:27017 -d mongo:3.6
```

## No mongo Compass

```
    mongodb://admin@localhost
```

## Trazer todos documentos que possuam a letra ‘a’ no nome

```
    {nome: { $regex: /a/ }}
```

## Trazer todos maiores de idade

idade >= 18

```
    { idade: {$gte: 18} }
```

## Combinar filtros usando vírgulas dentro do documento passado por parâmetro

```
    {nome: "Fabrizio", idade: {$gte: 18}}
```

## Outros operadores

- $gte: >=
- $eq: exatamente igual (=)
- $ne: diferente (<> ou !=)
- $gt: maior do que (>)
- $lt: menor do que (<)
- $lte: menor ou igual a (<=)
- $in: o valor está contido em um array de possibilidades, como em um OU. Ex: { idade: { $in: [10,12] } }

# Mongosh

- Mudar de banco de dados

```
    use fabrizio_borelli;
```

- Inserir um usuário:

```
    db.usuarios.insertOne( { nome: "Fabrizio Mongo SH", email : "sh@sh.com" } )
```

- Inserir vários usuários:

```
    db.usuarios.insertMany(
        [
            { nome: "Fabrizio Mongo SH 1", email : "sh1@sh.com" },
            { nome: "Fabrizio Mongo SH 2", email : "sh2@sh.com" },
            { nome: "Fabrizio Mongo SH 3", email : "sh3@sh.com" },
            { nombre: "Fabrizio Mongo SH 3", email : "sh3@sh.com", salario : 1001 },
        ]  
    )
```

- procurar um usuário pelo nome

```
    db.usuarios.find({nome: "Fabrizio Mongo SH"})
```

- procurar um usuário pelo nome com a frase SH

```
    db.usuarios.find({nome: { $regex: /SH/ } })
```

- procurar um usuário pelo salário (usando operador maior que)

```
    db.usuarios.find({salario: { $gte: 1000 } })
```

- funções limit e skip para limitar o número de documentos retornados e para ignorar alguns documentos

```
    db.usuarios.find().skip(1).limit(10)
```


- update apenas um registro

```
    db.usuarios.updateOne( {nome: "Fabrizio Mongo SH"}, { $set: { email: "alterado@g.com"}  } )
```

- update vários registros

Alterar todos os documentos que contenham SH

```
    db.usuarios.updateMany( {nome: /SH/}, { $set: { email: "alterado@g.com"}  } )
```

- delete (apenas um registro)

```
    db.usuarios.deleteOne({nome: "Fabrizio Mongo SH"})
```

# Algumas consultas

- db.usuarios.find( {} ) : retorna todos os usuários da coleção
- db.usuarios.find( { "name" : "Sarah Jones" } ): retorna os usuários exatamente com o name igual a 'Sarah Hojes'
- db.usuarios.find( { "name" : { $regex : /a/ }  } ) : retorna todos os usuários que contenham a letra 'a' no atributo 'name'.
- db.usuarios.find(  { $and :  [ { "name" : { $regex : /a/ } }, { id : { $gte : 1 }  } ]  }   ): retorna todos os usuários que contenham a letra 'a' no atributo 'name' e possuem o atributo 'id' >= 1
- db.usuarios.find( { "name" : { $regex : /a/ } , id : { $gte : 1 }  }  ): retorna todos os usuários que contenham a letra 'a' no atributo 'name' e possuem o atributo 'id' >= 1



# Criando Index para indexar todos os textos de todos os atributos de uma coleção

Trocar banco de dados

```
    use dbmongo
```

Criando Index para indexar todos os textos de todos os atributos de uma coleção:

```
    db.usuarios.createIndex( { "$**": "text" } )
```

Buscando todos os documentos com a palavra "Adam"

```
    db.usuarios.find({ $text: { $search: "Adam" } })
```

Inserindo um novo documento:

```
    db.usuarios.insert({
        "id": 4,
        "nomeBrasil": "Sarah Jones",
        "isActive": false,
        "dob": "1970-30-09"    
    })
```

Buscando todos os docuementos com a palavra Sarah Jones:

```
    db.usuarios.find({ $text: { $search: "Sarah Jones" } })
```



# No Spring (camada repository) :

@Query("{'nome' : ?0 }")
List<T> getByNome(  String nome );

@Query("{'nome' : :#{#nome} }")
List<T> getByNome( @Param("nome") String nome );