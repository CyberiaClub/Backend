package pe.edu.pucp.cyberiastore.comprobantepago.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;

public interface TipoComprobanteDAO {

    public ArrayList<TipoComprobante> listarTodos();

    public Boolean existeComprobantePago(TipoComprobante tipoComprobante);
}
