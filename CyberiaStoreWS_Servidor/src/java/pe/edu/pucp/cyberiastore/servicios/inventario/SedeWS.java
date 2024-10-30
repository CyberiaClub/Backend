package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;
import pe.edu.pucp.cyberiastore.sede.daoImpl.SedeDAOImpl;

@WebService(serviceName = "SedeWS")
public class SedeWS {
    
    private final SedeDAO sedeDAO;
    private Sede sede;
    
    public SedeWS(){
        this.sedeDAO = new SedeDAOImpl();
    }
    
    @WebMethod(operationName = "sede_insertar")
    public Integer sede_insertar(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion) {
        this.sede = new Sede(nombre, descripcion);
        return sedeDAO.insertar(this.sede);
    }
    
    @WebMethod(operationName = "sede_modificar")
    public Integer sede_modificar(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion) {
        this.sede = new Sede(nombre, descripcion);
        return sedeDAO.modificar(this.sede);
    }
    
    @WebMethod(operationName = "sede_listar")
    public ArrayList<Sede> sede_listar() {
        return sedeDAO.listarTodos();
    }
}
