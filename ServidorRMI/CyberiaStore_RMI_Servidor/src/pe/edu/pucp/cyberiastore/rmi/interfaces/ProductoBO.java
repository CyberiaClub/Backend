package pe.edu.pucp.cyberiastore.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public interface ProductoBO extends Remote {
    public Integer insertar(Producto producto) throws RemoteException;

    public Integer modificar(Producto producto) throws RemoteException;

    public Integer eliminar(Producto producto) throws RemoteException;

    public ArrayList<Producto> listarTodos() throws RemoteException;

    public Producto obtenerPorIdPorId(String idProducto) throws RemoteException;
    
    public Producto obtenerPorId_sku(String sku, Integer idSede) throws RemoteException;
    
    public Integer aumentarStock(Integer idProducto, Integer idSede, Integer cantidad) throws RemoteException;
    
    public ArrayList<Producto> lineasPedido(Integer idPedido) throws RemoteException;
}
