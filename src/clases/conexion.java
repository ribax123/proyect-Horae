package clases;

import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {

    //conexion Local
    public static Connection conectar() {
        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://server.hostingbricks.com:3306/horaeibx_bd_ds?useSSL=false", "horaeibx", "oprresion029294");

            //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
            return cn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error en la conexión!");
            System.out.println("Error en la conexión" + e);
        }
        return (null);
    }
}
