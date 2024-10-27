package pe.edu.pucp.cyberiastore.trabajador.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AdministradorDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class AdministradorBO {

    private AdministradorDAO administradorDAO;

    public AdministradorBO() {
        this.administradorDAO = new AdministradorDAOImpl();
    }

    public Integer insertar(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo,
            String direccion, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento, Double sueldo, Date fechaDeIngreso, Integer idSede) {
        Administrador administrador = new Administrador(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento, sueldo, fechaDeIngreso, idSede);
        return this.administradorDAO.insertar(administrador);
    }
    
    public ArrayList<Administrador> listarTodos(){
        return this.administradorDAO.listarTodos();
    }
}
