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
    String id_tipologia;
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
    String favor;
    String contra;

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
        radioButton();
        String radio;
        cliente = txt_Cliente.getText();
        getAnio = lbl_Fecha.getText();
        tipo = cbx_tipoSolicitud.getSelectedItem().toString();
        administrador = lb_Nombre.getText();
        id_servicio = cbx_tipoServicio.getSelectedIndex() + 1;
        id_tipologia = cbx_tipoSolicitud.getSelectedItem().toString();
        id_atencion = cbx_ModoAtencion.getSelectedItem().toString();
        id_atenon = id_atencion.substring(0, 1);
        id_tipogia = id_tipologia.substring(0, 2);
        cbxIdServicio = String.valueOf(id_servicio);

        trimestre = funcion.trimestre();
        Functions ms = new Functions();
        trimestreMes = ms.mesTrimes();
        
        System.out.println(contra);
        /*System.out.println("mes del trimestre " + trimestreMes);
        System.out.println("id de solicitud " + id_tipogia);
        System.out.println("id de atencion " + id_atenon);
        System.err.println("nombre" + cliente);
        System.err.println("anio" + anio);
        System.err.println("trimestre numero " + this.trimestre);
        System.err.println("id de servicio " + cbxIdServicio);*/

    }

    public void radioButton() {

        if (rb_favor.isSelected()) {
            favor = "1";
            contra = "0";
        }
        if (rb_Contra.isSelected()) {
            favor = "0";
            contra = "1";
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/iconopequeño.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoUno = new javax.swing.ButtonGroup();
        grupoDos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        jLabel_Nombre5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rb_favor = new javax.swing.JRadioButton();
        rb_Contra = new javax.swing.JRadioButton();
        Btn_add = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        rb_favor8 = new javax.swing.JRadioButton();
        rb_Contra8 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_Fecha = new javax.swing.JLabel();
        lb_Nombre = new javax.swing.JLabel();
        lb_Nombre1 = new javax.swing.JLabel();
        lb_Nombre2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel_Fodeer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(153, 153, 153))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Cliente.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_Cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel4.add(txt_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 330, 30));

        jLabel_Nombre3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre3.setText("Tipo de solicitúd :");
        jPanel4.add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        cbx_tipoSolicitud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_tipoSolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1.\tModificación condiciones acordadas", "A2.\tPublicidad engañosa", "A3.\tServicios no solicitados", "A4.\tFraudes en contratación", "A5.\tDatos personales", "A6.\tPlan corporativo", "B1.\tImposibilidad terminación contrato", "B2.\tCláusula de permanencia sin consentimiento", "B3.\tCláusula de permanencia superior a 1 año", "B4.\tValor subsidiado o financiado", "B5.\tFalta de información", "B6.\tPortabilidad numérica", "B7.\tCambio pospago a prepago", "C1.\tActivación sin autorización", "C2.\tFalta de información", "C3.\tNo controles de consumo", "C4.\tFacturación", "C5.\tCalidad del servicio", "D1.\tNo disponibilidad del servicio", "D2.\tCaída de llamadas", "D3.\tNo compensación informada", "D4.\tIntermitencia", "D5.\tNo traslado a nuevo domicilio", "D6.\tIntento de llamada no exitosa", "E1.\tError factura/ Cobro o descuento injustificado", "E2.\tIncremento tarifario", "E3.\tReporte a centrales de riesgo", "E4.\tCobro en proceso de reclamación", "E5.\tVigencia de saldos", "E6.\tTransferencia de saldos", "E7.\tFraude en facturación", "E8.\tCobro por reconexión", "F1.\tMensajes comerciales/ publicitarios", "F2.\tActivación recepción mensajes por suscripción sin autorización", "F3.\tRecepción mensajes por suscripción  Contenidos y Aplicaciones", "F4.\tCobro indebido", "F5.\tBaja del servicio/ Imposibilidad cancelación", "F6.\tBaja de contenido", "F7.\tFalta de información", "G1.\tMedios de atención al usuario", "H1.\tHurto", "H2.\tRegistro", "H3.\tGarantía", "H4.\tReposición", "H5.\tBandas", "I1.\tOtros" }));
        cbx_tipoSolicitud.setSelectedIndex(42);
        cbx_tipoSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_tipoSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipoSolicitudActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_tipoSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 330, 30));

        jLabel_Nombre6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre6.setText("Tipo de servicio :");
        jPanel4.add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        cbx_tipoServicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_tipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1. Telefonía fija", "2. Telefonía móvil", "3. Datos fijos", "4. Datos móviles", "5. Televisión por suscripción" }));
        cbx_tipoServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_tipoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipoServicioActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_tipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 330, 30));

        jLabel_Nombre7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre7.setText("Descripción del insidente");
        jPanel4.add(jLabel_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        jLabel_Nombre8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre8.setText("Colaborador responsable");
        jPanel4.add(jLabel_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        cbx_Colaborador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_Colaborador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_Colaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_ColaboradorActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_Colaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 330, 30));

        cbx_tipodesoporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_tipodesoporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cambio de contraseña", "Sin internet", "Internet lento" }));
        cbx_tipodesoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_tipodesoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipodesoporteActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_tipodesoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 330, 30));

        cbx_ModoAtencion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_ModoAtencion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.\tOficina", "2.\tLínea Telefónica", "3.\tPágina Web", "4.\tRed social", "5.\tOtros" }));
        cbx_ModoAtencion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_ModoAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_ModoAtencionActionPerformed(evt);
            }
        });
        jPanel4.add(cbx_ModoAtencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 330, 30));

        jLabel_Nombre9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre9.setText("Modo de atenciòn");
        jPanel4.add(jLabel_Nombre9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_Nombre5.setText("Nombre  del Cliente:");
        jPanel4.add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quejas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoDos.add(rb_favor);
        rb_favor.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rb_favor.setText("A Favor");
        jPanel5.add(rb_favor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        grupoDos.add(rb_Contra);
        rb_Contra.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rb_Contra.setText("En Contra");
        jPanel5.add(rb_Contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 180, 90));

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
        jPanel4.add(Btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 130, 120));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reposición", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoUno.add(rb_favor8);
        rb_favor8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rb_favor8.setText("A Favor");
        jPanel13.add(rb_favor8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        grupoUno.add(rb_Contra8);
        rb_Contra8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rb_Contra8.setText("En Contra");
        jPanel13.add(rb_Contra8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel4.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 180, 90));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 870, 450));

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

        jButton3.setText("Probador");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 870, 70));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Registro de Soportes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, 30));

        jLabel_Fodeer.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Fodeer.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel_Fodeer.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Fodeer.setText("Creado por ribax123@gmail.com ®");
        jPanel1.add(jLabel_Fodeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 610, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Sin título.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("de Colombia s.a.s");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Comunicaciones Terrestres ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, 30));

        jSeparator3.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 260, 10));

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("-");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 50, 40));

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 255));
        jButton2.setText("x");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 640));

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

        if (!nombre.equals("")) {

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
    private javax.swing.ButtonGroup grupoDos;
    private javax.swing.ButtonGroup grupoUno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Fodeer;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Nombre7;
    private javax.swing.JLabel jLabel_Nombre8;
    private javax.swing.JLabel jLabel_Nombre9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lb_Nombre;
    private javax.swing.JLabel lb_Nombre1;
    private javax.swing.JLabel lb_Nombre2;
    private javax.swing.JLabel lbl_Fecha;
    private javax.swing.JRadioButton rb_Contra;
    private javax.swing.JRadioButton rb_Contra8;
    private javax.swing.JRadioButton rb_favor;
    private javax.swing.JRadioButton rb_favor8;
    private javax.swing.JTextField txt_Cliente;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {

        cbx_tipoSolicitud.setSelectedIndex(0);
        txt_Cliente.setText("");

    }

}
