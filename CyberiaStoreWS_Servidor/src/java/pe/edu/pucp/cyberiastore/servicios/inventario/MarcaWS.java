package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.MarcaDAOImpl;

@WebService(serviceName = "MarcaWS")
public class MarcaWS {
    
    private final MarcaDAO marcaDAO;
    private Marca marca;
    
    public MarcaWS(){
        this.marcaDAO = new MarcaDAOImpl();
    }
    
    @WebMethod(operationName = "marca_insertar")
    public Integer marca_insertar(@WebParam(name = "nombre") String nombre) {
        this.marca = new Marca(nombre);
        return marcaDAO.insertar(this.marca);
    }
    
    @WebMethod(operationName = "marca_modificar")
    public Integer marca_modificar(@WebParam(name = "nombre") String nombre) {
        this.marca = new Marca(nombre);
        return marcaDAO.modificar(this.marca);
    }
    
    @WebMethod(operationName = "marca_listar")
    public ArrayList<Marca> marca_listar() {
        return marcaDAO.listarTodos();
    }
    
    @WebMethod(operationName = "marca_eliminar")
    public void marca_eliminar(@WebParam(name = "idMarca") Integer idMarca) {
        this.marca = new Marca();
        this.marca.setIdMarca(idMarca);
        marcaDAO.eliminar(this.marca);
    }
    
    @WebMethod(operationName = "marca_buscarIdPorNombre")
    public Integer marca_buscarIdPorNombre(@WebParam(name = "Marca") Marca marca, @WebParam(name = "abreConexion") Boolean abreConexion) {
        this.marca = marca;
        return marcaDAO.buscarIdPorNombre(this.marca, abreConexion);
    }
}
