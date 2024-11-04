package pe.edu.pucp.cyberiastore.trabajador.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AlmaceneroDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class AlmaceneroBO {

    private AlmaceneroDAO almaceneroDAO;

    public AlmaceneroBO() {
        this.almaceneroDAO = new AlmaceneroDAOImpl();
    }

    public Integer insertar(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo,
            String direccion, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento, Double sueldo, Date fechaDeIngreso, Integer idSede) {
        Almacenero almacenero = new Almacenero(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento, sueldo, fechaDeIngreso, idSede);
        return this.almaceneroDAO.insertar(almacenero);
    }

    public Integer modificar(Integer idAlmacenero,Integer idTrabajador, Double sueldo, Date fechaDeIngreso, Integer idUsuario, String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        Almacenero almacenero = new Almacenero(idAlmacenero,idTrabajador, sueldo, fechaDeIngreso, idUsuario, documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        return this.almaceneroDAO.modificar(almacenero);
    }

    public Almacenero obtenerPorId(Integer idAlmacenero) {
        return this.almaceneroDAO.obtenerPorId(idAlmacenero);
    }

    public ArrayList<Almacenero> listarTodos() {
        return this.almaceneroDAO.listarTodos();
    }
}
