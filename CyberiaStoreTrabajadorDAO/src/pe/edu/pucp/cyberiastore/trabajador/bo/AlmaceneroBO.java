package pe.edu.pucp.cyberiastore.trabajador.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AlmaceneroDAOImpl;

public class AlmaceneroBO {

    private AlmaceneroDAO almaceneroDAO;

    public AlmaceneroBO() {
        this.almaceneroDAO = new AlmaceneroDAOImpl();
    }
    
     public Integer insertar(Almacenero almacenero){
        return this.almaceneroDAO.insertar(almacenero);
    }
    
    public Integer modificar(Almacenero almacenero){
        return this.almaceneroDAO.modificar(almacenero);
    }

    public Integer eliminar(Almacenero almacenero){
        return this.almaceneroDAO.eliminar(almacenero);
    }

    public ArrayList<Almacenero> listarTodos(){
        ArrayList<Almacenero> almaceneroes = this.almaceneroDAO.listarTodos();
        return almaceneroes;
    }

    public Almacenero obtenerPorId(Integer idAlmacenero){
        Almacenero almacenero = this.almaceneroDAO.obtenerPorId(idAlmacenero);
        return almacenero;
    }
}
