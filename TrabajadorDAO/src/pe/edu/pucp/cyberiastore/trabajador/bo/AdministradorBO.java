package pe.edu.pucp.cyberiastore.trabajador.bo;

import pe.edu.pucp.Trabajador.trabajador.model.Administrador;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AdministradorDAOImpl;



public class AdministradorBO {
    private AdministradorDAO administradorDAO;
    
    public AdministradorBO(){
        this.administradorDAO = new AdministradorDAOImpl();
    }
    
    public Integer insertar(Administrador administrador){
        TrabajadorBO trabajadorBO = new TrabajadorBO();
        Integer idTrabajador = trabajadorBO.insertar((Trabajador)administrador);
        if(idTrabajador == null){
            return null;
        }
        administrador.setIdTrabajador(idTrabajador);
        Integer idAdministrador = this.administradorDAO.insertar(administrador);
        this.administradorDAO.insertarIdAdministrador(idAdministrador);
        return idAdministrador;
                
    }
}
