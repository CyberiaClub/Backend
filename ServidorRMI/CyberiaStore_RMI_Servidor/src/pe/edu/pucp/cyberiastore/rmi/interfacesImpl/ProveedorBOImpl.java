package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ProveedorBO;

public class ProveedorBOImpl extends UnicastRemoteObject implements ProveedorBO {

    private pe.edu.pucp.cyberiastore.inventario.bo.ProveedorBO proveedorBO;
    
    public ProveedorBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.proveedorBO = new pe.edu.pucp.cyberiastore.inventario.bo.ProveedorBO();
    }

    @Override
    public Integer insertar(Proveedor proveedor) throws RemoteException {
        return this.proveedorBO.insertar(proveedor);
    }

    @Override
    public Integer modificar(Proveedor proveedor) throws RemoteException {
        return this.proveedorBO.modificar(proveedor);
    }

    @Override
    public Integer eliminar(Proveedor proveedor) throws RemoteException {
        return this.proveedorBO.eliminar(proveedor);
    }

    @Override
    public ArrayList<Proveedor> listarTodos() throws RemoteException {
        return this.proveedorBO.listarTodos();
    }

    @Override
    public Proveedor obtenerPorId(Integer idProveedor) throws RemoteException {
        return this.proveedorBO.obtenerPorId(idProveedor);
    }
}
