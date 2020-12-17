package windows;

import java.awt.Color;
import clases.file;
import clases.metoth;
import clases.type;
import javax.swing.JOptionPane;

public class Borrar extends javax.swing.JPanel {

    public static String borrar = "";

    public Borrar() {
        
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        bton_borrar = new javax.swing.JButton();
        txt_borrar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_Borrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 51, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bton_borrar.setBackground(new java.awt.Color(0, 51, 102));
        bton_borrar.setForeground(new java.awt.Color(255, 255, 255));
        bton_borrar.setText("Comfirmar");
        bton_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_borrarActionPerformed(evt);
            }
        });
        add(bton_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 210, -1));

        txt_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_borrarActionPerformed(evt);
            }
        });
        add(txt_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 50, 27));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eliminar Registros");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 290, 40));

        lbl_Borrar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        lbl_Borrar.setForeground(new java.awt.Color(255, 255, 255));
        add(lbl_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/borrar (1).png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/base-de-datos-en-la-nube.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" ID :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 330, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Creado por ribax@gimail.com ®");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Version 1.0");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void bton_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bton_borrarActionPerformed
       
        borrar = txt_borrar.getText().trim();
        metoth union = new type();
       
        boolean bra = file.bandera;

        if (!borrar.equals("")) {
            union.borrar();
        }else{
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
        }


    }//GEN-LAST:event_bton_borrarActionPerformed

    private void txt_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_borrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_borrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bton_borrar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Borrar;
    private javax.swing.JTextField txt_borrar;
    // End of variables declaration//GEN-END:variables
}
