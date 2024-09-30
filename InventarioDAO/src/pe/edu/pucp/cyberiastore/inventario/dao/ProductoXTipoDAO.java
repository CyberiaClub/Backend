package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public interface ProductoXTipoDAO {
    public Integer insertar(String sku, String idTipoProducto);
    
    public Integer eliminar(String sku, String idTipoProducto);
    
    public Integer eliminarTipoProducto(String idTipoProducto);
    
    public Integer eliminarProducto(String sku);
    
    public ArrayList<Producto> buscarProductoPorTipo(String idTipoProducto);
    
    public ArrayList<TipoProducto> buscarTipoPorProducto(String sku);
}
