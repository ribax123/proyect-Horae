package windows;

import clases.conexion;
import clases.type;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static windows.Facturacion.modelDos;
import static windows.Facturacion1.modelcinco;

public class tablaFacturas extends javax.swing.JFrame {

    public static String vendedor;
    public static String user_UpdateDos = "";
    public static int valorTotal;
    DefaultTableModel modelfacturas = new DefaultTableModel();
    String user;

    public tablaFacturas() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        new Url().obtenerUrl();

        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select * from factura");

            ResultSet rs = pst.executeQuery();

            jTable_facturas = new JTable(modelfacturas);
            jScrollPane2.setViewportView(jTable_facturas);

            modelfacturas.addColumn("Factura N°");
            modelfacturas.addColumn("Cliente");
            modelfacturas.addColumn("Documento");
            modelfacturas.addColumn("Telefono");
            modelfacturas.addColumn("Dirección");
            modelfacturas.addColumn("vendedor");
            modelfacturas.addColumn("Pago");
            modelfacturas.addColumn("Total");
            modelfacturas.addColumn("Fecha");

            // ciclo para llenar la tabla
            /* cuando hay una solicitud  para generar 
            la lista, se crea un ciclo con un objeto...
             se crea un nuevo ciclo para iterar cada una
             de las posiciones e insertar cada uno de los datos en las 
            posiciones de las filas*/
            while (rs.next()) {
                Object[] fila = new Object[9];

                for (int i = 0; i < 9; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelfacturas.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar imformacion, ¡Contacte al administrador!");
        }

    }

    public void buscarFactura(String buscar) {
        modelfacturas.setRowCount(0);
        modelfacturas.setColumnCount(0);
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select * from  factura where Num_Factura like '%" + buscar + "%' or Vendedor like '%" + buscar + "%' or Fecha like '%" + buscar + "%'");

            ResultSet rs = pst.executeQuery();

            jTable_facturas = new JTable(modelfacturas);
            jScrollPane2.setViewportView(jTable_facturas);

            modelfacturas.addColumn("Factura N°");
            modelfacturas.addColumn("Cliente");
            modelfacturas.addColumn("Documento");
            modelfacturas.addColumn("Telefono");
            modelfacturas.addColumn("Dirección");
            modelfacturas.addColumn("vendedor");
            modelfacturas.addColumn("Pago");
            modelfacturas.addColumn("Total");
            modelfacturas.addColumn("Fecha");

            // ciclo para llenar la tabla
            /* cuando hay una solicitud  para generar 
            la lista, se crea un ciclo con un objeto...
             se crea un nuevo ciclo para iterar cada una
             de las posiciones e insertar cada uno de los datos en las 
            posiciones de las filas*/
            while (rs.next()) {
                Object[] fila = new Object[9];

                for (int i = 0; i < 9; i++) {
                    fila[i] = rs.getObject(i + 1);

                }

                modelfacturas.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar imformacion, ¡Contacte al administrador!");
        }

    }

    //abrir 
    public void seleciof() {
        int filasSleccionada = jTable_facturas.getSelectedRow();
        new Url().obtenerUrl();
        String ruta = System.getProperty("user.home");
        String datos;
        datos = jTable_facturas.getValueAt(filasSleccionada, 0).toString();
        //abrir

        String url = ruta + Url.UrlPFa + "\\Factura" + datos + ".pdf";

        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Archivo no encontrado!");
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        version = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_facturas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 160, -1));

        btnCerrar.setBackground(new java.awt.Color(0, 51, 102));
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("Volver");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 335, 100, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vendedor/ N° FActura/ Fecha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, -1, 30));

        btnAbrir.setBackground(new java.awt.Color(0, 51, 102));
        btnAbrir.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrir.setText("abrir");
        btnAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 335, 100, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Importar tabla (Exel)");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 335, 210, -1));

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        jPanel1.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, -1, -1));

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable_facturas.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_facturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_facturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_facturasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_facturas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 890, 253));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, 30));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar registro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 335, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_facturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_facturasMouseClicked

    }//GEN-LAST:event_jTable_facturasMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        buscarFactura(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        modelcinco.setRowCount(0);
        modelcinco.setColumnCount(0);
        Facturacion1 llamarT = new Facturacion1();
        llamarT.llenarFactura(jTable_facturas);
        llamarT.descagarFactura(jTable_facturas, modelcinco);      
        llamarT.setVisible(true);

        /* try {
            seleciof();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "¡Selecciona un registro!");
        }*/
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        type exType = new type();
        try {
            exType.exportarExcel(jTable_facturas);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "¡ERROR al generar registro!");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int filasSleccionada = jTable_facturas.getSelectedRow();
            String datos;
            datos = jTable_facturas.getValueAt(filasSleccionada, 0).toString();
            System.out.println(datos);
            type delete = new type();
            delete.delete("Num_Factura", "factura", datos);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "¡Selecciona un registro!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(tablaFacturas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaFacturas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaFacturas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaFacturas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_facturas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
