package pe.edu.pucp.cyberiastore.servicios.trabajador;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AdministradorDAOImpl;

@WebService(serviceName = "AdministradorWS")
public class AdministradorWS {

    private final AdministradorDAO administradorDAO;
    private Administrador administrador;

    public AdministradorWS() {
        this.administradorDAO = new AdministradorDAOImpl();
    }

    @WebMethod(operationName = "administrador_insertar")
    public Integer administrador_insertar(@WebParam(name = "documento") String documento,@WebParam(name = "telefono") String telefono,@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "apellidoPaterno") String apellidoPaterno,@WebParam(name = "apellidoMaterno") String apellidoMaterno,@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
                                          @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion,@WebParam(name = "contrasenha") String contrasenha,
                                          @WebParam(name = "nacionalidad") String nacionalidad,@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento,@WebParam(name = "sueldo") Double sueldo,
                                          @WebParam(name = "fechaIngreso") Date fechaIngreso, @WebParam(name = "idSede") Integer idSede) {
        this.administrador = new Administrador(documento,telefono,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,
                                               direccion,contrasenha,nacionalidad,tipoDocumento,sueldo,fechaIngreso,idSede);
        return administradorDAO.insertar(this.administrador);
    }

    @WebMethod(operationName = "administrador_modificar")
    public Integer administrador_modificar(@WebParam(name = "documento") String documento,@WebParam(name = "telefono") String telefono,@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "apellidoPaterno") String apellidoPaterno,@WebParam(name = "apellidoMaterno") String apellidoMaterno,@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
                                          @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion,@WebParam(name = "contrasenha") String contrasenha,
                                          @WebParam(name = "nacionalidad") String nacionalidad,@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento,@WebParam(name = "sueldo") Double sueldo,
                                          @WebParam(name = "fechaIngreso") Date fechaIngreso, @WebParam(name = "idSede") Integer idSede) {
        this.administrador = new Administrador(documento,telefono,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,
                                               direccion,contrasenha,nacionalidad,tipoDocumento,sueldo,fechaIngreso,idSede);
        return administradorDAO.modificar(this.administrador);
    }

    @WebMethod(operationName = "administrador_listar")
    public ArrayList<Administrador> administrador_listar() {
        return administradorDAO.listarTodos();
    }
}
