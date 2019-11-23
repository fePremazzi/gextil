/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Controller;

import DAO.PedidoDAO;
import VOs.PedidoVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class PedidoController {

    public void update(PedidoVO ped) {
        try {
            PedidoDAO peDao = new PedidoDAO();
            peDao.update(ped);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PedidoVO getById(int id) {
        try {
            PedidoDAO peDao = new PedidoDAO();
            return peDao.getById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<PedidoVO> getAll() {
        List<PedidoVO> listAll = new ArrayList<>();
        try {
            PedidoDAO peDao = new PedidoDAO();

            return peDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }

    public int getNextId() {
        try {
            PedidoDAO peDao = new PedidoDAO();
            return peDao.getProximoId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public int getNextNumId() {
        try {
            PedidoDAO peDao = new PedidoDAO();
            return peDao.getProximoNumId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void insere(PedidoVO ped) {
        try {
            if (ped != null) {

                PedidoDAO peDao = new PedidoDAO();
                peDao.insere(ped);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deletaPorId(int id) {
        try {

            PedidoDAO peDao = new PedidoDAO();
            peDao.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
