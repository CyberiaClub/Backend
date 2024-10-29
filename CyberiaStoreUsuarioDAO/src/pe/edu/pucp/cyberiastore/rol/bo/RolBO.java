package pe.edu.pucp.cyberiastore.rol.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.dao.RolDAO;
import pe.edu.pucp.cyberiastore.rol.daoImpl.RolDAOImpl;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoDAO;
import pe.edu.pucp.cyberiastore.rol.daoImpl.PermisoDAOImpl;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoXRolDAO;
import pe.edu.pucp.cyberiastore.rol.daoImpl.PermisoXRolDAOImpl;
import pe.edu.pucp.cyberiastore.rol.model.Rol;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;

public class RolBO {
    private RolDAO rolDAO;
    private PermisoXRolDAO permisoXRolDAO;
    
    public RolBO(){
        this.rolDAO = new RolDAOImpl();
        this.permisoXRolDAO = new PermisoXRolDAOImpl();
    }
    /*Para nuestro proyecto, solo listamos roles
    el Administrador no crea Roles, no los modifica ni los elimina.*/
}