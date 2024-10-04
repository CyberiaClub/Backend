package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;



public interface AlmaceneroDAO {
    public Integer insertar(Almacenero  almacenero);
    
    public Integer modificar(Almacenero  almacenero);
    
    public ArrayList<Almacenero> listarTodosAdministradores();
    
    public Almacenero obtenerPorId(Integer idAdministrador);
    
    public void insertarIdUsuario(Integer idUsuario);
    
    public void insertarIdTrabajador(Integer idTrabajador);
    
    public void insertarIdAlmacenero(Integer idAlmacenero);

}
