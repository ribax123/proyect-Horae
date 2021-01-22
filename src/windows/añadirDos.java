package windows;

import clases.conexion;
import clases.Datos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class añadirDos extends javax.swing.JPanel {

    String user;
    String fecha;
    String envio;
    

    public añadirDos() {
        initComponents();
        txtExito.setVisible(false);
        Datos mensajero = new Datos();
        user = Interfaz.user;
        Datos fh = new Datos();
        fecha = fh.fechaActual();
    }
    
     Timer timer = new Timer (4000, new ActionListener ()
{
    public void actionPerformed(ActionEvent e)
    {
        txtExito.setVisible(false);
     }
});

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bton_agregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        añadirDes1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        añadirUnidad = new javax.swing.JTextField();
        txtExito = new javax.swing.JLabel();
        txt_Envio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bton_agregar.setBackground(new java.awt.Color(0, 51, 102));
        bton_agregar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        bton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        bton_agregar.setText("Guardar registro");
        bton_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_agregarActionPerformed(evt);
            }
        });
        add(bton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 530, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Agregar al inventario");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 340, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creado por ribax123@gmail.com ®");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, -1, -1));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 510, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modelo :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        txtReferencia.setBackground(new java.awt.Color(0, 51, 102));
        txtReferencia.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtReferencia.setForeground(new java.awt.Color(255, 255, 255));
        txtReferencia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 480, 30));

        añadirDes1.setBackground(new java.awt.Color(0, 51, 102));
        añadirDes1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        añadirDes1.setForeground(new java.awt.Color(255, 255, 255));
        añadirDes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        añadirDes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirDes1ActionPerformed(evt);
            }
        });
        jPanel1.add(añadirDes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 480, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Unidades :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        añadirUnidad.setBackground(new java.awt.Color(0, 51, 102));
        añadirUnidad.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        añadirUnidad.setForeground(new java.awt.Color(255, 255, 255));
        añadirUnidad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(añadirUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 60, 30));

        txtExito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtExito.setForeground(new java.awt.Color(255, 255, 255));
        txtExito.setText("Registro exitoso!");
        jPanel1.add(txtExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        txt_Envio.setBackground(new java.awt.Color(0, 51, 102));
        txt_Envio.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txt_Envio.setForeground(new java.awt.Color(255, 255, 255));
        txt_Envio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_Envio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 480, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quien lo envia :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 970, 340));
    }// </editor-fold>//GEN-END:initComponents

    private void bton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bton_agregarActionPerformed

        String tipo_cmb;
        int validacion = 0;
        String descripcion, unidades, referencia, tipo_string = "";
        Datos mesajeroDos = new Datos();

        // definir variables
        referencia = txtReferencia.getText().trim();
        descripcion = añadirDes1.getText().trim();
        unidades = añadirUnidad.getText().trim();
        envio = txt_Envio.getText().trim();

        boolean vali = mesajeroDos.validacion(unidades);
        boolean val = mesajeroDos.validacion(descripcion, 0);

        if (!descripcion.equals("") || !unidades.equals("") || !referencia.equals("")) {

            if (val == false) {
                JOptionPane.showMessageDialog(null, "El nombre debe  contener carateres alfabeticos y minimo 10 letras");
                validacion++;

            } else if (vali == false) {
                añadirUnidad.setBackground(Color.orange);
                JOptionPane.showMessageDialog(null, "Unidades solo admite caracteres numericos.");
                validacion++;
                
            }

            //seleccion del comboBox
           

            if (validacion == 0) {
                try {
                    Connection cn2 = conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            " insert into inventario values (?,?,?,?,?,?,?)");

                    pst2.setInt(1, 0);
                    pst2.setString(2, referencia);
                    pst2.setString(3, descripcion);
                    pst2.setString(4, unidades);
                    pst2.setString(5, envio);
                    pst2.setString(6, fecha);
                    pst2.setString(7, user);

                    pst2.executeUpdate();
                    cn2.close();

                    añadirDes1.setBackground(Color.CYAN);
                    añadirUnidad.setBackground(Color.CYAN);
                    txtReferencia.setBackground(Color.CYAN);
                    txtExito.setVisible(true);
                    timer.start();
                    timer.setRepeats(false);

                    añadirDes1.setText("");
                    añadirUnidad.setText("");
                    txtReferencia.setText("");

                } catch (SQLException e) {
                    System.err.println("ERROR al registrar el producto" + e);
                    JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            añadirDes1.setBackground(Color.orange);
            añadirUnidad.setBackground(Color.orange);
            validacion++;

        }
       


    }//GEN-LAST:event_bton_agregarActionPerformed

    private void añadirDes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirDes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_añadirDes1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField añadirDes1;
    private javax.swing.JTextField añadirUnidad;
    private javax.swing.JButton bton_agregar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtExito;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txt_Envio;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
