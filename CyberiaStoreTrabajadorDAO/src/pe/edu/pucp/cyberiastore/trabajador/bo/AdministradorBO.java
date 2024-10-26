package pe.edu.pucp.cyberiastore.trabajador.bo;

import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AdministradorDAOImpl;

public class AdministradorBO {

    private AdministradorDAO administradorDAO;

    public AdministradorBO() {
        this.administradorDAO = new AdministradorDAOImpl();
    }
}
