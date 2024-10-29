package pe.edu.pucp.cyberiastore.pedido.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;


public interface PedidoDAO {
    public Integer insertar(Pedido pedido);

    public Integer modificar(Pedido pedido);

    public Integer eliminar(Pedido pedido);

    public ArrayList<Pedido> listarTodos();

    public Pedido obtenerPorId(Integer idPedido);

    public Boolean existePedido(Pedido pedido);

    public Boolean existePedido(Pedido pedido, Boolean abreConexion);
}
