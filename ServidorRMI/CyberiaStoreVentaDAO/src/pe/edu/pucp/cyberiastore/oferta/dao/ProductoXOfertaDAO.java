package pe.edu.pucp.cyberiastore.oferta.dao;

import java.sql.Connection;

public interface ProductoXOfertaDAO {

    public Integer insertar(Integer idProducto, Integer idOferta, Integer descuento);

    public Integer insertar(Integer idProducto, Integer idOferta, Integer descuento, Boolean usarTransaccion, Connection conexion);
}
