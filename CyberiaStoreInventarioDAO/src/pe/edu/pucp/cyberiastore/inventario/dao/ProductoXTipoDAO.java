package pe.edu.pucp.cyberiastore.inventario.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public interface ProductoXTipoDAO {
     public Integer insertar(Integer idProducto, Integer idTipoDeProducto);

    public Integer insertar(Integer idProducto, Integer idTipoDeProducto, Boolean usarTransaccion, Connection conexion);
}
