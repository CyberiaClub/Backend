package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Sede;
import pe.edu.pucp.cyberiastore.rmi.interfaces.SedeBO;

public class SedeBOImpl extends UnicastRemoteObject implements SedeBO {

    private pe.edu.pucp.cyberiastore.inventario.bo.SedeBO sedeBO;

    public SedeBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.sedeBO = new pe.edu.pucp.cyberiastore.inventario.bo.SedeBO();
    }

    @Override
    public Integer insertar(Sede sede) throws RemoteException {
        return this.sedeBO.insertar(sede);
    }

    @Override
    public Integer modificar(Sede sede) throws RemoteException {
        return this.sedeBO.modificar(sede);
    }

    @Override
    public Integer eliminar(Sede sede) throws RemoteException {
        return this.sedeBO.eliminar(sede);
    }

    @Override
    public ArrayList<Sede> listarTodos() throws RemoteException {
        return this.sedeBO.listarTodos();
    }

    @Override
    public ArrayList<Producto> listarProductosSede(Integer idSede) throws RemoteException {
        return this.sedeBO.listarProductosSede(idSede);
    }

    @Override
    public Sede obtenerPorId(Integer idSede) throws RemoteException {
        return this.sedeBO.obtenerPorId(idSede);
    }
}
