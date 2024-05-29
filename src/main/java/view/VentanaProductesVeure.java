package view;

import java.awt.Color;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.*;
import persistence.codeDynamixDAO;

public class VentanaProductesVeure extends javax.swing.JDialog {
    Interprete interprete;
    codeDynamixDAO dao;
    HashMap<Integer, ProductObj> products;

    public VentanaProductesVeure(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        interprete = Interprete.obtenerInstancia();
        dao = new codeDynamixDAO();
        try {
            products = dao.allProducts();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        initComponents();
        ImageIcon img = new ImageIcon("src\\main\\java\\images\\icon.png");
        setIconImage(img.getImage());
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecciona un producte...");
        for (int clave : products.keySet()) {
            jComboBox.addItem(String.valueOf(clave) + " |  " + products.get(clave).getName());
        }
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelProducto = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jComboBox = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        linea = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelPeso = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelColor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNada1 = new javax.swing.JLabel();
        jLabelNada2 = new javax.swing.JLabel();
        jLabelNada3 = new javax.swing.JLabel();
        jLabelNada4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Producte");
        setAutoRequestFocus(false);
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Mostrar Producte");

        jLabelProducto.setText("Producte:");

        jButtonVolver.setText("Tornar");
        jButtonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxPopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
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

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Nom:");

        jLabelNombre.setText(" ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Codi:");

        jLabelCodigo.setText(" ");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descripció:");

        jLabelDescripcion.setText(" ");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Pes:");

        jLabelPeso.setText(" ");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Color:");

        jLabelColor.setText(" ");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(" ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(" ");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(" ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(" ");

        jLabelNada1.setText(" ");

        jLabelNada2.setText(" ");

        jLabelNada3.setText(" ");

        jLabelNada4.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox, 0, 372, Short.MAX_VALUE)))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelNada3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                    .addComponent(jLabelNada2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNada1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPeso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNada4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProducto)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelPeso))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelColor))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNada1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNada2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelNada3))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelNada4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxPopupMenuWillBecomeInvisible
        String[] list;
        if (jComboBox.getSelectedItem() != null) {
            list = String.valueOf(jComboBox.getSelectedItem()).split(" |  ");
            ProductObj product = products.get(Integer.parseInt(list[0]));
            
            jLabelNombre.setText(product.getName());
            jLabelCodigo.setText(String.valueOf(product.getCode()));
            jLabelDescripcion.setText(product.getDescription());
            jLabelPeso.setText(String.valueOf(product.getWeight()) + "g");
            Color newColor = new Color(product.getColor());
            jLabelColor.setText(String.valueOf(newColor.getRed()) + ", " + String.valueOf(newColor.getGreen()) + ", " + String.valueOf(newColor.getBlue()));
            
            if (product instanceof ErgonomicChair) {
                ErgonomicChair chair = (ErgonomicChair) product;
                jLabel1.setText("Rodes:");
                jLabelNada1.setText(String.valueOf(chair.getWheels()));
                
                jLabel2.setText("Respatller?:");
                if (chair.isBackrest()) {
                    jLabelNada2.setText("Sí");
                } else {
                    jLabelNada2.setText("No");
                }
                
                jLabel3.setText("Reposabraços?:");
                if (chair.isArmrest()) {
                    jLabelNada3.setText("Sí");
                } else {
                    jLabelNada3.setText("No");
                }
                
                jLabel4.setText("");
                jLabelNada4.setText("");
                
            } else if (product instanceof ErgonomicKeyboard) {
                ErgonomicKeyboard keyboard = (ErgonomicKeyboard) product;
                jLabel1.setText("Tipus:");
                jLabelNada1.setText(keyboard.getType());
                
                jLabel2.setText("Llengua:");
                jLabelNada2.setText(keyboard.getLanguage());
                
                jLabel3.setText("Longitud:");
                jLabelNada3.setText(String.valueOf(keyboard.getLenght()) + "%");
                
                jLabel4.setText("Sense fil?");
                if (keyboard.isWireless()) {
                    jLabelNada4.setText("Sí");
                } else {
                    jLabelNada4.setText("No");
                }
                
            } else if (product instanceof ErgonomicMouse) {
                ErgonomicMouse mouse = (ErgonomicMouse) product;
                jLabel1.setText("Botons laterals:");
                jLabelNada1.setText(String.valueOf(mouse.getLateralButtons()));
                
                jLabel2.setText("Dretá?:");
                if (mouse.isHandDexterity()) {
                    jLabelNada2.setText("Sí");
                } else {
                    jLabelNada2.setText("No");
                }
                
                jLabel3.setText("Sense fil?:");
                if (mouse.isWireless()) {
                    jLabelNada3.setText("Sí");
                } else {
                    jLabelNada3.setText("No");
                }
                
                jLabel4.setText("");
                jLabelNada4.setText("");
                
            } else if (product instanceof ErgonomicTable) {
                ErgonomicTable table = (ErgonomicTable) product;
                jLabel1.setText("Material:");
                jLabelNada1.setText(table.getMaterial());
                
                jLabel2.setText("Rodes:");
                jLabelNada2.setText(String.valueOf(table.getWheels()));
                
                jLabel3.setText("Potes:");
                jLabelNada3.setText(String.valueOf(table.getLegs()));
                
                jLabel4.setText("Altura adjustable?");
                if (table.isAdjustableHeight()) {
                    jLabelNada4.setText("Sí");
                } else {
                    jLabelNada4.setText("No");
                }
                
            }
            
        } else {
            jComboBox.addItem("Selecciona un producte...");
        }
    }//GEN-LAST:event_jComboBoxPopupMenuWillBecomeInvisible

    private void jComboBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxPopupMenuWillBecomeVisible
        //Sirve para poder tener un "placeholder" en el combobox
        if (jComboBox.getItemAt(0).equals("Selecciona un producte...")) {
            jComboBox.removeItemAt(0);
        }
    }//GEN-LAST:event_jComboBoxPopupMenuWillBecomeVisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaProductesVeure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProductesVeure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProductesVeure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProductesVeure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                VentanaProductesVeure dialog = new VentanaProductesVeure(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelColor;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelNada1;
    private javax.swing.JLabel jLabelNada2;
    private javax.swing.JLabel jLabelNada3;
    private javax.swing.JLabel jLabelNada4;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel linea;
    // End of variables declaration//GEN-END:variables
}
