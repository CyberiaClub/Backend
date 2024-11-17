package pe.edu.pucp.cyberiastore.oferta.dao;

import java.sql.Connection;

public interface ProductoXOfertaDAO {
    
    public Integer insertar(Integer idProducto, Integer idOferta);

    public Integer insertar(Integer idProducto, Integer idOferta, Boolean usarTransaccion, Connection conexion);
}
