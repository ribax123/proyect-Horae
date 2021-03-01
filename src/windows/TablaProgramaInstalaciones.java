/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import clases.Datos;
import clases.Functions;
import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gises
 */
public class TablaProgramaInstalaciones extends javax.swing.JFrame {

    String fecha;
    String cliente;
    String direccion;
    String telefono;
    String tipo;
    String barrio;

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form IngresarInstalaciones
     */
    public TablaProgramaInstalaciones() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        setSize(1190, 560);
        

        tabla();

    }

    public void tabla() {
        model.setRowCount(0);
        model.setColumnCount(0);
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select * from tabla_instalaciones");

            ResultSet rs = pst.executeQuery();

            jtable_Instalaciones = new JTable(model);
            scrrol_Instalaciones.setViewportView(jtable_Instalaciones);

            model.addColumn("Nombre cliente");
            model.addColumn("Dirección");
            model.addColumn("Barrio");
            model.addColumn("Tipo");
            model.addColumn("Telefono");
            model.addColumn("Fecha");

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
                contar();
            }
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
        }
    }

    // Imagen logo miniatura
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    public void buscarInstalaciones(String buscar) {
        model.setRowCount(0);
        model.setColumnCount(0);
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select Nombre_cliente, Direccion, Barrio, TIpo, Telefono, Fecha  from  tabla_instalaciones where Nombre_cliente like '%" + buscar + "%' or Fecha like '%" + buscar + "%' or  TIpo like '%" + buscar + "%' or  Barrio like '%" + buscar + "%'");

            ResultSet rs = pst.executeQuery();

            jtable_Instalaciones = new JTable(model);
            scrrol_Instalaciones.setViewportView(jtable_Instalaciones);

            model.addColumn("Nombre cliente");
            model.addColumn("Direccion");
            model.addColumn("Barrio");
            model.addColumn("Tipo");
            model.addColumn("Telefono");
            model.addColumn("Fecha");

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
            JOptionPane.showMessageDialog(null, "Error al mostrar imformación, ¡Contacte al administrador!");
        }

    }

    public void borrar() {
        try {
            String datos;
            int filasSleccionada = jtable_Instalaciones.getSelectedRow();
            datos = jtable_Instalaciones.getValueAt(filasSleccionada, 1).toString();
            System.out.println(datos);
            Functions delete = new Functions();
            delete.delete("Direccion", "tabla_instalaciones", datos);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "¡Selecciona un registro!");
        }
    }

    public void actualizarLista() {
        obDatos();
        Datos dato = new Datos();
        fecha = dato.fechaActual();

        try {
            Connection cn2 = conexion.conectar();
            // instrucciones colsultas
            PreparedStatement pst2 = cn2.prepareStatement(
                    " insert into tabla_servicios values (?,?,?,?,?,?)");

            pst2.setString(1, cliente);
            pst2.setString(2, direccion);
            pst2.setString(3, barrio);
            pst2.setString(4, tipo);
            pst2.setString(5, telefono);
            pst2.setString(6, fecha);

            pst2.executeUpdate();
            cn2.close();

            borrar();
            tabla();

            JOptionPane.showMessageDialog(null, "Intalación realizada");

        } catch (SQLException e) {
            System.err.println("ERROR al registrar el usuario" + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador");
        }
    }

    public void obDatos() {
        String datos;

        int filasSleccionada = jtable_Instalaciones.getSelectedRow();
        datos = jtable_Instalaciones.getValueAt(filasSleccionada, 1).toString();
        System.out.println(datos);

        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select * from  tabla_instalaciones where Direccion =?");
            ps.setString(1, datos);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cliente = rs.getString("Nombre_cliente");
                direccion = rs.getString("Direccion");
                barrio = rs.getString("Barrio");
                tipo = rs.getString("TIpo");
                telefono = rs.getString("Telefono");

            } else {

            }

        } catch (Exception e) {
            System.out.println("Error al conectarse al servidor " + e);
        }
    }

    public void contar() {
        String r;
        for (int i = 1; i <= jtable_Instalaciones.getRowCount(); i++) {
            
                r = String.valueOf(i);
                numero_inst.setText(r);
                System.out.println(r);
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

        jPanel1 = new javax.swing.JPanel();
        scrrol_Instalaciones = new javax.swing.JScrollPane();
        jtable_Instalaciones = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_Filtrar = new javax.swing.JTextField();
        numero_inst = new javax.swing.JLabel();
        txt_instalacionOK = new javax.swing.JButton();
        txt_borrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtable_Instalaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        scrrol_Instalaciones.setViewportView(jtable_Instalaciones);

        jPanel1.add(scrrol_Instalaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1140, 390));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Filtrar :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 65, 440, 20));

        txt_Filtrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Filtrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_FiltrarKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 200, 34));

        numero_inst.setFont(new java.awt.Font("Arial", 0, 27)); // NOI18N
        numero_inst.setForeground(new java.awt.Color(255, 255, 255));
        numero_inst.setText("0");
        jPanel1.add(numero_inst, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 520, -1, -1));

        txt_instalacionOK.setBackground(new java.awt.Color(0, 102, 153));
        txt_instalacionOK.setForeground(new java.awt.Color(255, 255, 255));
        txt_instalacionOK.setText("Instalación completa");
        txt_instalacionOK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_instalacionOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_instalacionOKActionPerformed(evt);
            }
        });
        jPanel1.add(txt_instalacionOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 300, 30));

        txt_borrar.setBackground(new java.awt.Color(0, 102, 153));
        txt_borrar.setForeground(new java.awt.Color(255, 255, 255));
        txt_borrar.setText("Anular registro");
        txt_borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_borrarActionPerformed(evt);
            }
        });
        jPanel1.add(txt_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 210, 30));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("-");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 50, 40));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 153));
        jButton2.setText("x");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 27)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Programa de instalaciones CTC");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 27)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Intalaciones programadas :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 520, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_FiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FiltrarKeyReleased
        buscarInstalaciones(txt_Filtrar.getText());
    }//GEN-LAST:event_txt_FiltrarKeyReleased

    private void txt_instalacionOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_instalacionOKActionPerformed
        actualizarLista();
        contar();
    }//GEN-LAST:event_txt_instalacionOKActionPerformed

    private void txt_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_borrarActionPerformed

        int resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (resp == 0) {
            try {
                String datos;
                int filasSleccionada = jtable_Instalaciones.getSelectedRow();
                datos = jtable_Instalaciones.getValueAt(filasSleccionada, 1).toString();
                System.out.println(datos);
                Functions delete = new Functions();
                delete.delete("Direccion", "tabla_instalaciones", datos);
                tabla();
                contar();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "¡Selecciona un registro!");
            }

        }


    }//GEN-LAST:event_txt_borrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        System.out.println("");
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
            java.util.logging.Logger.getLogger(TablaProgramaInstalaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaProgramaInstalaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaProgramaInstalaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaProgramaInstalaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaProgramaInstalaciones().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtable_Instalaciones;
    private javax.swing.JLabel numero_inst;
    private javax.swing.JScrollPane scrrol_Instalaciones;
    private javax.swing.JTextField txt_Filtrar;
    private javax.swing.JButton txt_borrar;
    private javax.swing.JButton txt_instalacionOK;
    // End of variables declaration//GEN-END:variables
}
