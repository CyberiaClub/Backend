package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
public interface ProductoDAO {
    public Integer insertar (Producto producto);
    
    public Integer modificar (Producto producto);
    
    public Integer eliminar(Producto producto);
    
    public ArrayList<Producto> listar(String sql);
    
    public ArrayList<Producto> listarTodos();
    
    public Producto obtenerPorId(String idProducto);
}
