-- FUNCTIONS (CALCULOS PARA TRATAMENTO NO BANCO)
CREATE FUNCTION fn_TotalGeral
(
	@itm_valor decimal(6,2),
	@itm_qtd int
)
RETURNS decimal(6,2)
AS
BEGIN
	RETURN (@itm_valor * @itm_qtd)
END

/************************************************************************/

CREATE FUNCTION fn_Descontos
(
	@itm_valor decimal(6,2),
	@desconto int
)
RETURNS decimal(6,2)
AS
BEGIN 
	RETURN @itm_valor - (@itm_valor * @desconto/100)
END

-- PROCEDURES (INSERT, DELETE E UPDATE DE INFORMAÇÕES NAS TABELAS)
/************************************************************************/

	CREATE PROCEDURE sp_Insert_tbPedido (
		@IdPedido int, 
		@Num_Cliente_Pedido varchar(15), 
		@Tipo_Pedido varchar(15), 
		@Data_Cad_Pedido datetime, 
		@Data_Entrega_Pedido datetime, 
		@Id_Cliente int, 
		@Id_Usuario int)
	AS
		if NOT EXISTS (SELECT Id FROM tbPedido WHERE Id = @IdPedido)
		BEGIN
			INSERT INTO tbPedido (Num_Cliente, Tipo, Data_cadastro, Data_entrega, Id_cliente, Id_usuario)
			VALUES (@Num_Cliente_Pedido, @Tipo_Pedido, @Data_Cad_Pedido, @Data_Entrega_Pedido, @Id_Cliente, @Id_Usuario)
			EXEC sp_refreshview vw_ConsultaUltPedido
		END

/************************************************************************/

CREATE PROCEDURE sp_Insert_tbPedItm(
	@IdPedItm int,
	@Id_Pedido int,
	@Id_Item int, 
	@Desconto_Item int, 
	@Qtd_Itm_Pedido int)
AS
	BEGIN
		INSERT INTO tbPedItm (Id_Pedido, Id_Item, Desconto_Item, Qtd_Item)
		VALUES (@Id_Pedido, @Id_Item, @Desconto_Item, @Qtd_Itm_Pedido)
	END


/************************************************************************/

CREATE TRIGGER trg_Delete_Pedido on tbPedido instead of DELETE AS
BEGIN
	DECLARE
	@IdPedido int

	SELECT @IdPedido = Id FROM DELETED
	DELETE FROM tbPedItm WHERE Id_Pedido = @IdPedido	
	DELETE FROM tbPedido WHERE Id = @IdPedido
END

/************************************************************************/

CREATE PROCEDURE sp_Delete_tbPedido (
	@IdPedido int) as
BEGIN
	DELETE FROM tbPedido WHERE Id = @IdPedido
END

/************************************************************************/

CREATE TRIGGER trg_Delete_Orcamento on tbOrcamento instead of DELETE AS
BEGIN
	DECLARE
	@IdOrcamento int

	SELECT @IdOrcamento = Id FROM DELETED
	DELETE FROM tbOrcItm WHERE Id_Orcamento = @IdOrcamento	
	DELETE FROM tbOrcamento WHERE Id = @IdOrcamento
END

/************************************************************************/

CREATE PROCEDURE sp_Delete_tbOrcamento (
	@IdOrcamento int) as
BEGIN
	DELETE FROM tbOrcamento WHERE Id = @IdOrcamento
END

/************************************************************************/

CREATE PROCEDURE sp_Insert_tbOrcamento (
	@IdOrcamento int, 
	@Tipo_Orcamento varchar(15), 
	@Data_Cad_Orcamento datetime, 
	@Data_Entrega_Orcamento datetime,
	@Valida_Orcamento bit, 
	@Id_Cliente int, 
	@Id_Usuario int) 
AS
	if NOT EXISTS (SELECT Id FROM tbOrcamento WHERE Id = @IdOrcamento)
	BEGIN
		INSERT INTO tbOrcamento (Tipo, Data_cadastro, Data_entrega, Valida, Id_Cliente, Id_Usuario)
		VALUES (@Tipo_Orcamento, @Data_Cad_Orcamento, @Data_Entrega_Orcamento, @Valida_Orcamento, @Id_Cliente, @Id_Usuario)
		EXEC sp_refreshview vw_ConsultaUltOrcamento
	END

/************************************************************************/

CREATE PROCEDURE sp_Insert_tbOrcItm(
	@Id_OrcItm int,
	@Id_Orcamento int,
	@Id_Item int, 
	@Desconto_Item int, 
	@Qtd_Item_Orcamento int)
AS
	BEGIN
		INSERT INTO tbOrcItm (Id_Orcamento, Id_Item, Desconto_Item, Qtd_Item)
		VALUES (@Id_Orcamento, @Id_Item, @Desconto_Item, @Qtd_Item_Orcamento)
	END

/************************************************************************/

CREATE PROCEDURE sp_Subtotal_tbPedido (
	@IdPedido int) as
BEGIN
	if (SELECT Desconto_Item FROM tbPedItm WHERE Id_Pedido = @IdPedido) <= 0
		SELECT p.Id as "Pedido Nº", 
		CONCAT(i.Nome, ' - ', i.Descricao, 'Tam: ', i.Tamanho,' - ', i.Cor) as "Item", 
		tpi.Qtd_Item as "Quantidade", 
		dbo.fn_TotalGeral(i.Valor_Item, tpi.Qtd_item) as "Valor Total"
		FROM tbPedido p
		inner join tbPedItm tpi on tpi.Id_Pedido = p.Id
		inner join tbItem i on i.Id = tpi.Id_Item
		WHERE p.Id = @IdPedido
	else
		SELECT p.Id as "Pedido Nº",
		CONCAT(i.Nome, ' - ', i.Descricao, 'Tam: ', i.Tamanho,' - ', i.Cor) as "Item", 
		tpi.Qtd_Item as "Quantidade", tpi.Desconto_Item as "Desconto %",
		dbo.fn_Descontos(i.Valor_Item, tpi.Desconto_Item) as "Valor Total"
		FROM tbPedido p
		inner join tbPedItm tpi on tpi.Id_Pedido = p.Id
		inner join tbItem i on i.Id = tpi.Id_Item
		WHERE p.Id = @IdPedido
END

/************************************************************************/

CREATE PROCEDURE sp_Subtotal_tbOrcamento (
	@IdOrcamento int)
AS
BEGIN
	if (SELECT sum(Desconto_Item) FROM tbOrcItm WHERE Id_Orcamento = @IdOrcamento) <= 0
	BEGIN
		SELECT o.Id as "Orçamento Nº", 
		CONCAT(i.Nome, ' - ', i.Descricao, 'Tam: ', i.Tamanho,' - ', i.Cor) as "Item", 
		toi.Qtd_Item as "Quantidade", 
		dbo.fn_TotalGeral(i.Valor, toi.Qtd_Item) as "Valor Total"
		FROM tbOrcamento o
		inner join tbOrcItm toi on toi.Id_Orcamento = o.Id
		inner join tbItem i on i.Id = toi.Id_Item
		WHERE o.Id = @IdOrcamento
	END

	else
	BEGIN
		DECLARE @orcamento int

		CREATE TABLE #valor_descontos(
			item int,
			valor decimal(6,2),
			desconto int,
			total_desc decimal(6,2))

		DECLARE cur_DescontoItem CURSOR FOR
		SELECT Id FROM tbOrcamento WHERE Id = @IdOrcamento

		OPEN cur_DescontoItem

		FETCH NEXT FROM cur_DescontoItem 
		INTO @orcamento

		WHILE @@FETCH_STATUS = 0
			BEGIN
				INSERT INTO #valor_descontos (item, valor, desconto, total_desc)
				SELECT o.Id_Item, i.Valor, o.Desconto_Item, dbo.fn_Descontos(i.Valor, o.Desconto_Item) FROM tbOrcItm o
				inner join tbItem i on i.Id = o.Id_Item
				WHERE Id_Orcamento = @IdOrcamento

				FETCH NEXT FROM cur_DescontoItem 
				INTO @orcamento
			END

		CLOSE cur_DescontoItem
		DEALLOCATE cur_DescontoItem

		SELECT * FROM #valor_descontos
	END
END

/************************************************************************/

CREATE PROCEDURE sp_Concatena_Itens 
AS
BEGIN
	SELECT i.Id as "Item Nº", CONCAT(i.Id, ' - ', i.Nome, ' - ', i.Tamanho, ' - ', i.Cor, ' - ', i.Valor, ' - ', i.Descricao) as "Item" 
	FROM tbItem i 
END

/************************************************************************/

CREATE PROCEDURE sp_Concatena_Clientes
AS
BEGIN
	SELECT c.Id as "Cliente Nº", CONCAT(c.Id, ' - ', c.Nome, ' - ', c.Cpf_cnpj) as "Cliente" 
	FROM tbCliente c
END

/************************************************************************/

CREATE PROCEDURE sp_Concatena_Usuarios 
AS
BEGIN
	SELECT u.Id as "Usuario Nº", CONCAT(u.Id, ' - ', u.Nome, ' - ', u.id_cargo, ' - ', u.Username) as "Usuario" 
	FROM tbUsuario u 
END

/************************************************************************/

CREATE PROCEDURE sp_Insert_tbItem (
	@IdItem int,
	@Nome_Item varchar(30), 
	@Tamanho_Item varchar(4),
	@Cor_Item varchar(20), 
	@Valor_Item decimal(6,2), 
	@Descricao_Item varchar(30),
	@Imagem_Item image) 
AS
BEGIN
	if NOT EXISTS 
	(SELECT Nome, Tamanho, Cor FROM tbItem  
	WHERE Nome = @Nome_Item AND Tamanho = @Tamanho_Item AND Cor = @Cor_Item)
	BEGIN
		INSERT INTO tbItem (nome, tamanho, cor, valor, descricao, Imagem) 
		VALUES (@Nome_Item, @Tamanho_Item, @Cor_Item, @Valor_Item, @Descricao_Item, @Imagem_Item)
		RETURN 1
	END

	else
		RETURN 0
END

/************************************************************************/

CREATE PROCEDURE sp_Insert_tbCliente (
	@IdCliente int,
	@Nome_Cliente varchar(30), 
	@CNPJ varchar(14),
	@Imagem varchar(max)) 
AS
BEGIN
	if NOT EXISTS 
	(SELECT Cpf_cnpj FROM tbCliente WHERE Cpf_cnpj = @cnpj)
	BEGIN
		INSERT INTO tbCliente (nome, Cpf_cnpj, Imagem) 
		VALUES (@Nome_Cliente, @cnpj, @Imagem)
		RETURN 1
	END

	else
		RETURN 0
END

/************************************************************************/

CREATE PROCEDURE sp_Insert_tbUsuario (
	@IdUsuario int,
	@Nome_Usuario varchar(30), 
	@Cargo_Usuario varchar(30),
	@User_Usuario varchar(30), 
	@Senha_Usuario varchar(30),
	@Id_role varchar(30),
	@Imagem varchar(max))
AS
BEGIN
	if NOT EXISTS 
	(SELECT username FROM tbUsuario 
	WHERE username = @User_Usuario)
	BEGIN
		INSERT INTO tbUsuario (nome, id_cargo, username, senha, id_role, imagem) 
		VALUES (@Nome_Usuario, @Cargo_Usuario, @User_Usuario, @Senha_Usuario, @Id_role, @Imagem)
		RETURN 1
	END

	else
		RETURN 0
END

/************************************************************************/

CREATE PROCEDURE sp_Update_tbItem (
	@IdItem int,
	@Nome_Item varchar(30), 
	@Tamanho_Item varchar(4), 
	@Cor_Item varchar(20), 
	@Valor_Item decimal(6,2), 
	@Descricao_Item varchar(30),
	@Imagem_Item image)
AS
BEGIN
	UPDATE tbItem
	SET Valor = @Valor_Item, Descricao = @Descricao_Item, Imagem = @Imagem_Item
	WHERE Nome = @Nome_Item AND Tamanho = @Tamanho_Item AND Cor = @Cor_Item
END

/************************************************************************/

CREATE PROCEDURE sp_Update_tbCliente (
	@IdCliente int,
	@Nome_Cliente varchar(30),
	@CNPJ varchar(14),
	@Imagem varchar(max))
AS
BEGIN
	UPDATE tbCliente
	SET Cpf_cnpj = @cnpj, Nome = @Nome_Cliente, Imagem = @Imagem
	WHERE Id = @IdCliente
END

/************************************************************************/

CREATE PROCEDURE sp_Update_tbUsuario (
	@IdUsuario int,
	@Nome_Usuario varchar(30), 
	@Cargo_Usuario varchar(30),
	@User_Usuario varchar(30), 
	@Senha_Usuario varchar(30),
	@Id_role varchar(30),
	@Imagem varchar(max))
AS
BEGIN
	UPDATE tbUsuario
	SET Nome = @Nome_Usuario, id_cargo = @Cargo_Usuario, senha = @Pw_Usuario, id_role = @Id_role, imagem = @imagem
	WHERE User_Usuario = @User_Usuario
END 

/************************************************************************/

CREATE PROCEDURE sp_Delete_tbItem (
	@IdItem int)
AS
BEGIN
	if NOT EXISTS 
	(SELECT i.Nome, i.Tamanho, i.Cor FROM tbPedItm p 
	inner join tbItem i on p.Id_Item = i.Id
	WHERE i.Id = @IdItem)
		DELETE FROM tbItem WHERE Id = @IdItem

	if NOT EXISTS 
	(SELECT i.Nome, i.Tamanho, i.Cor FROM tbOrcItm o 
	inner join tbItem i on o.Id_Item = i.Id
	WHERE i.Id = @IdItem)
		DELETE FROM tbItem WHERE Id = @IdItem
END 

/************************************************************************/

CREATE PROCEDURE sp_Delete_tbCliente (
	@IdCliente int)
AS
BEGIN
	if NOT EXISTS 
	(SELECT c.Cpf_cnpj FROM tbPedido p 
	inner join tbCliente c on p.Id_Cliente = c.Id
	WHERE C.Id  = @IdCliente)
		DELETE FROM tbCliente WHERE Id = @IdCliente

	if NOT EXISTS 
	(SELECT c.Cpf_cnpj FROM tbOrcamento o 
	inner join tbCliente c on o.Id_Cliente = c.Id 
	WHERE C.Id = @IdCliente)
		DELETE FROM tbCliente WHERE Id = @IdCliente
END

/************************************************************************/

CREATE PROCEDURE sp_Delete_tbUsuario (
	@Id_Usuario int)
AS
BEGIN
	if NOT EXISTS 
	(SELECT u.usuario FROM tbPedido p 
	inner join tbUsuario u on p.Id_Usuario = u.Id
	WHERE u.Id = @Id_Usuario)
		DELETE FROM tbUsuario WHERE Id = @Id_Usuario

	if NOT EXISTS
	(SELECT u.usuario FROM tbOrcamento o 
	inner join tbUsuario u on o.Id_Usuario = u.Id
	WHERE u.Id = @Id_Usuario)
		DELETE FROM tbUsuario WHERE Id = @Id_Usuario
END 

/************************************************************************/

CREATE INDEX ind_NfPedido ON tbPedido(Num_Cliente)

CREATE INDEX ind_DescItem ON tbItem(Descricao)

/************************************************************************/

CREATE PROCEDURE sp_RelData_CadPedido(
	@Data_Cad_Pedido_I datetime,
	@Data_Cad_Pedido_F datetime)
AS
BEGIN
	SELECT p.IdPedido, c.Nome_Cliente, p.Tipo_Pedido FROM tbPedido p
	inner join tbCliente c on c.IdCliente = p.Id_Cliente 
	WHERE Data_Cad_Pedido between @Data_Cad_Pedido_I and @Data_Cad_Pedido_F

	SELECT poi.Id_Pedido, i.Nome_Item, i.Descricao_Item, i.Tamanho_Item, i.Cor_Item, poi.Qtd_Itm_Pedido, i.Valor_Item FROM tbPedItm poi
	inner join tbItem i on i.IdItem = poi.Id_Item
	inner join tbPedido p on p.IdPedido = poi.Id_Pedido
	WHERE Data_Cad_Pedido between @Data_Cad_Pedido_I and @Data_Cad_Pedido_F
END

/************************************************************************/

CREATE PROCEDURE sp_RelData_EntrPedido(
	@Data_Entr_Pedido_I datetime,
	@Data_Entr_Pedido_F datetime)
AS
BEGIN
	SELECT p.IdPedido, c.Nome_Cliente, p.Tipo_Pedido FROM tbPedido p
	inner join tbCliente c on c.IdCliente = p.Id_Cliente 
	WHERE Data_Entrega_Pedido between @Data_Entr_Pedido_I and @Data_Entr_Pedido_F

	SELECT poi.Id_Pedido, i.Nome_Item, i.Descricao_Item, i.Tamanho_Item, i.Cor_Item, poi.Qtd_Itm_Pedido, i.Valor_Item FROM tbPedItm poi
	inner join tbItem i on i.IdItem = poi.Id_Item
	inner join tbPedido p on p.IdPedido = poi.Id_Pedido
	WHERE Data_Entrega_Pedido between @Data_Entr_Pedido_I and @Data_Entr_Pedido_F
END

/************************************************************************/

CREATE PROCEDURE sp_RelData_CadOrcamento(
	@Data_Cad_Orcamento_I datetime,
	@Data_Cad_Orcamento_F datetime)
AS
BEGIN
	SELECT o.IdOrcamento, c.Nome_Cliente, o.Tipo_Orcamento FROM tbOrcamento o
	inner join tbCliente c on c.IdCliente = o.Id_Cliente 
	WHERE Data_Cad_Orcamento between @Data_Cad_Orcamento_I and @Data_Cad_Orcamento_F

	SELECT ooi.Id_Orcamento, i.Nome_Item, i.Descricao_Item, i.Tamanho_Item, i.Cor_Item, ooi.Qtd_Item_Orcamento, i.Valor_Item FROM tbOrcItm ooi
	inner join tbItem i on i.IdItem = ooi.Id_Item
	inner join tbOrcamento o on o.IdOrcamento = ooi.Id_Orcamento
	WHERE Data_Cad_Orcamento between @Data_Cad_Orcamento_I and @Data_Cad_Orcamento_F
END

/************************************************************************/

CREATE PROCEDURE sp_RelData_EntrOrcamento(
	@Data_Entr_Orcamento_I datetime,
	@Data_Entr_Orcamento_F datetime)
AS
BEGIN
	SELECT o.IdOrcamento, c.Nome_Cliente, o.Tipo_Orcamento FROM tbOrcamento o
	inner join tbCliente c on c.IdCliente = o.Id_Cliente 
	WHERE Data_Entrega_Orcamento between @Data_Entr_Orcamento_I and @Data_Entr_Orcamento_F

	SELECT ooi.Id_Orcamento, i.Nome_Item, i.Descricao_Item, i.Tamanho_Item, i.Cor_Item, ooi.Qtd_Item_Orcamento, i.Valor_Item FROM tbOrcItm ooi
	inner join tbItem i on i.IdItem = ooi.Id_Item
	inner join tbOrcamento o on o.IdOrcamento = ooi.Id_Orcamento
	WHERE Data_Entrega_Orcamento between @Data_Entr_Orcamento_I and @Data_Entr_Orcamento_F
END

/************************************************************************/

CREATE VIEW vw_ConsultaUltPedido AS
	SELECT top 1 IdPedido FROM tbPedido
	ORDER BY IdPedido DESC

/************************************************************************/

CREATE VIEW vw_ConsultaUltOrcamento AS
	SELECT top 1 IdOrcamento FROM tbOrcamento
	ORDER BY IdOrcamento DESC

/************************************************************************/

CREATE PROCEDURE sp_Consulta_ID_Mestre_Orcamento AS
BEGIN
	DECLARE @IdOrcamento int 

	SET @IdOrcamento =  (SELECT * FROM vw_ConsultaUltOrcamento)

	RETURN @IdOrcamento
END

/************************************************************************/

CREATE PROCEDURE sp_Consulta_ID_Mestre_Pedido AS
BEGIN
	DECLARE @IdPedido int 

	SET @IdPedido = (SELECT * FROM vw_ConsultaUltPedido)

	RETURN @IdPedido
END

/************************************************************************/

CREATE PROCEDURE sp_ConsultaAvancada_tbCliente(
	@IdPesquisa varchar (30), 
	@Nome_Cliente varchar (30), 
	@IdOrcamento varchar (30), 
	@CNPJ varchar(30),
	@IdPedido varchar (30), 
	@Data_Cad_Pedido varchar (30), 
	@Data_Entrega_Pedido varchar (30)) 
AS 
BEGIN
    SELECT DISTINCT c.* FROM tbCliente c
	left join tbOrcamento o on c.IdCliente = o.Id_Cliente
	left join tbPedido p on c.IdCliente = p.Id_Cliente
	WHERE
		(@IdPesquisa = '' or c.IdCliente = cast (@IdPesquisa as int)) and
		(@Nome_Cliente = '' or c.Nome_Cliente LIKE '%' + @Nome_Cliente + '%') and		
		(@IdOrcamento = '' or o.IdOrcamento = cast (@IdOrcamento as int)) and
		(@CNPJ = '' or c.CNPJ LIKE '%' + @CNPJ + '%') and	
		(@IdPedido = '' or p.IdPedido = cast (@IdPedido as int)) and
		(@Data_Cad_Pedido = '' or p.Data_Cad_Pedido >= cast (@Data_Cad_Pedido as datetime)
		and p.Data_Cad_Pedido < cast (@Data_Cad_Pedido as datetime) + 1 ) and
		(@Data_Entrega_Pedido = '' or p.Data_Entrega_Pedido >= cast (@Data_Entrega_Pedido as datetime)
		and p.Data_Entrega_Pedido < cast (@Data_Entrega_Pedido as datetime) + 1)
END

/************************************************************************/

CREATE PROCEDURE sp_ConsultaAvancada_tbPedido(
	@IdPesquisa varchar (30), 
	@CNPJ varchar (30), 
	@Data_Cad_Pedido varchar (30),
	@Data_Entrega_Pedido varchar (30), 
	@Num_Cliente_Pedido varchar (30), 
	@Nome_Item varchar (30)) 
AS
BEGIN
	SELECT DISTINCT p.* FROM tbPedido p
	inner join tbPedItm piI on p.IdPedido = piI.Id_Pedido
	left join tbItem i on i.IdItem = piI.Id_Item
	left join tbCliente c on c.IdCliente = p.Id_Cliente
	WHERE 
	    (@IdPesquisa = '' or p.IdPedido = cast (@IdPesquisa as int)) and
		(@CNPJ = '' or c.CNPJ LIKE '%' + @CNPJ + '%') and
	    (@Data_Cad_Pedido = '' or p.Data_Cad_Pedido >= cast (@Data_Cad_Pedido as datetime) 
		and p.Data_Cad_Pedido < cast (@Data_Cad_Pedido as datetime) + 1 ) and
		(@Data_Entrega_Pedido = '' or p.Data_Entrega_Pedido >= cast (@Data_Entrega_Pedido as datetime)
		and p.Data_Entrega_Pedido < cast (@Data_Entrega_Pedido as datetime) + 1) and
		(@Num_Cliente_Pedido = '' or p.Num_Cliente_Pedido = @Num_Cliente_Pedido) and 
		(@Nome_Item = '' or i.Nome_Item LIKE '%' + @Nome_Item + '%')
END

/************************************************************************/

CREATE PROCEDURE sp_ConsultaAvancada_tbItem(
	@IdPesquisa varchar (30),  
	@Descricao_Item varchar (30), 
	@Tamanho_Item varchar (30), 
	@Nome_Item varchar (30), 
	@Cor_Item varchar (30)) 
AS
BEGIN
	SELECT DISTINCT i.IdItem, i.Nome_Item, i.Tamanho_Item, i.Cor_Item,
	i.Valor_Item, i.Descricao_Item FROM tbItem i

	WHERE
		(@IdPesquisa = '' or i.IdItem = @IdPesquisa) and
		(@Descricao_Item = '' or i.Descricao_Item LIKE '%' + @Descricao_Item + '%') and
		(@Tamanho_Item = '' or i.Tamanho_Item = @Tamanho_Item) and 
		(@Nome_Item = '' or i.Nome_Item LIKE '%' + @Nome_Item + '%') and 
		(@Cor_Item = '' or i.Cor_Item LIKE '%' + @Cor_Item + '%')
END 