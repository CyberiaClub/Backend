package pe.edu.pucp.pedido;


public class Pedido {
    private static Integer idPedido = 0;
    private EstadoPedido estadoPedido;

    public Pedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    
}
