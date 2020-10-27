/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;
import clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;




public class informacionUsu extends javax.swing.JFrame {
    
    String user = "", user_update = "";
    int ID;
    
    
 // cosntructor   
    public informacionUsu() {
        initComponents();
        
        // variables de usuario
        user = Interfaz.user;
        user_update = gestionarUsuarios.user_Update;
        
        // Dimenciones y pocisión de la intefaz
        setSize(452, 295);
        setResizable(false);
        setTitle("Información del usuario " + " -  " + user);
        setLocationRelativeTo(null);
        
        // metodo para evitar el cierre total del programa
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        jLabel_titulo.setText("Informacion de usuario - " + user_update);
        
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select * from usuarios where username = '" + user_update + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                ID = rs.getInt("id_usuario");
                
                jTextField_Nombre.setText(rs.getString("nombre_usuario"));
                jTextField_username.setText(rs.getString("username"));
                
                jComboBox_estado.setSelectedItem(rs.getString("estado"));
                jComboBox_permios.setSelectedItem(rs.getString("nivel"));
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al cargar el usuario" + e);
            JOptionPane.showMessageDialog(null, "¡¡Error al cargar!!, contacte al administrador.");
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

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_permisos = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jLabel_permisos1 = new javax.swing.JLabel();
        jComboBox_permios = new javax.swing.JComboBox<>();
        jButton_ActualizarU = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fondoInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Información del usuario");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Username");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        jLabel_permisos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_permisos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_permisos.setText("Estado:");
        getContentPane().add(jLabel_permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));
        getContentPane().add(jTextField_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 160, -1));
        getContentPane().add(jTextField_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Nombre:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jComboBox_estado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_estadoItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 80, -1));

        jLabel_permisos1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_permisos1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_permisos1.setText("Permiso de:");
        getContentPane().add(jLabel_permisos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jComboBox_permios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Auxiliar" }));
        jComboBox_permios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_permiosItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox_permios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, -1));

        jButton_ActualizarU.setText("Actualizar Usuario");
        jButton_ActualizarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarUActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarU, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 160, -1));

        jButton2.setText("Actualizar password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 160, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creado por el equipo 6  ®");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        fondoInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondoINfo.jpg"))); // NOI18N
        getContentPane().add(fondoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_estadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_estadoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_estadoItemStateChanged

    private void jComboBox_permiosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_permiosItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_permiosItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        Restaura_pass restaurarPass = new Restaura_pass();
        restaurarPass.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton_ActualizarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarUActionPerformed

        int status_cm, nivel_cm, control = 0;
        String nombre, usuario, password, nivel ="", estado = "";
        
        
        nombre = jTextField_Nombre.getText().trim();
        usuario = jTextField_username.getText().trim();
        status_cm = jComboBox_estado.getSelectedIndex() +1;
        nivel_cm = jComboBox_permios.getSelectedIndex() +1;
       
        if (nombre.equals("")) {
            jTextField_Nombre.setBackground(Color.ORANGE);
            control++;
        } else if (usuario.equals("")) {
            jTextField_username.setBackground(Color.ORANGE);
            control++;
        }
        if (control == 0) {
            
            if(nivel_cm == 1){
                nivel = "Administrador";
            }else if (nivel_cm == 2) {
                nivel = "Auxiiar";
            }
            
            if(status_cm == 1){
                estado = "Activo";
            }else if (status_cm == 2){
                estado = "Inactivo";
            }
                           
            try {
                
                  Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                "select username from usuarios where username = '" + usuario + "' and not id_usuario = '" 
                + ID + "'");
                
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");
                    jTextField_username.setBackground(Color.ORANGE);
                    cn.close();
                    
                }else {
                    
                Connection cn2 = conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                "update usuarios set nombre_usuario=?, username=?, nivel=?, estado=? " 
                + "where id_usuario = '" + ID + "'");
                
                pst2.setString(1,nombre);
                pst2.setString(2,usuario);
                pst2.setString(3,nivel);
                pst2.setString(4,estado);
                
               pst2.executeUpdate();
               cn2.close();
               
               
               JOptionPane.showMessageDialog(null,"Actualizacion de usuario exitosa.");
               jTextField_Nombre.setBackground(Color.GREEN);
               jTextField_username.setBackground(Color.GREEN);
               
            }
                
                
                
            } catch (SQLException e) {
                System.out.println("Error al Actualizar" + e);
                
            }
        
        }else{
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
        
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ActualizarUActionPerformed

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
            java.util.logging.Logger.getLogger(informacionUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacionUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacionUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacionUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacionUsu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoInfo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_ActualizarU;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JComboBox<String> jComboBox_permios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_permisos;
    private javax.swing.JLabel jLabel_permisos1;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JTextField jTextField_Nombre;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
