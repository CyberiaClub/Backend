package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
public interface ProductoDAO {
    public Integer insertar (Producto producto);
    
    public Integer modificar (Producto producto);
    
    public Integer eliminar(Producto producto);
    
    public ArrayList<Producto> listarTodos();
    
    public Producto obtenerPorId(String idProducto);

    public Boolean existeProducto(Producto producto);

    public Boolean existeProducto(Producto producto, Boolean abreConexion);
    
    public Producto buscar_sku(String sku, Integer idSede);
}
