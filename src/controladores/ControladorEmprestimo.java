/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Cliente;
import entidades.Emprestimo;
import entidades.Livro;
import mapeadores.MapeadorLivro;
import telas.TelaEmprestimo;

/**
 *
 * @author Leonardo
 */
public class ControladorEmprestimo {
    
    private ControladorPrincipal ctrl_principal;
    private TelaEmprestimo telaEmprestimo;
    private Cliente clienteEmprestimo;
//    private MapeadorEmprestimo map;
    private MapeadorLivro mapLivro;
    
    
    public ControladorEmprestimo(ControladorPrincipal ctrl_principal){
        this.ctrl_principal = ctrl_principal;
//        this.map = new MapeadorEmprestimo();
        this.telaEmprestimo = new TelaEmprestimo(this);
        
    }
    
    

    
    public void CadastrarEmprestimo(Object livro, Object cliente){
        
        Livro livroEmprestado = (Livro) livro;
        Cliente clienteEmprestimo = (Cliente) cliente;
        
        Emprestimo novo = new Emprestimo(livroEmprestado, clienteEmprestimo);
        livroEmprestado.setDisponivel(false);
        System.out.println(novo.getLivroEmprestado() + "" + novo.getCliente());
        
        
    }
    

    
    
    
    
}
