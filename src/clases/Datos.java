package clases;

import java.util.Calendar;

public class Datos {

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
    public String fechaVencimiento() {

        Calendar c1 = Calendar.getInstance();
        String vencimiento ="";
        dia = Integer.toString(c1.get(Calendar.DATE));
        mes = Integer.toString(c1.get(Calendar.MONTH));
        anio = Integer.toString(c1.get(Calendar.YEAR));
        
        int mes = Integer.parseInt(getMes()); 
        int dia = Integer.parseInt(getDia());
        
        if (dia+1 <= 25){
          vencimiento= getAnio() + "-" + (mes+1) + "-" + (dia+5);  
        }if (dia+1 == 26){
            vencimiento= getAnio() + "-" + (mes+2) + "-" + (dia-25);
        }if (dia+1 == 27){
            vencimiento= getAnio() + "-" + (mes+2) + "-" + (dia-25);
        }if (dia+1 == 28){
            vencimiento= getAnio() + "-" + (mes+2) + "-" + (dia-25);
        }if (dia+1 == 29){
            vencimiento= getAnio() + "-" + (mes+2) + "-" + (dia-25);
        }if (dia+1 == 30){
            vencimiento= getAnio() + "-" + (mes+2) + "-" + (dia-25);
        }
       return vencimiento;
        
    }
    
    public String Anio (){
        
        Calendar anios = Calendar.getInstance();
        anio = Integer.toString(anios.get(Calendar.YEAR));
        return anio;
    }
    
    public String Mes (){
        
        Calendar mess = Calendar.getInstance();
        mes = Integer.toString(mess.get(Calendar.MONTH));
        int mesid = Integer.parseInt(getMes()); 
        int mes = Integer.parseInt(getMes())+ 1; 
        String ms = String.valueOf(mes);
        return ms ;
    }
    public String Dia (){
        
        Calendar dias  = Calendar.getInstance();
        dia = Integer.toString(dias.get(Calendar.DATE));
        return dia;
    }
// validacion ... solo numeros    
    public boolean validacion(String vali) {
        try {
            return vali.matches("[0-9.-]{1,40}");
        } catch (Exception e) {
            System.out.println("Operación cancelada");
        }
        return false;

    }


    // validacion letras nombre de productos
    public boolean validacion(String value, int num) {
        

        return value.matches("[a-zA-ZñÑ0-9 ]{3,40}");
    }
    
    
    
    //validacion cantidad de caracteres permitidos pass
    public boolean validacion(int num, String value) {

        return value.matches("[a-zA-Z0-9]{4,30}");

    }
    //validacion cantidad de caracteres permitidos Username (letras y numeros) 
    public boolean validacion(String value, String valuedos) {

        return value.matches("[a-zA-Z0-9]{6,20}");      
        
    }
    // validacion nombre de usuarios
    public  boolean  validacionNombre(String value){
    return value.matches("[a-zA-ZñÑ ]{3,20}");
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