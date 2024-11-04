package pe.edu.pucp.cyberiastore.comprobantedepago.dao;

import java.sql.Connection;

public interface FacturaXClienteDAO {
    
    public Integer insertar(Integer idFactura, Integer idCliente);

    public Integer insertar(Integer idFactura, Integer idCliente, Boolean usarTransaccion, Connection conexion);
    
}
