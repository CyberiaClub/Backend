package pe.edu.pucp.cyberiastore.sede.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.sede.model.Sede;

public interface StockSedeDAO {

    public Integer insertar(Integer idProducto, Integer idSede, Integer cantidadStock);

    public Integer insertar(Integer idProducto, Integer idSede, Integer cantidadStock, Boolean usarTransaccion, Connection conexion);
}
