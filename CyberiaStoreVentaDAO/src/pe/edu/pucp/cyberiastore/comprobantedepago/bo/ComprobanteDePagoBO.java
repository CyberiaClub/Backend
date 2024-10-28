package pe.edu.pucp.cyberiastore.comprobantedepago.bo;

import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.ComprobanteDePagoDAOImpl;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.ComprobanteDePago;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.ComprobanteDePagoDAO;


public class ComprobanteDePagoBO {
    private ComprobanteDePagoDAO metodoDAO;

    public ComprobanteDePagoBO() {
        this.metodoDAO = new ComprobanteDePagoDAOImpl();
    }
    public Integer insertar(ComprobanteDePago metodo){
        return this.metodoDAO.insertar(metodo);
    }
}
