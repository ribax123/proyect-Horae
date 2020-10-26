/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import clases.conexion;
import javax.swing.JOptionPane;
/**
 *
 * @author fabia_000
 */
public class Interfaz extends javax.swing.JFrame {

   public static String user = "";
   String pass = "";
    
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    // icono miniatura
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

        jLabel_icon = new javax.swing.JLabel();
        jButton_salir = new javax.swing.JButton();
        jLabel1_Usuario = new javax.swing.JLabel();
        jLabel_password = new javax.swing.JLabel();
        jTextField_User = new javax.swing.JTextField();
        jPassword_txt = new javax.swing.JPasswordField();
        botton_ingresar = new javax.swing.JButton();
        jLabel_Fodeer = new javax.swing.JLabel();
        jLabel_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoing.png"))); // NOI18N
        getContentPane().add(jLabel_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jButton_salir.setBackground(new java.awt.Color(153, 204, 255));
        jButton_salir.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton_salir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/058-power-button.png"))); // NOI18N
        jButton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 50, 50));

        jLabel1_Usuario.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1_Usuario.setText("Usuario :");
        getContentPane().add(jLabel1_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel_password.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel_password.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_password.setText("Contraseña :");
        getContentPane().add(jLabel_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jTextField_User.setBackground(new java.awt.Color(51, 204, 255));
        jTextField_User.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_User.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 150, 25));

        jPassword_txt.setBackground(new java.awt.Color(51, 204, 255));
        jPassword_txt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPassword_txt.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPassword_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 150, 25));

        botton_ingresar.setBackground(new java.awt.Color(153, 204, 255));
        botton_ingresar.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        botton_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        botton_ingresar.setText("Ingresar");
        botton_ingresar.setSelected(true);
        botton_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botton_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(botton_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 130, -1));

        jLabel_Fodeer.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel_Fodeer.setText("Creado por el equipo 7  ®");
        getContentPane().add(jLabel_Fodeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 545, -1, -1));
        jLabel_Fodeer.getAccessibleContext().setAccessibleName("Creado por  equipo 7 ®");

        jLabel_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondo.png"))); // NOI18N
        getContentPane().add(jLabel_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 309, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salirActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_salirActionPerformed

    private void botton_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botton_ingresarActionPerformed
    
        // validacions de campos vacios
        user = jTextField_User.getText().trim();
        pass = jPassword_txt.getText().trim();
        
        if(!user.equals("") || !pass.equals("")){
        
            //coneccion a base de datos e instrucciones
            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                "select nivel, estado from usuarios where username = '" + user
                        + "' and password = '" + pass + "'"); 
                
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                   
                    String nivel = rs.getString("nivel");
                    String estado = rs.getString("estado");
                    
                    if (nivel.equalsIgnoreCase("Administrador") && estado.equalsIgnoreCase("Activo")){
                         dispose();
                         new Administrador().setVisible(true);
                    
                    }else if(nivel.equalsIgnoreCase("Auxiliar") && estado.equalsIgnoreCase("Activo")){
                         dispose();
                         new Auxiliar().setVisible(true);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "¡¡Datos incorrectos!!");
                    jTextField_User.setText("");
                    jPassword_txt.setText(""); 
                }
                
            } catch (SQLException e) {
                System.err.println("Error en el boton acceder. " + e);
                JOptionPane.showMessageDialog(null, "¡¡ error al iniciar sesion!!, contacte al administrador");
            }
            
        } else{            
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
           
        }
    }//GEN-LAST:event_botton_ingresarActionPerformed
    
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botton_ingresar;
    private javax.swing.JButton jButton_salir;
    private javax.swing.JLabel jLabel1_Usuario;
    private javax.swing.JLabel jLabel_Fodeer;
    private javax.swing.JLabel jLabel_Fondo;
    private javax.swing.JLabel jLabel_icon;
    private javax.swing.JLabel jLabel_password;
    private javax.swing.JPasswordField jPassword_txt;
    private javax.swing.JTextField jTextField_User;
    // End of variables declaration//GEN-END:variables
}
