/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.sql.Connection;
import clases.conexion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class resultado_Id extends javax.swing.JFrame {

    String unds = "";
    String descrip = "";
    String tip = "";
    String atr = "";
    String ID = "";

    String user;
    String fecha;

    public static String texresu = "";

    public resultado_Id() {
        initComponents();
        setLocationRelativeTo(null);

        other mensajero = new other();
        user = Interfaz.user;
        fecha = mensajero.getAnio() + "-" + mensajero.getMes() + "-" + mensajero.getDia();
        ID = Buscar.ids;

        texDescr.setText(Buscar.descri);
        texUni.setText(Buscar.unidads);
        texTipo.setText(Buscar.tips);
        texFecha.setText(Buscar.fechs);
        texAutor.setText(Buscar.autors);

    }

    public void actualizacion() {
        tip = texTipo.getText().trim();
        unds = texUni.getText().trim();

        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("update  inventario set Unidades=?, Tipo=?"
                    + "where Id = '" + ID + "'");

            ps.setString(1, unds);
            ps.setString(2, tip);

            ps.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Actualizacion de registro exitosa.");
            texTipo.setBackground(Color.GREEN);
            texUni.setBackground(Color.GREEN);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Actualizacion imposible" + e);
        }

    }
    
    public void actuTablaRegis (){
     try {
            Connection cn2 = conexion.conectar();
            PreparedStatement ps2 = cn2.prepareStatement("insert into actualizacion_inventario values (?,?,?,?) ");

            ps2.setInt(1, 0);
            ps2.setString(2, ID);
            ps2.setString(3, user);
            ps2.setString(4, fecha);

            ps2.executeUpdate();
            cn2.close();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ingreso fallido"+ e);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        texFecha = new javax.swing.JTextField();
        texUni = new javax.swing.JTextField();
        texAutor = new javax.swing.JTextField();
        texTipo = new javax.swing.JTextField();
        texDescr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        texID = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        texFecha.setBackground(new java.awt.Color(0, 51, 153));
        texFecha.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        texFecha.setForeground(new java.awt.Color(255, 255, 255));
        texFecha.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(texFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 180, 30));

        texUni.setBackground(new java.awt.Color(0, 51, 153));
        texUni.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        texUni.setForeground(new java.awt.Color(255, 255, 255));
        texUni.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(texUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 180, 30));

        texAutor.setBackground(new java.awt.Color(0, 51, 153));
        texAutor.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        texAutor.setForeground(new java.awt.Color(255, 255, 255));
        texAutor.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(texAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 180, 30));

        texTipo.setBackground(new java.awt.Color(0, 51, 153));
        texTipo.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        texTipo.setForeground(new java.awt.Color(255, 255, 255));
        texTipo.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(texTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 180, 30));

        texDescr.setBackground(new java.awt.Color(0, 51, 153));
        texDescr.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        texDescr.setForeground(new java.awt.Color(255, 255, 255));
        texDescr.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(texDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 180, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Unidades:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Autor:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        texID.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        texID.setForeground(new java.awt.Color(255, 255, 255));
        texID.setText("ID:");
        jPanel1.add(texID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, -1));

        jButton1.setText("Actualizar registro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        dispose();

    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        actualizacion();
        actuTablaRegis();
       

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(resultado_Id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resultado_Id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resultado_Id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resultado_Id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new resultado_Id().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField texAutor;
    private javax.swing.JTextField texDescr;
    private javax.swing.JTextField texFecha;
    private javax.swing.JLabel texID;
    private javax.swing.JTextField texTipo;
    private javax.swing.JTextField texUni;
    // End of variables declaration//GEN-END:variables

}
