/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VOs.ClienteVO;
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
public class ClienteDAO extends Repositorio {

    public ClienteDAO() {
        tableName = "tbCliente";
        spInsert = "INSERT into " + tableName + " (Nome, Cpf_cnpj, Imagem) VALUES ( ? , ? , ? );";
    }

    public void update(ClienteVO cl) throws SQLException {

        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String sql;
        if (cl.getFoto().isEmpty() || cl.getFoto() == null) {
            sql = "UPDATE " + tableName + " SET Nome = ? , "
                    + "Cpf_cnpj = ? ,"
                    + "Imagem = ? WHERE Id = ? ;";
        } else {
            sql = "UPDATE " + tableName + " SET Nome = ? , "
                    + "Cpf_cnpj = ? "
                    + "WHERE Id = ? ;";
        }

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(sql);

            if (cl.getFoto().isEmpty() || cl.getFoto() == null) {
                stmt.setString(1, cl.getNome());
                stmt.setString(2, cl.getCpfOuCnpj());
                stmt.setString(3, cl.getFoto());
                stmt.setInt(4, cl.getId());
            } else {
                stmt.setString(1, cl.getNome());
                stmt.setString(2, cl.getCpfOuCnpj());
                stmt.setInt(3, cl.getId());
            }

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public ClienteVO getById(int id) throws SQLException {
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

    public List<ClienteVO> getAll() throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String spSelectAll = "SELECT * FROM " + tableName + ";";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spSelectAll);

            ResultSet rs = stmt.executeQuery();

            List<ClienteVO> listAll = new ArrayList<>();

            while (rs.next()) {
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

    public void insere(ClienteVO cl) throws SQLException {

        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        try {
            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spInsert);

            stmt.setString(1, cl.getNome());
            stmt.setString(2, cl.getCpfOuCnpj());
            stmt.setString(3, cl.getFoto());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public ClienteVO montaVO(ResultSet rs) throws SQLException {
        return new ClienteVO(rs.getString("Nome"),
                rs.getString("Cpf_cnpj"),
                rs.getString("Imagem"),
                rs.getInt("Id"));
    }

}
