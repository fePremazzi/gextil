/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOs;

import VOs.Enuns.EnunTipoPedido;
import java.sql.Date;

/**
 *
 * @author fePremazziNB
 */
public class PedidoVO extends EntidadeVO {
    
    private EnunTipoPedido tipo;
    private Date dataEmissao;
    private Date dataEntrega;
    private int numPedido;
    private int cliente;
    private int usuario;
    private int orcamento;

    public PedidoVO(){
    }

    public PedidoVO(EnunTipoPedido tipo, Date dataEmissao, Date dataEntrega, int numPedido, int cliente, int usuario, int orcamento, int id) {
        super(id);
        this.tipo = tipo;
        this.dataEmissao = dataEmissao;
        this.dataEntrega = dataEntrega;
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.usuario = usuario;
        this.orcamento = orcamento;
    }
    
    

    public EnunTipoPedido getTipo() {
        return tipo;
    }

    public void setTipo(EnunTipoPedido tipo) {
        this.tipo = tipo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(int orcamento) {
        this.orcamento = orcamento;
    }
    
    

    
    
}
