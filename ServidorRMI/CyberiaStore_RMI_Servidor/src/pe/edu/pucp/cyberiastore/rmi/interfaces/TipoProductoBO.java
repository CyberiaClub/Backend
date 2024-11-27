package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public interface TipoProductoBO extends Remote {

    public Integer insertar(TipoProducto tipoProducto) throws RemoteException;

    public Integer modificar(TipoProducto tipoProducto) throws RemoteException;

    public Integer eliminar(TipoProducto tipoProducto) throws RemoteException;

    public ArrayList<TipoProducto> listarTodos() throws RemoteException;

    public TipoProducto obtenerPorIdPorId(Integer idTipoProducto) throws RemoteException;
}
