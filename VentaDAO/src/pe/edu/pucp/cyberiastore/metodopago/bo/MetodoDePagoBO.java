package pe.edu.pucp.cyberiastore.metodopago.bo;

import pe.edu.pucp.cyberiastore.metodopago.dao.MetodoDePagoDAO;
import pe.edu.pucp.cyberiastore.metodopago.daoImpl.MetodoDePagoDAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.model.MetodoDePago;


public class MetodoDePagoBO {
    private MetodoDePagoDAO metodoDAO;

    public MetodoDePagoBO() {
        this.metodoDAO = new MetodoDePagoDAOImpl();
    }
    public Integer insertar(MetodoDePago metodo){
        return this.metodoDAO.insertar(metodo);
    }
}
