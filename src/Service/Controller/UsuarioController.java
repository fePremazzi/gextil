/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Controller;

import DAO.UsuarioDAO;
import Service.Utils.Validacao;
import VOs.ClienteVO;
import VOs.UsuarioVO;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class UsuarioController {
    
    public boolean insere (ClienteVO cliente){
        return true;
    }
    
    public boolean atualiza (ClienteVO cliente){
        return true;
    }
    
    public boolean deletaorId(int id){
        return true;
    }
    
    public UsuarioVO verificaUsuario(String username, String senhaTela){
        
        try {
            UsuarioDAO user = new UsuarioDAO();
            
            String senhaBanco = user.selecionaPorUsername(username);
            return Validacao.verificaSenha(senhaTela, senhaBanco);           
            
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public List<ClienteVO> consultaTodos (){
        return null;
    }
    
    
    
}
