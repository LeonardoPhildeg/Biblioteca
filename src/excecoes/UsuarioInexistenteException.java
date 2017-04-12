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
public class UsuarioInexistenteException extends Exception {
    
    public UsuarioInexistenteException(){
        this("Usuário e/ou Senha inválidos");
    }
    
    public UsuarioInexistenteException(String message){
        super(message);
    }
}
