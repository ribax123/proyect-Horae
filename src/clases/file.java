package clases;


import windows.Interfaz;


public abstract class file {

    String usero;
    Interfaz mensajero;
    public static boolean bandera;
    String password;
    String confirmacion_password;
    String user_update;
    String pasw;
    String borrarr;
    boolean validar;
    
    public  static String nombre_usero; 

    public file() {

        usero = Interfaz.user;
        pasw = Interfaz.getPass();
              
    }

    public abstract void variable();

}
