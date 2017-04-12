/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Cliente;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import telas.TelaListaCliente;
import telas.TelaPrincipal;

/**
 *
 * @author Davi
 */
public class ControladorPrincipal {
    
    private ControladorAcesso ctrl_acesso;
    private ArrayList <Usuario> usuarios;
    private ControladorCadastroCliente ctrl_cadastro_cliente;
    private TelaPrincipal telaPrincipal;
    private TelaListaCliente telaListaCliente;
    private ControladorCadastroLivro ctrl_cadastro_livro;
    private ControladorEmprestimo ctrl_emprestimo;
  

    public ControladorPrincipal() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.ctrl_acesso = new ControladorAcesso(this);
        this.ctrl_cadastro_cliente = new ControladorCadastroCliente(this);
        this.ctrl_cadastro_livro = new ControladorCadastroLivro(this);
        this.ctrl_emprestimo = new ControladorEmprestimo(this);
        this.telaListaCliente = new TelaListaCliente(this);
        this.telaPrincipal = new TelaPrincipal(this, ctrl_emprestimo);
        this.usuarios = new ArrayList<>();

    }
    
    public void inicia() {
        ctrl_acesso.exibeTela();
    }
    
    public void cadastrarUsuario(String login, String senha, boolean permissao) {
            Usuario usuario = new Usuario(login, senha, permissao);
            usuarios.add(usuario);
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
        telaPrincipal.exibeTelaFunc();
    }

    public void exibeTelaGerente() {
        telaPrincipal.setVisible(true);
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

    public void exibeListaCliente() {
        telaListaCliente.exibeTela();
    }
    
    public Collection<Cliente> getClientes() {
        return ctrl_cadastro_cliente.getClientes();
    }

    public void excluirLivro(int codLivro) throws IOException {
        ctrl_cadastro_livro.excluirLivro(codLivro);
    }
    
    public ControladorCadastroLivro getControladorCadastroLivro(){
        return this.ctrl_cadastro_livro;
    }
    public ControladorCadastroCliente getControladorCadastroCliente(){
        return this.ctrl_cadastro_cliente;
    }

    public boolean existeMatricula(Integer codCliente) {
        return ctrl_cadastro_cliente.existeMatricula(codCliente);
    }

    public ArrayList<Usuario> getColecao() {
        return this.usuarios;
    }
    
    public boolean getDisponivel(int codigo){
        return ctrl_cadastro_livro.getDisponivel(codigo);
    }

    public void salvarTudo() throws IOException {
        ctrl_cadastro_cliente.persist();
        ctrl_cadastro_livro.persist();
        ctrl_emprestimo.persist();
    }

    public void listarLivros() {
        this.telaPrincipal.listarLivros();
    }

    void listarClientes() {
        this.telaListaCliente.atualizar();
    }
}
