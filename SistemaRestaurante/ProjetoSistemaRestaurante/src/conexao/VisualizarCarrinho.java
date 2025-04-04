/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package conexao;

import DAO.BebidaDAO;
import DAO.ComidaDAO;
import DAO.PedidosDAO;
import DAO.SobremesaDAO;
import beans.Bebida;
import beans.Comida;
import beans.Pedido;
import beans.Sobremesa;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class VisualizarCarrinho extends javax.swing.JFrame {

    /**
     * Creates new form VisualizarCarrinho
     */
    public VisualizarCarrinho() {
        initComponents();
        preencherTabela();
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
        tblPedidosCarrinho = new javax.swing.JTable();
        lblCarrinho = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carrinho");

        tblPedidosCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome - Comida", "Quantidade - Comida", "Valor Unitário - Comida", "Nome - Bebida", "Quantidade - Bebida", "Valor Unitário - Bebida", "Nome - Sobremesa", "Quantidade - Sobremesa", "Valor Unitário - Sobremesa"
            }
        ));
        jScrollPane1.setViewportView(tblPedidosCarrinho);

        lblCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblCarrinho.setText("   CARRINHO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(541, 541, 541)
                        .addComponent(lblCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void preencherTabela() {
    
    PedidosDAO pDAO = new PedidosDAO();

    // Obtendo os itens conforme o nome digitado
    List<Pedido> listaPedidos = pDAO.getPedidos();
    

    // Obtendo o modelo da tabela
    DefaultTableModel tabelaPedidosCarrinho = (DefaultTableModel) tblPedidosCarrinho.getModel();
    tabelaPedidosCarrinho.setNumRows(0); // Limpando a tabela antes de preencher

    // Adicionando COMIDAS
    for (Pedido p : listaPedidos) {
        Object[] obj = new Object[]{p.getId_comida().getNome(), p.getQuantidade_comida(), p.getId_comida().getValor(), p.getId_bebida().getNome(), p.getQuantidade_bebida(), p.getId_bebida().getValor(), p.getId_sobremesa().getNome(), p.getQuantidade_sobremesa(), p.getId_sobremesa().getValor()};
        
        tabelaPedidosCarrinho.addRow(obj);
    }

}

    
    
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
            java.util.logging.Logger.getLogger(VisualizarCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarCarrinho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarrinho;
    private javax.swing.JTable tblPedidosCarrinho;
    // End of variables declaration//GEN-END:variables
}
