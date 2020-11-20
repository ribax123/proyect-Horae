
package windows;

public class Inicio extends javax.swing.JPanel {
        
    String user;
    
    public Inicio() {
       
        initComponents();
         user = Interfaz.user;         
         jtex_bienvenido.setText("!Bienvenido " + user + "!" );
    
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtex_bienvenido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 52, 128));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 390, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Control de inventario");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondo.jpeg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Creado por ribax123@gmail.com ®");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 270, -1));

        jtex_bienvenido.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jtex_bienvenido.setForeground(new java.awt.Color(0, 204, 204));
        add(jtex_bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 75, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondoAuxiliar.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 660, 370));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jtex_bienvenido;
    // End of variables declaration//GEN-END:variables
}
