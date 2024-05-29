package view;

import exceptions.CompanyException;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import model.*;
import persistence.codeDynamixDAO;

public class VentanaProductesRegistrar extends javax.swing.JDialog {
    Interprete interprete;
    codeDynamixDAO dao;
    Color newColor = new Color(Color.black.getRGB());

    public VentanaProductesRegistrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        interprete = Interprete.obtenerInstancia();
        dao = new codeDynamixDAO();
        initComponents();
        ImageIcon img = new ImageIcon("src\\main\\java\\images\\icon.png");
        setIconImage(img.getImage());
        jComboBox.removeAllItems();
        jComboBox.addItem("Selecciona un tipus...");
        jComboBox.addItem("Taula");
        jComboBox.addItem("Cadira");
        jComboBox.addItem("Teclat");
        jComboBox.addItem("Ratolí");
        
        jComboBoxR1.removeAllItems();
        jComboBoxR1.addItem("Mecanic");
        jComboBoxR1.addItem("Membrana");
        jComboBoxR1.addItem("Chiclet");
        
        jComboBoxR2.removeAllItems();
        jComboBoxR2.addItem("Espanyol");
        jComboBoxR2.addItem("Català");
        jComboBoxR2.addItem("Anglès");
        jComboBoxR2.addItem("Portuguès");
        jComboBoxR2.addItem("Francès");
        jComboBoxR2.addItem("Alemany");
        jComboBoxR2.addItem("Chinès");
        jComboBoxR2.addItem("Japonès");
        
        jCheckBoxR3.setVisible(false);
        jCheckBoxR4.setVisible(false);
        jComboBoxR1.setVisible(false);
        jComboBoxR2.setVisible(false);
        jComboBoxR3.setVisible(false);
        jSpinnerR1.setVisible(false);
        jSpinnerR2.setVisible(false);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerPeso = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jButtonElegir = new javax.swing.JButton();
        jPanelRGB = new javax.swing.JPanel();
        jLabelRGB = new javax.swing.JLabel();
        jLabelR1 = new javax.swing.JLabel();
        jLabelR2 = new javax.swing.JLabel();
        jLabelR3 = new javax.swing.JLabel();
        jLabelR4 = new javax.swing.JLabel();
        jCheckBoxR3 = new javax.swing.JCheckBox();
        jCheckBoxR4 = new javax.swing.JCheckBox();
        jSpinnerR2 = new javax.swing.JSpinner();
        jSpinnerR1 = new javax.swing.JSpinner();
        jLabelAlertas = new javax.swing.JLabel();
        jComboBoxR2 = new javax.swing.JComboBox<>();
        jComboBoxR3 = new javax.swing.JComboBox<>();
        jComboBoxR1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jSpinnerID = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Producte");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar producte");

        jLabel1.setText("Nom:");

        jLabel3.setText("Descripció:");

        jButtonVolver.setText("Tornar");
        jButtonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jTextAreaDescripcion.setColumns(16);
        jTextAreaDescripcion.setRows(3);
        jTextAreaDescripcion.setTabSize(4);
        jScrollPane1.setViewportView(jTextAreaDescripcion);

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

        jLabel4.setText("Tipus producte:");

        jLabel5.setText("Pes (g):");

        jSpinnerPeso.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel6.setText("Color:");

        jButtonElegir.setText("Elegir");
        jButtonElegir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonElegir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jButtonElegirItemStateChanged(evt);
            }
        });
        jButtonElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElegirActionPerformed(evt);
            }
        });

        jPanelRGB.setBackground(new java.awt.Color(51, 51, 51));
        jPanelRGB.setRequestFocusEnabled(false);

        jLabelRGB.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelRGB.setText(" ");

        javax.swing.GroupLayout jPanelRGBLayout = new javax.swing.GroupLayout(jPanelRGB);
        jPanelRGB.setLayout(jPanelRGBLayout);
        jPanelRGBLayout.setHorizontalGroup(
            jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelRGB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        jPanelRGBLayout.setVerticalGroup(
            jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRGBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRGB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelR1.setText(" ");

        jLabelR2.setText(" ");

        jLabelR3.setText(" ");

        jLabelR4.setText(" ");

        jCheckBoxR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxR3ActionPerformed(evt);
            }
        });

        jSpinnerR2.setModel(new javax.swing.SpinnerNumberModel());

        jSpinnerR1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabelAlertas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelAlertas.setForeground(new java.awt.Color(204, 0, 0));
        jLabelAlertas.setText(" ");

        jComboBoxR2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxR2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBoxR3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxR3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBoxR1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setText("Nº Identificador:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAlertas)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelR1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelR4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelR3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBoxR4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jSpinnerPeso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jPanelRGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jSpinnerR1)
                                            .addComponent(jSpinnerR2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                            .addComponent(jCheckBoxR3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jComboBoxR2, 0, 129, Short.MAX_VALUE)
                                                .addComponent(jComboBoxR3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jComboBoxR1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jSpinnerID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanelRGB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelR1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonElegir)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelR2)
                    .addComponent(jSpinnerR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabelR3)))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxR3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelR4)
                    .addComponent(jCheckBoxR4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAlertas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        if (jComboBox.getItemAt(0).equals("Selecciona un tipus...")) {
            jLabelAlertas.setText("*Has de seleccionar un tipus de producte*");
        } else {
            try {
                switch (jComboBox.getSelectedIndex()) {
                    case 0:
                        dao.insertTable(new ErgonomicTable(Integer.parseInt(jSpinnerR2.getValue().toString()), Integer.parseInt(jSpinnerR1.getValue().toString()), jCheckBoxR4.isSelected(), jComboBoxR3.getItemAt(jComboBoxR3.getSelectedIndex()), jTextFieldNombre.getText(), Integer.parseInt(jSpinnerID.getValue().toString()), jTextAreaDescripcion.getText(), Integer.parseInt(jSpinnerPeso.getValue().toString()), newColor.getRGB()));
                        break;
                        
                    case 1:
                        dao.insertChair(new ErgonomicChair(jCheckBoxR3.isSelected(), Integer.parseInt(jSpinnerR2.getValue().toString()), jCheckBoxR4.isSelected(), jTextFieldNombre.getText(), Integer.parseInt(jSpinnerID.getValue().toString()), jTextAreaDescripcion.getText(), Integer.parseInt(jSpinnerPeso.getValue().toString()), newColor.getRGB()));
                        break;
                        
                    case 2:
                        int longitud = 0;
                        switch (jComboBoxR3.getSelectedIndex()) {
                            case 0:
                                longitud = 100;
                                break;
                            case 1:
                                longitud = 80;
                                break;
                            case 2:
                                longitud = 75;
                                break;
                            case 3:
                                longitud = 65;
                                break;
                            case 4:
                                longitud = 60;
                                break;
                            case 5:
                                longitud = 40;
                                break;
                        }
                        dao.insertKeyboard(new ErgonomicKeyboard(jComboBoxR1.getItemAt(jComboBoxR1.getSelectedIndex()), jComboBoxR2.getItemAt(jComboBoxR2.getSelectedIndex()), longitud, jCheckBoxR4.isSelected(), jTextFieldNombre.getText(), Integer.parseInt(jSpinnerID.getValue().toString()), jTextAreaDescripcion.getText(), Integer.parseInt(jSpinnerPeso.getValue().toString()), newColor.getRGB()));
                        break;
                        
                    case 3:
                        dao.insertMouse(new ErgonomicMouse(jCheckBoxR3.isSelected(), Integer.parseInt(String.valueOf(jSpinnerR1.getValue())), jCheckBoxR4.isSelected(), jTextFieldNombre.getText(), Integer.parseInt(jSpinnerID.getValue().toString()), jTextAreaDescripcion.getText(), Integer.parseInt(jSpinnerPeso.getValue().toString()), newColor.getRGB()));
                        break;
                }
                JOptionPane.showMessageDialog(this, "El producte s'ha registrat correctament" , " ", 1);
                this.dispose();
            } catch (CompanyException | SQLException ex) {
                jLabelAlertas.setText(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElegirActionPerformed
        newColor = JColorChooser.showDialog(this,"Selecciona un color",jLabelRGB.getBackground());
        if (newColor != null) {
            jPanelRGB.setBackground(newColor);
            if (newColor.getRed() < 60 || newColor.getGreen() < 60 || newColor.getBlue() < 60) {
                jLabelRGB.setForeground(Color.WHITE);
            } else {
                jLabelRGB.setForeground(Color.BLACK);
            }
            jLabelRGB.setText(String.valueOf(" " + newColor.getRed()) + ", " + String.valueOf(newColor.getGreen()) + ", " + String.valueOf(newColor.getBlue()));
        }
    }//GEN-LAST:event_jButtonElegirActionPerformed

    private void jButtonElegirItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jButtonElegirItemStateChanged
        
    }//GEN-LAST:event_jButtonElegirItemStateChanged

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxPopupMenuWillBecomeInvisible
        switch (jComboBox.getSelectedIndex()) {
            case 0:
                jLabelR1.setText("Potes:"); //int
                jLabelR2.setText("Rodes:"); //int
                jLabelR3.setText("Material:"); //String
                jLabelR4.setText("Alçada ajustable:"); //boolean
                jCheckBoxR3.setVisible(false);
                jCheckBoxR4.setVisible(true);
                jComboBoxR1.setVisible(false);
                jComboBoxR2.setVisible(false);
                jComboBoxR3.setVisible(true);
                jSpinnerR1.setVisible(true);
                jSpinnerR2.setVisible(true);
                
                jComboBoxR3.removeAllItems();
                jComboBoxR3.addItem("Fusta");
                jComboBoxR3.addItem("Plàstic");
                jComboBoxR3.addItem("Alumini");
                jComboBoxR3.addItem("Metall");
                break;
            
            case 1:
                jLabelR1.setText("");
                jLabelR2.setText("Rodes:"); //int
                jLabelR3.setText("Respatller:"); //boolean
                jLabelR4.setText("Reposabraços:"); //boolean
                jCheckBoxR3.setVisible(true);
                jCheckBoxR4.setVisible(true);
                jComboBoxR1.setVisible(false);
                jComboBoxR2.setVisible(false);
                jComboBoxR3.setVisible(false);
                jSpinnerR1.setVisible(false);
                jSpinnerR2.setVisible(true);
                break;
                
            case 2:
                jLabelR1.setText("Tipus:"); //String
                jLabelR3.setText("Longitud:"); //int
                jLabelR2.setText("Llengua:"); //String
                jLabelR4.setText("Sense fil:"); //boolean
                jComboBoxR1.setVisible(true);
                jComboBoxR2.setVisible(true);
                jComboBoxR3.setVisible(true);
                jCheckBoxR3.setVisible(false);
                jCheckBoxR4.setVisible(true);
                jSpinnerR1.setVisible(false);
                jSpinnerR2.setVisible(false);
                
                jComboBoxR3.removeAllItems();
                jComboBoxR3.addItem("100%");
                jComboBoxR3.addItem("80%");
                jComboBoxR3.addItem("75%");
                jComboBoxR3.addItem("65%");
                jComboBoxR3.addItem("60%");
                jComboBoxR3.addItem("40%");
                break;
            
            case 3:
                jLabelR1.setText("");
                jLabelR2.setText("Botons laterals:"); //int
                jLabelR3.setText("Dretà:"); //boolean
                jLabelR4.setText("Sense fil:"); //boolean
                jCheckBoxR3.setVisible(true);
                jCheckBoxR4.setVisible(true);
                jComboBoxR1.setVisible(false);
                jComboBoxR2.setVisible(false);
                jComboBoxR3.setVisible(false);
                jSpinnerR1.setVisible(false);
                jSpinnerR2.setVisible(true);
                break;
        }
    }//GEN-LAST:event_jComboBoxPopupMenuWillBecomeInvisible

    private void jComboBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxPopupMenuWillBecomeVisible
        //Sirve para poder tener un "placeholder" en el combobox
        if (jComboBox.getItemAt(0).equals("Selecciona un tipus...")) {
            jComboBox.removeItemAt(0);
        }
    }//GEN-LAST:event_jComboBoxPopupMenuWillBecomeVisible

    private void jCheckBoxR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxR3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxR3ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaProductesRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProductesRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProductesRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProductesRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaProductesRegistrar dialog = new VentanaProductesRegistrar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonElegir;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JCheckBox jCheckBoxR3;
    private javax.swing.JCheckBox jCheckBoxR4;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JComboBox<String> jComboBoxR1;
    private javax.swing.JComboBox<String> jComboBoxR2;
    private javax.swing.JComboBox<String> jComboBoxR3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAlertas;
    private javax.swing.JLabel jLabelR1;
    private javax.swing.JLabel jLabelR2;
    private javax.swing.JLabel jLabelR3;
    private javax.swing.JLabel jLabelR4;
    private javax.swing.JLabel jLabelRGB;
    private javax.swing.JPanel jPanelRGB;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerID;
    private javax.swing.JSpinner jSpinnerPeso;
    private javax.swing.JSpinner jSpinnerR1;
    private javax.swing.JSpinner jSpinnerR2;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
