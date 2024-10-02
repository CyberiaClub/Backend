package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public interface ProductoXTipoDAO {
    public Integer insertar(Integer idProducto, Integer idTipoProducto);
    
    public Integer eliminar(Integer idProducto, Integer idTipoProducto);
    
    public Integer eliminarTipoProducto(Integer idTipoProducto);
    
    public Integer eliminarProducto(Integer idProducto);
    
    public ArrayList<Producto> buscarProductoPorTipo(Integer idTipoProducto);
    
    public ArrayList<TipoProducto> buscarTipoPorProducto(Integer idProducto);
}
