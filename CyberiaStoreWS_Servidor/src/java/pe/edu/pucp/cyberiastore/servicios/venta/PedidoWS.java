package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;
import pe.edu.pucp.cyberiastore.pedido.bo.PedidoBO;

@WebService(serviceName = "PedidoWS")
public class PedidoWS {
    
    private final PedidoBO pedidoBO;
    private Pedido pedido;
    
    public PedidoWS(){
        this.pedidoBO = new PedidoBO();
    }
    
    @WebMethod(operationName = "pedido_insertar")
    public Integer pedido_insertar(@WebParam(name = "pedido") Pedido pedido) {
        this.pedido = pedido;
        return pedidoBO.insertar(this.pedido);
    }
    
    @WebMethod(operationName = "pedido_modificar")
    public Integer pedido_modificar(@WebParam(name = "pedido") Pedido pedido) {
        this.pedido = pedido;
        return pedidoBO.modificar(this.pedido);
    }
    
    @WebMethod(operationName = "pedido_listar")
    public ArrayList<Pedido> pedido_listar() {
        return pedidoBO.listarTodos();
    }
    
    @WebMethod(operationName = "pedido_eliminar")
    public void pedido_eliminar(@WebParam(name = "pedido") Pedido pedido) {
        this.pedido = pedido;
        pedidoBO.eliminar(this.pedido);
    }
    
}
