package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;
import pe.edu.pucp.cyberiastore.rmi.interfaces.OfertaBO;

public class OfertaBOImpl extends UnicastRemoteObject implements OfertaBO {

    private pe.edu.pucp.cyberiastore.oferta.bo.OfertaBO ofertaBO;

    public OfertaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.ofertaBO = new pe.edu.pucp.cyberiastore.oferta.bo.OfertaBO();
    }

    @Override
    public Integer insertar(Oferta oferta) throws RemoteException {
        return this.ofertaBO.insertar(oferta);
    }

    @Override
    public Integer modificar(Oferta oferta) throws RemoteException {
        return this.ofertaBO.modificar(oferta);
    }

    @Override
    public Integer eliminar(Oferta oferta) throws RemoteException {
        return this.ofertaBO.eliminar(oferta);
    }

    @Override
    public ArrayList<Oferta> listarTodos() throws RemoteException {
        return this.ofertaBO.listarTodos();
    }

    @Override
    public Oferta obtenerPorId(Integer idOferta) throws RemoteException {
        return this.ofertaBO.obtenerPorId(idOferta);
    }
}
