/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Davi
 */
public class Usuario {
    
    private String login;
    private String senha;
    private boolean permissao;
    
    public Usuario(String login, String senha, boolean permissao) {
        this.login = login;
        this.senha = senha;
        this.permissao = permissao;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }
    
    
}
