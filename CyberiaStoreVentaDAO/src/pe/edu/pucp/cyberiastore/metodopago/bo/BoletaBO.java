package pe.edu.pucp.cyberiastore.metodopago.bo;

import pe.edu.pucp.cyberiastore.metodopago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.BoletaDAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.model.Boleta;
import pe.edu.pucp.cyberiastore.metodopago.model.ComprobanteDePago;

public class BoletaBO {

    private BoletaDAO boletaDAO;

    public BoletaBO() {
        this.boletaDAO = new BoletaDAOImpl();
    }
}
