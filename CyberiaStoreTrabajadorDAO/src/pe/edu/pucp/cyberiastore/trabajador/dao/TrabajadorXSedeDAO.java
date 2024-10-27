package pe.edu.pucp.cyberiastore.trabajador.dao;
import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;

public interface TrabajadorXSedeDAO {

    public Integer insertar(Integer idTrabajador, Integer idSede);

    public Integer insertar(Integer idTrabajador, Integer idSede, Boolean usarTransaccion, Connection conexion);

}
