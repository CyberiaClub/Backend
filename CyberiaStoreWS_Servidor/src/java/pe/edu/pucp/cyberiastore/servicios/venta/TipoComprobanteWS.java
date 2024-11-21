    package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.bo.TipoComprobanteBO;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;

@WebService(serviceName = "TipoComprobanteWS", targetNamespace = "CyberiaWS")
public class TipoComprobanteWS {

    private final TipoComprobanteBO tipoComprobanteBO;
    private TipoComprobante tipoComprobante;

    public TipoComprobanteWS() {
        this.tipoComprobanteBO = new TipoComprobanteBO();
    }

    @WebMethod(operationName = "tipo_comprobante_listar")
    public ArrayList<TipoComprobante> tipo_comprobante_listar() {
        return tipoComprobanteBO.listarTodos();
    }
}
