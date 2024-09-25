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
    private PermisoDAO permisoDAO;
    private PermisoXRolDAO permisoXRolDAO;
    private PermisoBO permisoBO;
    
    public RolBO(){
        this.rolDAO = new RolDAOImpl();
        this.permisoDAO = new PermisoDAOImpl();
        this.permisoXRolDAO = new PermisoXRolDAOImpl();
        this.permisoBO = new PermisoBO();
    }
    
    public Integer insertar(Integer idPermiso, String nombre){
        Rol rol = new Rol(idPermiso,nombre);
        return this.rolDAO.insertar(rol);
    }
    
    public Integer insertar(Rol rol){
        for(int i = 0; i < rol.getCantidadPermisos(); i++){
            permisoDAO.insertar(rol.getPermiso(i));
            permisoXRolDAO.insertar(rol.getIdRol(),rol.getPermiso(i).getIdPermiso());
        }
        return this.rolDAO.insertar(rol);
    }
    
    public Integer modificar(Rol rol){
        permisoXRolDAO.eliminarRol(rol.getIdRol());
        for(int i = 0; i < rol.getCantidadPermisos(); i++){
            permisoDAO.insertar(rol.getPermiso(i));
            permisoXRolDAO.insertar(rol.getIdRol(),rol.getPermiso(i).getIdPermiso());
        }
        return this.rolDAO.modificar(rol);
    }
    
    public Integer eliminar(Integer idPermiso, String nombre){
        Rol rol = new Rol(idPermiso,nombre);
        permisoXRolDAO.eliminarRol(rol.getIdRol());
        return this.rolDAO.eliminar(rol);
    }
    
    public ArrayList<Rol> listarTodos(){
        ArrayList<Rol> roles = this.rolDAO.listarTodos();
        for(Rol rol : roles){
            ArrayList<Permiso> permisos = permisoXRolDAO.buscarPermisosPorIdRol(rol.getIdRol());
            for (Permiso permiso : permisos) {
                rol.agregarPermiso(permiso);                
            }
        }
        return roles;
    }
    
    public Rol buscarPorId(int idRol){
        Rol rol = this.rolDAO.obtenerPorId("" + idRol);
        ArrayList<Permiso> permisos = permisoXRolDAO.buscarPermisosPorIdRol(rol.getIdRol());
        for (Permiso permiso : permisos) {
            rol.agregarPermiso(permiso);                
        }
        return rol;
    }
}