package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ProductoBO;

public class ProductoBOImpl extends UnicastRemoteObject implements ProductoBO {

    private pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO productoBO;
    
    public ProductoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.productoBO = new pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO();
    }

    @Override
    public Integer insertar(Producto producto) throws RemoteException {
        return this.productoBO.insertar(producto);
    }

    @Override
    public Integer modificar(Producto producto) throws RemoteException {
        return this.productoBO.modificar(producto);
    }

    @Override
    public Integer eliminar(Producto producto) throws RemoteException {
        return this.productoBO.eliminar(producto);
    }

    @Override
    public ArrayList<Producto> listarTodos() throws RemoteException {
        return this.productoBO.listarTodos();
    }

    @Override
    public Producto buscarPorId(String idProducto) throws RemoteException {
        return this.productoBO.buscarPorId(idProducto);
    }

    @Override
    public Producto buscar_sku(String sku, Integer idSede) throws RemoteException {
        return this.productoBO.buscar_sku(sku, idSede);
    }

    @Override
    public Integer aumentarStock(Integer idProducto, Integer idSede, Integer cantidad) throws RemoteException {
        return this.productoBO.aumentarStock(idProducto, idSede, cantidad);
    }

    @Override
    public ArrayList<Producto> lineasPedido(Integer idPedido) throws RemoteException {
        return this.productoBO.lineasPedido(idPedido);
    }
}
