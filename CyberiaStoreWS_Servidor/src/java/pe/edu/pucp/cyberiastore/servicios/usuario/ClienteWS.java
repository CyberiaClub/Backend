package pe.edu.pucp.cyberiastore.servicios.usuario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.usuario.dao.ClienteDAO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.ClienteDAOImpl;

@WebService(serviceName = "ClienteWS")
public class ClienteWS {

    private final ClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteWS() {
        this.clienteDAO = new ClienteDAOImpl();
    }

    @WebMethod(operationName = "cliente_insertar")
    public Integer cliente_insertar(@WebParam(name = "documento") String documento,@WebParam(name = "telefono") String telefono,@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "apellidoPaterno") String apellidoPaterno,@WebParam(name = "apellidoMaterno") String apellidoMaterno,@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
                                          @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion,@WebParam(name = "contrasenha") String contrasenha,
                                          @WebParam(name = "nacionalidad") String nacionalidad,@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento) {
        this.cliente = new Cliente(documento,telefono,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,
                                               direccion,contrasenha,nacionalidad,tipoDocumento);
        return clienteDAO.insertar(this.cliente);
    }

    @WebMethod(operationName = "cliente_modificar")
    public Integer cliente_modificar(@WebParam(name = "documento") String documento,@WebParam(name = "telefono") String telefono,@WebParam(name = "nombre") String nombre,
                                          @WebParam(name = "apellidoPaterno") String apellidoPaterno,@WebParam(name = "apellidoMaterno") String apellidoMaterno,@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
                                          @WebParam(name = "correo") String correo, @WebParam(name = "direccion") String direccion,@WebParam(name = "contrasenha") String contrasenha,
                                          @WebParam(name = "nacionalidad") String nacionalidad,@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento,@WebParam(name = "verificado") Boolean verificado) {
        this.cliente = new Cliente(documento,telefono,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,
                                   direccion,contrasenha,nacionalidad,tipoDocumento);
        this.cliente.setVerificado(verificado);
        return clienteDAO.modificar(this.cliente);
    }

    @WebMethod(operationName = "cliente_listar")
    public ArrayList<Cliente> cliente_listar() {
        return clienteDAO.listarTodos();
    }
}
