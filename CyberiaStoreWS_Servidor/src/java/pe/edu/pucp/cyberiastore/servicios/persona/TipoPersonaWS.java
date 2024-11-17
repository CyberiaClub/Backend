package pe.edu.pucp.cyberiastore.servicios.persona;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.bo.TipoPersonaBO;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;

@WebService(serviceName = "TipoPersonaWS", targetNamespace = "CyberiaWS")
public class TipoPersonaWS {

    private final TipoPersonaBO tipoPersonaBO;

    public TipoPersonaWS() {
        this.tipoPersonaBO = new TipoPersonaBO();
    }

    @WebMethod(operationName = "tipopersona_listar")
    public ArrayList<TipoPersona> listarTodos() {
        return this.tipoPersonaBO.listarTodos();
    }
}
