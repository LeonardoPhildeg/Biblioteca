/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;
import controladores.ControladorCadastroLivro;
import entidades.Cliente;
import java.util.HashMap;
import entidades.Livro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;



/**
 *
 * @author Leonardo
 */
public class MapeadorLivro implements Serializable{
    
    private HashMap <Integer,Livro> livros;
    private final String filename = "livros";
    
    
    public MapeadorLivro() throws IOException, FileNotFoundException, ClassNotFoundException{
        load();
    }
    
    
    
    public Livro get(Integer id){
        return livros.get(id);
    }
    
    public void put(Livro livro){
        this.livros.put(livro.getCodigo(), livro);
    }
    
    public void persist() throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(filename); ObjectOutputStream os = new ObjectOutputStream(fos);) {            
            os.writeObject(livros);
        } catch (FileNotFoundException ex ) {
            System.out.println("Erro ao abrir arquivo de Livros: " + filename + " " + ex.getMessage());
            this.livros = new HashMap<>();
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo de Livros: " + filename + " " + ex.getMessage());
            this.livros = new HashMap<>();
        }
    }
    
    
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filename);ObjectInputStream oi = new ObjectInputStream(fis);) { //são closeable, não precisa do oi.close e fis.close
            this.livros = (HashMap<Integer, Livro>) oi.readObject(); 
        } catch (ClassNotFoundException ex) {
            System.out.println("Tipo de classe arquivo de Livros: " + filename + " " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao carregar: " + filename + " " + ex.getMessage());
            this.livros = new HashMap<>();
        } catch (IOException ex) {
            System.out.println("Erro ao carregar arquivo de Livros: " + filename + " " + ex.getMessage());
            this.livros = new HashMap<>();
        }
    }
    
    
    public Collection <Livro> getListaLivros(){
        return this.livros.values();
    }
    
    public void excluirLivro(int codigo) throws IOException{
        System.out.println(codigo);
        livros.remove(codigo);
        persist();
    }
    
    public boolean existeCodigo(int codigo){
        return livros.containsKey(codigo);
    }
    
    public boolean existeNome(String nome){
        return livros.containsValue(nome);
    }
    
    public boolean getDisponivel(int codigo){
          Livro livro = get(codigo);
          
          for(Livro livros : livros.values()){
              if(livro.getDisponivel()){
                  return true;
              }
          }
 
        return false;
    }
}
