/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import componente.Login;
import entidades.Usuario;
import java.util.ArrayList;
import telas.TelaAcesso;

/**
 *
 * @author Davi
 */
public class ControladorAcesso implements Login {
    
    private TelaAcesso tela_acesso;
    private ControladorPrincipal ctrl_principal;
    private ArrayList<Usuario> colecao;

    public ControladorAcesso(ControladorPrincipal ctrl_principal) {
        this.ctrl_principal = ctrl_principal;
        this.tela_acesso = new TelaAcesso(this);
        this.colecao = new ArrayList<>();
    }
    
    public void exibeTela() {
        tela_acesso.exibeTela();
    }

    public boolean getPermissao(String usuario) {
        return ctrl_principal.getPermissao(usuario);
    }

    public void exibeTelaGerente() {
        ctrl_principal.exibeTelaGerente();
    }

    public void exibeTelaFunc() {
        ctrl_principal.exibeTelaFunc();
    }

    @Override
    public Usuario compararUsuarioSenha(String usuario, String senha) {
        receberColecao();
        for(Usuario user: colecao) {
            if (user.getLogin().equals(usuario)) {
                if(user.getSenha().equals(senha)) {
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public void receberColecao() {
        this.colecao = ctrl_principal.getColecao();
    }
    
}
