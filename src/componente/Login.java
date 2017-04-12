/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

/**
 *
 * @author Davi
 */
public interface Login {
    
    public abstract Object compararUsuarioSenha(String usuario, String senha);
    public abstract void receberColecao();
    
}
