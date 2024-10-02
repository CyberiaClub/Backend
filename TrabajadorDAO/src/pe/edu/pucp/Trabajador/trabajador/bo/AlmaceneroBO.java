package pe.edu.pucp.Trabajador.trabajador.bo;

import pe.edu.pucp.Trabajador.trabajador.model.Almacenero;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AlmaceneroDAOImpl;


public class AlmaceneroBO {
    private AlmaceneroDAO almaceneroDAO;
    
    public AlmaceneroBO(){
        this.almaceneroDAO = new AlmaceneroDAOImpl();
    }
    
    public Integer insertar(Almacenero administrador){
        TrabajadorBO trabajadorBO = new TrabajadorBO();
        Integer idTrabajador = trabajadorBO.insertar((Trabajador)administrador);
        if(idTrabajador == null){
            return null;
        }
        administrador.setIdTrabajador(idTrabajador);
        Integer idAlmacenero = this.almaceneroDAO.insertar(administrador);
        this.almaceneroDAO.insertarIdAlmacenero(idAlmacenero);
        
        
        
        return idAlmacenero;
    }
}
