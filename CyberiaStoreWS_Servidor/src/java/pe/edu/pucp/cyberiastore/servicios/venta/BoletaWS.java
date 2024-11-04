    package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Boleta;
import pe.edu.pucp.cyberiastore.comprobantedepago.bo.BoletaBO;

@WebService(serviceName = "BoletaWS")
public class BoletaWS {

    private final BoletaBO boletaBO;
    private Boleta boleta;

    public BoletaWS() {
        this.boletaBO = new BoletaBO();
    }

    @WebMethod(operationName = "boleta_insertar")
    public Integer boleta_insertar(@WebParam(name = "boleta") Boleta boleta){
        this.boleta = boleta;
        return boletaBO.insertar(this.boleta);
    }

    @WebMethod(operationName = "boleta_listar")
    public ArrayList<Boleta> boleta_listar() {
        return boletaBO.listarTodos();
    }
    
    @WebMethod(operationName = "boleta_eliminar")
    public void boleta_eliminar(@WebParam(name = "boleta") Boleta boleta) {
        this.boleta = boleta;
        boletaBO.eliminar(this.boleta);
    }
}
