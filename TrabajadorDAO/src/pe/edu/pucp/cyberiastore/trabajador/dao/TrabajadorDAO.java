package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;


public interface TrabajadorDAO {
    public Integer insertar(Trabajador trabajador);
    
    public Integer modificar(Trabajador trabajador);
    
    public ArrayList<Trabajador> listarTodosTrabajador();
    
    public Trabajador obtenerPorId(Integer trabajador);
    //
    public void insertarIdUsuario(Integer idUsuario);
    
    public void insertarIdTrabajador(Integer idTrabajador);
}
