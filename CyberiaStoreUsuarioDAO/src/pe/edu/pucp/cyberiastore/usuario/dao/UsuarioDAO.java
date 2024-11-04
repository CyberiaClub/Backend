package pe.edu.pucp.cyberiastore.usuario.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public interface UsuarioDAO {

    public Integer insertar(Usuario usuario);

    public Integer insertar(Usuario usuario, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(Usuario usuario);

    public Integer modificar(Usuario usuario, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(Usuario usuario);

    public Integer eliminar(Usuario usuario, Boolean usarTransaccion, Connection conexion);

    public ArrayList<Usuario> listarTodos();

    public Usuario obtenerPorId(Integer idUsuario);

    public Boolean existeUsuario(Usuario usuario);
}
