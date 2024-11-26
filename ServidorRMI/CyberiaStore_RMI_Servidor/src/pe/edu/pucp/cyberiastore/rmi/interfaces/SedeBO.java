package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Sede;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public interface SedeBO extends Remote {
    public Integer insertar(Sede sede) throws RemoteException;
    
    public Integer modificar(Sede sede) throws RemoteException;

    public Integer eliminar(Sede sede) throws RemoteException;

    public ArrayList<Sede> listarTodos() throws RemoteException;
    
    public ArrayList<Producto> listarProductosSede(Integer idSede) throws RemoteException;

    public Sede obtenerPorId(Integer idSede) throws RemoteException;
}
