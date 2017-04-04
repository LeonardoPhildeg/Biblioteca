/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import telas.TelaAcesso;

/**
 *
 * @author Davi
 */
public class ControladorAcesso {
    
    private TelaAcesso tela_acesso;
    private ControladorPrincipal ctrl_principal;

    public ControladorAcesso(ControladorPrincipal ctrl_principal) {
        this.ctrl_principal = ctrl_principal;
        this.tela_acesso = new TelaAcesso(this);
        
    }
    
    
    

    public void exibeTela() {
        tela_acesso.exibeTela();
    }

    public boolean logar(String usuario, String senha) {
       return ctrl_principal.logar(usuario, senha);
    }
    
}
