/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Utils;

/**
 *
 * @author fePremazziNB
 */
public class Validacao {
    
    public static boolean verificaSenha(String senhaTela, String senhaBanco){       
        return senhaTela.equals(senhaBanco);
    }
    
}
