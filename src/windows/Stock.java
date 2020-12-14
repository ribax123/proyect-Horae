package windows;

import clases.conexion;
import clases.documen;
import clases.type;
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

    public Stock() {
        initComponents();
        user = Interfaz.user;

        // conexión a la base de datos e instrucciones CONSULTAS llenar tabla
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Id, Referencia, Descripcion, Unidades, Tipo, Fecha, Autor from inventario");

            ResultSet rs = pst.executeQuery();

            jTable_product = new JTable(model);
            jScrollPane1.setViewportView(jTable_product);

            model.addColumn("Id");
            model.addColumn("Referencia");
            model.addColumn("Descripcion");
            model.addColumn("Unidades");
            model.addColumn("Tipo");
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
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buscarTipo = new javax.swing.JButton();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_pdf = new javax.swing.JButton();

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 640, 240));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inventario en Stock");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 350, 10));

        buscarTipo.setText("Actulizar");
        buscarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTipoActionPerformed(evt);
            }
        });
        add(buscarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Movil", "PC", "Cargador", "Audifonos", "Consola", "Reloj", "TV", " " }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, 32));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creado por ribax123@gmail.com ®");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        btn_pdf.setText("Crear Documento");
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });
        add(btn_pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTipoActionPerformed

        String Selecion = comboTipo.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn1 = conexion.conectar();

            if (Selecion.equals("Todos")) {
                query = "select Id, Referencia, Descripcion, Unidades, Tipo, Fecha, Autor from inventario";
            } else {
                query = "select Id, Referencia, Descripcion, Unidades, Tipo, Fecha, Autor from inventario where Tipo = '" + Selecion + "'";
            }
            PreparedStatement ps1 = cn1.prepareStatement(query);
            ResultSet rs = ps1.executeQuery();

            jTable_product = new JTable(model);
            jScrollPane1.setViewportView(jTable_product);

            model.addColumn("Id");
            model.addColumn("Referencia");
            model.addColumn("Descripcion");
            model.addColumn("Unidades");
            model.addColumn("Tipo");
            model.addColumn("Fecha");
            model.addColumn("Autor");

            while (rs.next()) {
                Object[] fila = new Object[6];

                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn1.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla TIPO" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar imformacion, ¡Contacte al administrador! TIPO");
        }
    }//GEN-LAST:event_buscarTipoActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed

        documen doc = new type();
        doc.pdfReport();

    }//GEN-LAST:event_btn_pdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pdf;
    private javax.swing.JButton buscarTipo;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_product;
    // End of variables declaration//GEN-END:variables

}
