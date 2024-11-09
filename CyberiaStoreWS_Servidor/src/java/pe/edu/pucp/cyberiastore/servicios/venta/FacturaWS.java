package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Factura;
import pe.edu.pucp.cyberiastore.comprobantedepago.bo.FacturaBO;

@WebService(serviceName = "FacturaWS",targetNamespace = "CyberiaWS")
public class FacturaWS {

    private final FacturaBO facturaBO;
    private Factura factura;

    public FacturaWS() {
        this.facturaBO = new FacturaBO();
    }

    @WebMethod(operationName = "factura_insertar")
    public Integer factura_insertar(@WebParam(name = "factura") Factura factura){
        this.factura = factura;
        return facturaBO.insertar(this.factura);
    }

    @WebMethod(operationName = "factura_listar")
    public ArrayList<Factura> factura_listar() {
        return facturaBO.listarTodos();
    }
    
    @WebMethod(operationName = "factura_eliminar")
    public void factura_eliminar(@WebParam(name = "factura") Factura factura) {
        this.factura = factura;
        facturaBO.eliminar(this.factura);
    }
}
