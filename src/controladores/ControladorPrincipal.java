/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Permissao;
import entidades.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Davi
 */
public class ControladorPrincipal {
    
    private ControladorAcesso ctrl_acesso;
    private ArrayList <Usuario> usuarios;
    private ControladorCadastroCliente ctrl_cadastro_cliente;

    public ControladorPrincipal() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.ctrl_acesso = new ControladorAcesso(this);
        this.usuarios = new ArrayList<>();
        this.ctrl_cadastro_cliente = new ControladorCadastroCliente(this);
    }
    
    public void inicia() {
        ctrl_acesso.exibeTela();
    }
    
    public void cadastrarUsuario(String login, String senha, Permissao permissao) {
            Usuario usuario = new Usuario(login, senha, permissao);
            usuarios.add(usuario);
    }

    public boolean logar(String usuario, String senha) {
        for (Usuario user : usuarios) {
            if (user.getLogin().equals(usuario)) {
                if(user.getSenha().equals(senha)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void listarUsuarios() {
        for (Usuario user : usuarios) {
            System.out.println(user.getLogin() + " " + user.getSenha() + " " + user.getPermissao().toString() );
        }
    }
    
}
