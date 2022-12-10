
-- criar sequence para gerar valores auto increment
CREATE SEQUENCE usuario_seq
	START WITH 1
	INCREMENT BY 1;

-- selecionar o próximo valor
SELECT usuario_seq.nextval FROM dual;

-- selecionar o valor atual
SELECT usuario_seq.currval FROM dual;

-- criando tabela de usuários
CREATE TABLE usuarios(
	id_user int primary key,
	nome_user varchar2(40),
	email_user varchar2(50)
);

-- criando nosso primeiro insert
INSERT INTO usuarios
	(id_user, nome_user, email_user)
	VALUES (usuario_seq.nextval,
		'Fabrizio', 'fab@gmail.com' );

-- fazendo commit
COMMIT;

-- selecionando (limit) de uma consulta
SELECT * FROM usuarios
	WHERE rownum = 1;

-- ver as tabelas no oracle
SELECT owner, table_name
  FROM dba_tables;

-- SELECT * FROM cadastro;
