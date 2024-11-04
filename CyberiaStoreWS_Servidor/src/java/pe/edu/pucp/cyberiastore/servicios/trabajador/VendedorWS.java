package pe.edu.pucp.cyberiastore.servicios.trabajador;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.trabajador.bo.VendedorBO;

@WebService(serviceName = "VendedorWS")
public class VendedorWS {

    private final VendedorBO vendedorBO;
    private Vendedor vendedor;

    public VendedorWS() {
        this.vendedorBO = new VendedorBO();
    }

    @WebMethod(operationName = "vendedor_insertar")
    public Integer vendedor_insertar(@WebParam(name = "vendedor") Vendedor vendedor) {
        this.vendedor = vendedor;
        return vendedorBO.insertar(this.vendedor);
    }

    @WebMethod(operationName = "vendedor_modificar")
    public Integer vendedor_modificar(@WebParam(name = "vendedor") Vendedor vendedor) {
        this.vendedor = vendedor;
        return vendedorBO.modificar(this.vendedor);
    }

    @WebMethod(operationName = "vendedor_listar")
    public ArrayList<Vendedor> vendedor_listar() {
        return vendedorBO.listarTodos();
    }
}
