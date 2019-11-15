/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fePremazziNB
 */
public class Validacao {
    
    public static boolean verificaSenha(String senhaTela, String senhaBanco){       
        return senhaTela.equals(senhaBanco);
    }
    
    public static String encriptSenha(String original){
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("SHA-1");
            byte messageDigest[] = algorithm.digest(original.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            
            return hexString.toString();
            //System.err.println(hexString.toString());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return original;
    }
    
    
}
