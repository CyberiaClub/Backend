package pe.edu.pucp.cyberiastore.pedido.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.pedido.model.LineaDePedido;

public interface LineaDePedidoDAO {
    public Integer insertar(LineaDePedido lineaPedido);
    
    public Integer modificar(LineaDePedido lineaPedido);
    
    public Integer eliminar(LineaDePedido lineaPedido);
    
    public ArrayList<LineaDePedido> listar(String sql);
    
    public ArrayList<LineaDePedido> listarTodos();
    
    public LineaDePedido obtenerPorId(String idLineaPedido);
}
