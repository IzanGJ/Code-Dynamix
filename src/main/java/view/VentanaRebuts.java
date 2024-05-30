package view;

import exceptions.CompanyException;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
import persistence.codeDynamixDAO;

public class VentanaRebuts extends javax.swing.JDialog {
    codeDynamixDAO dao;
    DefaultTableModel model;
    HashMap<Integer, ProductObj> products;
    HashMap<String, CompanyObj> companies;
    ArrayList<Integer> receiptsID;
    String[] list;

    public VentanaRebuts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        dao = new codeDynamixDAO();
        try {
            products = dao.allProducts();
            companies = dao.allCompanies();
        } catch (SQLException | CompanyException ex) {
            System.out.println(ex.getMessage());
        }
        initComponents();
        ImageIcon img = new ImageIcon("src\\main\\java\\images\\icon.png");
        setIconImage(img.getImage());
        
        jComboBoxProveedor.removeAllItems();
        jComboBoxProveedor.addItem("Selecciona un proveïdor...");
        for (String clave : companies.keySet()) {
            jComboBoxProveedor.addItem(clave + " | " + companies.get(clave).getNombre());
        }
        
        jComboBoxRecibo.removeAllItems();
        jComboBoxRecibo.addItem("Selecciona un rebut...");
        
        model = (DefaultTableModel)jTable1.getModel();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelProveedor = new javax.swing.JLabel();
        jButtonImprimir = new javax.swing.JButton();
        jComboBoxProveedor = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        linea = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelProveedor1 = new javax.swing.JLabel();
        jComboBoxRecibo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabelPrecioTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Veure rebuts");
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Veure Rebuts");

        jLabelProveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProveedor.setText("Proveïdor:");

        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonImprimir.setEnabled(false);
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxProveedor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxProveedorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxProveedorPopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBoxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProveedorActionPerformed(evt);
            }
        });

        linea.setBackground(new java.awt.Color(200, 200, 200));
        linea.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout lineaLayout = new javax.swing.GroupLayout(linea);
        linea.setLayout(lineaLayout);
        lineaLayout.setHorizontalGroup(
            lineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lineaLayout.setVerticalGroup(
            lineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producte", "Quantitat", "Preu", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabelProveedor1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProveedor1.setText("Rebut:");

        jComboBoxRecibo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxRecibo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxRecibo.setEnabled(false);
        jComboBoxRecibo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxReciboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxReciboPopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBoxRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxReciboActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Preu total: ");

        jLabelPrecioTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPrecioTotal.setText("0€");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nº identificador: ");

        jLabelID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelID.setText(" ");

        jButtonVolver.setText("Tornar");
        jButtonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabelProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelPrecioTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jComboBoxRecibo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(linea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)))))
                        .addGap(50, 50, 50)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProveedor)
                    .addComponent(jComboBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProveedor1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jComboBoxRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelID))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelPrecioTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jComboBoxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProveedorActionPerformed

    private void jComboBoxProveedorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxProveedorPopupMenuWillBecomeInvisible
        jButtonImprimir.setEnabled(false);
        model.setNumRows(0);
        jComboBoxRecibo.removeAllItems();
        jComboBoxRecibo.addItem("Selecciona un rebut...");
        jLabelPrecioTotal.setText(" ");
        jLabelID.setText(" ");
        
        if (jComboBoxProveedor.getSelectedItem() != null) {
            list = jComboBoxProveedor.getItemAt(jComboBoxProveedor.getSelectedIndex()).split(" | ");
            try {
                receiptsID = dao.getCompanyReceiptID(companies.get(list[0]));
            } catch (SQLException | CompanyException ex) {
                System.out.println(ex.getMessage()); //No la debe ver el usuario
            }
            
            if (receiptsID.isEmpty()) {
                jComboBoxRecibo.setEnabled(false);
                jComboBoxRecibo.removeAllItems();
                jComboBoxRecibo.addItem("No hi han rebuts");
            } else {
                jComboBoxRecibo.setEnabled(true);
            }
            
            
        } else {
            jComboBoxProveedor.addItem("Selecciona un proveïdor...");
        }
    }//GEN-LAST:event_jComboBoxProveedorPopupMenuWillBecomeInvisible

    private void jComboBoxProveedorPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxProveedorPopupMenuWillBecomeVisible
        //Sirve para poder tener un "placeholder" en el combobox
        if (jComboBoxProveedor.getItemAt(0).equals("Selecciona un proveïdor...")) {
            jComboBoxProveedor.removeItemAt(0);
        }
    }//GEN-LAST:event_jComboBoxProveedorPopupMenuWillBecomeVisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jTable1.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Ho sentim, no ha sigut possible imprimir la taula", "Error", JOptionPane.ERROR_MESSAGE);
            jButtonImprimir.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxReciboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxReciboPopupMenuWillBecomeInvisible
        model.setRowCount(0);
        list = jComboBoxRecibo.getItemAt(jComboBoxRecibo.getSelectedIndex()).split(" ");
        int id_receipt = Integer.parseInt(list[1]);
        list = jComboBoxProveedor.getItemAt(jComboBoxProveedor.getSelectedIndex()).split(" | ");
        if (jComboBoxRecibo.getSelectedItem() != null) {
            jLabelID.setText(String.valueOf(id_receipt));
            OrderObj order = null;
            try {
                order = dao.getCompanyReceiptProd(id_receipt);
                Float total = 0f;
                for (ProductObj product : order.getProducts()) {
                    total += product.getQty() * product.getPrice();
                    model.addRow(new Object[]{products.get(product.getCode()).getName(), product.getQty(), product.getPrice() + "€", Math.round(product.getQty() * product.getPrice() * 100.0) / 100.0 + "€"});
                }
                jLabelPrecioTotal.setText(String.valueOf(total) + "€");
                jButtonImprimir.setEnabled(true);
            } catch (SQLException | CompanyException ex) {
                System.out.println(ex.getMessage());
            }
            
            
            

        } else {
            jComboBoxRecibo.addItem("Selecciona un rebut...");
        }
    }//GEN-LAST:event_jComboBoxReciboPopupMenuWillBecomeInvisible

    private void jComboBoxReciboPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxReciboPopupMenuWillBecomeVisible
        //Sirve para poder tener un "placeholder" en el combobox
        if (jComboBoxRecibo.getItemAt(0).equals("Selecciona un rebut...")) {
            jComboBoxRecibo.removeItemAt(0);
        }
        
        try {
            if (!jComboBoxProveedor.getItemAt(jComboBoxProveedor.getSelectedIndex()).equals("Selecciona un proveïdor...")) {
                jComboBoxRecibo.removeAllItems();
                for (Integer clave : dao.getCompanyReceiptID(companies.get(list[0]))) {
                    jComboBoxRecibo.addItem("ID: " + clave);
                }
            }
        } catch (SQLException | CompanyException ex) {
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_jComboBoxReciboPopupMenuWillBecomeVisible

    private void jComboBoxReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxReciboActionPerformed

    private void jButtonVolverjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverjButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVolverjButton1ActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(VentanaRebuts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRebuts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRebuts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRebuts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaRebuts dialog = new VentanaRebuts(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxProveedor;
    private javax.swing.JComboBox<String> jComboBoxRecibo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelPrecioTotal;
    private javax.swing.JLabel jLabelProveedor;
    private javax.swing.JLabel jLabelProveedor1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel linea;
    // End of variables declaration//GEN-END:variables
}
