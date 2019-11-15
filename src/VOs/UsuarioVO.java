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
public class UsuarioVO extends EntidadeVO {
    
    private String nome;
    private String username;
    private String senha;
    private int cargo = -1;
    private int id_role = -1;

    public UsuarioVO(String nome, String username, String senha, int cargo, int id_role) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.cargo = cargo;
        this.id_role = id_role;
    }

    public UsuarioVO(String nome, String username, String senha, int cargo, int id_role, int id) {
        super(id);
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.cargo = cargo;
        this.id_role = id_role;
    }
    
    public UsuarioVO (){}
    
    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the cargo
     */
    public int getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    
    
    
}
