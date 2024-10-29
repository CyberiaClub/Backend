package pe.edu.pucp.cyberiastore.proveedor.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
public interface ProductoXProveedorDAO {
    
    public Integer insertar(Integer idProducto, Integer idProveedor);

    public Integer insertar(Integer idProducto, Integer idProveedor, Boolean usarTransaccion, Connection conexion);

}
