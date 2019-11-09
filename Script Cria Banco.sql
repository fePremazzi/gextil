CREATE TABLE tbCliente
(
	IdCliente int IDENTITY(1,1) PRIMARY KEY,
	Nome_Cliente varchar(30) NOT NULL,
	CNPJ varchar(14) NOT NULL
)

/************************************************************************/
CREATE TABLE tbItem
(
	IdItem int IDENTITY(1,1) PRIMARY KEY,
	Nome_Item varchar(30) NOT NULL,
	Tamanho_Item varchar(4) NOT NULL,
	Cor_Item varchar(20) NOT NULL,
	Valor_Item decimal(6,2) NOT NULL,
	Descricao_Item varchar(30) NOT NULL,
	Image_Item varchar(max) NOT NULL
)

/************************************************************************/
CREATE TABLE tbUsuario
(
	IdUsuario int IDENTITY(1,1) PRIMARY KEY,
	Nome_Usuario varchar(30) NOT NULL,
	Cargo_Usuario varchar(30) NOT NULL,
	User_Usuario varchar(30) NOT NULL,
	Pw_Usuario varchar(30) NOT NULL,
	Image_Usuario varchar(max) NOT  NULL
)

/************************************************************************/
CREATE TABLE tbPedido
(
	IdPedido int IDENTITY(1,1) PRIMARY KEY,
	Num_Cliente_Pedido varchar(15),
	Tipo_Pedido varchar(15) NOT NULL,
	Data_Cad_Pedido datetime NOT NULL,
	Data_Entrega_Pedido datetime NOT NULL,
	Id_Cliente int,
	CONSTRAINT fk_CliPed FOREIGN KEY(Id_Cliente) REFERENCES tbCliente(IdCliente),
	Id_Usuario int,
	CONSTRAINT fk_UsrPed FOREIGN KEY(Id_Usuario) REFERENCES tbUsuario(IdUsuario)
)

/************************************************************************/
CREATE TABLE tbOrcamento
(
	IdOrcamento int IDENTITY(1,1) PRIMARY KEY,
	Tipo_Orcamento varchar(15) NOT NULL,
	Data_Cad_Orcamento datetime NOT NULL,
	Data_Entrega_Orcamento datetime NOT NULL,
	Valida_Orcamento bit NOT NULL,
	Id_Cliente int,
	CONSTRAINT fk_CliOrc FOREIGN KEY(Id_Cliente) REFERENCES tbCliente(IdCliente),
	Id_Usuario int,
	CONSTRAINT fk_UsrOrc FOREIGN KEY(Id_Usuario) REFERENCES tbUsuario(IdUsuario)
)

/************************************************************************/
CREATE TABLE tbOrcItm
(
	IdOrcItm int IDENTITY(1,1) PRIMARY KEY,
	Id_Orcamento int,
	CONSTRAINT fk_OrcExpI FOREIGN KEY(Id_Orcamento) REFERENCES tbOrcamento(IdOrcamento),
	Id_Item int,
	CONSTRAINT fk_OrcItm FOREIGN KEY(Id_Item) REFERENCES tbItem(IdItem),
	Desconto_Item int,
	Qtd_Item_Orcamento int NOT NULL
)

/************************************************************************/
CREATE TABLE tbPedItm
(
	IdPedItm int IDENTITY(1,1) PRIMARY KEY,
	Id_Pedido int,
	CONSTRAINT fk_PedExpI FOREIGN KEY(Id_Pedido) REFERENCES tbPedido(IdPedido),
	Id_Item int,
	CONSTRAINT fk_PedItm FOREIGN KEY(Id_Item) REFERENCES tbItem(IdItem),
	Desconto_Item int,
	Qtd_Itm_Pedido int NOT NULL
)

/************************************************************************/

CREATE TABLE tbProdPed
(
	IdProdPed int IDENTITY(1,1) PRIMARY KEY,
	Num_Etapa int NOT NULL,
	Final_Etapa bit NOT NULL,
	Id_Producao int,
	CONSTRAINT fk_ProdPrPd FOREIGN KEY(Id_Producao) REFERENCES tbProducao(IdProducao),
	Id_Processo int,
	CONSTRAINT fk_ProcPrPd FOREIGN KEY(Id_Processo) REFERENCES tbProcessos(IdProcessos)
)

/************************************************************************/
