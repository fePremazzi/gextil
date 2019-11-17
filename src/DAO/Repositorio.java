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
public class Repositorio {

    protected String tableName;
    protected String spDeleta;
    protected String spInsert;
    protected String spSelectAll;

    public void deleteById(int id) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection cn = null;
        String selectSql = "DELETE " + tableName + " WHERE id = ? ;";

        try {
            cn = connection.getConnections();
            PreparedStatement stmt = cn.prepareStatement(selectSql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                cn.close();

            }
        }
    }

    public int getProximoId() throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection cn = null;
        String selectSql = "SELECT ISNULL(MAX(id)+1,1) AS proximo FROM " + tableName + ";";
        try {
            cn = connection.getConnections();
            PreparedStatement prepareSt = cn.prepareStatement(selectSql);

            ResultSet set = prepareSt.executeQuery();

            while (set.next()) {
                return set.getInt("proximo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                cn.close();

            }
        }
        return -2;
    }

}
