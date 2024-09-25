package pe.edu.pucp.cyberiastore.sede.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.sede.daoImpl.SedeDAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;
import pe.edu.pucp.cyberiastore.sede.model.Sede;

public class SedeBO {
    SedeDAO sedeDAO;
    
    public SedeBO(){
        this.sedeDAO = new SedeDAOImpl();
    }
    
    public Integer insertar(String direccion, String nombre){
        Sede sede = new Sede(direccion, nombre);
        return this.sedeDAO.insertar(sede);
    }
    
    public Integer modificar(String direccion, String nombre){
        Sede sede = new Sede(direccion, nombre);
        return this.sedeDAO.modificar(sede);
    }
    
    public Integer eliminar(String direccion, String nombre){
        Sede sede = new Sede(direccion, nombre);
        return this.sedeDAO.eliminar(sede);
    }
    
    public ArrayList<Sede> listarTodos(){
        ArrayList<Sede> sedes = this.sedeDAO.listarTodos();
        
        return sedes;
    }
    
    public Sede buscarPorId(Integer idSede){
        Sede sede = this.sedeDAO.obtenerPorId(""+idSede);
        
        return sede;
    }
}
