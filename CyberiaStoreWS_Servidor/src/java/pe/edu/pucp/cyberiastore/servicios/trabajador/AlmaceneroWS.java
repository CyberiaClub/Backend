package pe.edu.pucp.cyberiastore.servicios.trabajador;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AlmaceneroDAOImpl;

@WebService(serviceName = "AlmaceneroWS")
public class AlmaceneroWS {

    private final AlmaceneroDAO almaceneroDAO;
    private Almacenero almacenero;

    public AlmaceneroWS() {
        this.almaceneroDAO = new AlmaceneroDAOImpl();
    }

    @WebMethod(operationName = "almacenero_insertar")
    public Integer almacenero_insertar(@WebParam(name = "documento") String documento,@WebParam(name = "telefono") String telefono,@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "apellidoPaterno") String apellidoPaterno,@WebParam(name = "apellidoMaterno") String apellidoMaterno,@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
                                          @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion,@WebParam(name = "contrasenha") String contrasenha,
                                          @WebParam(name = "nacionalidad") String nacionalidad,@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento,@WebParam(name = "sueldo") Double sueldo,
                                          @WebParam(name = "fechaIngreso") Date fechaIngreso, @WebParam(name = "idSede") Integer idSede) {
        this.almacenero = new Almacenero(documento,telefono,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,
                                               direccion,contrasenha,nacionalidad,tipoDocumento,sueldo,fechaIngreso,idSede);
        return almaceneroDAO.insertar(this.almacenero);
    }

    @WebMethod(operationName = "almacenero_modificar")
    public Integer almacenero_modificar(@WebParam(name = "documento") String documento,@WebParam(name = "telefono") String telefono,@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "apellidoPaterno") String apellidoPaterno,@WebParam(name = "apellidoMaterno") String apellidoMaterno,@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
                                          @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion,@WebParam(name = "contrasenha") String contrasenha,
                                          @WebParam(name = "nacionalidad") String nacionalidad,@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento,@WebParam(name = "sueldo") Double sueldo,
                                          @WebParam(name = "fechaIngreso") Date fechaIngreso, @WebParam(name = "idSede") Integer idSede) {
        this.almacenero = new Almacenero(documento,telefono,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,
                                               direccion,contrasenha,nacionalidad,tipoDocumento,sueldo,fechaIngreso,idSede);
        return almaceneroDAO.modificar(this.almacenero);
    }

    @WebMethod(operationName = "almacenero_listar")
    public ArrayList<Almacenero> almacenero_listar() {
        return almaceneroDAO.listarTodos();
    }
}
