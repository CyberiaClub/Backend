
package pe.edu.pucp.cyberiastore.trabajador.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class Vendedor extends Trabajador {
    
    Integer idVendor;
    
    public Vendedor(){
        
    }
    
    public Integer getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(Integer idVendor) {
        this.idVendor = idVendor;
    }
    
}
