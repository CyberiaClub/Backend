package pe.edu.pucp.cyberiastore.inventario.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Sede;

public interface StockSedeDAO {

    public Integer insertar(Integer idProducto, Integer idSede, Integer cantidadStock);

    public Integer insertar(Integer idProducto, Integer idSede, Integer cantidadStock, Boolean usarTransaccion, Connection conexion);
    
    public Integer aumentarStock(Integer idProducto, Integer idSede, Integer stock);
}
