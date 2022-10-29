-- 13 de outubro

CREATE DATABASE IF NOT EXISTS db_curso_java;

use db_curso_java;

CREATE TABLE IF NOT EXISTS usuarios(
	id_user int primary key auto_increment,
	nome_user varchar(40),
	email_user varchar(50)
);

-- 17 de outubro

INSERT INTO usuarios
	(nome_user, email_user)
VALUES('Elys', 'elys@brq.com');

DELETE FROM usuarios
	where id_user = 1000;

-- 18 de outubro

ALTER TABLE usuarios
	ADD COLUMN idade int;

describe usuarios ;

CREATE INDEX usuarios_idade
	ON usuarios (idade);

ALTER TABLE usuarios
	DROP COLUMN idade;

-- aula 26/10
use db_curso_java;
-- DROP TABLE financiamentos;
CREATE TABLE IF NOT EXISTS financiamentos(
	id_financiamento int primary key
		auto_increment,
	numero_contrato int,
	valor decimal(13,2),
	usuario_id int,
	FOREIGN KEY (usuario_id)
	 references
		usuarios(id_user)
);


SELECT * FROM financiamentos f
	INNER JOIN usuarios u
		ON u.id_user = f.usuario_id;

INSERT INTO financiamentos
	(	numero_contrato,
			valor, usuario_id)
	VALUES ( 12345, 1000, 2 );

INSERT INTO financiamentos
	(	numero_contrato,
			valor, usuario_id)
	VALUES ( 124123, 2000, 2 );


-- aula 27/10
CREATE TABLE enderecos (
	id_endereco int primary key auto_increment,
	rua_endereco varchar(255),
	numero_endereco varchar(100),
	cep_endereco varchar(10),
	usuario_id int UNIQUE,
	FOREIGN KEY (usuario_id)
	 references
		usuarios(id_user)
);

use db_curso_java;

INSERT INTO db_curso_java.enderecos
(rua_endereco, numero_endereco,
	cep_endereco, usuario_id)
VALUES('Rua X', '12', '03456711', 2);

DROP TABLE IF EXISTS usuario_consorcio;
DROP TABLE IF EXISTS consorcios;

CREATE TABLE consorcios (
	id_consorcio int PRIMARY KEY auto_increment,
	nome_consorcio varchar(255),
	tipo_consorcio varchar(100),
	valor_consorcio decimal(13,2)
);

CREATE TABLE usuario_consorcio(
	id_usuario_consorcio int PRIMARY KEY auto_increment,
	usuario_id int,
	consorcio_id int,
	FOREIGN KEY (usuario_id)
	 references
		usuarios(id_user),
	FOREIGN KEY (consorcio_id)
	 references
		consorcios(id_consorcio)
);

INSERT INTO db_curso_java.consorcios
(nome_consorcio, tipo_consorcio, valor_consorcio)
VALUES('pirâmide', 'imóvel', 6);

INSERT INTO db_curso_java.consorcios
(nome_consorcio, tipo_consorcio, valor_consorcio)
VALUES('lata velha', 'automóvel', 1);


INSERT INTO db_curso_java.usuario_consorcio
(usuario_id, consorcio_id)
VALUES(2, 1);

INSERT INTO db_curso_java.usuario_consorcio
(usuario_id, consorcio_id)
VALUES(2, 2);

INSERT INTO db_curso_java.usuario_consorcio
(usuario_id, consorcio_id)
VALUES(3, 1);

