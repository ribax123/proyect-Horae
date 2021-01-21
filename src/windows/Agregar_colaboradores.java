package windows;


import clases.conexion;
import clases.Datos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


public class Agregar_colaboradores extends javax.swing.JFrame {

    String user;

    public Agregar_colaboradores() {
        initComponents();
        user = Interfaz.user;

        setResizable(false);
        setLocationRelativeTo(this);
        setSize(500,450);
        

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jTex_Nombre = new javax.swing.JTextField();
        cbx_cargo = new javax.swing.JComboBox<>();
        jLabel_Nombre4 = new javax.swing.JLabel();
        Btn_add = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        version = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 170, 10));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 50, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de colaboradores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 30));

        jLabel_Nombre3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Cargo :");
        jPanel1.add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jTex_Nombre.setBackground(new java.awt.Color(0, 51, 102));
        jTex_Nombre.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jTex_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jTex_Nombre.setBorder(null);
        jPanel1.add(jTex_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, 30));

        cbx_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Técnico(a)", "Ingeniero(a)", "Secretario(a)", "Compras", "Gerente general", "Abogado(a)", "Contador(a)", "Facturador(a)", "Psicólogo(a)", "Mensajero(a)", "Cordinador(a)", " ", " ", " " }));
        cbx_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_cargoActionPerformed(evt);
            }
        });
        jPanel1.add(cbx_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 170, 27));

        jLabel_Nombre4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Nombre :");
        jPanel1.add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 30));

        Btn_add.setBackground(new java.awt.Color(0, 51, 102));
        Btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        Btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 105, 105));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Creado por ribax@gimail.com ®");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        jPanel1.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_cargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_cargoActionPerformed

    private void Btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addActionPerformed

        // tipo Variables para los campos "agregar usuarios"
        int  validacion = 0;
        String nombre, cargo;

        // definir variables
        nombre = jTex_Nombre.getText().trim();
        
        cargo = cbx_cargo.getSelectedItem().toString();
        Datos mensAdd = new Datos();
        boolean val = mensAdd.validacion(nombre, 0);
        

        if (!nombre.equals("")) {

            
            if(val == false){
                JOptionPane.showMessageDialog(null, "El nombre debe  contener carateres alfabeticos y minimo 10 letras");
                validacion++;
            }
                        
            
            


            if (validacion == 0) {
                

                        // Ingresar nuevos colaboradore a la base de datos
                        if (validacion == 0) {
                            try {
                                Connection cn2 = conexion.conectar();
                                // instrucciones colsultas
                                PreparedStatement pst2 = cn2.prepareStatement(
                                        " insert into colaboradores values (?,?,?)");

                                pst2.setInt(1, 0);
                                pst2.setString(2, cargo);
                                pst2.setString(3, nombre);
                                

                                pst2.executeUpdate();
                                cn2.close();

                                Limpiar();

                                jTex_Nombre.setBackground(Color.green);
                                

                                JOptionPane.showMessageDialog(null, "Registro exitoso");
                                this.dispose();

                            } catch (SQLException e) {
                                System.err.println("ERROR al registrar el usuario");
                                JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador");
                            }
                        } else {

                        }

                    
           
            } 

            }else {
                JOptionPane.showMessageDialog(null, "Los campos no puede estar vacios");
        }


    }//GEN-LAST:event_Btn_addActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(ICONIFIED);
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
            java.util.logging.Logger.getLogger(Agregar_colaboradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_colaboradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_colaboradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_colaboradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_colaboradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_add;
    private javax.swing.JComboBox<String> cbx_cargo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTex_Nombre;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        jTex_Nombre.setText("");
        cbx_cargo.setSelectedIndex(0);
    }

}
