create database gextil
use gextil

CREATE TABLE tbUsuario
(
	id int IDENTITY(1,1) PRIMARY KEY,
	nome varchar(30) NOT NULL,
	id_cargo int NOT NULL,
	username varchar(30) NOT NULL,
	senha varchar(max) NOT NULL,
    id_role int NOT NULL
);
drop table tbusuario;
CREATE TABLE tbRole
(
	id int IDENTITY(1,1) PRIMARY KEY,
	descricao varchar(50) NOT NULL
);
INSERT INTO tbRole (descricao) VALUES ('COMUM');
select * from tbRole;
INSERT INTO tbusuario (nome, id_cargo, username, senha, id_role) values ('Fellipe', 1, 'fe', 'EE3E4AF9C48A69F5A5C47153EB4A777754BFBE6F', 1);

select * from tbUsuario

SELECT isnull(max(id)+1,1) as proximo from tbUsuario;