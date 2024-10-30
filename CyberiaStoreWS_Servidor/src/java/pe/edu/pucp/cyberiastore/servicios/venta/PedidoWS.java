package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;
import pe.edu.pucp.cyberiastore.pedido.model.EstadoPedido;
import pe.edu.pucp.cyberiastore.pedido.dao.PedidoDAO;
import pe.edu.pucp.cyberiastore.pedido.daoImpl.PedidoDAOImpl;

@WebService(serviceName = "PedidoWS")
public class PedidoWS {
    
    private final PedidoDAO pedidoDAO;
    private Pedido pedido;
    
    public PedidoWS(){
        this.pedidoDAO = new PedidoDAOImpl();
    }
    
    @WebMethod(operationName = "pedido_insertar")
    public Integer pedido_insertar(@WebParam(name = "estado") EstadoPedido estado, @WebParam(name = "productos") ArrayList<Producto> productos, @WebParam(name = "cantidades") ArrayList<Integer> cantidades) {
        this.pedido = new Pedido(estado);
        //Setear los arrayList en el pedido una vez esté corregido el model
        return pedidoDAO.insertar(this.pedido);
    }
    
    @WebMethod(operationName = "pedido_modificar")
    public Integer pedido_modificar(@WebParam(name = "estado") EstadoPedido estado, @WebParam(name = "productos") ArrayList<Producto> productos, @WebParam(name = "cantidades") ArrayList<Integer> cantidades) {
        this.pedido = new Pedido(estado);
        return pedidoDAO.modificar(this.pedido);
    }
    
    @WebMethod(operationName = "pedido_listar")
    public ArrayList<Pedido> pedido_listar() {
        return pedidoDAO.listarTodos();
    }
    
    @WebMethod(operationName = "pedido_eliminar")
    public void pedido_eliminar(@WebParam(name = "idPedido") Integer idPedido) {
        this.pedido = new Pedido();
        this.pedido.setIdPedido(idPedido);
        pedidoDAO.eliminar(this.pedido);
    }
    
}
