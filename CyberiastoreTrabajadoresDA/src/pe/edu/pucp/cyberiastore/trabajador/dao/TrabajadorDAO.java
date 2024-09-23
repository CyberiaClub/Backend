package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;


public interface TrabajadorDAO {
    public Integer insertar(Trabajador trabajador);
    
    public Integer modificar(Trabajador trabajador);
    
    public Integer eliminar(Trabajador trabajador);
    
    public ArrayList<Trabajador> listarTodos();
    
    public Trabajador obtenerPorId(Integer trabajador);
}
