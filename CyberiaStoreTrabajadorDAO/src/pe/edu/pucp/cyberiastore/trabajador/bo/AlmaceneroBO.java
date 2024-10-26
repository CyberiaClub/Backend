package pe.edu.pucp.cyberiastore.trabajador.bo;

import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AlmaceneroDAOImpl;


public class AlmaceneroBO {
    private AlmaceneroDAO almaceneroDAO;
    
    public AlmaceneroBO(){
        this.almaceneroDAO = new AlmaceneroDAOImpl();
    }
}
