package pe.edu.pucp.cyberiastore.oferta.bo;

import java.util.Date;
import pe.edu.pucp.cyberiastore.oferta.dao.OfertaDAO;
import pe.edu.pucp.cyberiastore.oferta.daoImpl.OfertaDAOImpl;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;


public class OfertaBO {
    private OfertaDAO ofertaDAO;
    
    public OfertaBO(){
        this.ofertaDAO = new OfertaDAOImpl();
    }
    
//    public Integer insertar(Date fechaInicio, Date fechaFin, Integer porcentaje){
//        Oferta oferta = new Oferta(fechaInicio,fechaFin,porcentaje);
//        return this.ofertaDAO.insertar(oferta);
//    }
//    
//    public Integer insertar(Oferta oferta){
//        return this.ofertaDAO.insertar(oferta);
//    }
//    
//    public Integer modificar(Date fechaInicio, Date fechaFin, Integer porcentaje){
//        Oferta oferta = new Oferta(fechaInicio,fechaFin,porcentaje);
//        return this.ofertaDAO.modificar(oferta);
//    }
//    
//    public Integer eliminar(Date fechaInicio, Date fechaFin, Integer porcentaje){
//        Oferta oferta = new Oferta(fechaInicio,fechaFin,porcentaje);
//        return this.ofertaDAO.eliminar(oferta);
//    }
    
}