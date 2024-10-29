package pe.edu.pucp.cyberiastore.comprobantedepago.bo;

import pe.edu.pucp.cyberiastore.comprobantedepago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.BoletaDAOImpl;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Boleta;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.ComprobanteDePago;

public class BoletaBO {

    private BoletaDAO boletaDAO;

    public BoletaBO() {
        this.boletaDAO = new BoletaDAOImpl();
    }
}
