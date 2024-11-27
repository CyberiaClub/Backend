package pe.edu.pucp.cyberiastore.comprobantepago.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.ComprobantePago;
import pe.edu.pucp.cyberiastore.comprobantepago.dao.ComprobantePagoDAO;
import pe.edu.pucp.cyberiastore.comprobantepago.daoImpl.ComprobantePagoDAOImpl;

public class ComprobantePagoBO {

    private ComprobantePagoDAO comprobantePagoDAO;

    public ComprobantePagoBO() {
        this.comprobantePagoDAO = new ComprobantePagoDAOImpl();
    }

    public Integer insertar(ComprobantePago oferta) {
        return this.comprobantePagoDAO.insertar(oferta);
    }

    public Integer modificar(ComprobantePago oferta) {
        return this.comprobantePagoDAO.modificar(oferta);
    }

    public Integer eliminar(ComprobantePago oferta) {
        return this.comprobantePagoDAO.eliminar(oferta);
    }

    public ArrayList<ComprobantePago> listarTodos() {
        ArrayList<ComprobantePago> comprobantesPago = this.comprobantePagoDAO.listarTodos();
        return comprobantesPago;
    }

    public ComprobantePago obtenerPorId(Integer idComprobantePago) {
        ComprobantePago comprobantePago = this.comprobantePagoDAO.obtenerPorId(idComprobantePago);
        return comprobantePago;
    }

    public ArrayList<ComprobantePago> buscarPersona(Integer idPersona) {
        ArrayList<ComprobantePago> comprobantesPago = this.comprobantePagoDAO.buscarPorUsuario(idPersona);
        return comprobantesPago;
    }

    public ArrayList<ComprobantePago> buscarSede(Integer idSede) {
        ArrayList<ComprobantePago> comprobantesPago = this.comprobantePagoDAO.buscarPorSede(idSede);
        return comprobantesPago;
    }
}
