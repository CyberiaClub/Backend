package pe.edu.pucp.cyberiastore.trabajador.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;


public class Administrador extends Trabajador {
    private Integer idAdministrador;

    public Administrador() {

    }
    
    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

}
