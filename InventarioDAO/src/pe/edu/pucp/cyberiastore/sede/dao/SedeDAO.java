package pe.edu.pucp.cyberiastore.sede.dao;

import pe.edu.pucp.cyberiastore.sede.model.Sede;
public interface SedeDAO {
    public Integer insertar (Sede sede);
    
    public Integer modificar (Sede sede);
    
    public Integer eliminar(Sede sede);
}
