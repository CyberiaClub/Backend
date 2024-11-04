package pe.edu.pucp.cyberiastore.rol.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoDAO;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoXRolDAO;
import pe.edu.pucp.cyberiastore.rol.daoImpl.PermisoDAOImpl;
import pe.edu.pucp.cyberiastore.rol.daoImpl.PermisoXRolDAOImpl;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;

public class PermisoBO {
    private PermisoDAO permisoDAO;
    private PermisoXRolDAO permisoXRolDAO;
    
    public PermisoBO(){
        this.permisoDAO = new PermisoDAOImpl();
        this.permisoXRolDAO = new PermisoXRolDAOImpl();
    }
    /*
    Esto no contiene nada, porque nunca se realiza inserciones, modificaciones, listartodos ni eliminados
    por lo tanto esta parte no se creo.*/
}
