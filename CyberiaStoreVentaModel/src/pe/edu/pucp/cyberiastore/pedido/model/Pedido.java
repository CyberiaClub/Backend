package pe.edu.pucp.cyberiastore.pedido.model;

import java.util.ArrayList;
import java.util.Map;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public class Pedido {
    private Integer idPedido;
    private EstadoPedido estadoPedido;
    private ArrayList<Map.Entry<Producto,Integer>> productosCantidad;
    
    public Pedido(){
        this.estadoPedido = EstadoPedido.EN_PREPARACION;
    }
    
    public Pedido(EstadoPedido estadoPedido) {
        this.estadoPedido = EstadoPedido.EN_PREPARACION;
    }

    public Integer getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
    
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    /**
     * @return the productosCantidad
     */
    public ArrayList<Map.Entry<Producto,Integer>> getProductosCantidad() {
        return productosCantidad;
    }

    /**
     * @param productosCantidad the productosCantidad to set
     */
    public void setProductosCantidad(ArrayList<Map.Entry<Producto,Integer>> productosCantidad) {
        this.productosCantidad = productosCantidad;
    }
    
}
