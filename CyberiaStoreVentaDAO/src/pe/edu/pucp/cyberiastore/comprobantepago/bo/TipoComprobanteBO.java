package pe.edu.pucp.cyberiastore.comprobantepago.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.dao.TipoComprobanteDAO;
import pe.edu.pucp.cyberiastore.comprobantepago.daoImpl.TipoComprobanteDAOImpl;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;

public class TipoComprobanteBO {
    private TipoComprobanteDAO tipoComprobanteDAO;
    
    public TipoComprobanteBO(){
        this.tipoComprobanteDAO = new TipoComprobanteDAOImpl();
    }

    public ArrayList<TipoComprobante> listarTodos(){
        ArrayList<TipoComprobante> tiposComprobante = this.tipoComprobanteDAO.listarTodos();
        return tiposComprobante;
    }
}
