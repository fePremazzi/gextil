/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Controller;

import DAO.ProdutoDAO;
import VOs.ProdutoVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class ProdutoController {

    public void update(ProdutoVO prd) {
        try {
            ProdutoDAO prDao = new ProdutoDAO();
            prDao.update(prd);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProdutoVO getById(int id) {
        try {
            ProdutoDAO prDao = new ProdutoDAO();
            return prDao.getById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<ProdutoVO> getAll() {
        List<ProdutoVO> listAll = new ArrayList<>();
        try {
            ProdutoDAO prDao = new ProdutoDAO();

            return prDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }

    public int getNextId() {
        try {
            ProdutoDAO prDao = new ProdutoDAO();
            return prDao.getProximoId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void insere(ProdutoVO prd) {
        try {
            if (prd != null) {

                ProdutoDAO prDao = new ProdutoDAO();
                prDao.insere(prd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deletaPorId(int id) {
        try {

            ProdutoDAO prDao = new ProdutoDAO();
            prDao.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
