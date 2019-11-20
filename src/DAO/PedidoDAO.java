/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VOs.Enuns.EnunTipoPedido;
import VOs.PedidoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fePremazziNB
 */
public class PedidoDAO extends Repositorio {

    public PedidoDAO() {
        tableName = "tbPedido";
        spInsert = "INSERT INTO " + tableName + " "
                + "(Num_pedido, Tipo, Data_cadastro, Data_entrega, Id_cliente, Id_usuario, Id_orcamento) "
                + "VALUES ( ? , ? , ? , ? , ? , ? , ? );";
    }

    public void update(PedidoVO ped) throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String sql = "UPDATE " + tableName + " SET Num_pedido = ? , "
                + "Tipo = ? ,"
                + "Data_cadastro = ? , "
                + "Data_entrega = ? , "
                + "Id_cliente = ? ,"
                + "Id_usuario = ? , "
                + "Id_orcamento = ? WHERE Id = ? ;";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, ped.getNumPedido());
            stmt.setString(2, ped.getTipo().toString());
            stmt.setDate(3, ped.getDataEmissao());
            stmt.setDate(4, ped.getDataEntrega());
            stmt.setInt(5, ped.getCliente());
            stmt.setInt(6, ped.getUsuario());
            stmt.setInt(7, ped.getOrcamento());
            stmt.setInt(8, ped.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public PedidoVO getById(int id) throws SQLException {
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

    public List<PedidoVO> getAll() throws SQLException {
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        String spSelectAll = "SELECT * FROM " + tableName + ";";

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spSelectAll);

            ResultSet rs = stmt.executeQuery();

            List<PedidoVO> listAll = new ArrayList<>();

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

    public void insere(PedidoVO ped) throws SQLException {
        //"(Num_cliente, Tipo, Data_cadastro, Data_entrega, Id_cliente, Id_usuario, Id_orcamento) "
        ConexaoDB connection = new ConexaoDB();
        Connection con = null;

        try {

            con = connection.getConnections();
            PreparedStatement stmt = con.prepareStatement(spInsert);

            stmt.setInt(1, ped.getNumPedido());
            stmt.setString(2, ped.getTipo().toString());
            stmt.setDate(3, ped.getDataEmissao());
            stmt.setDate(4, ped.getDataEntrega());
            stmt.setInt(5, ped.getCliente());
            stmt.setInt(6, ped.getUsuario());
            stmt.setInt(7, ped.getOrcamento());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public PedidoVO montaVO(ResultSet rs) throws SQLException {
        return new PedidoVO(EnunTipoPedido.valueOf(rs.getString("Tipo")),
                rs.getDate("Data_cadastro"),
                rs.getDate("Data_entrega"),
                rs.getInt("Num_pedido"),
                rs.getInt("Id_cliente"),
                rs.getInt("Id_usuario"),
                rs.getInt("Id_orcamento"),
                rs.getInt("Id"));
    }

}
