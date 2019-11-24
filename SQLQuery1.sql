if not exists(select * from sys.databases where name = 'gextil')
    create database gextil;
GO
use gextil
GO

-- Main tables

CREATE TABLE tbUsuario
(
	id int IDENTITY(1,1) PRIMARY KEY,
	nome varchar(30) NOT NULL,
	id_cargo int NOT NULL,
	username varchar(30) NOT NULL,
	senha varchar(max) NOT NULL,
    id_role int NOT NULL,
	imagem varchar(max)
);
GO
CREATE TABLE tbCliente
(
	Id			int IDENTITY(1,1) PRIMARY KEY,
	Nome		varchar(30) NOT NULL,
	Cpf_cnpj	varchar(30) NOT NULL,
	Imagem      varchar(max) NOT NUll
)
GO
CREATE TABLE tbItem
(
	Id			int IDENTITY(1,1) PRIMARY KEY,
	Nome		varchar(30)  NOT NULL,
	Tamanho		varchar(4)   NOT NULL,
	Cor			varchar(20)  NOT NULL,
	Valor		decimal(6,2) NOT NULL,
	Descricao	varchar(max)  NOT NULL,
)
GO
CREATE TABLE tbOrcamento
(
	Id						int IDENTITY(1,1) PRIMARY KEY,
	--Tipo					varchar(15) NOT NULL,
	Data_cadastro			datetime NOT NULL,
	--Data_entrega			datetime NOT NULL,
	--Valida					bit NOT NULL,
	Id_Cliente				int,
	Id_Usuario				int,
	Valor_total             decimal(6,2) NOT NULL,
	CONSTRAINT fk_CliOrc	FOREIGN KEY(Id_Cliente) REFERENCES tbCliente(Id),
	CONSTRAINT fk_UsrOrc	FOREIGN KEY(Id_Usuario) REFERENCES tbUsuario(Id)
)
GO
CREATE TABLE tbPedido
(
	Id						int IDENTITY(1,1) PRIMARY KEY,
	Num_pedido				varchar(15),
	Tipo					varchar(15) NOT NULL,
	Data_cadastro			datetime	 NOT NULL,
	Data_entrega			datetime	 NOT NULL,
	Id_cliente				int,
	Id_usuario				int,
	Id_orcamento            int,
	CONSTRAINT fk_OrcPed    FOREIGN KEY(Id_orcamento) REFERENCES tbOrcamento(Id),
	CONSTRAINT fk_CliPed	FOREIGN KEY(Id_cliente) REFERENCES tbCliente(Id),
	CONSTRAINT fk_UsrPed	FOREIGN KEY(Id_usuario) REFERENCES tbUsuario(Id)
)
GO
CREATE TABLE tbOrcItm
(
	Id						int IDENTITY(1,1) PRIMARY KEY,
	Id_Orcamento			int,
	Id_Item					int,
	Valor_item			    int NOT NULL,
	Qtd_Item				int NOT NULL,
	CONSTRAINT fk_OrcExpI FOREIGN KEY(Id_Orcamento) REFERENCES tbOrcamento(Id),
	CONSTRAINT fk_OrcItm FOREIGN KEY(Id_Item) REFERENCES tbItem(Id)
)
GO
CREATE TABLE tbRole
(
	id int IDENTITY(1,1) PRIMARY KEY,
	descricao varchar(50) NOT NULL
);
GO

-------------------------------------------------------------------------------------------------

INSERT INTO tbusuario (nome, id_cargo, username, senha, id_role) values ('Fellipe', 1, 'fe', 'EE3E4AF9C48A69F5A5C47153EB4A777754BFBE6F', 1);
GO
INSERT INTO tbRole (descricao) VALUES ('ADMIN');
GO
INSERT INTO tbRole (descricao) VALUES ('COMUM');

-------------------------------------------------------------------------------------------------



select * from tbCliente

select * from tbPedido

drop table tbusuario;


select * from tbRole;


select * from tbOrcamento

select * from tbOrcItm

SELECT isnull(max(id)+1,1) as proximo from tbUsuario;

UPDATE tbUsuario set id = 2 where id = 1002