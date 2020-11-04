/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import clases.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabia_000
 */
public class Stock extends javax.swing.JPanel {

    String user;
    public static String user_Update = "";
    DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form Stock
     */
    public Stock() {
        initComponents();
        user = Interfaz.user;
        
         // conexión a la base de datos e instrucciones CONSULTAS
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Id, Descripcion, Unidades, Tipo, Fecha, Autor from inventario");

            ResultSet rs = pst.executeQuery();

            jTable_product = new JTable(model);
            jScrollPane1.setViewportView(jTable_product );

            model.addColumn("Id");
            model.addColumn("Descripcion");
            model.addColumn("Unidades");
            model.addColumn("Tipo");
            model.addColumn("Fecha");
            model.addColumn("Autor");

            // ciclo para llenar la tabla
            /* cuando hay una solicitud  para generar 
            la lista, se crea un ciclo con un objeto...
             se crea un nuevo ciclo para iterar cada una
             de las posiciones e insertar cada uno de los datos en las 
            posiciones de las filas*/
            while (rs.next()) {
                Object[] fila = new Object[6];

                for (int i = 0; i < 6; i++) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_product = new javax.swing.JTable();
        CREADO = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 0, 51));
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 640, 300));

        CREADO.setForeground(new java.awt.Color(255, 255, 255));
        CREADO.setText("Creado por el equipo 6  ®");
        add(CREADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inventario en Stock");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sTOCK.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 430));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CREADO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_product;
    // End of variables declaration//GEN-END:variables
}
