package pe.edu.pucp.cyberiastore.rol.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;
import pe.edu.pucp.cyberiastore.rol.model.Rol;

public interface PermisoXRolDAO {
    
    public Integer insertar(int idPermiso, int idRol);
    
    public Integer eliminar(int idPermiso, int idRol);
    
    public Integer eliminarPermiso(int idPermiso);
    
    public Integer eliminarRol(int idRol);
    
    public ArrayList<Rol> buscarRolesPorIdPermiso(int idPermiso);
    
    public ArrayList<Permiso> buscarPermisosPorIdRol(int idRol);
}