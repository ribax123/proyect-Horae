package windows;

import clases.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class Urls extends javax.swing.JPanel {

    public static String UrlPFa;
    public static String UrlPIN;
    public static String UrlExel;
    String user;
    String tipo;
    public static int user_Update = 0;
    public DefaultTableModel model = new DefaultTableModel();

    public Urls() {
        initComponents();
        user = Interfaz.user;

        // conexión a la base de datos e instrucciones CONSULTAS llenar tabla
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        version = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtPDFInventario = new javax.swing.JTextField();
        txtEXEl = new javax.swing.JTextField();
        txtPDFFacturas = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 51, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inventario en Stock");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 350, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creado por ribax123@gmail.com ®");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));
        add(txtPDFInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 260, 27));
        add(txtEXEl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 260, 27));
        add(txtPDFFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 260, 27));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtEXEl;
    private javax.swing.JTextField txtPDFFacturas;
    private javax.swing.JTextField txtPDFInventario;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables

}
