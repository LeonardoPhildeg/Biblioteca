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
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapeadores.MapeadorEmprestimo;
import mapeadores.MapeadorLivro;
import telas.TelaEmprestimo;
import telas.TelaGerenciaEmprestimo;

/**
 *
 * @author Leonardo
 */
public class ControladorEmprestimo {
    
    private ControladorPrincipal ctrl_principal;
    private TelaEmprestimo telaEmprestimo;
    private TelaGerenciaEmprestimo telaGerenciaEmprestimo;
    private MapeadorEmprestimo map;
    
    
    
    public ControladorEmprestimo(ControladorPrincipal ctrl_principal) throws IOException, FileNotFoundException, ClassNotFoundException{
        this.ctrl_principal = ctrl_principal;       
        this.map = new MapeadorEmprestimo();
        this.telaEmprestimo = new TelaEmprestimo(this);
        this.telaGerenciaEmprestimo = new TelaGerenciaEmprestimo(this);
        
    }
    
    

    
    public void cadastrarEmprestimo(Integer indiceLivro, Integer indiceCliente){
        
        try {
            Livro livro = ctrl_principal.getControladorCadastroLivro().getLivro(indiceLivro);
            Cliente cliente = ctrl_principal.getControladorCadastroCliente().getMatricula(indiceCliente);
            Emprestimo novo = new Emprestimo(livro, cliente);
            livro.setDisponivel(false);
            put(novo);
            persist();
            System.out.println(novo.getLivroEmprestado().getCodigo() + " " + novo.getCliente().getNome());
            System.out.println(novo.getDataEmprestimo().toString() + " " + novo.getDataPrevistaDevolucao().toString());
            System.out.println(livro.getDisponivel());
        } catch (Exception ex) {
            }
        
        
        
    }
    

    public void devolverLivro(Integer codigoLivro){

        Emprestimo emprestimo = getEmprestimoCodLivro(codigoLivro);

        Livro livro = emprestimo.getLivroEmprestado();
        map.encerraEmprestimo(codigoLivro);
        livro.setDisponivel(true);
    }
    
    public void put(Emprestimo emprestimo){
        map.put(emprestimo);
    }
    
    public void persist() throws IOException{
        map.persist();
    }
    
    public void exibeTelaCadastroEmprestimo(){
        telaEmprestimo.setVisible(true);
    }
    
    public void exibeTelaGerenciaEmprestimo(){
        telaGerenciaEmprestimo.setVisible(true);
    }

    public boolean existeMatricula(Integer codCliente) {
        return ctrl_principal.existeMatricula(codCliente);
    }
    
    public Emprestimo getEmprestimoCodLivro(int codLivro){
        return map.getEmprestimoCodLivro(codLivro);
    }
    
    public Collection <Emprestimo> getListaEmprestimos(){
        return map.getListaEmprestimos();
    }
    
    public boolean getDisponivel(int codigo){
        return ctrl_principal.getDisponivel(codigo);
    }
}
