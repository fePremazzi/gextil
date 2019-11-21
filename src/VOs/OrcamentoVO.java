/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOs;

import java.sql.Date;

/**
 *
 * @author fePremazziNB
 */
public class OrcamentoVO extends EntidadeVO {
    
    private int cliente;
    private Date dataEmissao;
    private int usuario;
    private double valorTotal;

    public OrcamentoVO(int cliente, Date dataEmissao, int usuario, double valorTotal, int id) {
        super(id);
        this.cliente = cliente;
        this.dataEmissao = dataEmissao;
        this.usuario = usuario;
        this.valorTotal = valorTotal;
    }

    public OrcamentoVO() {
    }


    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    
    
}
