package pe.edu.pucp.cyberiastore.pedido.bo;

import pe.edu.pucp.cyberiastore.pedido.dao.PedidoDAO;
import pe.edu.pucp.cyberiastore.pedido.daoImpl.PedidoDAOImpl;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;


public class PedidoBO {
    private PedidoDAO pedidoDAO;

    public PedidoBO() {
        pedidoDAO = new PedidoDAOImpl();
    }
    
    public Integer insertar(Pedido pedido){
        return this.pedidoDAO.insertar(pedido);
    }
    
}
