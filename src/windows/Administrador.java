/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.sql.*;
import clases.conexion; 
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
        

/**
 *
 * @author fabia_000
 */
public class Administrador extends javax.swing.JFrame {
    
    String user, nombre_user;
    public static int sesion_user; 

    /**
     * Constructor
     */
    public Administrador() {
        initComponents();
        user = Interfaz.user;
        sesion_user = 1;
        
        // Dimenciones y pocisión de la interfaz
        setResizable(false);
        setTitle("Administrador - " + user);
        setLocationRelativeTo(null);
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // conexión a la base de datos e instrucciones consultas
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select nombre_usuario from usuarios where username = '" + user + "'");
            
            // validacion de usuarios en la base de datos
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                    nombre_user = rs.getString("nombre_usuario");
                    jLabel_nameUsuario.setText(nombre_user);
            }
                        
        } catch (Exception e) {
            System.err.println("error en la conexion desde la interfaz Administrador");
        }
        
        
        
    }
    // Imagen logo miniatura
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_nameUsuario = new javax.swing.JLabel();
        jButton_regisU = new javax.swing.JButton();
        jButton_gestionU = new javax.swing.JButton();
        jButton_MenuAux = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_wallp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_nameUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel_nameUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nameUsuario.setText("Administrador");
        getContentPane().add(jLabel_nameUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jButton_regisU.setBackground(new java.awt.Color(204, 255, 255));
        jButton_regisU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add-user.png"))); // NOI18N
        jButton_regisU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_regisU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_regisUActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_regisU, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 125, 110));

        jButton_gestionU.setBackground(new java.awt.Color(204, 255, 255));
        jButton_gestionU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/141-user-1.png"))); // NOI18N
        jButton_gestionU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_gestionU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionUActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionU, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 125, 110));

        jButton_MenuAux.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/137-briefcase.png"))); // NOI18N
        jButton_MenuAux.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_MenuAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MenuAuxActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_MenuAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 125, 110));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Auxiliar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Agregar usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creado por el equipo 6  ®");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/HORAE.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 190, 150));

        jLabel_wallp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondo.jpeg"))); // NOI18N
        jLabel_wallp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel_wallp, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 699, 400));

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
    private javax.swing.JButton jButton_MenuAux;
    private javax.swing.JButton jButton_gestionU;
    private javax.swing.JButton jButton_regisU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_nameUsuario;
    private javax.swing.JLabel jLabel_wallp;
    // End of variables declaration//GEN-END:variables
}
