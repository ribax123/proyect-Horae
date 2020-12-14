package windows;

import clases.conexion;
import clases.other;
import com.jgoodies.common.base.Strings;
import imprimir.Imprimir;
import imprimir.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import imprimir.Ticket;

;

public class Facturacion extends javax.swing.JFrame {

    String codigoFactura;
    String nombreCliente;
    String direccion;
    String cedula = "";
    other datos;
    String user_updateDos = tablaProductos.user_UpdateDos;
    String user = "";
    String formaPa;
    String producto;
    String fecha = "";
    String cantidad = "";

    int total = 0;
    public static String datosTotales;
    public static String datosUno;
    public static String datosDos;
    public static String datosTres;
    public static String vendedor = "";
    public static DefaultTableModel modelDos = new DefaultTableModel();
    public static String conector = new String();
    public static String datosFac;
    public static String datosFacdos;
    public static String datosFactres;
    public static String[] datosIm;
    public static String todoo = new String();

    public Facturacion() {
        initComponents();

        setResizable(false);
        setLocationRelativeTo(this);
        txtNumeroFactura.setText(codigoIn());
        setSize(830, 530);
        datos = new other();
        txtFecha.setText(datos.fechaActual());
        user = Interfaz.user;
        modelDos.setRowCount(0);
        modelDos.setColumnCount(0);
        modelDos.addColumn("Referencia");
        modelDos.addColumn("Descripción");
        modelDos.addColumn("Unidades");
        modelDos.addColumn("Valor unitario");
        modelDos.addColumn("Total");

        jTabla_Dos.setModel(modelDos);

        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    // instrucciones de consulta a la base de datos
                    "select * from usuarios where username = '" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txtVendedor.setText(rs.getString("nombre_usuario"));

            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al cargar el usuario" + e);
            JOptionPane.showMessageDialog(null, "¡¡Error al cargar!!, contacte al administrador.");
        }

    }

    public void Sumar() {
        int fila = 0;
        int total = 0;

        for (int i = 0; i < jTabla_Dos.getRowCount(); i++) {
            fila = Integer.parseInt(jTabla_Dos.getValueAt(i, 4).toString());
            total += fila;
        }

        txtTotal.setText(String.valueOf(total));

    }

    public int numeroAutoIn() {
        int idcode = 1;
        try {

            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT MAX(Num_Factura) FROM factura");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                idcode = rs.getInt(1) + 1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idcode;
    }

    public String codigoIn() {

        if (String.valueOf(numeroAutoIn()).equals(null)) {
            String valor;
            valor = "0000001";
            return valor;
        } else {
            int num;
            String codigo = "";
            num = numeroAutoIn();
            String ceros = "";
            String sNum = String.valueOf(num);
            for (int i = 0; i <= 6 - sNum.length(); i++) {
                ceros = ceros + "0";
            }
            codigo = ceros + numeroAutoIn();
            return codigo;
        }

    }

    public void guardarDatos() {
        codigoFactura = txtNumeroFactura.getText().trim();
        formaPa = CBx_formaDePago.getSelectedItem().toString();
        cedula = txtDocumento1.getText().trim();
        nombreCliente = txtNombreCliente.getText().trim();
        vendedor = txtVendedor.getText().trim();
        producto = jTabla_Dos.getColumnName(0);
        fecha = txtFecha.getText();
        total = Integer.parseInt(txtTotal.getText().trim());

        try {

            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("insert into factura values (?,?,?,?,?,?,?)");

            pst.setString(1, codigoFactura);
            pst.setString(2, nombreCliente);
            pst.setString(3, cedula);
            pst.setString(4, vendedor);
            //pst.setString(4, producto);
            // pst.setString(5, cantidad);
            pst.setString(5, formaPa);
            pst.setInt(6, total);
            pst.setString(7, fecha);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Factura guardada con exito!");

        } catch (SQLException e) {
            System.err.println("ERROR al registrar la factura" + e);
        }

    }

    public void llenarTablaImprimir() {

        try {

            for (int i = 0; i < jTabla_Dos.getColumnCount() + 1; i++) {
                String datos[] = new String[3];

                datos[0] = jTabla_Dos.getValueAt(i, 1).toString();
                datos[1] = jTabla_Dos.getValueAt(i, 2).toString();
                datos[2] = jTabla_Dos.getValueAt(i, 3).toString();

                datosUno = datos[0];
                datosDos = datos[1];
                datosTres = datos[2];
                datosTotales = (datosUno + " " + datosDos + " " + datosTres + "" + "\n");
                todoo = todoo + datosTotales;
                
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("la tabla ya esta vacia");
        }

    }

    public void imprimirTicket() {
        vendedor = txtVendedor.getText().trim();
        Ticket ticket = new Ticket("MOVIL TECH", "CC BAHIA", "1", txtNumeroFactura.getText(), vendedor, "2022", todoo, cantidad, user, cedula, fecha, cedula);
        ticket.print();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroFactura = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla_Dos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        CBx_formaDePago = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtDocumento1 = new javax.swing.JTextField();
        txtVendedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtFecha2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnGuardarImprimir = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        txtNumeroFactura.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        txtNumeroFactura.setForeground(new java.awt.Color(0, 102, 255));
        txtNumeroFactura.setText("codigo");
        jPanel1.add(txtNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 34, -1, -1));

        txtNombreCliente.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtNombreCliente.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 320, 30));

        jTabla_Dos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jTabla_Dos.setForeground(new java.awt.Color(153, 153, 153));
        jTabla_Dos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTabla_Dos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabla_Dos.setGridColor(new java.awt.Color(102, 102, 102));
        jTabla_Dos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTabla_Dos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 620, 160));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel2.setText("Nombre del cliente :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel4.setText("Forma de pago:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 65, -1, -1));

        CBx_formaDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        jPanel3.add(CBx_formaDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 100, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel7.setText("Documento N°:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        txtDocumento1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtDocumento1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(txtDocumento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, 30));

        txtVendedor.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtVendedor.setForeground(new java.awt.Color(153, 153, 153));
        txtVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendedorActionPerformed(evt);
            }
        });
        jPanel3.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 220, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel3.setText("Vendedor:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 620, 160));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFecha2.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txtFecha2.setText("Fecha:");
        jPanel5.add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtFecha.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setText("Fecha");
        jPanel5.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 290, 60));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 204));
        jButton2.setText("x");
        jButton2.setToolTipText("Cerrar");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 50, 36));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 204));
        jButton4.setText("-");
        jButton4.setToolTipText("Minimizar");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 50, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotal.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");
        txtTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel6.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 30));

        jButton3.setText("Total");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("$");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 22, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 250, 70));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 51, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salvar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 110));

        btnGuardarImprimir.setBackground(new java.awt.Color(0, 51, 204));
        btnGuardarImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir.png"))); // NOI18N
        btnGuardarImprimir.setToolTipText("Imprimir y guardar");
        btnGuardarImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarImprimirActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardarImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 110));

        btnProducto.setBackground(new java.awt.Color(0, 51, 204));
        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/productos.png"))); // NOI18N
        btnProducto.setToolTipText("Tabla de productos");
        btnProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducto.setName("Agregar productos"); // NOI18N
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        jPanel4.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 110));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 150, 420));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendedorActionPerformed

    }//GEN-LAST:event_txtVendedorActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Sumar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed

        tablaProductos tbV = new tablaProductos();
        tbV.setVisible(true);
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnGuardarImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarImprimirActionPerformed
        llenarTablaImprimir();

        imprimirTicket();
        System.out.println(todoo);

    }//GEN-LAST:event_btnGuardarImprimirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturacion().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBx_formaDePago;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarImprimir;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla_Dos;
    private javax.swing.JTextField txtDocumento1;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtFecha2;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JLabel txtNumeroFactura;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables

}
