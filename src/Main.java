
import controladores.ControladorPrincipal;
import entidades.Permissao;
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
        ctrl_principal.cadastrarUsuario("davi.f", "7267xjk3", Permissao.CLIENTE);
        ctrl_principal.cadastrarUsuario("funcionario", "7267xjk3", Permissao.FUNCIONARIO);
        ctrl_principal.cadastrarUsuario("gerente", "7267xjk3", Permissao.GERENTE);
        ctrl_principal.listarUsuarios();
        ctrl_principal.inicia();
    }
    
}
