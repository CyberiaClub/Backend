package pe.edu.pucp.cyberiastore.inventario.dao;

import pe.edu.pucp.cyberiastore.inventario.model.Producto;
public interface ProductoDAO {
    public Integer insertar (Producto producto);
    
    public Integer modificar (Producto producto);
    
    public Integer eliminar(Producto producto);
}
