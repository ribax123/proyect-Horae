package clases;

import java.util.Calendar;

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
        int num;
        try {
            num = Integer.parseInt(vali);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // validacion letras nombre
    public boolean validacion(String value, int num) {

        return value.matches("[a-zA-Z ]{10,40}");
    }
    
    
    
    //validacion cantidad de caracteres permitidos pass
    public boolean validacion(int num, String value) {

        return value.matches("[a-zA-Z0-9]{8,30}");

    }
    //validacion cantidad de caracteres permitidos Username 
    public boolean validacion(String value, String valuedos) {

        return value.matches("[a-zA-Z0-9]{6,20}");      
        
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