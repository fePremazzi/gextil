/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOs;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fePremazziNB
 */
public class OrcamentoVO extends EntidadeVO {
    
    private ClienteVO cliente;
    private ArrayList<ProdutoVO> listaProds;
    private Date dataEmissao;
    private UsuarioVO usuario;

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ProdutoVO> getListaProds() {
        return listaProds;
    }

    public void setListaProds(ArrayList<ProdutoVO> listaProds) {
        this.listaProds = listaProds;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }
    
    
    
}
