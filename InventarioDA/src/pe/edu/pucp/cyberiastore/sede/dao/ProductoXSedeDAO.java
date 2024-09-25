package pe.edu.pucp.cyberiastore.sede.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
public interface ProductoXSedeDAO {
    public Integer insertar(String sku, int idSede);
    
    public Integer eliminar(String sku, int idSede);
    
    public Integer eliminarProducto(String sku);
    
    public Integer eliminarSede(String isSede);
    
    public ArrayList<Producto> buscarProcutosPorSede(int idSede);
    
    public ArrayList<Sede> buscarSedePorProducto(String sku);
}
