package pe.edu.pucp.cyberiastore.inventario.dao;

import java.sql.Connection;

public interface ProductoXProductoDAO {

    public Integer insertar(Integer idPadre, Integer idHijo, Integer cantidad);

    public Integer insertar(Integer idPadre, Integer idHijo, Integer cantidad, Boolean usarTransaccion, Connection conexions);
}
