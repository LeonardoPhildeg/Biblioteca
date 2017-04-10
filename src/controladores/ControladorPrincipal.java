/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Cliente;
import entidades.Livro;
import entidades.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import telas.TelaPrincipal;

/**
 *
 * @author Davi
 */
public class ControladorPrincipal {
    
    private ControladorAcesso ctrl_acesso;
    private ArrayList <Usuario> usuarios;
    private ControladorCadastroCliente ctrl_cadastro_cliente;
    private TelaPrincipal telaGerente;
    private ControladorCadastroLivro ctrl_cadastro_livro;
    private ControladorEmprestimo ctrl_emprestimo;

    public ControladorPrincipal() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.ctrl_acesso = new ControladorAcesso(this);
        this.ctrl_cadastro_cliente = new ControladorCadastroCliente(this);
        this.ctrl_cadastro_livro = new ControladorCadastroLivro(this);
        this.ctrl_emprestimo = new ControladorEmprestimo(this);
        this.telaGerente = new TelaPrincipal(this);
        this.usuarios = new ArrayList<>();

    }
    
    public void inicia() {
        ctrl_acesso.exibeTela();
    }
    
    public void cadastrarUsuario(String login, String senha, boolean permissao) {
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
            System.out.println(user.getLogin() + " " + user.getSenha() + " " + user.getPermissao());
        }
    }

    public boolean getPermissao(String usuario) {
        for (Usuario user : usuarios) {
            if (user.getLogin().equals(usuario)) {
                return user.getPermissao();
            }
        }
        
        return false;
    }

    public void exibeTelaFunc() {
        telaGerente.exibeTelaFunc();
    }

    public void exibeTelaGerente() {
        telaGerente.setVisible(true);
    }
    
    public void exibeTelaCadastroCliente(){
        ctrl_cadastro_cliente.exibirTela();
    }
    
    public void exibeTelaCadastroLivro(){
        ctrl_cadastro_livro.exibirTela();
    }
    
    public void getCliente(int matricula){
        ctrl_cadastro_cliente.getMatricula(matricula);
    }

    public Collection<Livro> getLivros() {
        return ctrl_cadastro_livro.getLivros();
    }
    
    
    
}
