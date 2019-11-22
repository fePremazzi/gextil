/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VOs.OrcItemVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class OrcItemDAO extends Repositorio {

    public OrcItemDAO() {
        tableName = "tbOrcItm";
        spInsert = "INSERT INTO " + tableName + " "
                + "(Id_Orcamento, Id_Item, Valor_item, Qtd_Item) "
                + "VALUES ( ? , ? , ? , ? );";
    }

    public void update(OrcItemVO oi) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String sql = "UPDATE " + tableName + " SET Id_Orcamento = ? , "
                + "Id_Item = ? ,"
                + "Valor_item = ? , "
                + "Qtd_Item = ? WHERE Id = ? ;";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, oi.getId_orcamento());
            stmt.setInt(2, oi.getId_item());
            stmt.setDouble(3, oi.getValor_item());
            stmt.setInt(4, oi.getQtde_item());
            stmt.setInt(5, oi.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public OrcItemVO getById(int id) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String spGetById = "SELECT * FROM " + tableName + " WHERE Id = ? ;";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spGetById);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return montaVO(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return null;
    }

    public List<OrcItemVO> getAll() throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String spSelectAll = "SELECT * FROM " + tableName + ";";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spSelectAll);

            ResultSet rs = stmt.executeQuery();

            List<OrcItemVO> listAll = new ArrayList<>();

            while (rs.next()) {
                listAll.add(montaVO(rs));
            }

            return listAll;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return null;
    }

    public void insere(OrcItemVO oi) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spInsert);

            stmt.setInt(1, oi.getId_orcamento());
            stmt.setInt(2, oi.getId_item());
            stmt.setDouble(3, oi.getValor_item());
            stmt.setInt(4, oi.getQtde_item());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public OrcItemVO montaVO(ResultSet rs) throws SQLException {
        return new OrcItemVO(rs.getInt("Id_Orcamento"),
                rs.getInt("Id_Item"),
                rs.getDouble("Valor_item"),
                rs.getInt("Qtd_Item"),
                rs.getInt("Id"));
    }

}
