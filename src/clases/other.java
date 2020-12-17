package clases;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class other {

   private String dia;
   private String mes;
   private String anio;

  
   
    public String fechaActual() {

        Calendar c1 = Calendar.getInstance();

        dia = Integer.toString(c1.get(Calendar.DATE));
        mes = Integer.toString(c1.get(Calendar.MONTH));
        anio = Integer.toString(c1.get(Calendar.YEAR));
        int mes = Integer.parseInt(getMes());
        
        return getAnio() + "-" + (mes+1) + "-" + getDia();
    }
// validacion numeros    

    public boolean validacion(String vali) {
        try {
            return vali.matches("[0-9.]{1,40}");
        } catch (Exception e) {
            System.out.println("Operación cancelada");
        }
        return false;

    }

    // validacion letras nombre de productos
    public boolean validacion(String value, int num) {

        return value.matches("[a-zA-Z0-9 ]{5,40}");
    }
    
    
    
    //validacion cantidad de caracteres permitidos pass
    public boolean validacion(int num, String value) {

        return value.matches("[a-zA-Z0-9]{4,30}");

    }
    //validacion cantidad de caracteres permitidos Username 
    public boolean validacion(String value, String valuedos) {

        return value.matches("[a-zA-Z0-9]{6,20}");      
        
    }
    // validacion nombre de usuarios
    public  boolean  validacionNombre(String value){
    return value.matches("[a-zA-Z ]{6,20}");
    }
    

        

    
     
    // Encapsulamiento para acceder  dia - mes - año actual
    
    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @return the anio
     */
    public String getAnio() {
        return anio;
    }

}