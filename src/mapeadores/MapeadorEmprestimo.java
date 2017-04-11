/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import entidades.Emprestimo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Leonardo
 */
public class MapeadorEmprestimo {
    
    private HashMap <Integer,Emprestimo> emprestimos;
    private final String filename = "emprestimos";
    
    
    public MapeadorEmprestimo() throws IOException, FileNotFoundException, ClassNotFoundException{
        load();
    }
    
    
    
    public Emprestimo get(Integer id){
        return emprestimos.get(id);
    }
    
    public void put(Emprestimo emprestimo){
        this.emprestimos.put(emprestimo.getLivroEmprestado().getCodigo(), emprestimo);
    }
    
    public void persist() throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(filename); ObjectOutputStream os = new ObjectOutputStream(fos);) {            
            os.writeObject(emprestimos);
        } catch (FileNotFoundException ex ) {
            System.out.println("Erro ao abrir arquivo de Emprestimos: " + filename + " " + ex.getMessage());
            this.emprestimos = new HashMap<>();
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo de Emprestimos: " + filename + " " + ex.getMessage());
            this.emprestimos = new HashMap<>();
        }
    }
    
    
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filename);ObjectInputStream oi = new ObjectInputStream(fis);) { //são closeable, não precisa do oi.close e fis.close
            this.emprestimos = (HashMap<Integer, Emprestimo>) oi.readObject(); 
        } catch (ClassNotFoundException ex) {
            System.out.println("Tipo de classe arquivo de Emprestimos: " + filename + " " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao carregar: " + filename + " " + ex.getMessage());
            this.emprestimos = new HashMap<>();
        } catch (IOException ex) {
            System.out.println("Erro ao carregar arquivo de Emprestimos: " + filename + " " + ex.getMessage());
            this.emprestimos = new HashMap<>();
        }
    }
    
    
    public void encerraEmprestimo(int codLivro){
            emprestimos.remove(codLivro);
        
    }
    
    
    
    
    
    
    
    
    
    
}
