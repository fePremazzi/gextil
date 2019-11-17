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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class UsuarioController {

    public UsuarioVO getById(int id) {

        try {
            UsuarioDAO usrDao = new UsuarioDAO();
            return usrDao.getById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<UsuarioVO> getAll() {
        List<UsuarioVO> listAll = new ArrayList<UsuarioVO>();
        try {
            UsuarioDAO usrDao = new UsuarioDAO();

            return usrDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }

    public int getNextId() {
        try {
            UsuarioDAO usrDao = new UsuarioDAO();
            return usrDao.getProximoId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void insere(UsuarioVO usuario) {
        try {
            if (usuario != null) {

                UsuarioDAO usrDao = new UsuarioDAO();

                usuario.setSenha(Validacao.encriptSenha(usuario.getSenha()));

                usrDao.insereUsuario(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualiza(ClienteVO cliente) {
    }

    public void deletaPorId(int id) {
        try {

            UsuarioDAO usrDao = new UsuarioDAO();
            usrDao.deleteById(id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verificaUsuario(String username, String senhaTela) {

        try {
            UsuarioVO userBanco = this.consultaPorUsername(username);

            String senhaEncript = Validacao.encriptSenha(senhaTela);

            if (userBanco == null) {
                return false;
            }
            return Validacao.verificaSenha(senhaEncript, userBanco.getSenha());

        } catch (Exception e) {
            return false;
        }

    }

    public UsuarioVO consultaPorUsername(String username) {
        UsuarioDAO user = new UsuarioDAO();
        return user.selecionaPorUsername(username);
    }

    public List<ClienteVO> consultaTodos() {
        return null;
    }

}
