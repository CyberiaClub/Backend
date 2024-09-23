
package cyberiastoretrabajadorestest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import pe.edu.pucp.cyberiastore.trabajador.bo.TrabajadorBO;
import java.util.Date;

public class CyberiastoreTrabajadoresTest {

    public static void main(String[] args) throws ParseException {
        TrabajadorBO trabajadorBO=new TrabajadorBO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        trabajadorBO.insertar(98652.265, sdf.parse("3/12/2012"), sdf.parse("3/12/2024") );
    }
    
}
