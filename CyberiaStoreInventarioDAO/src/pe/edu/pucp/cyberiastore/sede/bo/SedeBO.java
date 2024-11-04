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
     public Integer insertar(Sede sede){
        return this.sedeDAO.insertar(sede);
    }
    
    public Integer modificar(Sede sede){
        return this.sedeDAO.modificar(sede);
    }

    public Integer eliminar(Sede sede){
        return this.sedeDAO.eliminar(sede);
    }

    public ArrayList<Sede> listarTodos(){
        ArrayList<Sede> sedees = this.sedeDAO.listarTodos();
        return sedees;
    }

    public Sede obtenerPorId(Integer idSede){
        Sede sede = this.sedeDAO.obtenerPorId(idSede);
        return sede;
    }
}
