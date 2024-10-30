package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProveedorDAOImpl;

@WebService(serviceName = "ProveedorWS")
public class ProveedorWS {
    
    private final ProveedorDAO proveedorDAO;
    private Proveedor proveedor;
    
    public ProveedorWS(){
        this.proveedorDAO = new ProveedorDAOImpl();
    }
    
    @WebMethod(operationName = "proveedor_insertar")
    public Integer proveedor_insertar(@WebParam(name = "ruc") String ruc,@WebParam(name = "nombre") String nombre, @WebParam(name = "razonSocial") String razonSocial, 
                                      @WebParam(name = "correo") String correo,@WebParam(name = "telefono") String telefono,
                                      @WebParam(name = "direccion") String direccion, @WebParam(name = "descripcion") String descripcion) {
        this.proveedor = new Proveedor(ruc,nombre,razonSocial,correo,telefono,direccion,descripcion);
        return proveedorDAO.insertar(this.proveedor);
    }
    
    @WebMethod(operationName = "proveedor_modificar")
    public Integer proveedor_modificar(@WebParam(name = "ruc") String ruc,@WebParam(name = "nombre") String nombre, @WebParam(name = "razonSocial") String razonSocial, 
                                      @WebParam(name = "correo") String correo,@WebParam(name = "telefono") String telefono,
                                      @WebParam(name = "direccion") String direccion, @WebParam(name = "descripcion") String descripcion) {
        this.proveedor = new Proveedor(ruc,nombre,razonSocial,correo,telefono,direccion,descripcion);
        return proveedorDAO.modificar(this.proveedor);
    }
    
    @WebMethod(operationName = "proveedor_listar")
    public ArrayList<Proveedor> proveedor_listar() {
        return proveedorDAO.listarTodos();
    }
    
    @WebMethod(operationName = "proveedor_eliminar")
    public void proveedor_eliminar(@WebParam(name = "idProveedor") Integer idProveedor) {
        this.proveedor = new Proveedor();
        this.proveedor.setIdProveedor(idProveedor);
        proveedorDAO.eliminar(this.proveedor);
    }
    
    @WebMethod(operationName = "proveedor_buscarIdPorNombre")
    public Integer proveedor_buscarIdPorNombre(@WebParam(name = "Proveedor") Proveedor proveedor, @WebParam(name = "abreConexion") Boolean abreConexion) {
        this.proveedor = proveedor;
        return proveedorDAO.buscarIdPorNombre(this.proveedor, abreConexion);
    }
}
