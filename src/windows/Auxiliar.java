package windows;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;

public class Auxiliar extends javax.swing.JFrame implements ActionListener {

    String user;

    //nuevos objetos de sus respectivas clases 
    Inicio inicio = new Inicio();
    añadirDos añadir = new añadirDos();
    Buscar buscar = new Buscar();
    Stock stock = new Stock();
    Borrar borrar = new Borrar();

    //constutor
    public Auxiliar() {
        initComponents();

        // // Dimenciones y pocisión de la intefaz 
        setSize(810, 423);
        setLocationRelativeTo(null);
        user = Interfaz.user;

        // mostrar panel principal "Inicio"
        contenedor.add(inicio);
        

        // botones paneles de la interfaz
        bt_añardir.addActionListener(this);
        bt_Inicio.addActionListener(this);
        bt_borrar.addActionListener(this);
        bt_stock.addActionListener(this);
        bt_buscar.addActionListener(this);
        
        

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    // icono miniatura
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bt_buscar = new javax.swing.JButton();
        bt_stock = new javax.swing.JButton();
        bt_Inicio = new javax.swing.JButton();
        bt_añardir = new javax.swing.JButton();
        bt_borrar = new javax.swing.JButton();
        jButton_Salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        contenedor.setPreferredSize(new java.awt.Dimension(610, 400));
        contenedor.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_buscar.setBackground(new java.awt.Color(0, 51, 102));
        bt_buscar.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        bt_buscar.setForeground(new java.awt.Color(255, 255, 255));
        bt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/activo.png"))); // NOI18N
        bt_buscar.setText("Update");
        bt_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_buscar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(bt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 132, 40));

        bt_stock.setBackground(new java.awt.Color(0, 51, 102));
        bt_stock.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        bt_stock.setForeground(new java.awt.Color(255, 255, 255));
        bt_stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/lista.png"))); // NOI18N
        bt_stock.setText("Stock");
        bt_stock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_stock.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_stockActionPerformed(evt);
            }
        });
        jPanel1.add(bt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 132, 40));

        bt_Inicio.setBackground(new java.awt.Color(0, 51, 102));
        bt_Inicio.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        bt_Inicio.setForeground(new java.awt.Color(255, 255, 255));
        bt_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/casa.png"))); // NOI18N
        bt_Inicio.setText("Inicio");
        bt_Inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Inicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_InicioActionPerformed(evt);
            }
        });
        jPanel1.add(bt_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 132, 40));

        bt_añardir.setBackground(new java.awt.Color(0, 51, 102));
        bt_añardir.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        bt_añardir.setForeground(new java.awt.Color(255, 255, 255));
        bt_añardir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/anadir.png"))); // NOI18N
        bt_añardir.setText("Registrar");
        bt_añardir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_añardir.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_añardir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_añardirActionPerformed(evt);
            }
        });
        jPanel1.add(bt_añardir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 132, 40));

        bt_borrar.setBackground(new java.awt.Color(0, 51, 102));
        bt_borrar.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        bt_borrar.setForeground(new java.awt.Color(255, 255, 255));
        bt_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/borrar.png"))); // NOI18N
        bt_borrar.setText("Eliminar");
        bt_borrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bt_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_borrarActionPerformed(evt);
            }
        });
        jPanel1.add(bt_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 132, 40));

        jButton_Salir.setBackground(new java.awt.Color(0, 102, 153));
        jButton_Salir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton_Salir.setForeground(new java.awt.Color(0, 204, 204));
        jButton_Salir.setText("x");
        jButton_Salir.setBorder(null);
        jButton_Salir.setContentAreaFilled(false);
        jButton_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 30, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/HORAE.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -10, 180, 150));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 100, -1));

        contenedor.add(jPanel1, java.awt.BorderLayout.LINE_START);

        getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_InicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_InicioActionPerformed

    private void bt_añardirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_añardirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_añardirActionPerformed

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void bt_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_stockActionPerformed

    private void bt_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_borrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_borrarActionPerformed

    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalirActionPerformed

        dispose();

    }//GEN-LAST:event_jButton_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(Auxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Auxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Auxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Auxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Auxiliar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Inicio;
    private javax.swing.JButton bt_añardir;
    private javax.swing.JButton bt_borrar;
    private javax.swing.JButton bt_buscar;
    private javax.swing.JButton bt_stock;
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    @Override

    // metodo y funcionalidad de los botones cambio de paneles en la interfaz
    public void actionPerformed(ActionEvent ae) {

        Object evt = ae.getSource();

        if (evt.equals(bt_Inicio)) {
            inicio.setVisible(true);
            buscar.setVisible(false);
            añadir.setVisible(false);
            borrar.setVisible(false);
            stock.setVisible(false);

            contenedor.add(inicio);
            contenedor.validate();

        } else if (evt.equals(bt_añardir)) {
            inicio.setVisible(false);
            buscar.setVisible(false);
            añadir.setVisible(true);
            borrar.setVisible(false);
            stock.setVisible(false);

            contenedor.add(añadir);
            contenedor.validate();

        } else if (evt.equals(bt_borrar)) {
            inicio.setVisible(false);
            buscar.setVisible(false);
            añadir.setVisible(false);
            borrar.setVisible(true);
            stock.setVisible(false);

            contenedor.add(borrar);
            contenedor.validate();

        } else if (evt.equals(bt_buscar)) {
            inicio.setVisible(false);
            buscar.setVisible(true);
            añadir.setVisible(false);
            borrar.setVisible(false);
            stock.setVisible(false);

            contenedor.add(buscar);
            contenedor.validate();

        } else if (evt.equals(bt_stock)) {
            inicio.setVisible(false);
            buscar.setVisible(false);
            añadir.setVisible(false);
            borrar.setVisible(false);
            stock.setVisible(true);

            contenedor.add(stock);
            contenedor.validate();
        }
    }
}
