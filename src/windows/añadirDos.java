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
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        añadirDes1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        añadirUnidad = new javax.swing.JTextField();
        txtExito = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bton_agregar.setBackground(new java.awt.Color(0, 51, 102));
        bton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        bton_agregar.setText("Guardar registro");
        bton_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_agregarActionPerformed(evt);
            }
        });
        add(bton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registrar Artículo");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 280, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creado por ribax123@gmail.com ®");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxTipo.setBackground(new java.awt.Color(0, 51, 153));
        cbxTipo.setForeground(new java.awt.Color(255, 255, 255));
        cbxTipo.setMaximumRowCount(10);
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Movil", "Accesorio", " " }));
        cbxTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Referencia :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        txtReferencia.setBackground(new java.awt.Color(0, 51, 102));
        txtReferencia.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtReferencia.setForeground(new java.awt.Color(255, 255, 255));
        txtReferencia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 180, 27));

        añadirDes1.setBackground(new java.awt.Color(0, 51, 102));
        añadirDes1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        añadirDes1.setForeground(new java.awt.Color(255, 255, 255));
        añadirDes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        añadirDes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirDes1ActionPerformed(evt);
            }
        });
        jPanel1.add(añadirDes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 180, 27));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Unidades :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        añadirUnidad.setBackground(new java.awt.Color(0, 51, 102));
        añadirUnidad.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        añadirUnidad.setForeground(new java.awt.Color(255, 255, 255));
        añadirUnidad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(añadirUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 180, 27));

        txtExito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtExito.setForeground(new java.awt.Color(0, 255, 0));
        txtExito.setText("Registro exitoso!");
        jPanel1.add(txtExito, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 510, 250));
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

        boolean vali = mesajeroDos.validacion(unidades);
        boolean val = mesajeroDos.validacion(descripcion, 0);

        tipo_cmb = cbxTipo.getSelectedItem().toString();

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
                    pst2.setString(5, tipo_cmb);
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

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField añadirDes1;
    private javax.swing.JTextField añadirUnidad;
    private javax.swing.JButton bton_agregar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtExito;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
