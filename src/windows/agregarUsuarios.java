package windows;

import java.util.*;
import clases.conexion;
import clases.other;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class agregarUsuarios extends javax.swing.JFrame {

    String user;

    public agregarUsuarios() {
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
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jPassword_add = new javax.swing.JPasswordField();
        jTex_Username = new javax.swing.JTextField();
        jTex_Nombre = new javax.swing.JTextField();
        listaBox = new javax.swing.JComboBox<>();
        jLabel_Nombre4 = new javax.swing.JLabel();
        Btn_add = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLainstru = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLainstru1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Username:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Password");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Nivel :");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jPassword_add.setBackground(new java.awt.Color(0, 51, 102));
        jPassword_add.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jPassword_add.setForeground(new java.awt.Color(255, 255, 255));
        jPassword_add.setBorder(null);
        jPassword_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword_addActionPerformed(evt);
            }
        });
        getContentPane().add(jPassword_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 170, 27));

        jTex_Username.setBackground(new java.awt.Color(0, 51, 102));
        jTex_Username.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jTex_Username.setForeground(new java.awt.Color(255, 255, 255));
        jTex_Username.setBorder(null);
        getContentPane().add(jTex_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 95, 170, 27));

        jTex_Nombre.setBackground(new java.awt.Color(0, 51, 102));
        jTex_Nombre.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jTex_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jTex_Nombre.setBorder(null);
        getContentPane().add(jTex_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 95, 170, 27));

        listaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Auxiliar" }));
        listaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaBoxActionPerformed(evt);
            }
        });
        getContentPane().add(listaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 170, 27));

        jLabel_Nombre4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Nombre :");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        Btn_add.setBackground(new java.awt.Color(0, 51, 102));
        Btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        Btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 105, 105));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 122, 170, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 122, 170, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 197, 170, 10));

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
        jPanel1.add(jLainstru, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Creado por ribax@gimail.com ®");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jLainstru1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLainstru1.setForeground(new java.awt.Color(255, 255, 255));
        jLainstru1.setText("Minimo 8 caracteres entre  ");
        jPanel1.add(jLainstru1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaBoxActionPerformed

    private void Btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addActionPerformed

        // tipo Variables para los campos "agregar usuarios"
        int permisos_cmb, validacion = 0;
        String nombre, username, pass, permisos_string = "";

        // definir variables
        nombre = jTex_Nombre.getText().trim();
        username = jTex_Username.getText().trim();
        pass = jPassword_add.getText().trim();
        permisos_cmb = listaBox.getSelectedIndex() + 1;
        other mensAdd = new other();
        boolean val = mensAdd.validacion(nombre, 0);
        boolean va2 = mensAdd.validacion(0, pass);
        boolean va3 = mensAdd.validacion(username, username);

        if (!nombre.equals("") || !username.equals("") || !pass.equals("")) {

            
            if(val == false){
                JOptionPane.showMessageDialog(null, "El nombre debe  contener carateres alfabeticos y minimo 10 letras");
                validacion++;
            }
            else if (va3 == false){
                 JOptionPane.showMessageDialog(null, "El usuario debe contener 6 caracteres minimos entre letras y numeros");
                 validacion++;
            }else if(va2 == false){
                JOptionPane.showMessageDialog(null, "La contraseña debe contener 8 caracteres minimos entre letras y numeros");
                validacion++;
            }
            
            
            
// validaciones para asignar los estados        
            if (permisos_cmb == 1) {
                permisos_string = "Administrador";
            } else if (permisos_cmb == 2) {
                permisos_string = "Auxliar";
            }

            if (validacion == 0) {
                try {
                    Connection cn = conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "select username from usuarios where username = '" + username + "'");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        jTex_Username.setBackground(Color.ORANGE);
                        JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
                        cn.close();
                    } else {

                        cn.close();

                        // Ingresar nuevos usuarios a la base de datos
                        if (validacion == 0) {
                            try {
                                Connection cn2 = conexion.conectar();
                                // instrucciones colsultas
                                PreparedStatement pst2 = cn2.prepareStatement(
                                        " insert into usuarios values (?,?,?,?,?,?)");

                                pst2.setInt(1, 0);
                                pst2.setString(2, nombre);
                                pst2.setString(3, username);
                                pst2.setString(4, pass);
                                pst2.setString(5, permisos_string);
                                pst2.setString(6, "Activo");

                                pst2.executeUpdate();
                                cn2.close();

                                Limpiar();

                                jTex_Nombre.setBackground(Color.green);
                                jTex_Username.setBackground(Color.green);
                                jPassword_add.setBackground(Color.green);

                                JOptionPane.showMessageDialog(null, "Registro exitoso");
                                this.dispose();

                            } catch (SQLException e) {
                                System.err.println("ERROR al registrar el usuario");
                                JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador");
                            }
                        } else {

                        }

                    }
                } catch (SQLException e) {
                    System.err.println("Error al validar el nombre de usuario." + e);
                    JOptionPane.showMessageDialog(null, "¡¡ ERROR al comparar usuario!!, contacte al administrador.");
                }
            } 

            }else {
                JOptionPane.showMessageDialog(null, "Los campos no puede estar vacios");
        }


    }//GEN-LAST:event_Btn_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPassword_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassword_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassword_addActionPerformed

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
            java.util.logging.Logger.getLogger(agregarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_add;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLainstru;
    private javax.swing.JLabel jLainstru1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword_add;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTex_Nombre;
    private javax.swing.JTextField jTex_Username;
    private javax.swing.JComboBox<String> listaBox;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        jTex_Nombre.setText("");
        jTex_Username.setText("");
        jPassword_add.setText("");
        listaBox.setSelectedIndex(0);
    }

}
