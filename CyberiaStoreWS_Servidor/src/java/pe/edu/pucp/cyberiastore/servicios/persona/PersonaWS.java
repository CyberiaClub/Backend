package pe.edu.pucp.cyberiastore.servicios.persona;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.cyberiastore.persona.model.Persona;
import pe.edu.pucp.cyberiastore.persona.bo.PersonaBO;

@WebService(serviceName = "PersonaWS", targetNamespace = "CyberiaWS")
public class PersonaWS {

    private final PersonaBO personaBO;
    private Persona persona;

    public PersonaWS() {
        this.personaBO = new PersonaBO();
    }

    @WebMethod(operationName = "persona_insertar")
    public Integer persona_insertar(@WebParam(name = "persona") Persona persona) {
        this.persona = persona;
        return personaBO.insertar(this.persona);
    }

    @WebMethod(operationName = "persona_modificar")
    public Integer persona_modificar(@WebParam(name = "persona") Persona persona) {
        this.persona = persona;
        return personaBO.modificar(this.persona);
    }

    @WebMethod(operationName = "persona_buscar_por_documento")
    public Persona obtenerPorDocumento(@WebParam(name = "documento") String documento) {
        return personaBO.obtenerPorDocumento(documento);
    }

    @WebMethod(operationName = "persona_enviar_correo_verificacion")
    public Boolean persona_enviar_correo_verificacion(@WebParam(name = "correo") String correo) {
        return personaBO.enviarCorreoVerificacion(correo);
    }

    @WebMethod(operationName = "persona_verificar_correo")
    public void persona_verificar_correo(@WebParam(name = "valorToken") String valorToken) {
        personaBO.marcarVerificado(valorToken);
    }
}
