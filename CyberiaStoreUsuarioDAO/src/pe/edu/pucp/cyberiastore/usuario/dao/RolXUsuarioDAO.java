package pe.edu.pucp.cyberiastore.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.model.Rol;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public interface RolXUsuarioDAO {
    
    public Integer insertar(String idUsuario, int idRol);
    
    public Integer eliminar(String idUsuario, int idRol);
    
    public Integer eliminarRol(int idRol);
    
    public Integer eliminarUsuario(String idUsuario);
    
    public ArrayList<Rol> buscarRolesPorIdUsuario(String idUsuario);
    
    public ArrayList<Usuario> buscarUsuariosPorIdRol(int idRol);
}