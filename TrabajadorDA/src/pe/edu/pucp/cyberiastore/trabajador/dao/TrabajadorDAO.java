package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;


public interface TrabajadorDAO {
    public Integer insertar(Trabajador trabajador);
    
    public Integer modificar(Trabajador trabajador);
    
    public Integer eliminar(Trabajador trabajador); //no se elimina se desactiva
    
    public ArrayList<Trabajador> listarTodosTrabajador();
    
    public Trabajador obtenerPorId(Integer trabajador);
}
