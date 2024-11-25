package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import pe.edu.pucp.cyberiastore.persona.model.Persona;
import pe.edu.pucp.cyberiastore.rmi.interfaces.PersonaBO;

public class PersonaBOImpl extends UnicastRemoteObject implements PersonaBO {

    private pe.edu.pucp.cyberiastore.persona.bo.PersonaBO personaBO;
    
    public PersonaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.personaBO = new pe.edu.pucp.cyberiastore.persona.bo.PersonaBO();
    }

    @Override
    public Integer insertar(Persona persona) throws RemoteException {
        return this.personaBO.insertar(persona);
    }

    @Override
    public Integer modificar(Persona persona) throws RemoteException {
        return this.personaBO.modificar(persona);
    }

    @Override
    public Integer marcarVerificado(String valorToken) throws RemoteException {
        return this.personaBO.marcarVerificado(valorToken);
    }

    @Override
    public Persona obtenerPorDocumento(String documento) throws RemoteException {
        return this.personaBO.obtenerPorDocumento(documento);
    }

    @Override
    public Boolean enviarCorreoVerificacion(String correo, String valorToken) throws RemoteException {
        return this.personaBO.enviarCorreoVerificacion(correo,valorToken);
    }

    @Override
    public Persona verificarPersona(String correo, String contrasena) throws RemoteException {
        return this.personaBO.verificarPersona(correo,contrasena);
    }
}
