package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoProductoBO;

public class TipoProductoBOImpl extends UnicastRemoteObject implements TipoProductoBO {

    private pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO tipoProductoBO;

    public TipoProductoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.tipoProductoBO = new pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO();
    }

    @Override
    public Integer insertar(TipoProducto tipoProducto) throws RemoteException {
        return this.tipoProductoBO.insertar(tipoProducto);
    }

    @Override
    public Integer modificar(TipoProducto tipoProducto) throws RemoteException {
        return this.tipoProductoBO.modificar(tipoProducto);
    }

    @Override
    public Integer eliminar(TipoProducto tipoProducto) throws RemoteException {
        return this.tipoProductoBO.eliminar(tipoProducto);
    }

    @Override
    public ArrayList<TipoProducto> listarTodos() throws RemoteException {
        return this.tipoProductoBO.listarTodos();
    }

    @Override
    public TipoProducto obtenerPorIdPorId(Integer idTipoProducto) throws RemoteException {
        return this.tipoProductoBO.obtenerPorId(idTipoProducto);
    }
}
