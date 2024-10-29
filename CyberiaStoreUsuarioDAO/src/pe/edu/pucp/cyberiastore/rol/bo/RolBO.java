package pe.edu.pucp.cyberiastore.rol.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.dao.RolDAO;
import pe.edu.pucp.cyberiastore.rol.daoImpl.RolDAOImpl;
import pe.edu.pucp.cyberiastore.rol.model.Rol;

public class RolBO {
    private RolDAO rolDAO;
    
    public RolBO(){
        this.rolDAO = new RolDAOImpl();
    }
    /*Para nuestro proyecto, solo listamos roles
    el Administrador no crea Roles, no los modifica ni los elimina.*/
    public ArrayList<Rol> listarTodos() {
        return this.rolDAO.listarTodos();
    }
}