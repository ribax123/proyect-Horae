package windows;

import clases.file;
import clases.recurs;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.WindowConstants;

public class Restaura_pass extends javax.swing.JFrame {

    public String user = "";
    public static String password;
    public static String user_update;
    public static String confirmacion_password;

    public Restaura_pass() {
        initComponents();

        user = Interfaz.user;
        user_update = gestionarUsuarios.user_Update;

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    // icono 
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
        jTex_Confirmarpass = new javax.swing.JPasswordField();
        jTex_pass = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        footh = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
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

        jBu_add.setBackground(new java.awt.Color(0, 51, 102));
        jBu_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add-pass.png"))); // NOI18N
        jBu_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBu_addActionPerformed(evt);
            }
        });
        getContentPane().add(jBu_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 70, 70));

        jTex_Confirmarpass.setBackground(new java.awt.Color(0, 51, 102));
        jTex_Confirmarpass.setForeground(new java.awt.Color(255, 255, 255));
        jTex_Confirmarpass.setBorder(null);
        getContentPane().add(jTex_Confirmarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 200, 27));

        jTex_pass.setBackground(new java.awt.Color(0, 51, 102));
        jTex_pass.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jTex_pass.setForeground(new java.awt.Color(255, 255, 255));
        jTex_pass.setBorder(null);
        jTex_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTex_passActionPerformed(evt);
            }
        });
        getContentPane().add(jTex_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 200, 27));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, -10, 50, 40));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, -10, 50, 40));

        footh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        footh.setForeground(new java.awt.Color(255, 255, 255));
        footh.setText("Creado por ribax123@gmail.com ®");
        jPanel1.add(footh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 97, 200, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 167, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBu_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBu_addActionPerformed

        password = jTex_pass.getText().trim();
        confirmacion_password = jTex_Confirmarpass.getText().trim();

        file union = new recurs();
        union.variable();
        boolean bnra = recurs.bandera;

        if (bnra == false) {
            jTex_pass.setBackground(Color.orange);
            jTex_Confirmarpass.setBackground(Color.orange);
            System.out.println(bnra + " +");

        } else {
            jTex_pass.setBackground(Color.green);
            jTex_Confirmarpass.setBackground(Color.green);

        }


    }//GEN-LAST:event_jBu_addActionPerformed

    private void jTex_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTex_passActionPerformed

    }//GEN-LAST:event_jTex_passActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JLabel footh;
    private javax.swing.JButton jBu_add;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel_pass1;
    private javax.swing.JLabel jLabel_pass2;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField jTex_Confirmarpass;
    private javax.swing.JPasswordField jTex_pass;
    // End of variables declaration//GEN-END:variables
}
