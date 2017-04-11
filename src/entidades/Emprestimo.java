/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
        this.dataEmprestimo = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, 2);
        this.dataPrevistaDevolucao = calendar.getTime();
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
    
    public void encerrarEmprestimo(){
        livroEmprestado.setDisponivel(false);
        this.dataEncerramento = new Date();
    }
    
    public long getDiasAtraso(){
        Date now = new Date();
        long diff = now.getTime() - this.dataPrevistaDevolucao.getTime();
        if(diff < 0){
            return 0;
        }else{
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
     
    }
    
    public double calculaMulta(){
        return getDiasAtraso() * 1.0;
    }
    
}
