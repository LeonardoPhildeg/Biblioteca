
import controladores.ControladorPrincipal;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */
public class Main {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        ControladorPrincipal ctrl_principal = new ControladorPrincipal();
        ctrl_principal.cadastrarUsuario("funcionario", "asd", false);
        ctrl_principal.cadastrarUsuario("gerente", "asd", true);
        ctrl_principal.listarUsuarios();
        ctrl_principal.inicia();
    }
    
}
