/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOs;

/**
 *
 * @author fePremazziNB
 */
public class OrcItemVO extends EntidadeVO {
    
    private int id_orcamento;
    private int id_item;
    private double valor_item;
    private int qtde_item;

    public OrcItemVO() {
    }    

    public OrcItemVO(int id_orcamento, int id_item, double valor_item, int qtde_item, int id) {
        super(id);
        this.id_orcamento = id_orcamento;
        this.id_item = id_item;
        this.valor_item = valor_item;
        this.qtde_item = qtde_item;
    }
    
    public int getId_orcamento() {
        return id_orcamento;
    }

    public void setId_orcamento(int id_orcamento) {
        this.id_orcamento = id_orcamento;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public double getValor_item() {
        return valor_item;
    }

    public void setValor_item(double valor_item) {
        this.valor_item = valor_item;
    }

    public int getQtde_item() {
        return qtde_item;
    }

    public void setQtde_item(int qtde_item) {
        this.qtde_item = qtde_item;
    }
    

    
}
