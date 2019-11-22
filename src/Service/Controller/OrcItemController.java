/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Controller;

import DAO.OrcItemDAO;
import VOs.OrcItemVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class OrcItemController {
    
    public void update(OrcItemVO oi) {
        try {
            OrcItemDAO oiDao = new OrcItemDAO();
            oiDao.update(oi);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OrcItemVO getById(int id) {
        try {
            OrcItemDAO oiDao = new OrcItemDAO();
            return oiDao.getById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<OrcItemVO> getAll() {
        List<OrcItemVO> listAll = new ArrayList<>();
        try {
            OrcItemDAO oiDao = new OrcItemDAO();

            return oiDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }

    public int getNextId() {
        try {
            OrcItemDAO oiDao = new OrcItemDAO();
            return oiDao.getProximoId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void insere(OrcItemVO oi) {
        try {
            if (oi != null) {

                OrcItemDAO oiDao = new OrcItemDAO();
                oiDao.insere(oi);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deletaPorId(int id) {
        try {

            OrcItemDAO oiDao = new OrcItemDAO();
            oiDao.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
