package windows;

import clases.conexion;
import clases.other;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import imprimir.Ticket;
import java.awt.Font;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class Facturacion extends javax.swing.JFrame {

    public static String nombreCliente;

    String user_updateDos = tablaProductos.user_UpdateDos;
    other datos;
    String user = "";
    String producto;
    String fecha = "";
    String cantidad = "";

    public static int total = 0;
    public static String cedula = "";
    public static String formaPa;
    public static String codigoFactura;
    public static String datosTotales;
    public static String datosUno;
    public static String datosDos;
    public static String datosTres;
    public static String vendedor = "";
    public static DefaultTableModel modelDos = new DefaultTableModel();
    public static String conector = new String();
    public static String datosFac;
    public static String datosFacdos;
    public static String datosFactres;
    public static String[] datosIm;
    public static String todoo = new String();
    public static String comentarios;
    public static String direccion;
    public static String telefono;

    public Facturacion() {
        initComponents();

        //txtVendedor.disable();
        txtTotal.disable();
        setResizable(false);
        setLocationRelativeTo(this);
        txtNumeroFactura.setText(codigoIn());
        setSize(830, 530);
        datos = new other();
        txtFecha.setText(datos.fechaActual());
        user = Interfaz.user;
        modelDos.setRowCount(0);
        modelDos.setColumnCount(0);
        modelDos.addColumn("Referencia");
        modelDos.addColumn("Descripción");
        modelDos.addColumn("Unidades");
        modelDos.addColumn("Valor unitario");
        modelDos.addColumn("Total");

        jTabla_Dos.setModel(modelDos);

        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    // instrucciones de consulta a la base de datos
                    "select * from usuarios where username = '" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txtVendedor.setText(rs.getString("nombre_usuario"));

            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al cargar el usuario" + e);
            JOptionPane.showMessageDialog(null, "¡¡Error al cargar!!, contacte al administrador.");
        }

    }

    public void Sumar() {
        int fila = 0;
        int total = 0;
        String puntoComa;

        for (int i = 0; i < jTabla_Dos.getRowCount(); i++) {
            puntoComa = jTabla_Dos.getValueAt(i, 4).toString().replace(".", "");
            fila = Integer.parseInt(puntoComa);
            total += fila;
        }

        DecimalFormat formatea = new DecimalFormat("###,###.##");

        txtTotal.setText(String.valueOf(formatea.format(total)));

    }

    public int numeroAutoIn() {
        int idcode = 1;
        try {

            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT MAX(Num_Factura) FROM factura");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                idcode = rs.getInt(1) + 1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idcode;
    }

    public String codigoIn() {

        if (String.valueOf(numeroAutoIn()).equals(null)) {
            String valor;
            valor = "0000001";
            return valor;
        } else {
            int num;
            String codigo = "";
            num = numeroAutoIn();
            String ceros = "";
            String sNum = String.valueOf(num);
            for (int i = 0; i <= 6 - sNum.length(); i++) {
                ceros = ceros + "0";
            }
            codigo = ceros + numeroAutoIn();
            return codigo;
        }

    }

    public void datosF() {
        String convertir;
        codigoFactura = txtNumeroFactura.getText().trim();
        vendedor = txtVendedor.getText().trim();
        producto = jTabla_Dos.getColumnName(0);
        fecha = txtFecha.getText();
        nombreCliente = txtNombreCliente.getText().trim();
        cedula = txtDocumento1.getText().trim();
        formaPa = CBx_formaDePago.getSelectedItem().toString();
        convertir = txtTotal.getText();
        total = Integer.parseInt(convertir.replace(".", ""));
        telefono = txtTelefono.getText().trim();
        direccion = txtDireccion.getText().trim();
        comentarios = txAreaComentarios.getText().trim();
    }

    public void guardarDatos() {
        datosF();

        try {

            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("insert into factura values (?,?,?,?,?,?,?,?,?)");

            pst.setString(1, codigoFactura);
            pst.setString(2, nombreCliente);
            pst.setString(3, cedula);
            pst.setString(4, telefono);
            pst.setString(5, direccion);
            pst.setString(6, vendedor);
            //pst.setString(4, producto);
            // pst.setString(5, cantidad);
            pst.setString(7, formaPa);
            pst.setInt(8, total);
            pst.setString(9, fecha);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Factura guardada con exito!");

        } catch (SQLException e) {
            System.err.println("ERROR al registrar la factura" + e);
        }

    }

    public void llenarTablaImprimir() {

        try {

            for (int i = 0; i < jTabla_Dos.getColumnCount() + 1; i++) {
                String datos[] = new String[3];

                datos[0] = jTabla_Dos.getValueAt(i, 1).toString();
                datos[1] = jTabla_Dos.getValueAt(i, 2).toString();
                datos[2] = jTabla_Dos.getValueAt(i, 4).toString();

                datosUno = datos[0];
                datosDos = datos[1];
                datosTres = datos[2];
                datosTotales = (datosDos + " " + datosUno + " $" + datosTres + "" + "\n  ");
                todoo = todoo + datosTotales;

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("La tabla ya esta vacia");
        }

    }

    public void imprimirTicket() {
        datosF();
        
        Ticket ticket = new Ticket("MOVILTECH", "CC BAHIA", "128B", txtNumeroFactura.getText(), vendedor, fecha, todoo, txtTotal.getText(), "", txtTotal.getText(), "", "");
        ticket.print();
    }

    public void pdfFactura() {
        datosF();
        new Url().obtenerUrl();
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            //guardar
            String FacturaNume = ruta + Url.UrlPFa +"Factura"+codigoFactura + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(FacturaNume));

            Image header = com.itextpdf.text.Image.getInstance("src/iconos/banner.jpeg");
            header.scaleToFit(550, 900);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph title = new Paragraph();
            Paragraph nombre = new Paragraph();
            Paragraph numDocumen = new Paragraph();
            Paragraph vendedor = new Paragraph();
            Paragraph fPago = new Paragraph();
            Paragraph total = new Paragraph();
            Paragraph comentarios = new Paragraph();
            Paragraph telefono = new Paragraph();
            Paragraph direccion = new Paragraph();
            DecimalFormat formatea = new DecimalFormat("###,###.##");

            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.add("FACTURA N° " + Facturacion.codigoFactura + ".\n\n");
            title.setFont(FontFactory.getFont("Arial", 30, Font.BOLD, BaseColor.BLUE));

            nombre.setAlignment(Paragraph.ALIGN_LEFT);
            nombre.add("Nombre del cliente: " + Facturacion.nombreCliente + ".\n\n");
            nombre.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN, BaseColor.BLACK));

            numDocumen.setAlignment(Paragraph.ALIGN_LEFT);
            numDocumen.add("Documento: " + Facturacion.cedula + ".\n\n");
            numDocumen.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN, BaseColor.BLACK));

            telefono.setAlignment(Paragraph.ALIGN_LEFT);
            telefono.add("Teléfono: " + Facturacion.telefono + ".\n\n");
            telefono.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN, BaseColor.BLACK));

            direccion.setAlignment(Paragraph.ALIGN_LEFT);
            direccion.add("Dirección: " + Facturacion.direccion + ".\n\n");
            direccion.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN, BaseColor.BLACK));

            vendedor.setAlignment(Paragraph.ALIGN_LEFT);
            vendedor.add("Vendedor: " + Facturacion.vendedor + ".\n\n");
            vendedor.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN, BaseColor.BLACK));

            fPago.setAlignment(Paragraph.ALIGN_LEFT);
            fPago.add("Forma de pago: " + Facturacion.formaPa + ".\n\n");
            fPago.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN, BaseColor.BLACK));

            total.setAlignment(Paragraph.ALIGN_LEFT);
            total.add("\n\n TOTAL A PAGAR: $ " + formatea.format(Facturacion.total) + ".\n\n");
            total.setFont(FontFactory.getFont("Arial", 24, Font.BOLD, BaseColor.BLACK));

            comentarios.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            comentarios.add("Comentarios:  " + Facturacion.comentarios + ".\n\n");
            comentarios.setFont(FontFactory.getFont("Arial", 16, Font.BOLD, BaseColor.BLACK));

            documento.open();
            documento.add(header);
            documento.add(title);
            documento.add(nombre);
            documento.add(numDocumen);
            documento.add(telefono);
            documento.add(direccion);
            documento.add(vendedor);
            documento.add(fPago);

            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Referencia");
            tabla.addCell("Descripcion");
            tabla.addCell("Unidades");
            tabla.addCell("Valor Uni");
            tabla.addCell("Subtotal");

            try {
                for (int i = 0; i < jTabla_Dos.getRowCount(); i++) {
                    String datos[] = new String[5];

                    datos[0] = jTabla_Dos.getValueAt(i, 0).toString();
                    datos[1] = jTabla_Dos.getValueAt(i, 1).toString();
                    datos[2] = jTabla_Dos.getValueAt(i, 2).toString();
                    datos[3] = jTabla_Dos.getValueAt(i, 3).toString();
                    datos[4] = jTabla_Dos.getValueAt(i, 4).toString();

                    tabla.addCell(datos[0]);
                    tabla.addCell(datos[1]);
                    tabla.addCell(datos[2]);
                    tabla.addCell(datos[3]);
                    tabla.addCell(datos[4]);

                }

                documento.add(tabla);
                documento.add(total);
                documento.add(comentarios);

            } catch (Exception e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Documento creado.");

        } catch (Exception e) {

        }
    }

    public void limpiarTablaDos() {
        modelDos.setRowCount(0);
        modelDos.setColumnCount(0);
        modelDos.addColumn("Referencia");
        modelDos.addColumn("Descripción");
        modelDos.addColumn("Unidades");
        modelDos.addColumn("Valor unitario");
        modelDos.addColumn("Total");

        jTabla_Dos.setModel(modelDos);
        txtTotal.setText("");
    }

    public void limpiarTodo() {
        limpiarTablaDos();
        txtNombreCliente.setText("");
        txtDocumento1.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txAreaComentarios.setText("");
    }

    public void disableDatos() {
        txtNombreCliente.disable();
        txtDocumento1.disable();
        txtTelefono.disable();
        txtDireccion.disable();
        txAreaComentarios.disable();
        CBx_formaDePago.disable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla_Dos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        panel_Codigo = new javax.swing.JPanel();
        txtNumeroFactura = new javax.swing.JLabel();
        jpanel_datos = new javax.swing.JPanel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CBx_formaDePago = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtDocumento1 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtVendedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtFecha2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnGuardarImprimir = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txAreaComentarios = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        bton_limpiarCampos = new javax.swing.JButton();
        btn_Facturas = new javax.swing.JButton();
        bton_limpiarTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel1.setText("Factura de venta número:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jTabla_Dos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jTabla_Dos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTabla_Dos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabla_Dos.setGridColor(new java.awt.Color(102, 102, 102));
        jTabla_Dos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTabla_Dos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 630, 100));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel2.setText("Nombre del cliente:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        panel_Codigo.setBackground(new java.awt.Color(255, 255, 255));
        panel_Codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        panel_Codigo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumeroFactura.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        txtNumeroFactura.setForeground(new java.awt.Color(0, 102, 255));
        txtNumeroFactura.setText("codigo");
        panel_Codigo.add(txtNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 13, -1, -1));

        jPanel1.add(panel_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 60));

        jpanel_datos.setBackground(new java.awt.Color(255, 255, 255));
        jpanel_datos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpanel_datos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreCliente.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 310, 26));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel4.setText("Forma de pago:");
        jpanel_datos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 73, -1, -1));

        CBx_formaDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        CBx_formaDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBx_formaDePagoActionPerformed(evt);
            }
        });
        jpanel_datos.add(CBx_formaDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 100, 29));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel7.setText("Documento N°:");
        jpanel_datos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txtDocumento1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtDocumento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumento1ActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtDocumento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 310, 26));

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 140, 26));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel3.setText("Teléfono:");
        jpanel_datos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 220, 26));

        txtVendedor.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendedorActionPerformed(evt);
            }
        });
        jpanel_datos.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 310, 26));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel6.setText("Dirección:");
        jpanel_datos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel9.setText("Vendedor:");
        jpanel_datos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanel1.add(jpanel_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 630, 160));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFecha2.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txtFecha2.setText("Fecha:");
        jPanel5.add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtFecha.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setText("Fecha");
        jPanel5.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 300, 60));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 204));
        jButton2.setText("x");
        jButton2.setToolTipText("Cerrar");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 50, 36));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 204));
        jButton4.setText("-");
        jButton4.setToolTipText("Minimizar");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 50, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotal.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");
        txtTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });
        jPanel6.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, 30));

        jButton3.setText("Total");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("$");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 250, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 51, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salvar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 110, 110));

        btnGuardarImprimir.setBackground(new java.awt.Color(0, 51, 204));
        btnGuardarImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir.png"))); // NOI18N
        btnGuardarImprimir.setToolTipText("Imprimir y guardar");
        btnGuardarImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarImprimirActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardarImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 110));

        btnProducto.setBackground(new java.awt.Color(0, 51, 204));
        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/productos.png"))); // NOI18N
        btnProducto.setToolTipText("Tabla de productos");
        btnProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducto.setName("Agregar productos"); // NOI18N
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        jPanel4.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 110));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 150, 430));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 100, 40));

        txAreaComentarios.setColumns(20);
        txAreaComentarios.setRows(5);
        jScrollPane2.setViewportView(txAreaComentarios);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 360, 130));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel8.setText("Comentarios:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel8.setForeground(new java.awt.Color(153, 153, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bton_limpiarCampos.setBackground(new java.awt.Color(0, 51, 153));
        bton_limpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/escoba.png"))); // NOI18N
        bton_limpiarCampos.setToolTipText("Limpiar todo");
        bton_limpiarCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bton_limpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_limpiarCamposActionPerformed(evt);
            }
        });
        jPanel8.add(bton_limpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, 70));

        btn_Facturas.setBackground(new java.awt.Color(0, 51, 153));
        btn_Facturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/factura.png"))); // NOI18N
        btn_Facturas.setToolTipText("Facturas");
        btn_Facturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FacturasActionPerformed(evt);
            }
        });
        jPanel8.add(btn_Facturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, 70));

        bton_limpiarTabla.setBackground(new java.awt.Color(0, 51, 153));
        bton_limpiarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/escobaTabla.png"))); // NOI18N
        bton_limpiarTabla.setToolTipText("Limpiar tabla");
        bton_limpiarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bton_limpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_limpiarTablaActionPerformed(evt);
            }
        });
        jPanel8.add(bton_limpiarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 250, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 830, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed

    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Sumar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?\n Los datos sin guardar se perderan!", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
       if(resp == 0){
           dispose();
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        other validar = new other();
        boolean valN = validar.validacion(txtDocumento1.getText());
        boolean valL = validar.validacionNombre(txtNombreCliente.getText());
        boolean valT = validar.validacion(txtTelefono.getText());
        if (txtTelefono.getText().equals("") || txtDocumento1.getText().equals("") || txtNombreCliente.getText().equals("") || txtDireccion.equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

        } else if (txtTotal.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "El total no pude ser igual a cero");

        } else if (valL == false) {
            JOptionPane.showMessageDialog(null, "El campo: Nombre del cliente,  Solo admite letras");

        } else if (valN == false) {
            JOptionPane.showMessageDialog(null, "El campo: Documento,  Solo admite numeros");

        } else if (valT == false) {
            JOptionPane.showMessageDialog(null, "El campo: Telefono,  Solo admite numeros");
        } else {
            pdfFactura();
            guardarDatos();
            disableDatos();
            btnProducto.setEnabled(false);
            bton_limpiarTabla.setEnabled(false);
            btnGuardar.setEnabled(false);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed

        tablaProductos tbV = new tablaProductos();
        tbV.setVisible(true);
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnGuardarImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarImprimirActionPerformed
        other validar = new other();
        boolean valN = validar.validacion(txtDocumento1.getText());
        boolean valL = validar.validacionNombre(txtNombreCliente.getText());
        if (txtTelefono.getText().equals("") || txtDocumento1.getText().equals("") || txtNombreCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

        } else if (txtTotal.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "El total no pude ser cero");

        } else if (valL == false) {
            JOptionPane.showMessageDialog(null, "El campo: Nombre del cliente,  Solo admite letras");

        } else if (valN == false) {
            JOptionPane.showMessageDialog(null, "El campo: Documento,  Solo admite numeros");

        } else {

            llenarTablaImprimir();
            imprimirTicket();
            disableDatos();
            btnProducto.setEnabled(false);
            bton_limpiarTabla.setEnabled(false);
           
        }


    }//GEN-LAST:event_btnGuardarImprimirActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtDocumento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumento1ActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendedorActionPerformed

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyReleased

    private void bton_limpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bton_limpiarCamposActionPerformed
        dispose();
        new Facturacion().setVisible(true);
    }//GEN-LAST:event_bton_limpiarCamposActionPerformed

    private void btn_FacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FacturasActionPerformed
        tablaFacturas facturast = new tablaFacturas();
        facturast.setVisible(true);
    }//GEN-LAST:event_btn_FacturasActionPerformed

    private void CBx_formaDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBx_formaDePagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBx_formaDePagoActionPerformed

    private void bton_limpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bton_limpiarTablaActionPerformed
        limpiarTablaDos();

    }//GEN-LAST:event_bton_limpiarTablaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturacion().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBx_formaDePago;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarImprimir;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btn_Facturas;
    private javax.swing.JButton bton_limpiarCampos;
    private javax.swing.JButton bton_limpiarTabla;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla_Dos;
    private javax.swing.JPanel jpanel_datos;
    private javax.swing.JPanel panel_Codigo;
    private javax.swing.JTextArea txAreaComentarios;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento1;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtFecha2;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JLabel txtNumeroFactura;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables

}
