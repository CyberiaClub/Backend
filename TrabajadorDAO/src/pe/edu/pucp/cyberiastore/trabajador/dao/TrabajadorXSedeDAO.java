
package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;


public interface TrabajadorXSedeDAO {
   
    public Integer insertar(Integer idTrabajador, Integer sede);
    
    public Integer eliminar(Integer idTrabajador, Trabajador sede);
    
    
    public Integer eliminarTrabajador(Integer idTrabajador);
    
    public ArrayList<Trabajador> buscarTrabajadorPorSede(Integer idTrabajadoro);
    
}
