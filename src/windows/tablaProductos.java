package windows;

import clases.conexion;
import clases.Datos;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

public class tablaProductos extends javax.swing.JFrame {

    public static String vendedor;
    public static String user_UpdateDos = "";
    public static int valorTotal;
    DefaultTableModel model = new DefaultTableModel();
    String user;

    public tablaProductos() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);

        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Referencia, Descripcion from inventario");

            ResultSet rs = pst.executeQuery();

            jTable_usuariosTres = new JTable(model);
            jScrollPane2.setViewportView(jTable_usuariosTres);

            model.addColumn("Referencia");
            model.addColumn("Descripción");

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

    public void llenarTablaDos() {
        
        boolean validacionCantidad;
        boolean validacionValor;
        Datos vali = new Datos();
        String nameDos;
        String name = JOptionPane.showInputDialog("Unidades:");

        validacionCantidad = vali.validacion(name);
        
        try {
            if (!name.equals("") && validacionCantidad == true) {
                nameDos = JOptionPane.showInputDialog("Valor:");
                validacionValor = vali.validacion(nameDos);

                if (!nameDos.equals("") && validacionValor == true) {

                    int filasSleccionada = jTable_usuariosTres.getSelectedRow();
                    String val;
                    String datos[] = new String[5];
                    DecimalFormat formatea = new DecimalFormat("###,###.##");
                    int valor = Integer.parseInt(name);
                    int valorDos = Integer.parseInt(nameDos);
                    String nameTres = String.valueOf(formatea.format(valorDos));
                    //String cantidadTabla;
                    //int cantidadTotal;
                    //int totalActualizado;

                    valorTotal = valor * valorDos;

                    val = String.valueOf(formatea.format(valorTotal));

                    datos[0] = jTable_usuariosTres.getValueAt(filasSleccionada, 0).toString();
                    datos[1] = jTable_usuariosTres.getValueAt(filasSleccionada, 1).toString();
                    datos[2] = name;
                    datos[3] = nameTres;
                    datos[4] = val;
                    //cantidadTabla = jTable_usuariosTres.getValueAt(filasSleccionada, 2).toString();
                    //cantidadTotal = Integer.parseInt(cantidadTabla);

                    // aumenta o disminuye  la cantidad en el stock
                    //totalActualizado = cantidadTotal - valor;
                    Facturacion.modelDos.addRow((datos));

                    /**
                     * try { Connection cn = conexion.conectar();
                     * PreparedStatement pst = cn.prepareStatement("UPDATE
                     * inventario SET Unidades = '" + totalActualizado + "'
                     * WHERE Referencia = '"jTable_usuariosTres.getValueAt(filasSleccionada,0).toString()"' ");
                     *
                     * pst.executeUpdate();
                     *
                     * } catch (Exception e) {
                }
                     */
                } else {
                    JOptionPane.showMessageDialog(null, "NO pueden haber campos vacios, ni  caracteres alfabeticos");
                }
            

        }else {
            JOptionPane.showMessageDialog(null, "NO pueden haber campos vacios, ni  caracteres alfabeticos");
        }}catch (Exception e) {
                System.out.println("acción cancelada");
               return;
            }
    }

    public void buscarPrductos(String buscar) {
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
            model.addColumn("Unidades");

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
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar imformacion, ¡Contacte al administrador!");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_usuariosTres = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable_usuariosTres = new JTable(){
            public boolean isCellEditable(int row, int colum){
                for(int i = 0; i< jTable_usuariosTres.getRowCount(); i++){

                    if (row == i){
                        return true;
                    }
                }
                return false;
            }
        };
        jTable_usuariosTres.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_usuariosTres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_usuariosTres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_usuariosTresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_usuariosTres);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 63, 380, 253));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
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

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Insertar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 120, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        llenarTablaDos();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable_usuariosTresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_usuariosTresMouseClicked
            if (evt.getClickCount() == 1){
                llenarTablaDos();
                JOptionPane.showMessageDialog(null, "nada");
            }
    }//GEN-LAST:event_jTable_usuariosTresMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        buscarPrductos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
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
            java.util.logging.Logger.getLogger(tablaProductos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaProductos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaProductos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaProductos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_usuariosTres;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
