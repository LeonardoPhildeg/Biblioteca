/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Leonardo
 */
public class LivroNaoDisponivelException extends Exception{
    
    public LivroNaoDisponivelException(){
        this("Não é possível realizar empréstimo de um livro já emprestado!");
    }
    
    public LivroNaoDisponivelException(String message){
        super(message);
    }
    
    
}
