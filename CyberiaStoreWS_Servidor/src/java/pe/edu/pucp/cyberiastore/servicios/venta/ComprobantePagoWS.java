package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.ComprobantePago;
import pe.edu.pucp.cyberiastore.comprobantepago.bo.ComprobantePagoBO;

@WebService(serviceName = "ComprobantePagoWS",targetNamespace = "CyberiaWS")
public class ComprobantePagoWS {
    
    private final ComprobantePagoBO comprobantePagoBO;
    private ComprobantePago comprobantePago;
    
    public ComprobantePagoWS() {
        this.comprobantePagoBO = new ComprobantePagoBO();
    }

    @WebMethod(operationName = "comprobante_pago_listar")
    public ArrayList<ComprobantePago> comprobante_pago_listar() {
        return comprobantePagoBO.listarTodos();
    }

    @WebMethod(operationName = "comprobante_pago_insertar")
    public Integer comprobante_pago_insertar(@WebParam(name = "comprobante_pago") ComprobantePago comprobante_pago) {
        this.comprobantePago = comprobante_pago;
        return comprobantePagoBO.insertar(this.comprobantePago);
    }
}