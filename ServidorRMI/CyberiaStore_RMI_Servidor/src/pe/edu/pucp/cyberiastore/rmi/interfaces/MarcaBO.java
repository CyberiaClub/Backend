package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;

public interface MarcaBO extends Remote {
    public Integer insertar(Marca marca) throws RemoteException;
    
    public Integer eliminar(Marca marca) throws RemoteException;
    
    public ArrayList<Marca> listarTodos() throws RemoteException;
    
    public Marca obtenerPorIdPorId(Integer idMarca) throws RemoteException;
}
