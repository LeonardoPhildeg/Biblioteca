/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import mapeadores.MapeadorLivro;
import entidades.Livro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import telas.TelaCadastroLivro;

/**
 *
 * @author Davi
 */
public class ControladorCadastroLivro {
    
    private MapeadorLivro map;
    private ControladorPrincipal ctrl_controlador_principal;
    private TelaCadastroLivro telaCadastroLivro;
    
    
    public ControladorCadastroLivro(ControladorPrincipal ctrl_controlador_principal) throws IOException, FileNotFoundException, ClassNotFoundException{
        this.ctrl_controlador_principal = ctrl_controlador_principal;
        this.map = new MapeadorLivro();
        this.telaCadastroLivro = new TelaCadastroLivro(this);
    }
    
    public void cadastrarLivro(String nome, int codigo, String autor, boolean disponivel) throws IOException{
        Livro livro = new Livro(nome, codigo, autor, disponivel);
        put(livro);
        persist();
    }
    
    public void put(Livro livro){
        map.put(livro);
    }
    
    public void persist() throws IOException{
        map.persist();
    }
    
    public void excluirLivro(int codigo) throws IOException{
        map.excluirLivro(codigo);
    }
    
    public void exibirTela(){
        telaCadastroLivro.setVisible(true);
    }


    public Collection<Livro> getLivros() {
        return map.getListaLivros();
    }
    
    public Livro getLivro(int codigoLivro) throws Exception{
        if(map.existeCodigo(codigoLivro)){
            return map.get(codigoLivro);
        } else{
            throw new Exception("Livro não existe");
        }
    }
}
