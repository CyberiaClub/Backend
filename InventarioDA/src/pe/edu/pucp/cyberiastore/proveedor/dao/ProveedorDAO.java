package pe.edu.pucp.cyberiastore.proveedor.dao;

import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
public interface ProveedorDAO {
    public Integer insertar (Proveedor proveedor);
    
    public Integer modificar (Proveedor proveedor);
    
    public Integer eliminar(Proveedor proveedor);
}
