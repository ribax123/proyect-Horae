package windows;

import clases.Functions;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
import clases.Interface_Functions;
import javax.swing.JOptionPane;

public class Administrador extends javax.swing.JFrame {
    
    String user, nombre_user;
    
    public Administrador() {
        initComponents();
        user = Interfaz.user;

        // Dimenciones y pocisión de la interfaz
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Interface_Functions union = new Functions();
        union.nombreusuario();
        boolean bra = Functions.bandera;
        
        if (bra == true) {
            jLabel_nameUsuario.setText(Functions.nombre_usero);
        }
    }

    // Imagen logo miniatura
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wallpap = new javax.swing.JPanel();
        jLabel_nameUsuario = new javax.swing.JLabel();
        jButton_regisU = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton_gestionU = new javax.swing.JButton();
        jButton_MenuAux = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_regisU1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton_regisU2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton_regisU3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wallpap.setBackground(new java.awt.Color(0, 51, 102));
        wallpap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_nameUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel_nameUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nameUsuario.setText("Administrador");
        wallpap.add(jLabel_nameUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jButton_regisU.setBackground(new java.awt.Color(0, 51, 102));
        jButton_regisU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add-user.png"))); // NOI18N
        jButton_regisU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_regisU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_regisUActionPerformed(evt);
            }
        });
        wallpap.add(jButton_regisU, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 125, 110));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registros");
        wallpap.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar usuario");
        wallpap.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/HORAE.png"))); // NOI18N
        wallpap.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 190, 150));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Version 1.0");
        wallpap.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 540, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("colaborardor");
        wallpap.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, -1, -1));

        jButton_gestionU.setBackground(new java.awt.Color(0, 51, 102));
        jButton_gestionU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/141-user-1.png"))); // NOI18N
        jButton_gestionU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_gestionU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionUActionPerformed(evt);
            }
        });
        wallpap.add(jButton_gestionU, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 125, 110));

        jButton_MenuAux.setBackground(new java.awt.Color(0, 51, 102));
        jButton_MenuAux.setForeground(new java.awt.Color(0, 51, 102));
        jButton_MenuAux.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/137-briefcase.png"))); // NOI18N
        jButton_MenuAux.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_MenuAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MenuAuxActionPerformed(evt);
            }
        });
        wallpap.add(jButton_MenuAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 125, 110));

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
        wallpap.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 50, 40));

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
        wallpap.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 50, 40));

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/facturar.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        wallpap.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 125, 110));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Facturación");
        wallpap.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Creado por ribax123@gmail.com ");
        wallpap.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, -1));

        jButton_regisU1.setBackground(new java.awt.Color(0, 51, 102));
        jButton_regisU1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        jButton_regisU1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_regisU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_regisU1ActionPerformed(evt);
            }
        });
        wallpap.add(jButton_regisU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 125, 110));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Instalaciones");
        wallpap.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, -1, -1));

        jButton_regisU2.setBackground(new java.awt.Color(0, 51, 102));
        jButton_regisU2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/006-ftp-1.png"))); // NOI18N
        jButton_regisU2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_regisU2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_regisU2ActionPerformed(evt);
            }
        });
        wallpap.add(jButton_regisU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 125, 110));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Registrar");
        wallpap.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Programar ");
        wallpap.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Registro ");
        wallpap.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("de soportes");
        wallpap.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/soporte-tecnico.png"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        wallpap.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 125, 110));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Gestionar usuario");
        wallpap.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        jButton_regisU3.setBackground(new java.awt.Color(0, 51, 102));
        jButton_regisU3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/152-followers.png"))); // NOI18N
        jButton_regisU3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_regisU3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_regisU3ActionPerformed(evt);
            }
        });
        wallpap.add(jButton_regisU3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 125, 110));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Registrar");
        wallpap.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("cliente");
        wallpap.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, -1, -1));

        getContentPane().add(wallpap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_gestionUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionUActionPerformed
        // nuevo objeto de la clase ... 
        gestionarUsuarios gestionarU = new gestionarUsuarios();
        // ABRIR NUEVA INTERFAZ
        gestionarU.setVisible(true);
        

    }//GEN-LAST:event_jButton_gestionUActionPerformed

    private void jButton_regisUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_regisUActionPerformed

        // nuevo objeto de la clase ... 
        agregarUsuarios registrarUsuarios = new agregarUsuarios();
        // ABRIR NUEVA INTERFAZ
        registrarUsuarios.setVisible(true);
        

    }//GEN-LAST:event_jButton_regisUActionPerformed

    private void jButton_MenuAuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MenuAuxActionPerformed
        // nuevo objeto de la clase ...
        Auxiliar auxiliar = new Auxiliar();
        // ABRIR NUEVA INTERFAZ
        auxiliar.setVisible(true);

    }//GEN-LAST:event_jButton_MenuAuxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (resp == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Facturacion factura = new Facturacion();
        factura.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton_regisU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_regisU1ActionPerformed
        agregarClientes clientes = new agregarClientes();
        clientes.setVisible(true);
    }//GEN-LAST:event_jButton_regisU1ActionPerformed

    private void jButton_regisU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_regisU2ActionPerformed
        Agregar_Instalaciones af = new Agregar_Instalaciones();
        af.setVisible(true);

    }//GEN-LAST:event_jButton_regisU2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Monitoreo_quejasAdd monitoreo = new Monitoreo_quejasAdd();
        monitoreo.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton_regisU3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_regisU3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_regisU3ActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*CREA Y MUESTRA LA INTERFAZ */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_MenuAux;
    private javax.swing.JButton jButton_gestionU;
    private javax.swing.JButton jButton_regisU;
    private javax.swing.JButton jButton_regisU1;
    private javax.swing.JButton jButton_regisU2;
    private javax.swing.JButton jButton_regisU3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_nameUsuario;
    private javax.swing.JPanel wallpap;
    // End of variables declaration//GEN-END:variables
}
