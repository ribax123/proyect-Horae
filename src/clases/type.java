package clases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import windows.Administrador;
import windows.Auxiliar;
import static windows.Borrar.borrar;
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

}
