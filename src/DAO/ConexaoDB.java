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

    public Connection getConnections() throws SQLException {
//        Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
        String connectionUrl
                = "jdbc:sqlserver://localhost:1433;"
                + "database=gextil;"
                + "user=sa;"
                + "password=123456;";

//        ResultSet resultSet = null;

        Connection connection = DriverManager.getConnection(connectionUrl);
        return connection; //.createStatement();
    }

}
