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

/**
 *
 * @author fePremazziNB
 */
public class Repositorio {
    
    protected String tableName;
    protected String spDeleta;
    
    
    public int getProximoId() throws SQLException {
        int proximoId = 0;
        ConexaoDB connection = new ConexaoDB();
        Connection cn = null; 
        int nextId = 0;
        String selectSql = "SELECT isnull(max(id)+1,1) from ?; ";
        try {
            cn = connection.getConnections();
            PreparedStatement prepareSt = cn.prepareStatement(selectSql);
            prepareSt.setString(1, tableName);
            nextId = prepareSt.executeQuery().getInt(0);
        } catch (Exception e) {
        } finally{
            cn.close();
        }
        return nextId;
    }
    
    
    
}
