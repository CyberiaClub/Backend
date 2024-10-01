package pe.edu.pucp.cyberiastore.rol.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.model.Rol;

public interface RolDAO {
    
    public Integer insertar(Rol rol);
    
    public Integer modificar(Rol rol);
    
    public Integer eliminar(Rol rol);
    
    public ArrayList<Rol> listar(String sql);
    
    public ArrayList<Rol> listarTodos();
    
    public Rol obtenerPorId(String idRol);
}