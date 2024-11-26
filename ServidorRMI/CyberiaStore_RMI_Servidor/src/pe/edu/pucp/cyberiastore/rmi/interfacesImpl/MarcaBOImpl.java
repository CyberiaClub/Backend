package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.rmi.interfaces.MarcaBO;

public class MarcaBOImpl extends UnicastRemoteObject implements MarcaBO {
    
    private pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO marcaBO;
    
    public MarcaBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.marcaBO = new pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO();
    }

    @Override
    public Integer insertar(Marca marca) throws RemoteException {
        return this.marcaBO.insertar(marca);
    }

    @Override
    public Integer eliminar(Marca marca) throws RemoteException {
        return this.marcaBO.eliminar(marca);
    }

    @Override
    public ArrayList<Marca> listarTodos() throws RemoteException {
        return this.marcaBO.listarTodos();
    }

    @Override
    public Marca obtenerPorIdPorId(Integer idMarca) throws RemoteException {
        return this.marcaBO.obtenerPorId(idMarca);
    }
}
