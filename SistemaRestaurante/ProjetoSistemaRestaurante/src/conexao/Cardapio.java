/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package conexao;

import DAO.BebidaDAO;
import DAO.ComidaDAO;
import DAO.SobremesaDAO;
import beans.Bebida;
import beans.Comida;
import beans.Sobremesa;
import java.awt.Dimension;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gilberto, matheus e romeo.
 */
public class Cardapio extends javax.swing.JFrame {

    /**
     * Creates new form Cardapio
     */
    public Cardapio() {
        initComponents();
        preencheTabela();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpTipoItemCardapio = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        rdoComidas = new javax.swing.JRadioButton();
        rdoBebidas = new javax.swing.JRadioButton();
        rdoSobremesas = new javax.swing.JRadioButton();
        btnIrCarrinho = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cardápio");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        jLabel1.setText("      CARDÁPIO");

        tblNome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tblNome.setText("NOME:");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeCaretUpdate(evt);
            }
        });
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Quantidade", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblItens);

        btnGrpTipoItemCardapio.add(rdoComidas);
        rdoComidas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoComidas.setText("Comidas");
        rdoComidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoComidasActionPerformed(evt);
            }
        });

        btnGrpTipoItemCardapio.add(rdoBebidas);
        rdoBebidas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoBebidas.setText("Bebidas");
        rdoBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoBebidasActionPerformed(evt);
            }
        });

        btnGrpTipoItemCardapio.add(rdoSobremesas);
        rdoSobremesas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoSobremesas.setText("Sobremesas");
        rdoSobremesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSobremesasActionPerformed(evt);
            }
        });

        btnIrCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnIrCarrinho.setText("Iniciar seus pedidos");
        btnIrCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoComidas)
                                .addGap(179, 179, 179)
                                .addComponent(rdoBebidas)
                                .addGap(160, 160, 160)
                                .addComponent(rdoSobremesas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tblNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIrCarrinho)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(336, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoComidas)
                    .addComponent(rdoBebidas)
                    .addComponent(rdoSobremesas))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnIrCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(468, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeCaretUpdate
        preencheTabela();
    }//GEN-LAST:event_txtNomeCaretUpdate

        
 public void preencheTabela(){
        
     ComidaDAO cDAO = new ComidaDAO();
     BebidaDAO bDAO = new BebidaDAO();
     SobremesaDAO sDAO = new SobremesaDAO();
     
     
     if (rdoComidas.isSelected()){
         List<Comida> listaComidas = cDAO.getComidasNome(txtNome.getText());
         
         DefaultTableModel tabelaItens = (DefaultTableModel) tblItens.getModel();
         tabelaItens.setNumRows(0);
         for(Comida c : listaComidas){
            
            Object [] obj = new Object[]{ c.getId(), c.getNome(), c.getValor(), c.getQuantidade(), c.getEstado()};
            
            tabelaItens.addRow(obj);
        }
     }
     else if (rdoBebidas.isSelected()){
         List<Bebida> listaBebidas = bDAO.getBebidasNome(txtNome.getText());
         
         DefaultTableModel tabelaItens = (DefaultTableModel) tblItens.getModel();
         tabelaItens.setNumRows(0);
         for(Bebida b : listaBebidas){
            
            Object [] obj = new Object[]{ b.getId(), b.getNome(), b.getValor(), b.getQuantidade(), b.getEstado()};
            
            tabelaItens.addRow(obj);
        }
     }
     else if (rdoSobremesas.isSelected()){
         List<Sobremesa> listaSobremesas = sDAO.getSobremesasNome(txtNome.getText());
         
         DefaultTableModel tabelaItens = (DefaultTableModel) tblItens.getModel();
         tabelaItens.setNumRows(0);
         for(Sobremesa s : listaSobremesas){
            
            Object [] obj = new Object[]{ s.getId(), s.getNome(), s.getValor(), s.getQuantidade(), s.getEstado()};
            
            tabelaItens.addRow(obj);
        }
     }
        
        
            
   }
    
    
    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed

    }//GEN-LAST:event_txtNomeActionPerformed

    private void rdoComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoComidasActionPerformed
        preencheTabela();
    }//GEN-LAST:event_rdoComidasActionPerformed

    private void rdoBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoBebidasActionPerformed
        preencheTabela();
    }//GEN-LAST:event_rdoBebidasActionPerformed

    private void rdoSobremesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSobremesasActionPerformed
        preencheTabela();
    }//GEN-LAST:event_rdoSobremesasActionPerformed

    private void btnIrCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrCarrinhoActionPerformed
        IniciarPedidos irCarrinho = new IniciarPedidos();
        irCarrinho.setVisible(true);
    }//GEN-LAST:event_btnIrCarrinhoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cardapio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrpTipoItemCardapio;
    private javax.swing.JButton btnIrCarrinho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoBebidas;
    private javax.swing.JRadioButton rdoComidas;
    private javax.swing.JRadioButton rdoSobremesas;
    private javax.swing.JTable tblItens;
    private javax.swing.JLabel tblNome;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
