# API

Application Programming Interface

# Json é chave : valor

"nome" : "Fabrizio",
"sobrenome": "Borelli",
"idade": 34

# Estrutura Json

{} -> é um objeto
[] -> é um array

# Todo Json começa com {} ou  []

{
"curso" : "Java",
"professor" : "Nelson",
"carga-horaria" : 296,
"telefones" : [
"11982733817", "1144833839"
]
}


# Sobre REST, temos os seguintes verbos:

Verbos são ações que gostaríamos de "fazer"

- GET : para "retornar" dados
- POST : para "enviar" dados novos
- PATCH : Para atualizar dados
- PUT : Para atualizar dados
- DELETE : Para deletar dados

PUT é usado quando enviamos um objeto completo. Se você quiser atualizar só uma parte dele e não reenviar tudo, use PATCH


# CRUD -> CREATE, READ, UPDATE , DELETE

É Criar, Ler, Alterar e Deletar uma **ENTIDADE**, como por exemplo, professores.

1. GET ALL (READ)
2. GET ONE (READ)
3. POST    (CREATE)
4. PATCH   (UPDATE) ou PUT (UPDATE)
5. DELETE  (DELETE)

Sendo mais genérico:

1. GET ALL --  /entidade
2. GET ONE (READ) --  /entidade/{id_da_entidade}
3. POST    (CREATE) --  /entidade
4. PATCH   (UPDATE) ou PUT (UPDATE) --  /entidade/{id_da_entidade}
5. DELETE  (DELETE) /entidade/{id_da_entidade}

Exemplo:

1. GET ALL --  /usuarios
2. GET ONE (READ) --  /usuarios/{id_do_usuario}
3. POST    (CREATE) --  /usuarios
4. PATCH   (UPDATE) ou PUT (UPDATE) --   /usuarios/{id_do_usuario}
5. DELETE  (DELETE)  /usuarios/{id_do_usuario}
6. GET /usuarios/{id_do_usuario}/nome/{nome_do_usuario}
