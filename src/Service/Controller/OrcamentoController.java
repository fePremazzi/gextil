/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Controller;

import DAO.OrcamentoDAO;
import VOs.OrcamentoVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class OrcamentoController {
    
    public void update(OrcamentoVO orc) {
        try {
            OrcamentoDAO orcDao = new OrcamentoDAO();
            orcDao.update(orc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OrcamentoVO getById(int id) {
        try {
            OrcamentoDAO orcDao = new OrcamentoDAO();
            return orcDao.getById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<OrcamentoVO> getAll() {
        List<OrcamentoVO> listAll = new ArrayList<>();
        try {
            OrcamentoDAO orcDao = new OrcamentoDAO();

            return orcDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }

    public int getNextId() {
        try {
            OrcamentoDAO orcDao = new OrcamentoDAO();
            return orcDao.getProximoId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void insere(OrcamentoVO orc) {
        try {
            if (orc != null) {

                OrcamentoDAO orcDao = new OrcamentoDAO();
                orcDao.insere(orc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deletaPorId(int id) {
        try {

            OrcamentoDAO orcDao = new OrcamentoDAO();
            orcDao.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
