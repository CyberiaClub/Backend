package pe.edu.pucp.cyberiastore.metodopago.bo;

import pe.edu.pucp.cyberiastore.metodopago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.metodopago.daoImpl.BoletaDAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.model.Boleta;
import pe.edu.pucp.cyberiastore.metodopago.model.MetodoDePago;

public class BoletaBO {

    private BoletaDAO boletaDAO;

    public BoletaBO() {
        this.boletaDAO = new BoletaDAOImpl();
    }

    public Integer insertar(Boleta boleta) {
        MetodoDePagoBO metodoBO = new MetodoDePagoBO();
        Integer id = metodoBO.insertar((MetodoDePago) boleta);
        boleta.setIdMetodoDePago(id);//guardamos el METODO DE PAGO
        id = this.boletaDAO.insertar(boleta);
        this.boletaDAO.insertarIdBoleta(id);
        return id;
        // falta insertar BOLETA_X_CLIENTE
    }

}
