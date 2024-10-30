package pe.edu.pucp.cyberiastore.servicios.trabajador;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.VendedorDAOImpl;

@WebService(serviceName = "VendedorWS")
public class VendedorWS {

    private final VendedorDAO vendedorDAO;
    private Vendedor vendedor;

    public VendedorWS() {
        this.vendedorDAO = new VendedorDAOImpl();
    }

    @WebMethod(operationName = "vendedor_insertar")
    public Integer vendedor_insertar(@WebParam(name = "documento") String documento,@WebParam(name = "telefono") String telefono,@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "apellidoPaterno") String apellidoPaterno,@WebParam(name = "apellidoMaterno") String apellidoMaterno,@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
                                          @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion,@WebParam(name = "contrasenha") String contrasenha,
                                          @WebParam(name = "nacionalidad") String nacionalidad,@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento,@WebParam(name = "sueldo") Double sueldo,
                                          @WebParam(name = "fechaIngreso") Date fechaIngreso, @WebParam(name = "idSede") Integer idSede) {
        this.vendedor = new Vendedor(documento,telefono,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,
                                               direccion,contrasenha,nacionalidad,tipoDocumento,sueldo,fechaIngreso,idSede);
        return vendedorDAO.insertar(this.vendedor);
    }

    @WebMethod(operationName = "vendedor_modificar")
    public Integer vendedor_modificar(@WebParam(name = "documento") String documento,@WebParam(name = "telefono") String telefono,@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "apellidoPaterno") String apellidoPaterno,@WebParam(name = "apellidoMaterno") String apellidoMaterno,@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
                                          @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion,@WebParam(name = "contrasenha") String contrasenha,
                                          @WebParam(name = "nacionalidad") String nacionalidad,@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento,@WebParam(name = "sueldo") Double sueldo,
                                          @WebParam(name = "fechaIngreso") Date fechaIngreso, @WebParam(name = "idSede") Integer idSede) {
        this.vendedor = new Vendedor(documento,telefono,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,
                                               direccion,contrasenha,nacionalidad,tipoDocumento,sueldo,fechaIngreso,idSede);
        return vendedorDAO.modificar(this.vendedor);
    }

    @WebMethod(operationName = "vendedor_listar")
    public ArrayList<Vendedor> vendedor_listar() {
        return vendedorDAO.listarTodos();
    }
}
