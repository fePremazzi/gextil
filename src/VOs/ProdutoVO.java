/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOs;

import VOs.Enuns.EnunCor;
import VOs.Enuns.EnunTamanho;

/**
 *
 * @author fePremazziNB
 */
public class ProdutoVO extends EntidadeVO{
    
    private String nome;
    private EnunTamanho tamanho;
    private EnunCor cor;
    private double valorUnit;
    private String descricao;

    public ProdutoVO() {
    }

    public ProdutoVO(String nome, EnunTamanho tamanho, EnunCor cor, double valorUnit, String descricao, int id) {
        super(id);
        this.nome = nome;
        this.tamanho = tamanho;
        this.cor = cor;
        this.valorUnit = valorUnit;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnunTamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(EnunTamanho tamanho) {
        this.tamanho = tamanho;
    }

    public EnunCor getCor() {
        return cor;
    }

    public void setCor(EnunCor cor) {
        this.cor = cor;
    }

    public double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
