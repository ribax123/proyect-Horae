package windows;

import clases.Datos;
import clases.conexion;
import clases.Functions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Stock extends javax.swing.JPanel {

    String user;
    String tipo;
    public static int user_Update = 0;
    public DefaultTableModel model = new DefaultTableModel();
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

    public Stock() {
        initComponents();
        user = Interfaz.user;

    }

    public void llenarStock() {

        tablaInventario();

    }

    public void tablaInventario() {
        model.setRowCount(0);
        model.setColumnCount(0);
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Id, Referencia, Descripcion, Unidades, Origen,Estado, Fecha, Autor from inventario");

            ResultSet rs = pst.executeQuery();

            jTable_product = new JTable(model);
            jScrollPane1.setViewportView(jTable_product);

            model.addColumn("Id");
            model.addColumn("Referencia");
            model.addColumn("Descripcion");
            model.addColumn("Unidades");
            model.addColumn("Procedencia");
            model.addColumn("Estado");
            model.addColumn("Fecha");
            model.addColumn("Autor");

            while (rs.next()) {
                Object[] fila = new Object[8];

                for (int i = 0; i < 8; i++) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_product = new javax.swing.JTable();
        version = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        bton_borrar = new javax.swing.JButton();
        buscarID = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_product.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jTable_product.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_product.setGridColor(new java.awt.Color(153, 0, 0));
        jScrollPane1.setViewportView(jTable_product);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 970, 330));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 530, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inventario ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 290, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creado por ribax123@gmail.com ®");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 210, 27));

        bton_borrar.setBackground(new java.awt.Color(0, 51, 102));
        bton_borrar.setForeground(new java.awt.Color(255, 255, 255));
        bton_borrar.setText("Eliminar");
        bton_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_borrarActionPerformed(evt);
            }
        });
        add(bton_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 210, -1));

        buscarID.setBackground(new java.awt.Color(0, 51, 102));
        buscarID.setForeground(new java.awt.Color(255, 255, 255));
        buscarID.setText("Gestionar producto");
        buscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarIDActionPerformed(evt);
            }
        });
        add(buscarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 200, 25));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        Functions functions = new Functions();
        functions.buscar(txtBuscar.getText(), model, jTable_product, jScrollPane1,
                " select Id, Referencia, Descripcion, Unidades,Origen, Fecha, Autor from inventario"
                + " where Referencia like '%" + txtBuscar.getText() + "%' or Descripcion like '%" + txtBuscar.getText() + "%' or Fecha like '%" + txtBuscar.getText() + "%'");

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void bton_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bton_borrarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (resp == 0) {
            try {
                String datos;
                int filasSleccionada = jTable_product.getSelectedRow();
                datos = jTable_product.getValueAt(filasSleccionada, 0).toString();
                System.out.println(datos);
                Functions delete = new Functions();
                delete.delete("Id", "inventario", datos);
                tablaInventario();

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "¡Selecciona un registro!");
            }

        }

    }//GEN-LAST:event_bton_borrarActionPerformed

    private void buscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarIDActionPerformed

        String datos;
        int filasSleccionada = jTable_product.getSelectedRow();
        datos = jTable_product.getValueAt(filasSleccionada, 0).toString();
        System.out.println(datos);

        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select * from inventario where Id =?");
            ps.setString(1, datos);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ids = rs.getString("Id");
                descri = rs.getString("Descripcion");
                unidads = rs.getString("Unidades");
                estado = rs.getString("Estado");
                origen = rs.getString("Origen");
                fechs = rs.getString("Fecha");
                autors = rs.getString("Autor");

                resultado_Id resusltado = new resultado_Id();
                resusltado.setVisible(true);

            } else {

            }

        } catch (Exception e) {
            System.out.println("Error al conectarse al servidor " + e);
        }
    }//GEN-LAST:event_buscarIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bton_borrar;
    private javax.swing.JButton buscarID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_product;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables

}
