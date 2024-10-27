package pe.edu.pucp.cyberiastore.metodopago.bo;

import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.ComprobanteDePagoDAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.model.ComprobanteDePago;
import pe.edu.pucp.cyberiastore.metodopago.dao.ComprobanteDePagoDAO;


public class ComprobanteDePagoBO {
    private ComprobanteDePagoDAO metodoDAO;

    public ComprobanteDePagoBO() {
        this.metodoDAO = new ComprobanteDePagoDAOImpl();
    }
    public Integer insertar(ComprobanteDePago metodo){
        return this.metodoDAO.insertar(metodo);
    }
}
