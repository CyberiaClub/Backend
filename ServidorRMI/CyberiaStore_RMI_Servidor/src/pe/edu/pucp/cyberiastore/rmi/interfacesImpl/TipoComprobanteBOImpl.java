package pe.edu.pucp.cyberiastore.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoComprobanteBO;

public class TipoComprobanteBOImpl extends UnicastRemoteObject implements TipoComprobanteBO {

    private pe.edu.pucp.cyberiastore.comprobantepago.bo.TipoComprobanteBO tipoComprobanteBO;

    public TipoComprobanteBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.tipoComprobanteBO = new pe.edu.pucp.cyberiastore.comprobantepago.bo.TipoComprobanteBO();
    }

    @Override
    public ArrayList<TipoComprobante> listarTodos() throws RemoteException {
        return this.tipoComprobanteBO.listarTodos();
    }
}
