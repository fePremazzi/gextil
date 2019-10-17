/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOs;

import VOs.Enuns.EnunTipoPedido;
import java.util.Date;

/**
 *
 * @author fePremazziNB
 */
public class PedidoVO extends EntidadeVO {
    
    private EnunTipoPedido tipo;
    private Date dataEmissao;
    private Date dataEntrega;
    private int numPedido;
    private ClienteVO cliente;
    private UsuarioVO usuario;
    private OrcamentoVO orcamento;

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

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public OrcamentoVO getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(OrcamentoVO orcamento) {
        this.orcamento = orcamento;
    }
    
    

    
    
}
