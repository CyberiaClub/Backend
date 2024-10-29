package pe.edu.pucp.cyberiastore.inventario.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
public interface ProductoXMarcaDAO {
    public Integer insertar(Integer idProducto, Integer idMarca);

    public Integer insertar(Integer idProducto, Integer idMarca, Boolean usarTransaccion, Connection conexion);

}
