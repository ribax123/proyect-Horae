/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.util.Calendar;
import java.util.Date;

public class other {

    public String m1 = "";
    public String m2 = "";

    public void other() {
      m1 = "Exito al guardar";
     
    }

    Calendar c1 = Calendar.getInstance();

    private String dia = Integer.toString(c1.get(Calendar.DATE));
    private String mes = Integer.toString(c1.get(Calendar.MONTH));
    private String anio = Integer.toString(c1.get(Calendar.YEAR));

    public Date fecha() {
        Date fecha = new Date();
        return fecha;
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
