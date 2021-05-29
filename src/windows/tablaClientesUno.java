package windows;

import clases.conexion;
import clases.Datos;
import com.sun.glass.events.MouseEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import static windows.Facturacion.txtDireccion;
import static windows.Facturacion.txtDocumento1;
import static windows.Facturacion.txtNombreCliente;
import static windows.Facturacion.txtTelefono;

public class tablaClientesUno extends javax.swing.JFrame {

    public static String vendedor;
    public static String user_UpdateDos = "";
    public static int valorTotal;
    public static String NnombreCliente;
    public static String documento = "hola";
    public static String Ntelefono;
    public static String Ddireccion = "adios";
    DefaultTableModel model = new DefaultTableModel();
    String user;

    public tablaClientesUno() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);

        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Nombre_Cliente, documento, telefono, direccion, megabyts, ubicacion from clientesuribia");

            ResultSet rs = pst.executeQuery();

            jTable_Clientes = new JTable(model);
            jScrollPane2.setViewportView(jTable_Clientes);

            model.addColumn("Nombre");
            model.addColumn("Documento");
            model.addColumn("Telefono");
            model.addColumn("Dirección");
            model.addColumn("Velocidad");
            model.addColumn("Ubicación");

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

    public void obtenerDatos(JTable tabla) {
        tablaClientesUno datos = new tablaClientesUno();

        int filasSleccionada = tabla.getSelectedRow();
        NnombreCliente = tabla.getValueAt(filasSleccionada, 0).toString();
        documento = tabla.getValueAt(filasSleccionada, 1).toString();
        Ntelefono = tabla.getValueAt(filasSleccionada, 2).toString();
        Ddireccion = tabla.getValueAt(filasSleccionada, 3).toString();

    }

    /*public void buscarPrductos(String buscar) {
        model.setRowCount(0);
        model.setColumnCount(0);
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Referencia, Descripcion, Unidades from inventario where Descripcion like '%" + buscar + "%' or Referencia like '%" + buscar + "%'");

            ResultSet rs = pst.executeQuery();

            jTable_usuariosTres = new JTable(model);
            jScrollPane2.setViewportView(jTable_usuariosTres);

            model.addColumn("Referencia");
            model.addColumn("Descripción");
            model.addColumn("Valor");

            // ciclo para llenar la tabla
            /* cuando hay una solicitud  para generar 
            la lista, se crea un ciclo con un objeto...
             se crea un nuevo ciclo para iterar cada una
             de las posiciones e insertar cada uno de los datos en las 
            posiciones de las filas
            while (rs.next()) {
                Object[] fila = new Object[3];

                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar imformacion, ¡Contacte al administrador!");
        }

    }*/

    public void datos() {
        obtenerDatos(jTable_Clientes);
        txtDocumento1.setText(documento);
        txtDireccion.setText(Ddireccion);
        txtNombreCliente.setText(NnombreCliente);
        txtTelefono.setText(Ntelefono);
        
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Clientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();

        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable_Clientes = new JTable(){
            public boolean isCellEditable(int row, int colum){
                for(int i = 0; i< jTable_Clientes.getRowCount(); i++){

                    if (row == i){
                        return true;
                    }
                }
                return false;
            }
        };
        jTable_Clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ClientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable_ClientesMousePressed(evt);
            }
        });
        jTable_Clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable_ClientesKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Clientes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 63, 620, 253));

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 145, -1));

        btnInsert.setBackground(new java.awt.Color(0, 51, 102));
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setText("Insertar");
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 230, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed

        datos();
        dispose();


    }//GEN-LAST:event_btnInsertActionPerformed

    private void jTable_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClientesMouseClicked

    }//GEN-LAST:event_jTable_ClientesMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        //      buscarPrductos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jTable_ClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClientesMousePressed


    }//GEN-LAST:event_jTable_ClientesMousePressed

    private void jTable_ClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable_ClientesKeyPressed


    }//GEN-LAST:event_jTable_ClientesKeyPressed

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
            java.util.logging.Logger.getLogger(tablaClientesUno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaClientesUno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaClientesUno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaClientesUno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaClientesUno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Clientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
