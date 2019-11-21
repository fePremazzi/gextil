/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Controller;

import DAO.ClienteDAO;
import VOs.ClienteVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class ClienteController {

    public void update(ClienteVO cl) {
        try {
            ClienteDAO clDao = new ClienteDAO();
            clDao.update(cl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClienteVO getById(int id) {

        try {
            ClienteDAO clDao = new ClienteDAO();
            return clDao.getById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<ClienteVO> getAll() {
        List<ClienteVO> listAll = new ArrayList<>();
        try {
            ClienteDAO clDao = new ClienteDAO();

            return clDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }

    public int getNextId() {
        try {
            ClienteDAO clDao = new ClienteDAO();
            return clDao.getProximoId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void insere(ClienteVO cl) {
        try {
            if (cl != null) {

                ClienteDAO clDao = new ClienteDAO();
                clDao.insere(cl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletaPorId(int id) {
        try {

            ClienteDAO clDao = new ClienteDAO();
            clDao.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClienteVO getByName(String name) {
        try {

            ClienteDAO clDao = new ClienteDAO();
            return clDao.getByName(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
