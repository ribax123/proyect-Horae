package clases;

import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {

    //conexion Local
    public static Connection conectar() {
        try {

             //Connection cn = DriverManager.getConnection("jdbc:mysql://server.hostingbricks.com:3306/horaeibx_bd_ds?useSSL=false", "horaeibx", "oprresion029294");
          //Connection cn = DriverManager.getConnection("jdbc:mysql://hostingfast.ctcolombia.com.co:3306/wwwctcol_horaeibx_bd_ds", "wwwctcolombiacom", "hhcE)+?q+).d");

             Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_db", "root", "");
            return cn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error en la conexión!");
            System.out.println("Error en la conexión" + e);
        }
        return (null);
    }

    public static Connection conectarDos() {
        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://server.hostingbricks.com:3306/horaeibx_bd_ds?useSSL=false", "horaeibx", "oprresion029294");
           // Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "");
            return cn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error en la conexión!");
            System.out.println("Error en la conexión" + e);
        }
        return (null);
    }
}
