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
public abstract class EntidadeVO {

    private int id;

    public EntidadeVO() {
    }

    public EntidadeVO(int id) {
        super();
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
