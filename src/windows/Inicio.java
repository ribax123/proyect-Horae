package windows;

import clases.Datos;

public class Inicio extends javax.swing.JPanel {

    String user;
    String fecha;

    public Inicio() {

        initComponents();
        user = Interfaz.user;
        jtex_bienvenido.setText("¡Bienvenido " + user + "!");
        Datos o = new Datos();

        fecha = o.fechaActual();

        if (o.getDia().equals("30")) {
            recordatorioMes.setText("¡Hoy es dia de inventrio General!");
        } else {
            recordatorioMes.setText(fecha);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtex_bienvenido = new javax.swing.JLabel();
        recordatorioMes = new javax.swing.JLabel();
        btn_movimientos = new javax.swing.JButton();
        btn_movimientos1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 390, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Movimientos");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Creado por ribax123@gmail.com ®");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 405, 270, -1));

        jtex_bienvenido.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jtex_bienvenido.setForeground(new java.awt.Color(0, 204, 204));
        add(jtex_bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 75, -1, -1));

        recordatorioMes.setBackground(new java.awt.Color(204, 0, 0));
        recordatorioMes.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        recordatorioMes.setForeground(new java.awt.Color(0, 204, 51));
        add(recordatorioMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 300, 30));

        btn_movimientos.setText("Estado de equipos");
        btn_movimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_movimientosActionPerformed(evt);
            }
        });
        add(btn_movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        btn_movimientos1.setText("Manejo de equipos");
        btn_movimientos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_movimientos1ActionPerformed(evt);
            }
        });
        add(btn_movimientos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_movimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_movimientosActionPerformed
        Tabla_EstadoEquipos tablaEqquipos = new Tabla_EstadoEquipos();
        tablaEqquipos.setVisible(true);
            
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_movimientosActionPerformed

    private void btn_movimientos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_movimientos1ActionPerformed
      Manejo_equipos manejoEquipos = new Manejo_equipos();
      
      manejoEquipos.setVisible(true);
    }//GEN-LAST:event_btn_movimientos1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_movimientos;
    private javax.swing.JButton btn_movimientos1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jtex_bienvenido;
    private javax.swing.JLabel recordatorioMes;
    // End of variables declaration//GEN-END:variables
}
