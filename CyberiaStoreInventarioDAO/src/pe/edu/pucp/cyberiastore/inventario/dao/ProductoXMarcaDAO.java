package pe.edu.pucp.cyberiastore.inventario.dao;

import java.sql.Connection;
public interface ProductoXMarcaDAO {
    public Integer insertar(Integer idProducto, Integer idMarca);

    public Integer insertar(Integer idProducto, Integer idMarca, Boolean usarTransaccion, Connection conexion);

}
