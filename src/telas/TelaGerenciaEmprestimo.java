/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controladores.ControladorEmprestimo;
import entidades.Emprestimo;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class TelaGerenciaEmprestimo extends javax.swing.JFrame {

    private ControladorEmprestimo ctrl_emprestimo;
    
    public TelaGerenciaEmprestimo(ControladorEmprestimo ctrlEmprestimo) {
        this.ctrl_emprestimo = ctrlEmprestimo;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaEmprestimos = new javax.swing.JTable();
        jbEmprestimo = new javax.swing.JButton();
        jbDevolucao = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtTabelaEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Cliente", "Data Empréstimo", "Data Devolução"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTabelaEmprestimos);

        jbEmprestimo.setText("Emprestimo");
        jbEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmprestimoActionPerformed(evt);
            }
        });

        jbDevolucao.setText("Devolução");

        jbVoltar.setText("Voltar");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jbVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbDevolucao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEmprestimo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEmprestimo)
                    .addComponent(jbDevolucao)
                    .addComponent(jbVoltar)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmprestimoActionPerformed
        ctrl_emprestimo.exibeTelaCadastroEmprestimo();
    }//GEN-LAST:event_jbEmprestimoActionPerformed

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listarEmprestimos();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDevolucao;
    private javax.swing.JButton jbEmprestimo;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTable jtTabelaEmprestimos;
    // End of variables declaration//GEN-END:variables

    private void listarEmprestimos(){
        DefaultTableModel modelTb = (DefaultTableModel) jtTabelaEmprestimos.getModel();
        int tamanhoTabela = modelTb.getRowCount();
        boolean encontrou;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        for(Emprestimo emprestimo : ctrl_emprestimo.getListaEmprestimos()){
            encontrou = false;
            for(int i = 0; i < modelTb.getRowCount(); i++) {
                if (Integer.parseInt(modelTb.getValueAt(i, 1).toString()) == emprestimo.getLivroEmprestado().getCodigo()){
                    encontrou = true;
//                    modelTb.setValueAt(emprestimo.getLivroEmprestado().getNome(), i, 1);
//                    modelTb.setValueAt(emprestimo.getCliente().getNome(), i, 2);
//                    modelTb.setValueAt(format.format(emprestimo.getDataEmprestimo()), i, 3);
//                    modelTb.setValueAt(format.format(emprestimo.getDataPrevistaDevolucao()), i, 4);
                }
            }
            if(!encontrou){
                modelTb.addRow(new Object []{emprestimo.getLivroEmprestado().getNome(), emprestimo.getCliente().getNome(),
                    format.format(emprestimo.getDataEmprestimo()), format.format((emprestimo.getDataPrevistaDevolucao()))  });
            }
        }
           if (tamanhoTabela >= modelTb.getRowCount()){
                JOptionPane.showMessageDialog(this, "Não existe algo para atualizar");
        }
        
        
        
    }

 //modelTb.getValueAt(i, 1).toString()==(emprestimo.getLivroEmprestado().getNome())

}
