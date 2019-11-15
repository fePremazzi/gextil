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

/**
 *
 * @author fePremazziNB
 */
public class UsuarioDAO extends Repositorio {

    public UsuarioDAO() {
        tableName = "tbUsuario";
        spDeleta = "spDeletaUsuario"; // verificar nome da sp
        spInsert = "INSERT INTO gextil.dbo.tbusuario (nome, id_cargo, username, senha, id_role) VALUES (?, ?, ?, ?, ?);";
        spSelectAll = "SELECT * FROM " + tableName + ";";
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

            stmt.executeQuery();
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
                return montaVO(resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getInt("id_cargo"),
                        resultSet.getString("username"),
                        resultSet.getString("senha"),
                        resultSet.getInt("id_role"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private UsuarioVO montaVO(int id, String nome, int id_cargo, String username, String senha, int id_role) {

        return new UsuarioVO(nome, username, senha, id_cargo, id_role, id);

    }

}
