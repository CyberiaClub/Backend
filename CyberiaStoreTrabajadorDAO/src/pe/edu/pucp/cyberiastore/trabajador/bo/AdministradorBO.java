package pe.edu.pucp.cyberiastore.trabajador.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AdministradorDAOImpl;

public class AdministradorBO {

    private AdministradorDAO administradorDAO;

    public AdministradorBO() {
        this.administradorDAO = new AdministradorDAOImpl();
    }

     public Integer insertar(Administrador administrador){
        return this.administradorDAO.insertar(administrador);
    }
    
    public Integer modificar(Administrador administrador){
        return this.administradorDAO.modificar(administrador);
    }

    public Integer eliminar(Administrador administrador){
        return this.administradorDAO.eliminar(administrador);
    }

    public ArrayList<Administrador> listarTodos(){
        ArrayList<Administrador> administradores = this.administradorDAO.listarTodos();
        return administradores;
    }

    public Administrador obtenerPorId(Integer idAdministrador){
        Administrador administrador = this.administradorDAO.obtenerPorId(idAdministrador);
        return administrador;
    }
}
