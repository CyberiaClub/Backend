package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
import pe.edu.pucp.cyberiastore.proveedor.bo.ProveedorBO;

@WebService(serviceName = "ProveedorWS")
public class ProveedorWS {
<<<<<<< Updated upstream
    
    private final ProveedorBO proveedorBO;
    private Proveedor proveedor;
    
    public ProveedorWS(){
        this.proveedorBO = new ProveedorBO();
=======

    private final ProveedorDAO proveedorDAO;
    private Proveedor proveedor;

    public ProveedorWS() {
        this.proveedorDAO = new ProveedorDAOImpl();
>>>>>>> Stashed changes
    }

    @WebMethod(operationName = "proveedor_insertar")
<<<<<<< Updated upstream
    public Integer proveedor_insertar(@WebParam(name = "proveedor") Proveedor proveedor) {
        this.proveedor = proveedor;
        return proveedorBO.insertar(this.proveedor);
=======
    public Integer proveedor_insertar(@WebParam(name = "ruc") String ruc, @WebParam(name = "nombre") String nombre, @WebParam(name = "razonSocial") String razonSocial,
            @WebParam(name = "correo") String correo, @WebParam(name = "telefono") String telefono,
            @WebParam(name = "direccion") String direccion, @WebParam(name = "descripcion") String descripcion) {
        this.proveedor = new Proveedor(ruc, nombre, razonSocial, correo, telefono, direccion, descripcion);
        return proveedorDAO.insertar(this.proveedor);
>>>>>>> Stashed changes
    }

    @WebMethod(operationName = "proveedor_modificar")
<<<<<<< Updated upstream
    public Integer proveedor_modificar(@WebParam(name = "proveedor") Proveedor proveedor) {
        this.proveedor = proveedor;
        return proveedorBO.modificar(this.proveedor);
=======
    public Integer proveedor_modificar(@WebParam(name = "ruc") String ruc, @WebParam(name = "nombre") String nombre, @WebParam(name = "razonSocial") String razonSocial,
            @WebParam(name = "correo") String correo, @WebParam(name = "telefono") String telefono,
            @WebParam(name = "direccion") String direccion, @WebParam(name = "descripcion") String descripcion) {
        this.proveedor = new Proveedor(ruc, nombre, razonSocial, correo, telefono, direccion, descripcion);
        return proveedorDAO.modificar(this.proveedor);
>>>>>>> Stashed changes
    }

    @WebMethod(operationName = "proveedor_listar")
    public ArrayList<Proveedor> proveedor_listar() {
        return proveedorBO.listarTodos();
    }

    @WebMethod(operationName = "proveedor_eliminar")
<<<<<<< Updated upstream
    public void proveedor_eliminar(@WebParam(name = "proveedor") Proveedor proveedor) {
=======
    public void proveedor_eliminar(@WebParam(name = "idProveedor") Integer idProveedor) {
        this.proveedor = new Proveedor();
        this.proveedor.setIdProveedor(idProveedor);
        proveedorDAO.eliminar(this.proveedor);
    }

    @WebMethod(operationName = "proveedor_buscarIdPorNombre")
    public Integer proveedor_buscarIdPorNombre(@WebParam(name = "Proveedor") Proveedor proveedor, @WebParam(name = "abreConexion") Boolean abreConexion) {
>>>>>>> Stashed changes
        this.proveedor = proveedor;
        proveedorBO.eliminar(this.proveedor);
    }
}
