package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.ComprobantePago;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ComprobantePagoBO;

public class ComprobantePagoBOImpl extends UnicastRemoteObject implements ComprobantePagoBO {

    private pe.edu.pucp.cyberiastore.comprobantepago.bo.ComprobantePagoBO comprobantePagoBO;
    
    public ComprobantePagoBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.comprobantePagoBO = new pe.edu.pucp.cyberiastore.comprobantepago.bo.ComprobantePagoBO();
    }

    @Override
    public Integer insertar(ComprobantePago comprobantePago) throws RemoteException {
        return this.comprobantePagoBO.insertar(comprobantePago);
    }

    @Override
    public Integer modificar(ComprobantePago comprobantePago) throws RemoteException {
        return this.comprobantePagoBO.modificar(comprobantePago);
    }

    @Override
    public Integer eliminar(ComprobantePago comprobantePago) throws RemoteException {
        return this.comprobantePagoBO.eliminar(comprobantePago);
    }

    @Override
    public ArrayList<ComprobantePago> listarTodos() throws RemoteException {
        return this.comprobantePagoBO.listarTodos();
    }

    @Override
    public ComprobantePago obtenerPorId(Integer idComprobantePago) throws RemoteException {
        return this.comprobantePagoBO.obtenerPorId(idComprobantePago);
    }
}
