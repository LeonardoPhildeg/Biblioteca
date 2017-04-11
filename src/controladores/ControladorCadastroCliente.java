/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Cliente;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import mapeadores.MapeadorCliente;
import telas.TelaCadastroCliente;

/**
 *
 * @author Leonardo
 */
public class ControladorCadastroCliente {
    
    private MapeadorCliente map;
    private TelaCadastroCliente telaCadastroCliente;
    private ControladorPrincipal ctrl_controlador_principal;
    
    
    public ControladorCadastroCliente(ControladorPrincipal ctrl_controlador_principal) throws IOException, FileNotFoundException, ClassNotFoundException{
        this.ctrl_controlador_principal = ctrl_controlador_principal;
        this.map = new MapeadorCliente();
        this.telaCadastroCliente = new TelaCadastroCliente(this);
        
    }
    
    
    public void criarCliente(String nome, int matricula) throws IOException{
        Cliente cliente = new Cliente(nome, matricula);
        put(cliente);
        persist();
    }
    
    public Cliente getMatricula(int matricula){
        return map.get(matricula);
    }
    
    public void put(Cliente cliente){
        map.put(cliente);
    }
    
    public void persist() throws IOException{
        map.persist();
    }
    
    public void excluirCliente(int matricula){
        map.excluirCliente(matricula);
    }
    
    public void exibirTela(){
        telaCadastroCliente.setVisible(true);
    }

    public Collection<Cliente> getClientes() {
        return map.getListaClientes();
    }

    boolean existeMatricula(Integer codCliente) {
        return map.existeMatricula(codCliente);
    }
    
}
