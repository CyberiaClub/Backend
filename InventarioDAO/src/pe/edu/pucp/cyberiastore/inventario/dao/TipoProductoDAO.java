package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
public interface TipoProductoDAO {
    public Integer insertar (TipoProducto tipoProducto);
    
    public Integer modificar (TipoProducto tipoProducto);
    
    public Integer eliminar(TipoProducto tipoProducto);
    
    public ArrayList<TipoProducto> listar(String sql);
    
    public ArrayList<TipoProducto> listarTodos();
    
    public TipoProducto obtenerPorId(String idTipoProducto);
}
