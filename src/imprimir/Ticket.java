/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imprimir;


import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.PrintException;
import javax.print.ServiceUI;
import javax.print.attribute.*;
import javax.swing.JOptionPane;

public class Ticket {

    //Ticket attribute content
    public String contentTicket
            = "        *****{{nameLocal}}*****          \n"
            + "            movil-tech.com               \n"
            + "        moviltech111@gmail.com           \n"
            + "       Contacto@movil-tech.com           \n\n"
            + "  SAN ANDRESITO DE LA 38 \n"
            + "  DIRECCION: cra38 #9-45 BOGOTA D.C. \n"
            + "  SUCURSAL: {{expedition}}\n"
            + "  LOCAL # {{box}}\n"
            + "  ============================================\n"           
            + "  RICARDO CASTELLANOS\n"
            + "  CELULAR: 313 4485808- 305 8078808\n"
            + "  TEL FIJO: 031-4673364\n"
            + "  Factura # {{ticket}}\n"
            + "  VENDEDOR: {{cajero}}\n"
            + "  FECHA :{{dateTime}}\n"
            + "  ============================================\n"
            + "  {{items}}\n"
            + "  ============================================\n"
            + "  SUBTOTAL: {{subTotal}}\n"
            + "  IVA: {{tax}}\n"
            + "  TOTAL: {{total}}\n\n"
            + "  GARANTIA: {{garantia}}\n\n"
            + "  ============================================\n"
            + "  GRACIAS POR SU COMPRA...\n"
            + "  ESPERAMOS SU VISITA NUEVAMENTE {{nameLocal}}.\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n"
            + "\n";

    //El constructor que setea los valores a la instancia
    public Ticket(String nameLocal, String expedition, String box, String ticket, String caissier, String dateTime, String items, String subTotal, String tax, String total, String garantia) {
        this.contentTicket = this.contentTicket.replace("{{nameLocal}}", nameLocal);
        this.contentTicket = this.contentTicket.replace("{{expedition}}", expedition);
        this.contentTicket = this.contentTicket.replace("{{box}}", box);
        this.contentTicket = this.contentTicket.replace("{{ticket}}", ticket);
        this.contentTicket = this.contentTicket.replace("{{cajero}}", caissier);
        this.contentTicket = this.contentTicket.replace("{{dateTime}}", dateTime);
        this.contentTicket = this.contentTicket.replace("{{items}}", items);
        this.contentTicket = this.contentTicket.replace("{{subTotal}}", subTotal);
        this.contentTicket = this.contentTicket.replace("{{tax}}", tax);
        this.contentTicket = this.contentTicket.replace("{{total}}", total);      
        this.contentTicket = this.contentTicket.replace("{{garantia}}", garantia);
    }

    public void print() {
        //Especificamos el tipo de dato a imprimir
        //Tipo: bytes; Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        //Aca obtenemos el servicio de impresion por defatul
        //Si no quieres ver el dialogo de seleccionar impresora usa esto
        //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        //Con esto mostramos el dialogo para seleccionar impresora
        //Si quieres ver el dialogo de seleccionar impresora usalo
        //Solo mostrara las impresoras que soporte arreglo de bits
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);

        //Creamos un arreglo de tipo byte
        byte[] bytes;

        //Aca convertimos el string(cuerpo del ticket) a bytes tal como
        //lo maneja la impresora(mas bien ticketera :p)
        bytes = this.contentTicket.getBytes();

        //Creamos un documento a imprimir, a el se le appendeara
        //el arreglo de bytes
        Doc doc = new SimpleDoc(bytes, flavor, null);

        //Imprimimos dentro de un try de a huevo
        try {
            //Creamos un trabajo de impresión

            DocPrintJob job = service.createPrintJob();
            job.print(doc, null);
        } catch (PrintException ex) {
            JOptionPane.showMessageDialog(null, "error de impresion");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Impresion cancelada");
        }

    }
}
