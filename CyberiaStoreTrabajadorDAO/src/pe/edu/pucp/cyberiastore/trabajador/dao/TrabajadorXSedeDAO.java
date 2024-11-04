package pe.edu.pucp.cyberiastore.trabajador.dao;
import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;

public interface TrabajadorXSedeDAO {

    public Integer insertar(Integer idBoleta, Integer idCliente);

    public Integer insertar(Integer idBoleta, Integer idCliente, Boolean usarTransaccion, Connection conexion);

}
