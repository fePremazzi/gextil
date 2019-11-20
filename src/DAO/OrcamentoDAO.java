/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VOs.OrcamentoVO;
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
public class OrcamentoDAO extends Repositorio {
    
    public OrcamentoDAO() {
        tableName = "tbOrcamento";
        spInsert = "INSERT INTO " + tableName + " "
                + "(Data_cadastro, Id_Cliente, Id_Usuario, Valor_total) "
                + "VALUES ( ? , ? , ? , ? );";
    }
    
    public void update(OrcamentoVO orc) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String sql = "UPDATE " + tableName + " SET Data_cadastro = ? , "
                + "Id_Cliente = ? ,"
                + "Id_Usuario = ? , "
                + "Valor_total = ? WHERE Id = ? ;";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setDate(1, orc.getDataEmissao());
            stmt.setInt(2, orc.getCliente());
            stmt.setInt(3, orc.getUsuario());
            stmt.setDouble(4, orc.getValorTotal());
            stmt.setInt(5, orc.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }
    
    public OrcamentoVO getById(int id) throws SQLException {
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
    
    public List<OrcamentoVO> getAll() throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String spSelectAll = "SELECT * FROM " + tableName + ";";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spSelectAll);

            ResultSet rs = stmt.executeQuery();

            List<OrcamentoVO> listAll = new ArrayList<>();

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
    
    public void insere(OrcamentoVO orc) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spInsert);
            //"(Data_cadastro, Id_Cliente, Id_Usuario, Valor_total) "


            stmt.setDate(1, orc.getDataEmissao());
            stmt.setInt(2, orc.getCliente());
            stmt.setInt(3, orc.getUsuario());
            stmt.setDouble(4, orc.getValorTotal());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    public OrcamentoVO montaVO(ResultSet rs) throws SQLException {
        return new OrcamentoVO(rs.getInt("Id_Cliente"),
                rs.getDate("Data_cadastro"),
                rs.getInt("Id_Usuario"),
                rs.getDouble("Valor_total"),
                rs.getInt("Id"));
    }
    
}
