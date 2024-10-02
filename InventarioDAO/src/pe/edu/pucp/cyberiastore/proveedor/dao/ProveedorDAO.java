    package pe.edu.pucp.cyberiastore.proveedor.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
public interface ProveedorDAO {
    public Integer insertar (Proveedor proveedor);
    
    public Integer modificar (Proveedor proveedor);
    
    public Integer eliminar(Proveedor proveedor);
    
    public ArrayList<Proveedor> listar(String sql);
    
    public ArrayList<Proveedor> listarTodos();
    
    public Proveedor obtenerPorId(String idProveedor);
    
    public Integer obtenerId(Proveedor proveedor);
    
    public Integer obtenerIdPorRuc(String ruc);
            
    public String imprimirId();
}
