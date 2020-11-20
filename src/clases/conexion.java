package clases;

import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {

    //conexion Local
    public static Connection conectar() {
        try {
            
        
            Connection cn = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10377605", "sql10377605", "RaJuPKNgpg");
            return cn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error en la conexión!");
            System.out.println("Error en la conexión" + e);
        }
        return (null);
    }
}
