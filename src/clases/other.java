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

    // validacion letras
    public boolean validacion(String value, int num) {

        return value.matches("[a-zA-Z ]*");
    }

    public boolean validacion(int num, String value) {

        return value.matches("[a-zA-Z0-9]{8,15}");

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

    