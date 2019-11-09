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
public class UsuarioDAO extends Repositorio{
    
    public UsuarioDAO(){
        tableName = "tbUsuario";
        spDeleta = "spDeletaUsuario"; // verificar nome da sp
    }
    
    public UsuarioVO selecionaPorUsername(String username){
        
        try {
            String selectSql = "SELECT * FROM tbUsuario WHERE username = ?;";
            ConexaoDB stat = new ConexaoDB();
            Connection con = stat.getConnections();
            PreparedStatement stmt = con.prepareStatement(selectSql);
            
            stmt.setString(0, username);
            
            ResultSet resultSet = stmt.executeQuery();

            // Print results from select statement
            while (resultSet.first()) {
                int id = resultSet.getInt("id");
                return resultSet.getString("senha");
            }
        } catch (Exception e) {
        }
        
        
        return "null";
    }
    
    public UsuarioVO montaVO (int id, String nome, int id_cargo, String username, String senha, int id_role){
        
        return new UsuarioVO(nome, username, senha, id_cargo, id_role, id);
        
    }
    
}
