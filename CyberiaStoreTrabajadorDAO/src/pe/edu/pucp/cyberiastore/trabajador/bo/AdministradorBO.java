package pe.edu.pucp.cyberiastore.trabajador.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
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

    public Integer modificar(Integer idAdministrador,Integer idTrabajador, Double sueldo, Date fechaDeIngreso, Integer idUsuario, String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        Administrador administrador = new Administrador(idAdministrador,idTrabajador, sueldo, fechaDeIngreso, idUsuario, documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        return this.administradorDAO.modificar(administrador);
    }

    public Administrador obtenerPorId(Integer idAdministrador) {
        return this.administradorDAO.obtenerPorId(idAdministrador);
    }

    public ArrayList<Administrador> listarTodos() {
        return this.administradorDAO.listarTodos();
    }
}
