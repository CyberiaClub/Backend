package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;

public interface OfertaBO extends Remote{
    public Integer insertar(Oferta oferta) throws RemoteException;
    
    public Integer modificar(Oferta oferta) throws RemoteException;

    public Integer eliminar(Oferta oferta) throws RemoteException;

    public ArrayList<Oferta> listarTodos() throws RemoteException;

    public Oferta obtenerPorId(Integer idOferta) throws RemoteException;
}
