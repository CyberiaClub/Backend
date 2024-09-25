package pe.edu.pucp.cyberiastore.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public interface UsuarioDAO {
    
    public Integer insertar(Usuario usuario);
    
    public Integer modificar(Usuario usuario);
    
    public Integer eliminar(Usuario usuario);
    
    public ArrayList<Usuario> listar(String sql);
    
    public ArrayList<Usuario> listarTodos();
    
    public Usuario obtenerPorId(String idUsuario);
}