package pe.edu.pucp.cyberiastore.trabajador.bo;

import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorXSedeDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.TrabajadorXSedeDAOImpl;


public class TrabajadorXSedeBO {
    private TrabajadorXSedeDAO trabajadorSedeDAO;

    public TrabajadorXSedeBO() {
        this.trabajadorSedeDAO = new TrabajadorXSedeDAOImpl();
    }
    
    public Integer insertar(Integer idTrabajador, Integer idSede){
        return this.trabajadorSedeDAO.insertar(idTrabajador, idSede);
    }
    
}
