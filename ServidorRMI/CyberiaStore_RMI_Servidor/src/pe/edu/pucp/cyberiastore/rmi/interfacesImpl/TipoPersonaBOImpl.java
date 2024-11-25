package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoPersonaBO;

public class TipoPersonaBOImpl extends UnicastRemoteObject implements TipoPersonaBO {

    private pe.edu.pucp.cyberiastore.persona.bo.TipoPersonaBO tipoPersonaBO;
    
    public TipoPersonaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.tipoPersonaBO = new pe.edu.pucp.cyberiastore.persona.bo.TipoPersonaBO();
    }

    @Override
    public ArrayList<TipoPersona> listarRolesDeTrabajadores() throws RemoteException {
        return this.tipoPersonaBO.listarRolesDeTrabajadores();
    }

    @Override
    public TipoPersona listarPaginas(String tipo_persona) throws RemoteException {
        return this.tipoPersonaBO.listarPaginas(tipo_persona);
    }
}
