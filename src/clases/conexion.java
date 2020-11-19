package clases;

import java.sql.*;

public class conexion {

    //conexion Local
    public static Connection conectar() {
        try {
            
            String url= "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10377605";
            String user = "sql10377605";
            String pass= "RaJuPKNgpg";
            
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10377605", "sql10377605", "RaJuPKNgpg");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        return (null);
    }
}
