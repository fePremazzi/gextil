/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author fePremazziNB
 */
public class UsuarioDAO extends Repositorio{
    
    public UsuarioDAO(){
        tablePath = "tbUsuario";
        spDeleta = "spDeletaUsuario"; // verificar nome da sp
    }
    
}
