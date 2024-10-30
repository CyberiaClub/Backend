package pe.edu.pucp.cyberiastore.proveedor.dao;

import java.sql.Connection;
public interface ProductoXProveedorDAO {
    
    public Integer insertar(Integer idProducto, Integer idProveedor,Double precio);

    public Integer insertar(Integer idProducto, Integer idProveedor,Double precio, Boolean usarTransaccion, Connection conexion);

}
