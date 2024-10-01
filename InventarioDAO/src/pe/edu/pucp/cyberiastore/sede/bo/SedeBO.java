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
    
    public Integer insertar(String nombre, String descripcion){
        Sede sede = new Sede(nombre,descripcion);
        return this.sedeDAO.insertar(sede);
    }
    
    public Integer modificar(String nombre, String descripcion){
        Sede sede = new Sede(nombre, descripcion);
        return this.sedeDAO.modificar(sede);
    }
    
    public Integer eliminar(String nombre, String descripcion){
        Sede sede = new Sede(nombre, descripcion);
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
    public void imprimirId(){
        System.err.println(this.sedeDAO.imprimirId());
    }
}
