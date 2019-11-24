/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import gextil.config;
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
        String connectionUrl
                = "jdbc:sqlserver://" + config.db_server + ":1433;"
                + "database=gextil;"
                + "user=" + config.db_user + ";"
                + "password=" + config.db_password + ";";

        Connection connection = DriverManager.getConnection(connectionUrl);
        return connection;
    }

}
