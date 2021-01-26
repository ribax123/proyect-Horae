package windows;

import java.sql.Connection;
import clases.conexion;
import clases.Datos;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Buscar extends javax.swing.JPanel {

    public static String ids = "";
    public static String descri = "";
    public static String unidads = "";
    public static String tips = "";
    public static String fechs = "";
    public static String autors = "";
    public static Datos fecha1;
    public static String dia = "";
    public static String estado = "";
    public static String origen = "";

    DefaultTableModel model = new DefaultTableModel();

    public Buscar() {
        initComponents();
        fecha1 = new Datos();
        addFecha.setText(fecha1.fechaActual());

        todaConexion();
    }
// metodo para llenar una tabla

    public void todaConexion() {
        model.setRowCount(0);
        model.setColumnCount(0);
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select resgistro, id, usuario, fecha from actualizacion_inventario");

            ResultSet rs = pst.executeQuery();

            tabla_actualizaciones = new JTable(model);
            jScrollPane1.setViewportView(tabla_actualizaciones);

            model.addColumn("Registro");
            model.addColumn("Id");
            model.addColumn("Usuario");
            model.addColumn("Fecha");

            // ciclo para llenar la tabla
            /* cuando hay una solicitud  para generar 
            la lista, se crea un ciclo con un objeto...
             se crea un nuevo ciclo para iterar cada una
             de las posiciones e insertar cada uno de los datos en las 
            posiciones de las filas*/
            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addFecha = new javax.swing.JLabel();
        jText_ID = new javax.swing.JTextField();
        buscarID = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_actualizaciones = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_actu = new javax.swing.JButton();
        version = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(0, 51, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addFecha.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addFecha.setForeground(new java.awt.Color(255, 255, 255));
        addFecha.setText("fecha");
        add(addFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 13, -1, 20));

        jText_ID.setBackground(new java.awt.Color(0, 51, 102));
        jText_ID.setForeground(new java.awt.Color(255, 255, 255));
        jText_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jText_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_IDActionPerformed(evt);
            }
        });
        add(jText_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 120, 23));

        buscarID.setBackground(new java.awt.Color(0, 51, 102));
        buscarID.setForeground(new java.awt.Color(255, 255, 255));
        buscarID.setText("Gestionar producto");
        buscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarIDActionPerformed(evt);
            }
        });
        add(buscarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 200, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Novedades");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar actualización");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 220, -1));

        tabla_actualizaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_actualizaciones);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 320, 100));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Creado por ribax123@gmail.com ®");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 200, -1));

        btn_actu.setText("Actualizar");
        btn_actu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actuActionPerformed(evt);
            }
        });
        add(btn_actu, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Version 1.0");
        add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarIDActionPerformed

        ids = jText_ID.getText().trim();
        Datos mensaID = new Datos();
        boolean val = mensaID.validacion(ids);
        int control = 0;

        if (!ids.equals("")) {

            if (val != true) {
                JOptionPane.showMessageDialog(null, "Solo puedes ingresar valores numericos.");
                control++;
            }

            if (control == 0) {

                try {
                    Connection cn = conexion.conectar();
                    PreparedStatement ps = cn.prepareStatement("select * from inventario where Id =?");
                    ps.setString(1, ids);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {

                        ids = rs.getString("Id");
                        descri = rs.getString("Descripcion");
                        unidads = rs.getString("Unidades");
                        estado = rs.getString("Estado");
                        origen= rs.getString("Origen");
                        fechs = rs.getString("Fecha");
                        autors = rs.getString("Autor");

                        resultado_Id resusltado = new resultado_Id();
                        resusltado.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "El ID no existe");
                    }

                } catch (Exception e) {
                    System.out.println("Error al conectarse al servidor " + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El ID no puede estar vacio.");
            jText_ID.setBackground(Color.ORANGE);
        }

    }//GEN-LAST:event_buscarIDActionPerformed

    private void jText_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_IDActionPerformed

    }//GEN-LAST:event_jText_IDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ids = jText_ID.getText().trim();
        Datos mensaID = new Datos();
        boolean val = mensaID.validacion(ids);
        int control = 0;

        if (!ids.equals("")) {
            if (val != true) {
                JOptionPane.showMessageDialog(null, "Solo puedes ingresar valores numericos.");
                control++;
            }

            if (control == 0) {

                model.setRowCount(0);
                model.setColumnCount(0);

                try {

                    Connection cn1 = conexion.conectar();
                    PreparedStatement pst1 = cn1.prepareStatement(
                            "select id from actualizacion_inventario where id = '" + ids + "'");

                    ResultSet rs1 = pst1.executeQuery();

                    if (!rs1.next()) {
                        JOptionPane.showMessageDialog(null, "El registro no ha sido actualizado");
                        todaConexion();

                    } else {
                        cn1.close();

                        try {

                            Connection cn = conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement(
                                    "select resgistro, id, usuario, fecha from actualizacion_inventario where id = '" + ids + "'");

                            ResultSet rs = pst.executeQuery();

                            tabla_actualizaciones = new JTable(model);
                            jScrollPane1.setViewportView(tabla_actualizaciones);

                            model.addColumn("Registro");
                            model.addColumn("Id");
                            model.addColumn("Usuario");
                            model.addColumn("Fecha");

                            while (rs.next()) {
                                Object[] fila = new Object[4];

                                for (int i = 0; i < 4; i++) {
                                    fila[i] = rs.getObject(i + 1);
                                }
                                model.addRow(fila);
                            }

                        } catch (SQLException e) {
                            System.err.print("Error al llenar la tabla" + e);
                            JOptionPane.showMessageDialog(null, "Error al mostrar imformacion, ¡Contacte al administrador!");
                        }
                    }
                } catch (Exception e) {
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El ID no puede estar vacio.");
            jText_ID.setBackground(Color.ORANGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_actuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actuActionPerformed
        todaConexion();
    }//GEN-LAST:event_btn_actuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addFecha;
    private javax.swing.JButton btn_actu;
    private javax.swing.JButton buscarID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jText_ID;
    private javax.swing.JTable tabla_actualizaciones;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables

}
