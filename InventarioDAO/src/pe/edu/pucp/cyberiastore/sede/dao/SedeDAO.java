package pe.edu.pucp.cyberiastore.sede.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
public interface SedeDAO {
    public Integer insertar (Sede sede);
    
    public Integer modificar (Sede sede);
    
    public Integer eliminar(Sede sede);
    
    public ArrayList<Sede> listar(String sql);
    
    public ArrayList<Sede> listarTodos();
    
    public Sede obtenerPorId(String idSede);
    
    public Integer obtenerId(Sede sede);
    
    public String imprimirId();
}
