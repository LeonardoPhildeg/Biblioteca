/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Cliente;
import entidades.Emprestimo;
import entidades.Livro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapeadores.MapeadorEmprestimo;
import mapeadores.MapeadorLivro;
import telas.TelaEmprestimo;

/**
 *
 * @author Leonardo
 */
public class ControladorEmprestimo {
    
    private ControladorPrincipal ctrl_principal;
    private TelaEmprestimo telaEmprestimo;
    private MapeadorEmprestimo map;
    
    
    public ControladorEmprestimo(ControladorPrincipal ctrl_principal) throws IOException, FileNotFoundException, ClassNotFoundException{
        this.ctrl_principal = ctrl_principal;       
        this.map = new MapeadorEmprestimo();
        this.telaEmprestimo = new TelaEmprestimo(this);
        
    }
    
    

    
    public void CadastrarEmprestimo(Integer indiceLivro, Integer indiceCliente){
        
        try {
            Livro livro = ctrl_principal.getControladorCadastroLivro().getLivro(indiceLivro);
            Cliente cliente = ctrl_principal.getControladorCadastroCliente().getMatricula(indiceCliente);
            Emprestimo novo = new Emprestimo(livro, cliente);
            livro.setDisponivel(false);
            put(novo);
            persist();
            System.out.println(novo.getLivroEmprestado() + "" + novo.getCliente());
        } catch (Exception ex) {
            }
        
        
        
    }
    

    public void devolverLivro(Integer codigoLivro){
        try{
            Livro livro = ctrl_principal.getControladorCadastroLivro().getLivro(codigoLivro);
            map.encerraEmprestimo(codigoLivro);
            livro.setDisponivel(true);
            

        }catch(Exception ex){
            
        }
    }
    
    public void put(Emprestimo emprestimo){
        map.put(emprestimo);
    }
    
    public void persist() throws IOException{
        map.persist();
    }
    
}
