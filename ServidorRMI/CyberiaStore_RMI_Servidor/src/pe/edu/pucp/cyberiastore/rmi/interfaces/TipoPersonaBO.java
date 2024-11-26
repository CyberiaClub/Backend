package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;

public interface TipoPersonaBO extends Remote {

    public ArrayList<TipoPersona> listarRolesDeTrabajadores() throws RemoteException;

    public TipoPersona listarPaginas(String tipo_persona) throws RemoteException;
}
