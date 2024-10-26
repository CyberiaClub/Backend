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
    
    public Integer insertar(Integer idPermiso, String nombre, String descripcion){
        Permiso permiso = new Permiso(idPermiso,nombre,descripcion);
        return this.permisoDAO.insertar(permiso);
    }
    
    public Integer modificar(Integer idPermiso, String nombre, String descripcion){
        Permiso permiso = new Permiso(idPermiso,nombre,descripcion);
        return this.permisoDAO.modificar(permiso);
    }
    
    public Integer eliminar(Integer idPermiso, String nombre, String descripcion){
        Permiso permiso = new Permiso(idPermiso,nombre,descripcion);
        permisoXRolDAO.eliminarPermiso(idPermiso);
        return this.permisoDAO.eliminar(permiso);
    }
    
    public ArrayList<Permiso> listarTodos(){
        return this.permisoDAO.listarTodos();
    }
    
    public Permiso buscarPorId(int idPermiso){
        return this.permisoDAO.obtenerPorId("" + idPermiso);
    }
}
