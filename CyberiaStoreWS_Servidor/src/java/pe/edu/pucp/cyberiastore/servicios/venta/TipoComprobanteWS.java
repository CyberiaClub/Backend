package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;
import pe.edu.pucp.cyberiastore.comprobantepago.bo.TipoComprobanteBO;

@WebService(serviceName = "TipoComprobanteWS",targetNamespace = "CyberiaWS")
public class TipoComprobanteWS {
    
    private final TipoComprobanteBO tipoComprobanteBO;
    private TipoComprobante tipoComprobante;
    
    public TipoComprobanteWS() {
        this.tipoComprobanteBO = new TipoComprobanteBO();
    }

    @WebMethod(operationName = "tipo_comprobante_listar")
    public ArrayList<TipoComprobante> oferta_listar() {
        return tipoComprobanteBO.listarTodos();
    }
}
