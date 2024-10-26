package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
public interface ProductoXMarcaDAO {
    public Integer insertar(Integer idProducto, Integer idMarca);
    
    public Integer eliminar(Integer idProducto, Integer idMarca);
    
    public Integer eliminarMarca(Integer idMarca);
    
    public Integer eliminarProducto(Integer idProducto);
    
    public ArrayList<Marca> buscarMarcasPorSku(Integer idProducto);
    
    public ArrayList<Producto> buscarProductosPorIdMarca(Integer idMarca);
}
