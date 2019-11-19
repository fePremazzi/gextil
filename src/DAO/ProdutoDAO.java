/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VOs.ProdutoVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class ProdutoDAO extends Repositorio {

    public ProdutoDAO() {
        tableName = "tbItem";
        spInsert = "INSERT INTO " + tableName + " (Nome, Tamanho, Cor, Valor, Descricao) "
                + "VALUES ( ? , ? , ? , ? , );";
    }

    public void update(ProdutoVO cl) {

    }

    public ProdutoVO getById(int id) {
        return null;
    }

    public List<ProdutoVO> getAll() {
        return null;
    }

    public void insere(ProdutoVO prd) {

    }

    public ProdutoVO montaVO(ResultSet rs) throws SQLException {
        return new ProdutoVO(rs.getString("Nome"),
                rs.getString("Cpf_cnpj"),
                rs.getString("Imagem"),
                rs.getInt("Id"));
    }

}
