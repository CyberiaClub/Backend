package pe.edu.pucp.cyberiastore.sede.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.sede.model.Sede;

public interface SedeDAO {
    
    public Integer insertar(Sede sede);

    public Integer modificar(Sede sede);

    public Integer eliminar(Sede sede);

    public ArrayList<Sede> listarTodos();

    public Sede obtenerPorId(Integer idSede);

    public Boolean existeSede(Sede sede);

    public Boolean existeSede(Sede sede, Boolean abreConexion);

    public Integer buscarIdPorNombre(Sede sede, Boolean abreConexion);
}
