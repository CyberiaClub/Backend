package pe.edu.pucp.cyberiastore.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.usuario.dao.ClienteDAO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.ClienteDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
public class ClienteBO {

    private ClienteDAO clienteDAO;

    public ClienteBO() {
        clienteDAO = new ClienteDAOImpl();
    }
     public Integer insertar(Cliente cliente){
        return this.clienteDAO.insertar(cliente);
    }
    
    public Integer modificar(Cliente cliente){
        return this.clienteDAO.modificar(cliente);
    }

    public Integer eliminar(Cliente cliente){
        return this.clienteDAO.eliminar(cliente);
    }

    public ArrayList<Cliente> listarTodos(){
        ArrayList<Cliente> clientees = this.clienteDAO.listarTodos();
        return clientees;
    }

    public Cliente obtenerPorId(Integer idCliente){
        Cliente cliente = this.clienteDAO.obtenerPorId(idCliente);
        return cliente;
    }
    
    public Cliente buscarPorDocumento(String documento){
        Cliente cliente = this.clienteDAO.buscarPorDocumento(documento);
        return cliente;
    }
    
}
