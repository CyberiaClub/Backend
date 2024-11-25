package pe.edu.pucp.cyberiastore.inventario.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public interface ProductoXProductoDAO {

    public Integer insertar(Integer idPadre, Integer idHijo, Integer cantidad);

    public Integer insertar(Integer idPadre, Integer idHijo, Integer cantidad, Boolean usarTransaccion, Connection conexions);

    public ArrayList<Producto> listarPorIdPadre(Integer idPadre);
}
