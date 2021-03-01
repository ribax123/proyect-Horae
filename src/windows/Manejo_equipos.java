/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import clases.Datos;
import clases.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Manejo_equipos extends javax.swing.JFrame {

    int total;

    String validarD;
    String valor;
    String nombreCliente;
    String descripcion;
    String funcion;
    String fecha;
    String serial;
    String user;
    String cantidad;
    String responsable;
    String valorTabla;
    String referenciaTabla;

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelt = new DefaultTableModel();

    public Manejo_equipos() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);

        Datos datos = new Datos();
        fecha = datos.fechaActual();
        txt_fecha.setText(fecha);

        tablaCargo();
        tablaEquipos();

    }

    public void tablaEquipos() {

        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Descripcion, Referencia from inventario");

            ResultSet rs = pst.executeQuery();

            jtable_equipos = new JTable(model);
            jScrollPane2.setViewportView(jtable_equipos);

            model.addColumn("Descripción");
            model.addColumn("Referencia");

            // ciclo para llenar la tabla
            /* cuando hay una solicitud  para generar 
            la lista, se crea un ciclo con un objeto...
             se crea un nuevo ciclo para iterar cada una
             de las posiciones e insertar cada uno de los datos en las 
            posiciones de las filas*/
            while (rs.next()) {
                Object[] fila = new Object[2];

                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar imformacion, ¡Contacte al administrador!");
        }
    }

    public void tablaCargo() {

        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Codigo, Nombre,  Cargo from Colaboradores");

            ResultSet rs = pst.executeQuery();

            jtable_equipos1 = new JTable(modelt);
            jScrollPane4.setViewportView(jtable_equipos1);

            modelt.addColumn("Codigo");
            modelt.addColumn("Nombre");
            modelt.addColumn("Cargo");

            // ciclo para llenar la tabla
            /* cuando hay una solicitud  para generar 
            la lista, se crea un ciclo con un objeto...
             se crea un nuevo ciclo para iterar cada una
             de las posiciones e insertar cada uno de los datos en las 
            posiciones de las filas*/
            while (rs.next()) {
                Object[] fila = new Object[3];

                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelt.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar imformación, ¡Contacte al administrador!");
        }
    }

    public void seleccionEquipo() {
        int filasSleccionada = jtable_equipos.getSelectedRow();
        String seleccionar;

        seleccionar = jtable_equipos.getValueAt(filasSleccionada, 0).toString();
        txt_descripcion.setText(seleccionar);

    }

    public void seleccionColaborador() {
        int filasSleccionada = jtable_equipos1.getSelectedRow();
        String seleccionar;

        seleccionar = jtable_equipos1.getValueAt(filasSleccionada, 1).toString();
        txt_colaborador.setText(seleccionar);

    }

    public void ManejoEquipos() {
        initComponents();

        Datos datos = new Datos();
        fecha = datos.fechaActual();
        txt_fecha.setText(fecha);
    }

    public void obtenerDatos() {
        nombreCliente = txt_cliente.getText().trim();
        serial = txt_serial.getText().trim();
        descripcion = txt_descripcion.getText().trim();
        funcion = cmb_fun.getSelectedItem().toString();
        cantidad = txt_cantidad.getText().trim();
        responsable = txt_colaborador.getText().trim();

    }

   
    public void descontar() {

        try {

            int filasSleccionada = jtable_equipos.getSelectedRow();
            referenciaTabla = jtable_equipos.getValueAt(filasSleccionada, 1).toString();
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select Unidades from inventario where referencia =?");
            ps.setString(1, referenciaTabla);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                valorTabla = rs.getString("Unidades");
                System.out.println(valorTabla);

            } else {

                System.out.println("no hay valor" + valorTabla);

            }

        } catch (Exception e) {
            System.out.println("Error al conectarse al servidor " + e);
        }

        //aumenta o disminuye la cantidad en el stock
        try {

            int valorTablaTotal;

            int valorCambio;
            valor = txt_cantidad.getText().trim();
            valorCambio = Integer.parseInt(valor);
            valorTablaTotal = Integer.parseInt(valorTabla);
            total = valorTablaTotal - valorCambio;
            System.out.println(total);

            if (total < 1) {

                JOptionPane.showMessageDialog(null, "Cantidad fuera de rango");

            } else {

                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("UPDATE inventario SET Unidades =  '" + total + "' WHERE Referencia = '" + referenciaTabla + "'");

                pst.executeUpdate();
               guardarDatos();
            }

        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }

    public void guardarDatos() {
        obtenerDatos();

        try {

            Connection cn2 = conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    " insert into control_equipos values (?,?,?,?,?,?,?)");

            pst2.setString(1, nombreCliente);
            pst2.setString(2, serial);
            pst2.setString(3, descripcion);
            pst2.setString(4, cantidad);
            pst2.setString(5, responsable);
            pst2.setString(6, funcion);
            pst2.setString(7, fecha);

            pst2.executeUpdate();
            cn2.close();
            JOptionPane.showMessageDialog(null, "Exito al guardar");
        } catch (SQLException e) {
            System.err.println("ERROR al guardar el registro" + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_serial = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_cliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        accion = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmb_fun = new javax.swing.JComboBox<>();
        btn_elegir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_equipos = new javax.swing.JTable();
        btn_guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtable_equipos1 = new javax.swing.JTable();
        btn_elegirC = new javax.swing.JButton();
        txt_colaborador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_serial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel1.add(txt_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 310, 30));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_descripcion.setForeground(new java.awt.Color(255, 255, 255));
        txt_descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 500, 290, 30));

        txt_cliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel1.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 310, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Serial-S/N :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, 30));

        accion.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        accion.setForeground(new java.awt.Color(255, 255, 255));
        accion.setText("Función :");
        jPanel1.add(accion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, -1, 30));

        txt_fecha.setBackground(new java.awt.Color(255, 255, 255));
        txt_fecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha.setText("Fecha");
        jPanel1.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre cliente :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 30));

        cmb_fun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Instalación", "Migración", "Traslado", "Devolución", "Retiro", "Cambio\t" }));
        cmb_fun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_funActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 150, 30));

        btn_elegir.setText("Seleccionar equipo");
        btn_elegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elegirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_elegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 190, 30));

        jtable_equipos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtable_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtable_equipos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 490, 280));

        btn_guardar.setText("Guardar Registro");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 440, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gestión de equipos.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 50, 40));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 50, 40));

        jtable_equipos1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtable_equipos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jtable_equipos1);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 490, 280));

        btn_elegirC.setText("Seleccionar responsable");
        btn_elegirC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elegirCActionPerformed(evt);
            }
        });
        jPanel1.add(btn_elegirC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 190, 30));

        txt_colaborador.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_colaborador.setForeground(new java.awt.Color(255, 255, 255));
        txt_colaborador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_colaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 290, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 30));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel1.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 310, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_elegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegirActionPerformed
        seleccionEquipo();
    }//GEN-LAST:event_btn_elegirActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        boolean validarCantidad;
        Datos data = new Datos();
        validarCantidad = data.validacion(txt_cantidad.getText());
        if (!txt_cantidad.getText().equals("")
                || !txt_cliente.getText().equals("") || !txt_colaborador.getText().equals("")
                || !txt_descripcion.getText().equals("") || !txt_serial.getText().equals("")) {
            if (validarCantidad == true) {
                
                descontar();

            } else {
                JOptionPane.showMessageDialog(null, "El campo CANTIDAD no es valido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_elegirCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegirCActionPerformed
        seleccionColaborador();
    }//GEN-LAST:event_btn_elegirCActionPerformed

    private void cmb_funActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_funActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_funActionPerformed

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
            java.util.logging.Logger.getLogger(Manejo_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manejo_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manejo_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manejo_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manejo_equipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accion;
    private javax.swing.JButton btn_elegir;
    private javax.swing.JButton btn_elegirC;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cmb_fun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtable_equipos;
    private javax.swing.JTable jtable_equipos1;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_colaborador;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JLabel txt_fecha;
    private javax.swing.JTextField txt_serial;
    // End of variables declaration//GEN-END:variables
}
