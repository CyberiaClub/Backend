package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;
import pe.edu.pucp.cyberiastore.inventario.bo.ProveedorBO;

@WebService(serviceName = "ProveedorWS",targetNamespace = "CyberiaWS")
public class ProveedorWS {
    
    private final ProveedorBO proveedorBO;
    private Proveedor proveedor;
    
    public ProveedorWS(){
        this.proveedorBO = new ProveedorBO();
    }
    
    @WebMethod(operationName = "proveedor_insertar")
    public Integer proveedor_insertar(@WebParam(name = "proveedor") Proveedor proveedor) {
        this.proveedor = proveedor;
        return proveedorBO.insertar(this.proveedor);
    }
    
    @WebMethod(operationName = "proveedor_modificar")
    public Integer proveedor_modificar(@WebParam(name = "proveedor") Proveedor proveedor) {
        this.proveedor = proveedor;
        return proveedorBO.modificar(this.proveedor);
    }
    
    @WebMethod(operationName = "proveedor_listar")
    public ArrayList<Proveedor> proveedor_listar() {
        return proveedorBO.listarTodos();
    }
    
    @WebMethod(operationName = "proveedor_eliminar")
    public void proveedor_eliminar(@WebParam(name = "proveedor") Proveedor proveedor) {
        this.proveedor = proveedor;
        proveedorBO.eliminar(this.proveedor);
    }
}