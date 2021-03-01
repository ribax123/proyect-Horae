package windows;

import java.sql.Connection;
import clases.conexion;
import clases.Datos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
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
        setSize(863, 488);

        Datos mensajero = new Datos();
        user = Interfaz.user;
        Datos fc = new Datos();
        fecha = fc.fechaActual();
        ID = Buscar.ids;
        texID.setText(ID);

        // llenar los campos con los datos solicitados
        texDescr.setText(Stock.descri);
        texUni.setText(Stock.unidads);
        txt_estado.setText(Stock.tips);
        texfecha.setText(Stock.fechs);
        texAutor.setText(Stock.autors);
        txt_estado.setText(Stock.estado);
        txt_procedencia.setText(Stock.origen);
        

    }
   

    // actualizar datos
    public void actualizacion() {
        String proce ;
        proce = txt_procedencia.getText().trim();
        tip = txt_estado.getText().trim();
        unds = texUni.getText().trim();
        

        try {

            if (tip.equals("") || unds.equals("")) {
                JOptionPane.showMessageDialog(null, "No pueden haber campos vacios.");

            } else {
                Connection cn = conexion.conectar();
                PreparedStatement ps = cn.prepareStatement("update  inventario set Unidades=?, Estado=?, Origen=?"
                        + "where Id = '" + ID + "'");

                ps.setString(1, unds);
                ps.setString(2, tip);
                ps.setString(3, proce);

                ps.executeUpdate();
                cn.close();

                JOptionPane.showMessageDialog(null, "Actualizacion de registro exitosa.");
                txt_estado.setBackground(Color.GREEN);
                texUni.setBackground(Color.GREEN);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Actualizacion imposible" + e);
        }

    }

    public void actuTablaRegis() {
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

            JOptionPane.showMessageDialog(null, "ingreso fallido" + e);
        }
    }

    //icono
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        texUni = new javax.swing.JTextField();
        txt_estado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        procedencia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        texID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        texID1 = new javax.swing.JLabel();
        texDescr = new javax.swing.JLabel();
        texfecha = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        texAutor = new javax.swing.JLabel();
        txt_procedencia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        texID2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        texUni.setBackground(new java.awt.Color(0, 51, 102));
        texUni.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        texUni.setForeground(new java.awt.Color(255, 255, 255));
        texUni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        texUni.setCaretColor(new java.awt.Color(255, 255, 255));
        texUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texUniActionPerformed(evt);
            }
        });
        jPanel1.add(texUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 180, 30));

        txt_estado.setBackground(new java.awt.Color(0, 51, 102));
        txt_estado.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_estado.setForeground(new java.awt.Color(255, 255, 255));
        txt_estado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt_estado.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estadoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 180, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Unidades :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        procedencia.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        procedencia.setForeground(new java.awt.Color(255, 255, 255));
        procedencia.setText("Procedencia :");
        jPanel1.add(procedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Autor :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, -1, -1));

        texID.setBackground(new java.awt.Color(255, 255, 255));
        texID.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        texID.setForeground(new java.awt.Color(255, 255, 255));
        texID.setText("ID");
        jPanel1.add(texID, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar registro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 470, 350, -1));

        texID1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        texID1.setForeground(new java.awt.Color(255, 255, 255));
        texID1.setText("Gestion de Inventario");
        jPanel1.add(texID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        texDescr.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        texDescr.setForeground(new java.awt.Color(255, 255, 255));
        texDescr.setText("jLabel2");
        jPanel1.add(texDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        texfecha.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        texfecha.setForeground(new java.awt.Color(255, 255, 255));
        texfecha.setText("jLabel2");
        jPanel1.add(texfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 50, 40));

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 153));
        jButton3.setText("-");
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 50, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Creado por ribax123@gmail.com ®");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, -1, -1));

        texAutor.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        texAutor.setForeground(new java.awt.Color(255, 255, 255));
        texAutor.setText("jLabel2");
        jPanel1.add(texAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, -1));

        txt_procedencia.setBackground(new java.awt.Color(0, 51, 102));
        txt_procedencia.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_procedencia.setForeground(new java.awt.Color(255, 255, 255));
        txt_procedencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt_procedencia.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_procedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 180, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estado :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        texID2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        texID2.setForeground(new java.awt.Color(255, 255, 255));
        texID2.setText("Registro :");
        jPanel1.add(texID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        actualizacion();
        actuTablaRegis();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void texUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texUniActionPerformed

    private void txt_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadoActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel procedencia;
    private javax.swing.JLabel texAutor;
    private javax.swing.JLabel texDescr;
    private javax.swing.JLabel texID;
    private javax.swing.JLabel texID1;
    private javax.swing.JLabel texID2;
    private javax.swing.JTextField texUni;
    private javax.swing.JLabel texfecha;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_procedencia;
    // End of variables declaration//GEN-END:variables

}
