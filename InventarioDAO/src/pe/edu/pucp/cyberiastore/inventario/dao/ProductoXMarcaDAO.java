package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
public interface ProductoXMarcaDAO {
    public Integer insertar(String sku, int idMarca);
    
    public Integer eliminar(String sku, int idMarca);
    
    public Integer eliminarMarca(int idMarca);
    
    public Integer eliminarProducto(String sku);
    
    public ArrayList<Marca> buscarMarcasPorSku(String sku);
    
    public ArrayList<Producto> buscarProductosPorIdMarca(int idMarca);
}
