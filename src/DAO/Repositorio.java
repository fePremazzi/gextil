/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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

    public ResultSet getAll() throws SQLException {

        ConexaoDB connection = new ConexaoDB();
        Connection cn = null;

        try {
            
            cn = connection.getConnections();
            PreparedStatement prepareSt = cn.prepareStatement(spSelectAll);

            return prepareSt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                cn.close();
            }
        }

        return null;
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
