package pe.edu.pucp.cyberiastore.rol.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;

public interface PermisoDAO {
    
    public Integer insertar(Permiso permiso);
    
    public Integer modificar(Permiso permiso);
    
    public Integer eliminar(Permiso permiso);
    
    public ArrayList<Permiso> listar(String sql);
    
    public ArrayList<Permiso> listarTodos();
    
    public Permiso obtenerPorId(String idPermiso);
}