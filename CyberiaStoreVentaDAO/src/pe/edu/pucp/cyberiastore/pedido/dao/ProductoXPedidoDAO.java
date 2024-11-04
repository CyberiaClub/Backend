package pe.edu.pucp.cyberiastore.pedido.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.pedido.model.LineaDePedido;

public interface ProductoXPedidoDAO {
    public Integer insertar(Integer idProducto, Integer idPedido, Integer cantidad);

    public Integer insertar(Integer idProducto, Integer idPedido, Integer cantidad, Boolean usarTransaccion, Connection conexion);

}
