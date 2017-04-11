/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import java.io.Serializable;
import java.util.HashMap;
import entidades.Cliente;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
/**
 *
 * @author Leonardo
 */
public class MapeadorCliente implements Serializable {
    
    private HashMap <Integer, Cliente> clientes;
    private final String filename = "clientes";
    
    
    public MapeadorCliente() throws IOException, FileNotFoundException, ClassNotFoundException{
        load();
    }
    
    public Cliente get(Integer id){
        return clientes.get(id);
    }
    
    public void put(Cliente cliente){
        this.clientes.put(cliente.getMatricula(), cliente);
    }
    
    
    public void persist() throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(filename); ObjectOutputStream os = new ObjectOutputStream(fos);) {            
            os.writeObject(clientes);
        } catch (FileNotFoundException ex ) {
            System.out.println("Erro ao abrir arquivo de Clientes: " + filename + " " + ex.getMessage());
            this.clientes = new HashMap<>();
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo de Clientes: " + filename + " " + ex.getMessage());
            this.clientes = new HashMap<>();
        }
        imprime();
    }
    
    
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filename);ObjectInputStream oi = new ObjectInputStream(fis);) { //são closeable, não precisa do oi.close e fis.close
            this.clientes = (HashMap<Integer, Cliente>) oi.readObject(); 
        } catch (ClassNotFoundException ex) {
            System.out.println("Tipo de classe arquivo de Clientes: " + filename + " " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao carregar arquivo de Clientes: " + filename + " " + ex.getMessage());
            this.clientes = new HashMap<>();
        } catch (IOException ex) {
            System.out.println("Erro ao carregar arquivo de Clientes: " + filename + " " + ex.getMessage());
            this.clientes = new HashMap<>();
        }
    }
    
    
    public Collection <Cliente> getListaClientes(){
        return clientes.values();
    }
    
    public void excluirCliente(int matricula){
        clientes.remove(matricula);
    }
    
    public boolean existeMatricula(int matricula){
        return clientes.containsKey(matricula);
    }
    
    public void imprime(){
        for (Cliente object : clientes.values()) {
            System.out.println(object.getNome());
        }
    }
    
    public void remove(int codCliente) {
        clientes.remove(codCliente);
    }
}
