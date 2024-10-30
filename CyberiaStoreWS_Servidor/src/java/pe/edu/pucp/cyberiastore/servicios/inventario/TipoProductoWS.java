package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.TipoProductoDAOImpl;

@WebService(serviceName = "TipoProductoWS")
public class TipoProductoWS {
    
    private final TipoProductoDAO tipoProductoDAO;
    private TipoProducto tipoProducto;
    
    public TipoProductoWS(){
        this.tipoProductoDAO = new TipoProductoDAOImpl();
    }
    
    @WebMethod(operationName = "tipoProducto_insertar")
    public Integer tipoProducto_insertar(@WebParam(name = "tipo") String tipo) {
        this.tipoProducto = new TipoProducto(tipo);
        return tipoProductoDAO.insertar(this.tipoProducto);
    }
    
    @WebMethod(operationName = "tipoProducto_modificar")
    public Integer tipoProducto_modificar(@WebParam(name = "tipo") String tipo) {
        this.tipoProducto = new TipoProducto(tipo);
        return tipoProductoDAO.modificar(this.tipoProducto);
    }
    
    @WebMethod(operationName = "tipoProducto_listar")
    public ArrayList<TipoProducto> tipoProducto_listar() {
        return tipoProductoDAO.listarTodos();
    }
    
    @WebMethod(operationName = "tipoProducto_eliminar")
    public void tipoProducto_eliminar(@WebParam(name = "idTipoProducto") Integer idTipoProducto) {
        this.tipoProducto = new TipoProducto();
        this.tipoProducto.setIdTipoProducto(idTipoProducto);
        tipoProductoDAO.eliminar(this.tipoProducto);
    }
}
