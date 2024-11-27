package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;

public interface TipoComprobanteBO extends Remote {

    public ArrayList<TipoComprobante> listarTodos() throws RemoteException;
}
