package windows;


import clases.conexion;
import clases.Datos;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;



public class Agregar_Instalaciones extends javax.swing.JFrame {
    

    String responsable;
    String user;
    String fecha;
    String cliente;
    String direccion;
    String telefono;
    String tipo;
    String barrio;
    

    public Agregar_Instalaciones() {
        initComponents();
        Datos datos = new Datos();
        fecha = datos.fechaActual();
        lbl_Fecha.setText(fecha);
        user = Interfaz.user;
        responsable = Interfaz.user;
        lb_Nombre.setText(responsable);

        setResizable(false);
        setLocationRelativeTo(this);
       
        

    }
    
    public void obtenerDatos(){
        direccion = txt_Direccion.getText();
        cliente = txt_Cliente.getText();
        barrio = txt_Barrio.getText();
        fecha = lbl_Fecha.getText();
        telefono = txt_Telefono.getText();
        tipo = cbx_tipo.getSelectedItem().toString();
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
        jButton1 = new javax.swing.JButton();
        txt_Telefono = new javax.swing.JTextField();
        txt_Direccion = new javax.swing.JTextField();
        txt_Barrio = new javax.swing.JTextField();
        txt_Cliente = new javax.swing.JTextField();
        Btn_add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        cbx_tipo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_Fecha = new javax.swing.JLabel();
        lb_Nombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 50, 40));

        txt_Telefono.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_Telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 250, 30));

        txt_Direccion.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_Direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 250, 30));

        txt_Barrio.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_Barrio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_Barrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 250, 30));

        txt_Cliente.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_Cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 250, 30));

        Btn_add.setBackground(new java.awt.Color(0, 51, 102));
        Btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/120-diskette.png"))); // NOI18N
        Btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 130, 120));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos de lnstalación");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 30));

        jLabel_Nombre3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Tipo de instalación :");
        jPanel1.add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        cbx_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gpon", "Cableado UTP", "Antena", " ", " " }));
        cbx_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbx_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 170, 30));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Creado por ribax@gimail.com ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, -1, -1));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        jPanel1.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, -1, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Dirección :");
        jPanel1.add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, 30));

        jLabel_Nombre2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Barrio :");
        jPanel1.add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, 30));

        jLabel_Nombre4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Nombre  del Cliente:");
        jPanel1.add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 30));

        jLabel_Nombre5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Telefono :");
        jPanel1.add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, 30));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Fecha.setText("fecha");
        jPanel2.add(lbl_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lb_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lb_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        lb_Nombre.setText("Nombre");
        jPanel2.add(lb_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 180, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 507));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_tipoActionPerformed

    private void Btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addActionPerformed

        // tipo Variables para los campos "agregar usuarios"
        int  validacion = 0;
        String nombre, cargo;
        obtenerDatos();
        

        // definir variables
        nombre = txt_Cliente.getText().trim();
        
        cargo = cbx_tipo.getSelectedItem().toString();
        Datos mensAdd = new Datos();
        boolean val = mensAdd.validacion(nombre, 0);
        

        if (!nombre.equals("")||!txt_Direccion.getText().equals("")||!txt_Telefono.getText().equals("")) {

            
            if(val == false){
                JOptionPane.showMessageDialog(null, "El nombre debe  contener carateres alfabeticos y minimo 10 letras");
                
            }
                        
            
            


            if (validacion == 0) {
                

                        // Ingresar nuevos colaboradore a la base de datos
                        if (validacion == 0) {
                            try {
                                Connection cn2 = conexion.conectar();
                                // instrucciones colsultas
                                PreparedStatement pst2 = cn2.prepareStatement(
                                        " insert into tabla_instalaciones values (?,?,?,?,?,?)");

                                pst2.setString(1, cliente);
                                pst2.setString(2, direccion);
                                pst2.setString(3, barrio);
                                pst2.setString(4, tipo);
                                pst2.setString(5, telefono);
                                pst2.setString(6, fecha);
                                

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

                    
           
            } 

            }else {
                JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios");
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
            java.util.logging.Logger.getLogger(Agregar_Instalaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_Instalaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_Instalaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_Instalaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_Instalaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_add;
    private javax.swing.JComboBox<String> cbx_tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_Nombre;
    private javax.swing.JLabel lbl_Fecha;
    private javax.swing.JTextField txt_Barrio;
    private javax.swing.JTextField txt_Cliente;
    private javax.swing.JTextField txt_Direccion;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_Telefono.setText("");
        txt_Barrio.setText("");
        txt_Direccion.setText("");
        cbx_tipo.setSelectedIndex(0);
        txt_Cliente.setText("");
        
     
        
        
        
    }

}
