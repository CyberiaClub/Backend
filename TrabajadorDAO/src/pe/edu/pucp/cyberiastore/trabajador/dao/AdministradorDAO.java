package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;



public interface AdministradorDAO {
    public Integer insertar(Administrador  administrador);
    
    public Integer modificar(Administrador  administrador);
    
    public ArrayList<Administrador> listarTodosAdministradores();
    
    public Administrador obtenerPorId(Integer idAdministrador);
    //
    public void insertarIdUsuario(Integer idUsuario);
    
    public void insertarIdTrabajador(Integer idTrabajador);
    
    public void insertarIdAdministrador(Integer idAdministrador);

}
