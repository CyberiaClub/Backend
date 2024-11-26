package pe.edu.pucp.cyberiastore.oferta.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.oferta.dao.OfertaDAO;
import pe.edu.pucp.cyberiastore.oferta.daoImpl.OfertaDAOImpl;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;

public class OfertaBO {

    private OfertaDAO ofertaDAO;

    public OfertaBO() {
        this.ofertaDAO = new OfertaDAOImpl();
    }

    public Integer insertar(Oferta oferta) {
        return this.ofertaDAO.insertar(oferta);
    }

    public Integer modificar(Oferta oferta) {
        return this.ofertaDAO.modificar(oferta);
    }

    public Integer eliminar(Oferta oferta) {
        return this.ofertaDAO.eliminar(oferta);
    }

    public ArrayList<Oferta> listarTodos() {
        ArrayList<Oferta> ofertaes = this.ofertaDAO.listarTodos();
        return ofertaes;
    }

    public Oferta obtenerPorId(Integer idOferta) {
        Oferta oferta = this.ofertaDAO.obtenerPorId(idOferta);
        return oferta;
    }

}
