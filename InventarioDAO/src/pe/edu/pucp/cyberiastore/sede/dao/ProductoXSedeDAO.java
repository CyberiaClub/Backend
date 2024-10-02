package pe.edu.pucp.cyberiastore.sede.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
public interface ProductoXSedeDAO {
    
    public Integer insertar(Integer idProducto, Integer idSede , Integer cantidad);
    
    public Integer eliminar(Integer idProducto, Integer idSede);
    
    public Integer eliminarProducto(Integer idProducto);
    
    public Integer eliminarSede(Integer idSede);
    
    public ArrayList<Producto> buscarProcutosPorSede(Integer idSede);
    
    public ArrayList<Sede> buscarSedePorProducto(Integer idProducto);
}
