package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;

public interface ProveedorBO extends Remote {

    public Integer insertar(Proveedor proveedor) throws RemoteException;

    public Integer modificar(Proveedor proveedor) throws RemoteException;

    public Integer eliminar(Proveedor proveedor) throws RemoteException;

    public ArrayList<Proveedor> listarTodos() throws RemoteException;

    public Proveedor obtenerPorId(Integer idProveedor) throws RemoteException;
}
