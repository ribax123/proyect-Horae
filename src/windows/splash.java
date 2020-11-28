package windows;

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
//l2vHX%!$u$)2

public class splash extends javax.swing.JFrame implements Runnable {

    private Thread time = null;

    public splash() {
        initComponents();

        setLocationRelativeTo(null);
        AWTUtilities.setWindowOpaque(this, false);
        time = new Thread(this);
        time.start();
        setSize(688, 487);

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        horaelogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        carga = new javax.swing.JLabel();
        cargandopuntos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Fodeer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        horaelogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/logo11_1_131140.png"))); // NOI18N
        horaelogo.setText("jLabel1");
        jPanel1.add(horaelogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 490, 430));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        carga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Pulse-1s-200px.gif"))); // NOI18N
        jPanel2.add(carga, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 180, 120));

        cargandopuntos.setText("Cargarndo...");
        jPanel2.add(cargandopuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Creado por ribax123@gmail.com ®");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 260, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 690, 110));

        jLabel_Fodeer.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Fodeer.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel_Fodeer.setText("Creado por ribax123@gmail.com ®");
        jPanel1.add(jLabel_Fodeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carga;
    private javax.swing.JLabel cargandopuntos;
    private javax.swing.JLabel horaelogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Fodeer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    // cuenta regresiva para abrir la interfaz del login
    @Override
    public void run() {

        while (time != null) {
            try {
                Thread.sleep(6000);
                new Interfaz().setVisible(true);
                this.dispose();
                break;

            } catch (InterruptedException ex) {
                Logger.getLogger(splash.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        time = null;

    }
}
