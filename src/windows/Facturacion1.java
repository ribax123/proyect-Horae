package windows;

import clases.conexion;
import clases.other;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JTable;

public class Facturacion1 extends javax.swing.JFrame {

    public static String nombreCliente;

    String user_updateDos = tablaProductos.user_UpdateDos;
    other datos;
    String user = "";
    String producto;
    String fecha = "";
    String cantidad = "";

    public static int total = 0;
    public static String cedula = "";
    public static String formaPa;
    public static String codigoFactura;
    public static String datosTotales;
    public static String datosUno;
    public static String datosDos;
    public static String datosTres;
    public static String vendedor = "";
    public static DefaultTableModel modelcinco = new DefaultTableModel();
    public static String conector = new String();
    public static String datosFac;
    public static String datosFacdos;
    public static String datosFactres;
    public static String[] datosIm;
    public static String todoo = new String();
   
    public static String direccion;
    public static String telefono;

    public Facturacion1() {
        initComponents();

        //txtVendedor.disable();
        txAreaComentarios.disable();
        
        setResizable(false);
        setLocationRelativeTo(this);
        setSize(690, 610);
        
        datos = new other();
        txtFecha.setText(datos.fechaActual());
        user = Interfaz.user;               
    }
    public void llenarFactura(JTable tabla) {
       
        try {
            int filasSleccionada = tabla.getSelectedRow();
            String datos = tabla.getValueAt(filasSleccionada, 0).toString();

            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Num_Factura, Nombre_Cliente, Fecha, Documento, Direccion, Telefono, Total, Forma_Pago, Vendedor, Comentarios, Garantia  from factura "
                    + "where Num_Factura = '" + datos + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                txtNombreCliente.setText(rs.getString("Nombre_Cliente"));
                txtVendedor.setText(rs.getString("Vendedor"));
                txtNumeroFactura.setText(rs.getString("Num_Factura"));
                txtFecha.setText(rs.getString("Fecha"));
                txtDocumento1.setText(rs.getString("Documento"));
                txtDireccion.setText(rs.getString("Direccion"));
                txtTelefono.setText(rs.getString("Telefono"));
                txtTotal.setText(rs.getString("Total"));
                txAreaComentarios.setText(rs.getString("Comentarios"));
                txtGarantia.setText(rs.getString("Garantia"));
                txtFormaDePago.setText(rs.getString("Forma_Pago"));
                 
                System.out.println("llenando ");
                
                
                
            } else {
                System.out.println("error");
            }

            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar imformacion, ¡Contacte al administrador!");
        }
    }

     public void descagarFactura(JTable tabla, DefaultTableModel model) {

        try {
            int filasSleccionada = tabla.getSelectedRow();
            String datos = tabla.getValueAt(filasSleccionada, 0).toString();

            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select  Referencia, Descripcion, unidades, Valor_Unitario, Total from tabla_facturas "
                    + "where Num_Factura = '" + datos + "'");

            ResultSet rs = pst.executeQuery();

            tabla = new JTable(model);
            jScrollPane1.setViewportView(tabla);

            model.addColumn("Referencia");
            model.addColumn("Descripcion");
            model.addColumn("Unidaes");
            model.addColumn("Valor uni");
            model.addColumn("Total");

            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
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
   
    @Override
    public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla_cinco = new javax.swing.JTable();
        panel_Codigo = new javax.swing.JPanel();
        txtNumeroFactura = new javax.swing.JLabel();
        jpanel_datos = new javax.swing.JPanel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDocumento1 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtVendedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        txtFormaDePago = new javax.swing.JTextField();
        panel_traza = new javax.swing.JPanel();
        txtFecha2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        panel_Total = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txAreaComentarios = new javax.swing.JTextArea();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel1.setText("Factura de venta número:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jTabla_cinco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jTabla_cinco.setModel(new javax.swing.table.DefaultTableModel(
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
        jTabla_cinco.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabla_cinco.setGridColor(new java.awt.Color(102, 102, 102));
        jTabla_cinco.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTabla_cinco);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 630, 100));

        panel_Codigo.setBackground(new java.awt.Color(255, 255, 255));
        panel_Codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        panel_Codigo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumeroFactura.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        txtNumeroFactura.setForeground(new java.awt.Color(0, 153, 0));
        txtNumeroFactura.setText("codigo");
        panel_Codigo.add(txtNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 13, -1, -1));

        jPanel1.add(panel_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 310, 60));

        jpanel_datos.setBackground(new java.awt.Color(255, 255, 255));
        jpanel_datos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpanel_datos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreCliente.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 310, 26));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel4.setText("Forma de pago:");
        jpanel_datos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 73, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel7.setText("Documento N°:");
        jpanel_datos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txtDocumento1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtDocumento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumento1ActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtDocumento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 310, 26));

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 140, 26));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel3.setText("Teléfono:");
        jpanel_datos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 220, 26));

        txtVendedor.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendedorActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 310, 26));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel6.setText("Dirección:");
        jpanel_datos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel9.setText("Vendedor:");
        jpanel_datos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel2.setText("Nombre del cliente:");
        jpanel_datos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel13.setText("Garantia:");
        jpanel_datos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        txtGarantia.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGarantiaActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtGarantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 140, 26));

        txtFormaDePago.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtFormaDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormaDePagoActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtFormaDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 140, 26));

        jPanel1.add(jpanel_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 630, 160));

        panel_traza.setBackground(new java.awt.Color(255, 255, 255));
        panel_traza.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        panel_traza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFecha2.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txtFecha2.setText("Fecha:");
        panel_traza.add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtFecha.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setText("Fecha");
        panel_traza.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jPanel1.add(panel_traza, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 300, 60));

        panel_Total.setBackground(new java.awt.Color(255, 255, 255));
        panel_Total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panel_Total.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("$");
        panel_Total.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Total");
        panel_Total.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txtTotal.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");
        txtTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });
        panel_Total.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, 30));

        jPanel1.add(panel_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, 250, 50));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel8.setText("Observaciones");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/WhatsApp Image 2020-12-16 at 6.16.52 PM.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 130));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Regresar");
        jButton2.setToolTipText("Cerrar");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 560, 130, 36));

        txAreaComentarios.setColumns(20);
        txAreaComentarios.setRows(5);
        txAreaComentarios.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(txAreaComentarios);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 360, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed

    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
            dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtDocumento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumento1ActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendedorActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyReleased

    private void txtGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGarantiaActionPerformed

    }//GEN-LAST:event_txtGarantiaActionPerformed

    private void txtFormaDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormaDePagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormaDePagoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturacion1().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla_cinco;
    private javax.swing.JPanel jpanel_datos;
    private javax.swing.JPanel panel_Codigo;
    private javax.swing.JPanel panel_Total;
    private javax.swing.JPanel panel_traza;
    private javax.swing.JTextArea txAreaComentarios;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento1;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtFecha2;
    private javax.swing.JTextField txtFormaDePago;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JLabel txtNumeroFactura;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables

}
