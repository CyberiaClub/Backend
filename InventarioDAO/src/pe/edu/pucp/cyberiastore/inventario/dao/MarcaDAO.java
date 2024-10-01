package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
public interface MarcaDAO {
    public Integer insertar (Marca marca);
    
    public Integer modificar (Marca marca);
    
    public Integer eliminar(Marca marca);
    
    public ArrayList<Marca> listar(String sql);
    
    public ArrayList<Marca> listarTodos();
    
    public Marca obtenerPorId(String idMarca);
    
    public Integer obtenerId(Marca marca);
    
    public String imprimirId();
}
