package pe.edu.pucp.cyberiastore.servicios.usuario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.bo.ClienteBO;

@WebService(serviceName = "ClienteWS",targetNamespace = "CyberiaWS")
public class ClienteWS {

    private final ClienteBO clienteBO;
    private Cliente cliente;

    public ClienteWS() {
        this.clienteBO = new ClienteBO();
    }

    @WebMethod(operationName = "cliente_insertar")
    public Integer cliente_insertar(@WebParam(name = "cliente") Cliente cliente) {
        this.cliente = cliente;
        return clienteBO.insertar(this.cliente);
    }

    @WebMethod(operationName = "cliente_modificar")
    public Integer cliente_modificar(@WebParam(name = "cliente") Cliente cliente){
        this.cliente = cliente;
        return clienteBO.modificar(this.cliente);
    }

    @WebMethod(operationName = "cliente_listar")
    public ArrayList<Cliente> cliente_listar() {
        return clienteBO.listarTodos();
    }
    
    @WebMethod(operationName = "cliente_buscar_por_documento")
    public Cliente cliente_buscar_por_documento(@WebParam(name = "documento") String documento) {
        return clienteBO.buscarPorDocumento(documento);
    }
    
}
