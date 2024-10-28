package pe.edu.pucp.cyberiastore.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;

public interface ClienteDAO {

    public Integer insertar(Cliente cliente);

    public Integer modificar(Cliente cliente);

    public Integer eliminar(Cliente cliente);

    public ArrayList<Cliente> listarTodos();

    public Cliente obtenerPorId(Integer idCliente);

    public Boolean existeCliente(Cliente cliente);

    public Boolean existeCliente(Cliente cliente, Boolean abreConexion);
}
