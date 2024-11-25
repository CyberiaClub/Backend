package pe.edu.pucp.cyberiastore.servicios.persona;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.bo.TipoPersonaBO;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;
import pe.edu.pucp.cyberiastore.persona.pagina.Pagina;

@WebService(serviceName = "TipoPersonaWS", targetNamespace = "CyberiaWS")
public class TipoPersonaWS {

    private final TipoPersonaBO tipoPersonaBO;

    public TipoPersonaWS() {
        this.tipoPersonaBO = new TipoPersonaBO();
    }@WebMethod(operationName = "tipopersona_listar_roles_trabajadores")
    public ArrayList<TipoPersona> tipopersona_listar_roles_trabajadores() {
        return this.tipoPersonaBO.listarRolesDeTrabajadores();
    }
    
    @WebMethod(operationName = "tipopersona_listar_paginas")
    public TipoPersona tipopersona_listar_paginas(@WebParam(name = "tipo_persona")String tipo_persona) {
        return this.tipoPersonaBO.listarPaginas(tipo_persona);
    }
    
}
