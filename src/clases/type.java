package clases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import windows.Administrador;
import windows.Auxiliar;
import static windows.Borrar.borrar;
import windows.Facturacion;
import static windows.Interfaz.getPass;
import windows.segur;

public class type extends file implements metoth, documen {
//Dar ingreso a la aplicación, especificando el permiso por medio de una consulta a la base de datos- login.
    @Override
    public void variable() {

        // validaciones campos vacios
        if (!usero.equals("") || !pasw.equals("")) {

            //conexion y consulta a la base de datos
            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select nivel, estado from usuarios where username = '" + usero
                        + "' and password = '" + getPass() + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    // guarda en variables el nivel y el estado desde la base de datos
                    String nivel = rs.getString("nivel");
                    String estado = rs.getString("estado");

                    if (nivel.equalsIgnoreCase("Administrador") && estado.equalsIgnoreCase("Activo")) {
                        //se encarga de eliminar un objeto y asi liberar recursos 
                        bandera = true;
                        // si la condicion se cumple abre una nueva interfaz
                        new Administrador().setVisible(true);
                        cn.close();

                    } else if (estado.equals("Inactivo")) {
                        JOptionPane.showMessageDialog(null, "¡El usuario se encuentra inactivo!");
                    } else if (nivel.equalsIgnoreCase("Auxiliar") && estado.equalsIgnoreCase("Activo")) {
                        bandera = true;
                        new Auxiliar().setVisible(true);
                        cn.close();
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "¡¡Datos incorrectos!!");
                    //deja los espacios de la interfaz en blanco en caso de no coincidir.
                    bandera = false;
                }

            } catch (SQLException e) {
                System.err.println("Error en el boton acceder. " + e);
                JOptionPane.showMessageDialog(null, "¡¡ Error al iniciar sesión!!, comunicate con administrador");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

        }

    }
//Accede a una base de datos y extrae el nombre del usuario. administrador
    @Override
    public void nombreusuario() {
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios where username = '" + usero + "'");

            // validacion de usuarios en la base de datos
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombre_usero = rs.getString("nombre_usuario");
                bandera = true;
            }

        } catch (Exception e) {
            System.err.println("error en la conexion desde la interfaz Administrador");
        }

    }
//Verifica en la base de datos si el Id ingresado se encuentra registrado. validación para borrar
    @Override
    public void borrar() {
       
        borrar = borrarr;
        other vali = new other();
        validar = vali.validacion(borrar);

        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select Id from inventario where Id =?");
            ps.setString(1, borrar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                segur mjr = new segur();
                mjr.setVisible(true);
           
            } else if (validar != true) {
                JOptionPane.showMessageDialog(null, "este campo solo acepta numeros");
            } else {
                JOptionPane.showMessageDialog(null, "El ID no existe");               
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al conectarse al servidor " + e);
        }
    }
    
    public void delete(String indentificador, String tablaCodigo, String esto){
        try {
            
            String query = "delete  from "  +tablaCodigo+ " where " +indentificador+ " = ?";
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, esto);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado!");
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
//public void pdfReport() crea un reporte/registro formato.pdf
    @Override
    public void pdfReport() {

        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Inventario.pdf"));
            
            Image header = com.itextpdf.text.Image.getInstance("src/iconos/banner.png");
            header.scaleToFit(550, 900);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph title = new Paragraph();
            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.add("Registros de inventario en stock. \n\n");
            title.setFont(FontFactory.getFont("Arial", 16, Font.BOLD,BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(header);
            documento.add(title);

            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Descripcion");
            tabla.addCell("Unidades");
            tabla.addCell("Tipo");
            tabla.addCell("Fecha");
            tabla.addCell("Autor");

            try {
                Connection cn = conexion.conectar();
                PreparedStatement ps = cn.prepareStatement("select * from inventario");
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    
                     do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                     documento.add(tabla);
                    
                }

            } catch (Exception  e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Documento creado.");
        } catch (Exception e) {
        }

    }

    @Override
    public void numeroDLetras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pdfFactura() {
         Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/factura.pdf"));
            
            Image header = com.itextpdf.text.Image.getInstance("src/iconos/banner.png");
            header.scaleToFit(550, 900);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph title = new Paragraph();
            Paragraph nombre = new Paragraph();
            Paragraph numDocumen = new Paragraph();
            Paragraph vendedor = new Paragraph();
            Paragraph fPago = new Paragraph();
            
            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.add("Factura N° " + Facturacion.codigoFactura + "\n\n");
            title.setFont(FontFactory.getFont("Arial", 22, Font.BOLD,BaseColor.DARK_GRAY));
            
            nombre.setAlignment(Paragraph.ALIGN_LEFT);
            nombre.add("Nombre del cliente: " + Facturacion.nombreCliente + "\n\n");
            nombre.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN,BaseColor.BLACK));
            
            numDocumen.setAlignment(Paragraph.ALIGN_LEFT);
            numDocumen.add("Documento: " + Facturacion.cedula + "\n\n");
            numDocumen.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN,BaseColor.BLACK));
            
            vendedor.setAlignment(Paragraph.ALIGN_LEFT);
            vendedor.add("Vendedor: " + Facturacion.cedula + "\n\n");
            vendedor.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN,BaseColor.BLACK));
            
            fPago.setAlignment(Paragraph.ALIGN_LEFT);
            fPago.add("Forma de pago: " + Facturacion.formaPa + "\n\n");
            fPago.setFont(FontFactory.getFont("Arial", 16, Font.PLAIN,BaseColor.BLACK));
            
            
            
            
            
            
            documento.open();
            documento.add(header);
            documento.add(title);
            documento.add(nombre);
            documento.add(numDocumen);
            documento.add(vendedor);
            documento.add(fPago);

            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Referencia");
            tabla.addCell("Descripcion");
            tabla.addCell("Unidades");
            tabla.addCell("Valor Uni");
            tabla.addCell("Total");
           

            try {
                Connection cn = conexion.conectar();
                PreparedStatement ps = cn.prepareStatement("select * from inventario");
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    
                     do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                     documento.add(tabla);
                    
                }

            } catch (Exception  e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Documento creado.");
        } catch (Exception e) {
        }

    }
    public void exportarExcel(JTable t) throws IOException, java.io.IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (NumberFormatException e) {
                throw e;
            }
        }
    

}
}
