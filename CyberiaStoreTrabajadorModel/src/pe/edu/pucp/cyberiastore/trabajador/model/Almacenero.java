
package pe.edu.pucp.cyberiastore.trabajador.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;


public class Almacenero extends Trabajador {
    private Integer idAlmacenero;

    public Almacenero() {
        super();
    }
    
    public Integer getIdAlmacenero() {
        return idAlmacenero;
    }

    public void setIdAlmacenero(Integer idAlmacenero) {
        this.idAlmacenero = idAlmacenero;
    }
    
    
}
