package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.model.Persona;

public interface PersonaBO extends Remote {

    public Integer insertar(Persona persona) throws RemoteException;

    public Integer modificar(Persona persona) throws RemoteException;

    public Integer modificarUsuario(Persona persona)throws RemoteException;

    public Integer marcarVerificado(String valorToken) throws RemoteException;

    public Persona obtenerPorDocumento(String documento) throws RemoteException;

    public Boolean enviarCorreoVerificacion(String correo, String valorToken) throws RemoteException;

    public Persona verificarPersona(String correo, String contrasena) throws RemoteException;
}
