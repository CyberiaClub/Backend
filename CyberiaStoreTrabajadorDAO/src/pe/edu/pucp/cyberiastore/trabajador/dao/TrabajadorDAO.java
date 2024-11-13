package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;

public interface TrabajadorDAO {

    public Integer insertar(Trabajador trabajador);

    public Integer insertar(Trabajador trabajador, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(Trabajador trabajador);

    public Integer modificar(Trabajador trabajador, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(Trabajador trabajador);

    public Integer eliminar(Trabajador trabajador, Boolean usarTransaccion, Connection conexion);

    public ArrayList<Trabajador> listarTodos();

    public Trabajador obtenerPorId(Integer idTrabajador);

    public Boolean existeTrabajador(Trabajador trabajador);

    public Boolean existeTrabajador(Trabajador trabajador, Boolean abreConexion);
    
}
