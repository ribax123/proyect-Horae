/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.util.Calendar;

public  class other {

    public String m1 = "";
    public String m2 = "";

    public void other() {
        m1 = "Exito al guardar";

    }

    Calendar c1 = Calendar.getInstance();

    private String dia = Integer.toString(c1.get(Calendar.DATE));
    private String mes = Integer.toString(c1.get(Calendar.MONTH));
    private String anio = Integer.toString(c1.get(Calendar.YEAR));

    public boolean validacion(String vali) {
        int num;
        try {
            num = Integer.parseInt(vali);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean validacion(String value, int num) {

        return value.matches("[a-zA-Z ]*");
    }
    
    public boolean validacion (int num, String value){
    
        return value.matches("[a-zA-Z0-9]{8,15}");
    
    }
    
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
