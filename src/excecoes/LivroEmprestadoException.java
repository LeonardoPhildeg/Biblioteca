/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Davi
 */
public class LivroEmprestadoException extends Exception {
    
    public LivroEmprestadoException(){
        this("Não é possível excluir livros que estão emprestados!");
    }
    
    public LivroEmprestadoException(String message){
        super(message);
    }
    
}
