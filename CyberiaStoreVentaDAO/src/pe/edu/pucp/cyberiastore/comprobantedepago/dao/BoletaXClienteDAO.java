package pe.edu.pucp.cyberiastore.comprobantedepago.dao;

import java.sql.Connection;

public interface BoletaXClienteDAO {

    public Integer insertar(Integer idBoleta, Integer idCliente);

    public Integer insertar(Integer idBoleta, Integer idCliente, Boolean usarTransaccion, Connection conexion);

}
