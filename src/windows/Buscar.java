package windows;

import java.sql.Connection;
import clases.conexion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Buscar extends javax.swing.JPanel {
    
    public static String ids = "";
    public static String descri = "";
    public static String unidads = "";
    public static String tips = "";
    public static String fechs = "";
    public static String autors = "";
    
    public Buscar() {
        initComponents();
        other fecha1 = new other();
        
        addFecha.setText(fecha1.getAnio() + "-" + fecha1.getMes() + "-" + fecha1.getDia());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addFecha = new javax.swing.JLabel();
        jText_ID = new javax.swing.JTextField();
        buscarID = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addFecha.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addFecha.setForeground(new java.awt.Color(255, 255, 255));
        addFecha.setText("fecha");
        add(addFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, -1, -1));

        jText_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_IDActionPerformed(evt);
            }
        });
        add(jText_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 150, 23));

        buscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarIDActionPerformed(evt);
            }
        });
        add(buscarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 20, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarIDActionPerformed
        
        ids = jText_ID.getText().trim();
        other mensaID = new other();
        boolean val = mensaID.validacion(ids);
        
        if(val != true){
            jText_ID.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar valores numericos.");
            return;
        }
        
        
        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select * from inventario where Id =?");
            ps.setString(1, ids);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                ids = rs.getString("Id");
                descri = rs.getString("Descripcion");
                unidads = rs.getString("Unidades");
                tips = rs.getString("Tipo");
                fechs = rs.getString("Fecha");
                autors = rs.getString("Autor");
                
                resultado_Id resusltado = new resultado_Id();
                resusltado.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "El ID no es valido");
                
            }
            
        } catch (Exception e) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_buscarIDActionPerformed

    private void jText_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_IDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addFecha;
    private javax.swing.JButton buscarID;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jText_ID;
    // End of variables declaration//GEN-END:variables

}
