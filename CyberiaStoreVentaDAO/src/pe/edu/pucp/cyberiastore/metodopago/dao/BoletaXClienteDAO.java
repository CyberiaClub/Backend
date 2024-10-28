package pe.edu.pucp.cyberiastore.metodopago.dao;

import java.sql.Connection;

public interface BoletaXClienteDAO {

    public Integer insertar(Integer idTrabajador, Integer idSede);

    public Integer insertar(Integer idTrabajador, Integer idSede, Boolean usarTransaccion, Connection conexion);

}
