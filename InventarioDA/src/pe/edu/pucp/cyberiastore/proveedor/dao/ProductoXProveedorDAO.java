package pe.edu.pucp.cyberiastore.proveedor.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
public interface ProductoXProveedorDAO {
    
    public Integer insertar(String sku, String ruc);
    
    public Integer eliminar(String sku, String ruc);
    
    public Integer eliminarProveedor(String ruc);
    
    public Integer eliminarProducto(String sku);
    
    public ArrayList<Proveedor> buscarProveedoresPorSku(String sku);
    
    public ArrayList<Producto> buscarProductoProRuc(String ruc);
    
}
