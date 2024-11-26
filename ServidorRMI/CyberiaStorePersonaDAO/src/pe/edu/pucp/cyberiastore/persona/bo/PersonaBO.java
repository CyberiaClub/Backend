package pe.edu.pucp.cyberiastore.persona.bo;

import pe.edu.pucp.cyberiastore.persona.dao.PersonaDAO;
import pe.edu.pucp.cyberiastore.persona.daoImpl.PersonaDAOImpl;
import pe.edu.pucp.cyberiastore.persona.model.Persona;

public class PersonaBO {

    private PersonaDAO personaDAO;

    public PersonaBO() {
        this.personaDAO = new PersonaDAOImpl();
    }

    public Integer insertar(Persona persona) {
        return this.personaDAO.insertar(persona);
    }

    public Integer modificar(Persona persona) {
        return this.personaDAO.modificar(persona);
    }

    public Integer marcarVerificado(String valorToken) {
        return this.personaDAO.marcarVerificado(valorToken);
    }

    public Persona obtenerPorDocumento(String documento) {
        return this.personaDAO.obtenerPorDocumento(documento);
    }

    public Boolean enviarCorreoVerificacion(String correo, String valorToken) {
        return this.personaDAO.enviarCorreoVerificacion(correo, valorToken);
    }

    public Persona verificarPersona(String correo, String contrasena) {
        Persona persona = new Persona();
        persona.setCorreo(correo);
        persona.setContrasena(contrasena);
        return this.personaDAO.verificarPersona(persona);
    }
}
