package windows;

import clases.conexion;
import clases.Datos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class agregarClientes extends javax.swing.JFrame {

    String user;

    public agregarClientes() {
        initComponents();
        user = Interfaz.user;

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txt_nombre = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_documento = new javax.swing.JPasswordField();
        txt_dieccion = new javax.swing.JTextField();
        cbx_servicio = new javax.swing.JComboBox<>();
        cbx_megas = new javax.swing.JComboBox<>();
        Btn_add = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLainstru = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLainstru1 = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel_Nombre6 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registro de clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 170, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 170, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 170, 10));

        txt_nombre.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(102, 102, 102));
        txt_nombre.setBorder(null);
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 170, 27));

        txt_telefono.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(102, 102, 102));
        txt_telefono.setBorder(null);
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 170, 27));

        txt_documento.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_documento.setForeground(new java.awt.Color(102, 102, 102));
        txt_documento.setBorder(null);
        txt_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_documentoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 170, 27));

        txt_dieccion.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_dieccion.setForeground(new java.awt.Color(102, 102, 102));
        txt_dieccion.setBorder(null);
        jPanel1.add(txt_dieccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 170, 27));

        cbx_servicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ANTENA", "GPON", "CABLEADO" }));
        cbx_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_servicioActionPerformed(evt);
            }
        });
        jPanel1.add(cbx_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 170, 27));

        cbx_megas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "6", "8", "10", "15", "20", "50" }));
        cbx_megas.setSelectedIndex(3);
        cbx_megas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_megasActionPerformed(evt);
            }
        });
        jPanel1.add(cbx_megas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 170, 27));

        Btn_add.setBackground(new java.awt.Color(0, 51, 102));
        Btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        Btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 105, 105));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("-");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 50, 40));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 153));
        jButton2.setText("x");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 50, 40));

        jLainstru.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLainstru.setForeground(new java.awt.Color(255, 255, 255));
        jLainstru.setText("numeros y letras.");
        jPanel1.add(jLainstru, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Creado por ribax@gimail.com ®");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        jLainstru1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLainstru1.setForeground(new java.awt.Color(255, 255, 255));
        jLainstru1.setText("Minimo 8 caracteres entre  ");
        jPanel1.add(jLainstru1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        jPanel1.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, -1, -1));

        jLabel_Nombre3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Nombre3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nombre3.setText("Mbs");
        jPanel1.add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        jLabel_Nombre2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Nombre2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nombre2.setText("Documento :");
        jPanel1.add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel_Nombre5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Nombre5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nombre5.setText("Dirección :");
        jPanel1.add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 170, -1));

        jLabel_Nombre6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Nombre6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nombre6.setText("Tipo de servicio :");
        jPanel1.add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel_Nombre4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Nombre4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nombre4.setText("Nombre :");
        jPanel1.add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel_Nombre.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nombre.setText("Telefono :");
        jPanel1.add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_megasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_megasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_megasActionPerformed

    private void Btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addActionPerformed

        // tipo Variables para los campos "agregar usuarios"
        String megas_cmb, servicio;
        String nombre, telefono, documento, direccion = "";

        // definir variables
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();
        documento = txt_documento.getText().trim();
        direccion = txt_dieccion.getText().trim();
        megas_cmb = cbx_megas.getSelectedItem().toString();
        servicio = cbx_servicio.getSelectedItem().toString();
        Datos mensAdd = new Datos();
       

        if (!nombre.equals("") || !documento.equals("") || !direccion.equals("")) {

            int validacion = 0;

// validaciones para asignar los estados        
            if (validacion == 0) {
                            try {
                                Connection cn2 = conexion.conectar();
                                // instrucciones colsultas
                                PreparedStatement pst2 = cn2.prepareStatement(
                                        " insert into clientesuribia values (?,?,?,?,?,?,?)");

                                
                                pst2.setString(1, nombre);
                                pst2.setString(2, documento);
                                pst2.setString(3, telefono);
                                pst2.setString(4, direccion);
                                pst2.setString(5, mensAdd.fechaActual());
                                pst2.setString(6, servicio);
                                pst2.setString(7, megas_cmb);

                                pst2.executeUpdate();
                                cn2.close();

                                Limpiar();

                                

                                JOptionPane.showMessageDialog(null, "Registro exitoso");
                                

                            } catch (SQLException e) {
                                System.err.println("ERROR al registrar el usuario" + e);
                                JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador");
                            }
                        } else {

                        }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos no puede estar vacios");
        }


    }//GEN-LAST:event_Btn_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_documentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_documentoActionPerformed

    private void cbx_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_servicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_servicioActionPerformed

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
            java.util.logging.Logger.getLogger(agregarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_add;
    private javax.swing.JComboBox<String> cbx_megas;
    private javax.swing.JComboBox<String> cbx_servicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLainstru;
    private javax.swing.JLabel jLainstru1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txt_dieccion;
    private javax.swing.JPasswordField txt_documento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_nombre.setText("");
        txt_telefono.setText("");
        txt_documento.setText("");
        txt_dieccion.setText("");
        
    }

}
