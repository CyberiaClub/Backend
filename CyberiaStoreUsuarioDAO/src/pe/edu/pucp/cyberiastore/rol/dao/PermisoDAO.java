package pe.edu.pucp.cyberiastore.rol.dao;
import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;

public interface PermisoDAO {

    public Integer insertar(Permiso permiso);

    public Integer insertar(Permiso permiso, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(Permiso permiso);

    public Integer modificar(Permiso permiso, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(Permiso permiso);

    public Integer eliminar(Permiso permiso, Boolean usarTransaccion, Connection conexion);

    public ArrayList<Permiso> listarTodos();

    public Permiso obtenerPorId(Integer idPermiso);

    public Boolean existePermiso(Permiso permiso);
}
