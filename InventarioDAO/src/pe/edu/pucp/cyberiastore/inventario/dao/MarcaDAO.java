package pe.edu.pucp.cyberiastore.inventario.dao;

import pe.edu.pucp.cyberiastore.inventario.model.Marca;
public interface MarcaDAO {
    public Integer insertar (Marca marca);
    
    public Integer modificar (Marca marca);
    
    public Integer eliminar(Marca marca);
}
