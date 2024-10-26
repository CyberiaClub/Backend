package pe.edu.pucp.cyberiastore.proveedor.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
public interface ProductoXProveedorDAO {
    
    public Integer insertar(Integer idProducto, Integer idProveedor, Double precioProveedor);
    
    public Integer eliminar(Integer idProducto, Integer idProveedor);
    
    public Integer eliminarProveedor(Integer idProveedor);
    
    public Integer eliminarProducto(Integer idProducto);
    
    public ArrayList<Proveedor> buscarProveedoresPorSku(Integer idProducto);
    
    public ArrayList<Producto> buscarProductoProRuc(Integer idProveedor);
    
}
