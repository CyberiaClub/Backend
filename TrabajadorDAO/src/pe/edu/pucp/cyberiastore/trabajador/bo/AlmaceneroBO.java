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
    
    public Integer insertar(Almacenero almacenero){
        TrabajadorBO trabajadorBO = new TrabajadorBO();
        Integer idTrabajador = trabajadorBO.insertar((Trabajador)almacenero);
        if(idTrabajador == null){
            return null;
        }
        almacenero.setIdTrabajador(idTrabajador);
        Integer idAlmacenero = this.almaceneroDAO.insertar(almacenero);
        this.almaceneroDAO.insertarIdAlmacenero(idAlmacenero);
        return idAlmacenero;
    }
}
