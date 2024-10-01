package pe.edu.pucp.cyberiastore.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;

public interface ClienteDAO {
    
    public Integer insertar(Cliente cliente);
    
    public Integer modificar(Cliente cliente);
    
    public Integer eliminar(Boolean activo);
    
    public ArrayList<Cliente> listar(String sql);
    
    public ArrayList<Cliente> listarTodos();
    
    public Cliente obtenerPorId(String idCliente);
}