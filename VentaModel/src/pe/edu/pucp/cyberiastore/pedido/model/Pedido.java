package pe.edu.pucp.cyberiastore.pedido.model;


public class Pedido {
    private Integer idPedido;
    private EstadoPedido estadoPedido;
    
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
    
}
