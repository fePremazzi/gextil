CREATE TABLE tbCliente
(
	Id			int IDENTITY(1,1) PRIMARY KEY,
	Nome		varchar(30) NOT NULL,
	Cpf_cnpj	varchar(30) NOT NULL,
	Imagem      varchar(max) NOT NUll
)

/************************************************************************/
CREATE TABLE tbItem
(
	Id			int IDENTITY(1,1) PRIMARY KEY,
	Nome		varchar(30)  NOT NULL,
	Tamanho		varchar(4)   NOT NULL,
	Cor			varchar(20)  NOT NULL,
	Valor		decimal(6,2) NOT NULL,
	Descricao	varchar(max)  NOT NULL,
)

/************************************************************************/
CREATE TABLE tbUsuario
(
	id			int IDENTITY(1,1) PRIMARY KEY,
	nome		varchar(30)  NOT NULL,
	id_cargo		int NOT NULL,
	username		varchar(30)  NOT NULL,
	senha			varchar(max)  NOT NULL,
	id_role int NOT NULL,
	imagem		varchar(max) NOT NULL
)

/************************************************************************/
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

/*************************************************************************/
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

/************************************************************************/
CREATE TABLE tbOrcItm
(
	Id						int IDENTITY(1,1) PRIMARY KEY,
	Id_Orcamento			int,
	CONSTRAINT fk_OrcExpI FOREIGN KEY(Id_Orcamento) REFERENCES tbOrcamento(IdOrcamento),
	Id_Item					int,
	CONSTRAINT fk_OrcItm FOREIGN KEY(Id_Item) REFERENCES tbItem(IdItem),
	Valor_item			    int,
	Qtd_Item				int NOT NULL
)

/************************************************************************/
CREATE TABLE tbPedItm
(
	Id						int IDENTITY(1,1) PRIMARY KEY,
	Id_Pedido				int,
	CONSTRAINT fk_PedExpI FOREIGN KEY(Id_Pedido) REFERENCES tbPedido(IdPedido),
	Id_Item					int,
	CONSTRAINT fk_PedItm FOREIGN KEY(Id_Item) REFERENCES tbItem(IdItem),
	Desconto_Item			int,
	Qtd_Item				int NOT NULL
)

/************************************************************************/