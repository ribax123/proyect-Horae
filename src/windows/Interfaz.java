package windows;

import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import clases.conexion;
import javax.swing.JOptionPane;

// clase
public class Interfaz extends javax.swing.JFrame {

    //  variasble global usuario
    public static String user = "";
    String pass = "";

    //constructor
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // icono miniatura
    public Image getIconImage() {
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

        jLabel_Fodeer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1_Usuario = new javax.swing.JLabel();
        jLabel_password = new javax.swing.JLabel();
        jPassword_txt = new javax.swing.JPasswordField();
        jTextField_User = new javax.swing.JTextField();
        botton_ingresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton_salir = new javax.swing.JButton();
        jLabel_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Fodeer.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Fodeer.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel_Fodeer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Fodeer.setText("Creado por el equipo 7  ®");
        getContentPane().add(jLabel_Fodeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));
        jLabel_Fodeer.getAccessibleContext().setAccessibleName("Creado por  equipo 7 ®");

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1_Usuario.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/usuario.png"))); // NOI18N
        jPanel2.add(jLabel1_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 273, 40, 40));

        jLabel_password.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel_password.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/candado.png"))); // NOI18N
        jPanel2.add(jLabel_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 346, 40, 40));

        jPassword_txt.setBackground(new java.awt.Color(0, 51, 102));
        jPassword_txt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPassword_txt.setForeground(new java.awt.Color(0, 153, 153));
        jPassword_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jPassword_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 220, 30));

        jTextField_User.setBackground(new java.awt.Color(0, 51, 102));
        jTextField_User.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_User.setForeground(new java.awt.Color(0, 153, 153));
        jTextField_User.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField_User.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_UserActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 220, 30));

        botton_ingresar.setBackground(new java.awt.Color(0, 153, 153));
        botton_ingresar.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        botton_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        botton_ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/entrar.png"))); // NOI18N
        botton_ingresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botton_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botton_ingresar.setSelected(true);
        botton_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botton_ingresarActionPerformed(evt);
            }
        });
        jPanel2.add(botton_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 60, 60));

        jSeparator1.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 280, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 280, -1));

        jButton_salir.setBackground(new java.awt.Color(0, 0, 0));
        jButton_salir.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton_salir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton-de-encendido-apagado.png"))); // NOI18N
        jButton_salir.setBorder(null);
        jButton_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_salirActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 30, 30));

        jLabel_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/HORAE.png"))); // NOI18N
        jPanel2.add(jLabel_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 200));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 410, 570));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 56)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sing In");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 522, 215, 3));

        jLabel_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/a.jpg"))); // NOI18N
        getContentPane().add(jLabel_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salirActionPerformed

        // funcion boton salir
        System.exit(0);


    }//GEN-LAST:event_jButton_salirActionPerformed

    private void botton_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botton_ingresarActionPerformed

        // variables para obtener el texto de los campos
        user = jTextField_User.getText().trim();
        pass = jPassword_txt.getText().trim();

        // validaciones campos vacios
        if (!user.equals("") || !pass.equals("")) {

            //conexion y consulta a la base de datos
            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select nivel, estado from usuarios where username = '" + user
                        + "' and password = '" + pass + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    // guarda en variables el nivel y el estado desde la base de datos
                    String nivel = rs.getString("nivel");
                    String estado = rs.getString("estado");

                    if (nivel.equalsIgnoreCase("Administrador") && estado.equalsIgnoreCase("Activo")) {
                        //se encarga de eliminar un objeto y asi liberar recursos 
                        dispose();
                        // si la condicion se cumple abre una nueva interfaz
                        new Administrador().setVisible(true);

                    } else if (nivel.equalsIgnoreCase("Auxiliar") && estado.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Auxiliar().setVisible(true);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "¡¡Datos incorrectos!!");
                    //deja los spacios de la interfaz en blanco en caso de no coincidir
                    jTextField_User.setText("");
                    jPassword_txt.setText("");
                }

            } catch (SQLException e) {
                System.err.println("Error en el boton acceder. " + e);
                JOptionPane.showMessageDialog(null, "¡¡ error al iniciar sesion!!, contacte al administrador");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

        }
    }//GEN-LAST:event_botton_ingresarActionPerformed

    private void jTextField_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_UserActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_Usuario;
    private javax.swing.JLabel jLabel_Fodeer;
    private javax.swing.JLabel jLabel_Fondo;
    private javax.swing.JLabel jLabel_icon;
    private javax.swing.JLabel jLabel_password;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword_txt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField_User;
    // End of variables declaration//GEN-END:variables
}
