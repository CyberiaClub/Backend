package pe.edu.pucp.cyberiastore.inventario.dao;

import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public interface ProductoXProductoDAO {
    public Integer insertar(Integer idContenedor, Integer idMiembro, Integer cantidad);
}