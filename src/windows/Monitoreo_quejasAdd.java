package windows;

import clases.conexion;
import clases.Datos;
import clases.Functions;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class Monitoreo_quejasAdd extends javax.swing.JFrame {

    String administrador;
    String responsable;
    String user;
    String getAnio;
    String fecha;
    String cliente;
    int id_servicio;
    String   id_tipologia;
    String telefono;
    String tipo;
    String barrio;
    String anio;
    String trimestre;
    String cbxIdServicio;
    Functions funcion = new Functions();
    String empaquetado;
    String id_tipogia;
    String id_atencion;
    String id_atenon;
    String trimestreMes;
    

    public Monitoreo_quejasAdd() {
        initComponents();
        Datos datos = new Datos();
        anio = datos.Anio();
        fecha = datos.fechaActual();      
        lbl_Fecha.setText(fecha);
        user = Interfaz.user;
        responsable = Interfaz.user;
        lb_Nombre.setText(responsable);
        Functions funcion = new Functions();
        funcion.llenar_cmbx(cbx_Colaborador, "SELECT Nombre FROM colaboradores");
        empaquetado = "N";
        
       
        
        
        
        

        setResizable(false);
        setLocationRelativeTo(this);

    }

    public void obtenerDatos() {

        cliente = txt_Cliente.getText();
        getAnio = lbl_Fecha.getText();
        tipo = cbx_tipoSolicitud.getSelectedItem().toString();
        administrador = lb_Nombre.getText();
        id_servicio = cbx_tipoServicio.getSelectedIndex()+1;
        id_tipologia = cbx_tipoSolicitud.getSelectedItem().toString();
        id_atencion = cbx_ModoAtencion.getSelectedItem().toString();
        id_atenon = id_atencion.substring(0,1);
        id_tipogia = id_tipologia.substring(0,2);
        cbxIdServicio = String.valueOf(id_servicio);
        
        trimestre = funcion.trimestre();
        Functions ms = new Functions();
        trimestreMes = ms.mesTrimes();
        
        System.out.println("mes del trimestre " +trimestreMes);
        System.out.println("id de solicitud " + id_tipogia);
        System.out.println("id de atencion " + id_atenon);
        System.err.println("nombre" + cliente);
        System.err.println("anio" + anio);
        System.err.println("trimestre numero " + this.trimestre);
        System.err.println("id de servicio " +cbxIdServicio );
        

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
        jPanel3 = new javax.swing.JPanel();
        Btn_add = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        version = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        txt_Cliente = new javax.swing.JTextField();
        jLabel_Nombre3 = new javax.swing.JLabel();
        cbx_tipoSolicitud = new javax.swing.JComboBox<>();
        jLabel_Nombre6 = new javax.swing.JLabel();
        cbx_tipoServicio = new javax.swing.JComboBox<>();
        jLabel_Nombre7 = new javax.swing.JLabel();
        jLabel_Nombre8 = new javax.swing.JLabel();
        cbx_Colaborador = new javax.swing.JComboBox<>();
        cbx_tipodesoporte = new javax.swing.JComboBox<>();
        cbx_ModoAtencion = new javax.swing.JComboBox<>();
        jLabel_Nombre9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_Fecha = new javax.swing.JLabel();
        lb_Nombre = new javax.swing.JLabel();
        lb_Nombre1 = new javax.swing.JLabel();
        lb_Nombre2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_Fodeer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 186, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_add.setBackground(new java.awt.Color(255, 255, 255));
        Btn_add.setForeground(new java.awt.Color(255, 255, 255));
        Btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/120-diskette.png"))); // NOI18N
        Btn_add.setBorder(null);
        Btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_addActionPerformed(evt);
            }
        });
        jPanel3.add(Btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 130, 120));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("-");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 50, 40));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("x");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 50, 40));

        version.setBackground(new java.awt.Color(255, 255, 255));
        version.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("Vs. 1.0");
        jPanel3.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Sin título.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("de Colombia s.a.s");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Comunicaciones Terrestres ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        jSeparator1.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(204, 0, 0));
        jSeparator1.setAlignmentX(200.0F);
        jSeparator1.setAlignmentY(200.0F);
        jSeparator1.setDoubleBuffered(true);
        jSeparator1.setFocusCycleRoot(true);
        jSeparator1.setFocusTraversalPolicyProvider(true);
        jSeparator1.setFocusable(true);
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 230, 10));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -10, 330, 640));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Nombre4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre4.setText("Nombre  del Cliente:");
        jPanel4.add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 30));

        txt_Cliente.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txt_Cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel4.add(txt_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 330, 30));

        jLabel_Nombre3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre3.setText("Tipo de solicitúd :");
        jPanel4.add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        cbx_tipoSolicitud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_tipoSolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1.\tModificación condiciones acordadas", "A2.\tPublicidad engañosa", "A3.\tServicios no solicitados", "A4.\tFraudes en contratación", "A5.\tDatos personales", "A6.\tPlan corporativo", "B1.\tImposibilidad terminación contrato", "B2.\tCláusula de permanencia sin consentimiento", "B3.\tCláusula de permanencia superior a 1 año", "B4.\tValor subsidiado o financiado", "B5.\tFalta de información", "B6.\tPortabilidad numérica", "B7.\tCambio pospago a prepago", "C1.\tActivación sin autorización", "C2.\tFalta de información", "C3.\tNo controles de consumo", "C4.\tFacturación", "C5.\tCalidad del servicio", "D1.\tNo disponibilidad del servicio", "D2.\tCaída de llamadas", "D3.\tNo compensación informada", "D4.\tIntermitencia", "D5.\tNo traslado a nuevo domicilio", "D6.\tIntento de llamada no exitosa", "E1.\tError factura/ Cobro o descuento injustificado", "E2.\tIncremento tarifario", "E3.\tReporte a centrales de riesgo", "E4.\tCobro en proceso de reclamación", "E5.\tVigencia de saldos", "E6.\tTransferencia de saldos", "E7.\tFraude en facturación", "E8.\tCobro por reconexión", "F1.\tMensajes comerciales/ publicitarios", "F2.\tActivación recepción mensajes por suscripción sin autorización", "F3.\tRecepción mensajes por suscripción  Contenidos y Aplicaciones", "F4.\tCobro indebido", "F5.\tBaja del servicio/ Imposibilidad cancelación", "F6.\tBaja de contenido", "F7.\tFalta de información", "G1.\tMedios de atención al usuario", "H1.\tHurto", "H2.\tRegistro", "H3.\tGarantía", "H4.\tReposición", "H5.\tBandas", "I1.\tOtros" }));
        cbx_tipoSolicitud.setSelectedIndex(42);
        cbx_tipoSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_tipoSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipoSolicitudActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_tipoSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 330, 30));

        jLabel_Nombre6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre6.setText("Tipo de servicio :");
        jPanel4.add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        cbx_tipoServicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_tipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1. Telefonía fija", "2. Telefonía móvil", "3. Datos fijos", "4. Datos móviles", "5. Televisión por suscripción", " " }));
        cbx_tipoServicio.setSelectedIndex(2);
        cbx_tipoServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_tipoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipoServicioActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_tipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 330, 30));

        jLabel_Nombre7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre7.setText("Tipo de soporte");
        jPanel4.add(jLabel_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jLabel_Nombre8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre8.setText("Colaborador responsable");
        jPanel4.add(jLabel_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        cbx_Colaborador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_Colaborador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_Colaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_ColaboradorActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_Colaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 330, 30));

        cbx_tipodesoporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_tipodesoporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oficina fisica", "Oficina virtual", "Linea telefonica" }));
        cbx_tipodesoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_tipodesoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipodesoporteActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_tipodesoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 330, 30));

        cbx_ModoAtencion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_ModoAtencion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.\tOficina", "2.\tLínea Telefónica", "3.\tPágina Web", "4.\tRed social", "5.\tOtros" }));
        cbx_ModoAtencion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_ModoAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_ModoAtencionActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_ModoAtencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 330, 30));

        jLabel_Nombre9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre9.setText("Modo de atenciòn");
        jPanel4.add(jLabel_Nombre9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 410, 450));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_Fecha.setForeground(new java.awt.Color(102, 102, 102));
        lbl_Fecha.setText("AÑO");
        jPanel2.add(lbl_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        lb_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lb_Nombre.setForeground(new java.awt.Color(102, 102, 102));
        lb_Nombre.setText("Nombre");
        jPanel2.add(lb_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        lb_Nombre1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lb_Nombre1.setForeground(new java.awt.Color(102, 102, 102));
        lb_Nombre1.setText("Fecha:");
        jPanel2.add(lb_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lb_Nombre2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lb_Nombre2.setForeground(new java.awt.Color(102, 102, 102));
        lb_Nombre2.setText("Reportado:");
        jPanel2.add(lb_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 410, 70));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Registro de soportes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, 30));

        jLabel_Fodeer.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Fodeer.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel_Fodeer.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Fodeer.setText("Creado por ribax123@gmail.com ®");
        jPanel1.add(jLabel_Fodeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_tipoSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_tipoSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_tipoSolicitudActionPerformed

    private void cbx_tipoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_tipoServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_tipoServicioActionPerformed

    private void cbx_ModoAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_ModoAtencionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_ModoAtencionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addActionPerformed

        // tipo Variables para los campos "agregar usuarios"
        int validacion = 0;
        String nombre;
        obtenerDatos();

        // definir variables
        nombre = txt_Cliente.getText().trim();

        
        Datos mensAdd = new Datos();
        boolean val = mensAdd.validacion(nombre, 0);

        if (!nombre.equals("") ) {

            if (val == false) {
                JOptionPane.showMessageDialog(null, "El nombre debe  contener carateres alfabeticos y minimo 10 letras");

            }

            if (validacion == 0) {

                // Ingresar nuevos colaboradore a la base de datos
                if (validacion == 0) {
                    try {
                        Connection cn2 = conexion.conectar();
                        // instrucciones colsultas
                        PreparedStatement pst2 = cn2.prepareStatement(
                            " insert into monitoreo_quejas values (?,?,?,?,?,?,?,?)");

                        pst2.setString(1, anio);
                        pst2.setString(2, trimestre);
                        pst2.setString(3, trimestreMes);
                        pst2.setString(4, cbxIdServicio);
                        pst2.setString(5, empaquetado);
                        pst2.setString(6, id_tipogia);
                        pst2.setString(7, id_atenon);
                        pst2.setString(8, "0");

                        pst2.executeUpdate();
                        cn2.close();

                        Limpiar();

                        JOptionPane.showMessageDialog(null, "Registro exitoso");

                    } catch (SQLException e) {
                        System.err.println("ERROR al registrar el usuario" + e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador");
                    }
                } else {

                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "El campo cliente es obligatorio");
        }
    }//GEN-LAST:event_Btn_addActionPerformed

    private void cbx_ColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_ColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_ColaboradorActionPerformed

    private void cbx_tipodesoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_tipodesoporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_tipodesoporteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        obtenerDatos();
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Monitoreo_quejasAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Monitoreo_quejasAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Monitoreo_quejasAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Monitoreo_quejasAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Monitoreo_quejasAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_add;
    private javax.swing.JComboBox<String> cbx_Colaborador;
    private javax.swing.JComboBox<String> cbx_ModoAtencion;
    private javax.swing.JComboBox<String> cbx_tipoServicio;
    private javax.swing.JComboBox<String> cbx_tipoSolicitud;
    private javax.swing.JComboBox<String> cbx_tipodesoporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_Fodeer;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Nombre7;
    private javax.swing.JLabel jLabel_Nombre8;
    private javax.swing.JLabel jLabel_Nombre9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_Nombre;
    private javax.swing.JLabel lb_Nombre1;
    private javax.swing.JLabel lb_Nombre2;
    private javax.swing.JLabel lbl_Fecha;
    private javax.swing.JTextField txt_Cliente;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        
        cbx_tipoSolicitud.setSelectedIndex(0);
        txt_Cliente.setText("");

    }

}
