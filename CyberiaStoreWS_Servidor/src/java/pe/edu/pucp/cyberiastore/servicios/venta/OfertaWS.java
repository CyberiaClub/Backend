package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;
import pe.edu.pucp.cyberiastore.oferta.dao.OfertaDAO;
import pe.edu.pucp.cyberiastore.oferta.daoImpl.OfertaDAOImpl;

@WebService(serviceName = "OfertaWS")
public class OfertaWS {

    private final OfertaDAO ofertaDAO;
    private Oferta oferta;

    public OfertaWS() {
        this.ofertaDAO = new OfertaDAOImpl();
    }

    @WebMethod(operationName = "oferta_insertar")
    public Integer oferta_insertar(@WebParam(name = "fechaInicio") Date fechaInicio, @WebParam(name = "fechaFin") Date fechaFin, @WebParam(name = "porcentaje") Integer porcentaje) {
        this.oferta = new Oferta(fechaInicio, fechaFin, porcentaje);
        return ofertaDAO.insertar(this.oferta);
    }

    @WebMethod(operationName = "oferta_modificar")
    public Integer oferta_modificar(@WebParam(name = "fechaInicio") Date fechaInicio, @WebParam(name = "fechaFin") Date fechaFin, @WebParam(name = "porcentaje") Integer porcentaje) {
        this.oferta = new Oferta(fechaInicio, fechaFin, porcentaje);
        return ofertaDAO.modificar(this.oferta);
    }

    @WebMethod(operationName = "oferta_listar")
    public ArrayList<Oferta> oferta_listar() {
        return ofertaDAO.listarTodos();
    }
}
