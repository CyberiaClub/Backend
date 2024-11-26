package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.ComprobantePago;

public interface ComprobantePagoBO extends Remote {
    public Integer insertar(ComprobantePago oferta) throws RemoteException;
    
    public Integer modificar(ComprobantePago oferta) throws RemoteException;

    public Integer eliminar(ComprobantePago oferta) throws RemoteException;

    public ArrayList<ComprobantePago> listarTodos() throws RemoteException;

    public ComprobantePago obtenerPorId(Integer idComprobantePago) throws RemoteException;
    
    public ArrayList<ComprobantePago> buscarPersona(Integer idPersona) throws RemoteException;
    
    public ArrayList<ComprobantePago> buscarSede(Integer idSede) throws RemoteException;
}
