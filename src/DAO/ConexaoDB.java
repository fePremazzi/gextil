/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fePremazziNB
 */
public class ConexaoDB {

    public Statement getConnections() throws SQLException {
        String connectionUrl
                = "jdbc:sqlserver://localhost:1433;"
                + "database=gextil;"
                + "user=sa;"
                + "password=123456;"
                + "trustServerCertificate=false;";

        ResultSet resultSet = null;

        Connection connection = DriverManager.getConnection(connectionUrl);
        return connection.createStatement();
    }

}
