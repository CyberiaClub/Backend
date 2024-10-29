package pe.edu.pucp.cyberiastore.rol.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.model.Rol;

public interface RolDAO {

    public Integer insertar(Rol rol);

    public Integer insertar(Rol rol, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(Rol rol);

    public Integer modificar(Rol rol, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(Rol rol);

    public Integer eliminar(Rol rol, Boolean usarTransaccion, Connection conexion);

    public ArrayList<Rol> listarTodos();

    public Rol obtenerPorId(Integer idRol);

    public Boolean existeRol(Rol rol);
}
