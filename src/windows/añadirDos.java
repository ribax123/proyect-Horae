package windows;

import clases.conexion;
import clases.other;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class añadirDos extends javax.swing.JPanel {

    String user;
    String fecha;

    public añadirDos() {
        initComponents();
        other mensajero = new other();
        user = Interfaz.user;
        other fh = new other();
        fecha = fh.fechaActual();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bton_agregar = new javax.swing.JButton();
        cbxTipo = new javax.swing.JComboBox<>();
        añadirUnidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        añadirDes1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bton_agregar.setBackground(new java.awt.Color(0, 51, 102));
        bton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        bton_agregar.setText("Guardar registro");
        bton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_agregarActionPerformed(evt);
            }
        });
        add(bton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 150, -1));

        cbxTipo.setBackground(new java.awt.Color(0, 51, 153));
        cbxTipo.setForeground(new java.awt.Color(255, 255, 255));
        cbxTipo.setMaximumRowCount(10);
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pc", "Movil", "Cargador", "Audifonos", "Reloj", "TV", "Consola" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });
        add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        añadirUnidad.setBackground(new java.awt.Color(0, 51, 102));
        añadirUnidad.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        añadirUnidad.setForeground(new java.awt.Color(255, 255, 255));
        añadirUnidad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        add(añadirUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 180, 27));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Unidades :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registrar producto");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 300, -1));

        añadirDes1.setBackground(new java.awt.Color(0, 51, 102));
        añadirDes1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        añadirDes1.setForeground(new java.awt.Color(255, 255, 255));
        añadirDes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        añadirDes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirDes1ActionPerformed(evt);
            }
        });
        add(añadirDes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 180, 27));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creado por ribax123@gmail.com ®");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        txtReferencia.setBackground(new java.awt.Color(0, 51, 102));
        txtReferencia.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtReferencia.setForeground(new java.awt.Color(255, 255, 255));
        txtReferencia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        add(txtReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 180, 27));

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Referencia :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void bton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bton_agregarActionPerformed

        int tipo_cmb, validacion = 0;
        String descripcion, unidades, referencia, tipo_string = "";
        other mesajeroDos = new other();

        // definir variables
        referencia = txtReferencia.getText().trim();
        descripcion = añadirDes1.getText().trim();
        unidades = añadirUnidad.getText().trim();
        
        boolean vali = mesajeroDos.validacion(unidades);
        boolean val = mesajeroDos.validacion(descripcion, 0);

        tipo_cmb = cbxTipo.getSelectedIndex() + 1;

        if (!descripcion.equals("") || !unidades.equals("") || !referencia.equals("")) {

            if (val == false) {
                JOptionPane.showMessageDialog(null, "El nombre debe  contener carateres alfabeticos y minimo 10 letras");
                validacion++;
            

        } else if (vali != true) {
            añadirUnidad.setBackground(Color.orange);
            validacion++;
            JOptionPane.showMessageDialog(null, "Unidades solo admite caracteres numericos.");
        }

        //seleccion del comboBox
        if (tipo_cmb == 1) {
            tipo_string = "PC";
        } else if (tipo_cmb == 2) {
            tipo_string = "Movil";
        } else if (tipo_cmb == 3) {
            tipo_string = "Cargador";
        } else if (tipo_cmb == 4) {
            tipo_string = "Audifonos";
        } else if (tipo_cmb == 5) {
            tipo_string = "Reloj";
        } else if (tipo_cmb == 6) {
            tipo_string = "TV";
        } else if (tipo_cmb == 7) {
            tipo_string = "Consola";
        }

        if (validacion == 0) {
            try {
                Connection cn2 = conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        " insert into inventario values (?,?,?,?,?,?,?)");

                pst2.setInt(1, 0);
                pst2.setString(2,referencia);
                pst2.setString(3, descripcion);
                pst2.setString(4, unidades);
                pst2.setString(5, tipo_string);
                pst2.setString(6, fecha);
                pst2.setString(7, user);

                pst2.executeUpdate();
                cn2.close();

                añadirDes1.setBackground(Color.green);
                añadirUnidad.setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Registro exitoso");

                añadirDes1.setText("");
                añadirUnidad.setText("");

            } catch (SQLException e) {
                System.err.println("ERROR al registrar el producto" + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador");
            }
        }
    }

    
        else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        añadirDes1.setBackground(Color.orange);
        añadirUnidad.setBackground(Color.orange);
        validacion++;

    }


    }//GEN-LAST:event_bton_agregarActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void añadirDes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirDes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_añadirDes1ActionPerformed


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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtReferencia;
    // End of variables declaration//GEN-END:variables
}
