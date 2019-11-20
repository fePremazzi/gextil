/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VOs.Enuns.EnunCor;
import VOs.Enuns.EnunTamanho;
import VOs.ProdutoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class ProdutoDAO extends Repositorio {

    public ProdutoDAO() {
        tableName = "tbItem";
        spInsert = "INSERT INTO " + tableName + " "
                + "(Nome, Tamanho, Cor, Valor, Descricao) "
                + "VALUES ( ? , ? , ? , ? , ? );";
    }

    public void update(ProdutoVO prd) throws SQLException {

        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String sql = "UPDATE " + tableName + " SET Nome = ? , "
                + "Tamanho = ? ,"
                + "Cor = ? , "
                + "Valor = ? , "
                + "Descricao = ? WHERE Id = ? ;";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, prd.getNome());
            stmt.setString(2, prd.getTamanho().toString());
            stmt.setString(3, prd.getCor().toString());
            stmt.setDouble(4, prd.getValorUnit());
            stmt.setString(5, prd.getDescricao());
            stmt.setInt(6, prd.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public ProdutoVO getById(int id) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String spGetById = "SELECT * FROM " + tableName + " WHERE Id = ? ;";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spGetById);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return montaVO(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return null;
    }

    public List<ProdutoVO> getAll() throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String spSelectAll = "SELECT * FROM " + tableName + ";";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spSelectAll);

            ResultSet rs = stmt.executeQuery();

            List<ProdutoVO> listAll = new ArrayList<>();

            while (rs.next()) {
                System.out.println(rs.getString("Tamanho"));
                System.out.println(rs.getString("Cor"));

                listAll.add(montaVO(rs));
            }

            return listAll;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return null;
    }

    public void insere(ProdutoVO prd) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spInsert);
            //+ "(Nome, Tamanho, Cor, Valor, Descricao) "

            stmt.setString(1, prd.getNome());
            stmt.setString(2, prd.getTamanho().toString());
            stmt.setString(3, prd.getCor().toString());
            stmt.setDouble(4, prd.getValorUnit());
            stmt.setString(5, prd.getDescricao());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public ProdutoVO montaVO(ResultSet rs) throws SQLException {
        return new ProdutoVO(rs.getString("Nome"),
                EnunTamanho.valueOf(rs.getString("Tamanho")),
                EnunCor.valueOf(rs.getString("Cor")),
                rs.getDouble("Valor"),
                rs.getString("Descricao"),
                rs.getInt("Id"));
    }

}
