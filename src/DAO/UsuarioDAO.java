/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VOs.UsuarioVO;
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
public class UsuarioDAO extends Repositorio {

    public UsuarioDAO() {
        tableName = "tbUsuario";
        spDeleta = "spDeletaUsuario"; // verificar nome da sp
        spInsert = "INSERT INTO gextil.dbo.tbusuario (nome, id_cargo, username, senha, id_role) VALUES (?, ?, ?, ?, ?);";
    }

    public void update(UsuarioVO usr) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String sql;
        if (usr.getSenha().isEmpty() || usr.getSenha() == null) {
            sql = "UPDATE " + tableName + " SET nome = ? , "
                    + "id_cargo = ? , "
                    + "username = ? , "
                    + "id_role = ? "
                    + "WHERE id = ? ;";
        } else {
            sql = "UPDATE " + tableName + " SET nome = ? , "
                    + "id_cargo = ? , "
                    + "username = ? , "
                    + "senha = ? , "
                    + "id_role = ? "
                    + "WHERE id = ? ;";
        }

        try {
            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(sql);

            if (usr.getSenha().isEmpty() || usr.getSenha() == null) {
                stmt.setString(1, usr.getNome());
                stmt.setInt(2, usr.getCargo());
                stmt.setString(3, usr.getUsername());
                stmt.setInt(4, usr.getId_role());
                stmt.setInt(5, usr.getId());
            } else {
                stmt.setString(1, usr.getNome());
                stmt.setInt(2, usr.getCargo());
                stmt.setString(3, usr.getUsername());
                stmt.setString(4, usr.getSenha());
                stmt.setInt(5, usr.getId_role());
                stmt.setInt(6, usr.getId());
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

    public UsuarioVO getById(int id) {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String sql = "SELECT * FROM " + tableName + " WHERE id = ? ;";

        try {
            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return montaVO(rs);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<UsuarioVO> getAll() throws SQLException {

        ConexaoDB connection = new ConexaoDB();
        Connection cn = null;

        try {

            cn = connection.getConnections();
            PreparedStatement prepareSt = cn.prepareStatement(spSelectAll);

            ResultSet rs = prepareSt.executeQuery();

            List<UsuarioVO> listAll = new ArrayList<UsuarioVO>();

            while (rs.next()) {
                listAll.add(montaVO(rs));
            }

            return listAll;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                cn.close();
            }
        }

        return null;
    }

    public void insereUsuario(UsuarioVO usr) {

        try {
            ConexaoDB stat = new ConexaoDB();
            Connection con = stat.getConnections();
            PreparedStatement stmt = con.prepareStatement(spInsert);

            stmt.setString(1, usr.getNome());
            stmt.setInt(2, usr.getCargo());
            stmt.setString(3, usr.getUsername());
            stmt.setString(4, usr.getSenha());
            stmt.setInt(5, usr.getId_role());

            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    public UsuarioVO selecionaPorUsername(String username) {

        try {
            String selectSql = "SELECT * FROM tbUsuario WHERE username = ?;";
            ConexaoDB stat = new ConexaoDB();
            Connection con = stat.getConnections();
            PreparedStatement stmt = con.prepareStatement(selectSql);

//            stmt.setString(1, tableName);
            stmt.setString(1, username);

            ResultSet resultSet = stmt.executeQuery();

            // Print results from select statement
            while (resultSet.next()) {
                return montaVO(resultSet);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private UsuarioVO montaVO(ResultSet rs) throws SQLException {

        return new UsuarioVO(rs.getString("nome"),
                rs.getString("username"),
                rs.getString("senha"),
                rs.getInt("id_cargo"),
                rs.getInt("id_role"),
                rs.getInt("id"));

    }

}
