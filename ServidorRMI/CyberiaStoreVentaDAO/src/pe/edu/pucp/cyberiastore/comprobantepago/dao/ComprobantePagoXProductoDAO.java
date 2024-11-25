package pe.edu.pucp.cyberiastore.comprobantepago.dao;

import java.sql.Connection;

public interface ComprobantePagoXProductoDAO {
    public Integer insertar(Integer idComprobantePago, Integer idProducto, Integer cantidad);

    public Integer insertar(Integer idComprobantePago, Integer idProducto, Integer cantidad, Boolean usarTransaccion, Connection conexion);
}
