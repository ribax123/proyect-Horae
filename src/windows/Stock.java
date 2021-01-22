package windows;

import clases.conexion;
import clases.Functions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Stock extends javax.swing.JPanel {

    String user;
    String tipo;
    public static int user_Update = 0;
    public DefaultTableModel model = new DefaultTableModel();

    public Stock() {
        initComponents();
        user = Interfaz.user;

    }

    public void llenarStock() {
        model.setRowCount(0);
        model.setColumnCount(0);
// conexión a la base de datos e instrucciones CONSULTAS llenar tabla
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Id, Referencia, Descripcion, Unidades, Origen, Fecha, Autor from inventario");

            ResultSet rs = pst.executeQuery();

            jTable_product = new JTable(model);
            jScrollPane1.setViewportView(jTable_product);

            model.addColumn("Id");
            model.addColumn("Referencia");
            model.addColumn("Descripcion");
            model.addColumn("Unidades");
            model.addColumn("Origen");
            
            model.addColumn("Fecha");
            model.addColumn("Autor");

            while (rs.next()) {
                Object[] fila = new Object[7];

                for (int i = 0; i < 7; i++) {
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 970, 310));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 530, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inventario en Stock");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 350, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

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
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 210, 27));

        bton_borrar.setBackground(new java.awt.Color(0, 51, 102));
        bton_borrar.setForeground(new java.awt.Color(255, 255, 255));
        bton_borrar.setText("Eliminar");
        bton_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_borrarActionPerformed(evt);
            }
        });
        add(bton_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 210, -1));
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
   

    }//GEN-LAST:event_bton_borrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bton_borrar;
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
