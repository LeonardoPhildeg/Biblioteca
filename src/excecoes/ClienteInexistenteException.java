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
public class ClienteInexistenteException extends Exception {
 
    public ClienteInexistenteException(){
        this("Código de cliente não consta na lista de cadastro!");
    }
    
    public ClienteInexistenteException(String message){
        super(message);
    }
    
    
    
}
