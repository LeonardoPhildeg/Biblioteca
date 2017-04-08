/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Leonardo
 */
public class Emprestimo implements Serializable{
    
    private Cliente cliente;
    private Livro livroEmprestado;
    private Date dataEmprestimo;
    private Date dataPrevistaDevolucao;
    private Date dataEncerramento;
    
    public Emprestimo (Livro livroEmprestado, Cliente cliente){
        this.livroEmprestado = livroEmprestado;
        this.cliente = cliente;
        this.dataEmprestimo = (Date) new Date().clone();
        this.dataPrevistaDevolucao = (Date) new Date().clone();
        this.dataPrevistaDevolucao.setTime(dataEmprestimo.getTime() + calculaMiliSegundosPorDias(14));
    }
    
    
    public Livro getLivroEmprestado(){
        return livroEmprestado;
    }
    
    public void setLivroEmprestado(Livro livroEmprestado){
        this.livroEmprestado = livroEmprestado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    private long calculaMiliSegundosPorDias(int dias){
        return (24 * 60 * 60 * 1000) * dias;
    }
    
    private long calculaDiaPorMiliSegundo(long miliSegundos){
        long miliPorDia = (24 * 60 * 60 * 1000);
        return (int) (miliSegundos / miliPorDia);
    }
    
    public void prorrogarPrazo(int dias){
        long previsaoAtual = dataPrevistaDevolucao.getTime();
        this.dataPrevistaDevolucao.setTime(previsaoAtual + calculaMiliSegundosPorDias(dias));
    }
    
    public void encerrarEmprestimo(){
        livroEmprestado.setDisponivel(false);
        this.dataEncerramento = (Date) new Date().clone();
    }
    
    
    
}
