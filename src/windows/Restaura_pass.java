
package windows;

import java.sql.*;
import clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Restaura_pass extends javax.swing.JFrame {

    String user = "", user_update = "";

    public Restaura_pass() {
        initComponents();

        user = Interfaz.user;
        user_update = gestionarUsuarios.user_Update;

        setResizable(false);
        setTitle("Restablecer contraseña para " + user_update);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    // icono pequeño
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_pass1 = new javax.swing.JLabel();
        jLabel_pass2 = new javax.swing.JLabel();
        jBu_add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTex_Confirmarpass = new javax.swing.JPasswordField();
        jTex_pass = new javax.swing.JPasswordField();
        jLabel_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Restablecer contraseña");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        jLabel_pass1.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel_pass1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pass1.setText("Confirmar contraseña :");
        getContentPane().add(jLabel_pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel_pass2.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel_pass2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pass2.setText("Contraseña :");
        getContentPane().add(jLabel_pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jBu_add.setBackground(new java.awt.Color(204, 255, 255));
        jBu_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add-pass.png"))); // NOI18N
        jBu_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBu_addActionPerformed(evt);
            }
        });
        getContentPane().add(jBu_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 70, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creado por el equipo 7 ®");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));
        getContentPane().add(jTex_Confirmarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 200, 27));

        jTex_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTex_passActionPerformed(evt);
            }
        });
        getContentPane().add(jTex_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 200, 27));

        jLabel_wall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondopass.jpg"))); // NOI18N
        getContentPane().add(jLabel_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBu_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBu_addActionPerformed

        String password, confirmacion_password;

        password = jTex_pass.getText().trim();
        confirmacion_password = jTex_Confirmarpass.getText().trim();

        if (!password.equals("") && !confirmacion_password.equals("")) {

            if (password.equals(confirmacion_password)) {

                try {
                    // conexion al la base de datos.
                    Connection cn = conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update usuarios set password=? where username = '" + user_update + "'");

                    pst.setString(1, password);

                    pst.executeUpdate();
                    cn.close();

                    jTex_pass.setBackground(Color.GREEN);
                    jTex_Confirmarpass.setBackground(Color.GREEN);

                    JOptionPane.showMessageDialog(null, "Restauración exitosa");
                    // cierra la venta cuando se ejecuta exitosamente
                    this.dispose();

                } catch (SQLException e) {
                    System.err.println("Error en restaurar la contraseña " + e);
                }

            } else {
                jTex_Confirmarpass.setBackground(Color.ORANGE);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");

            }

        } else {
            jTex_pass.setBackground(Color.ORANGE);
            jTex_Confirmarpass.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "No se admiten campos vacios.");

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jBu_addActionPerformed

    private void jTex_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTex_passActionPerformed
       
    }//GEN-LAST:event_jTex_passActionPerformed

    
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
            java.util.logging.Logger.getLogger(Restaura_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaura_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaura_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaura_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaura_pass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBu_add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_pass1;
    private javax.swing.JLabel jLabel_pass2;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_wall;
    private javax.swing.JPasswordField jTex_Confirmarpass;
    private javax.swing.JPasswordField jTex_pass;
    // End of variables declaration//GEN-END:variables
}
