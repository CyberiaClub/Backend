package pe.edu.pucp.pedido;


public class LineaDePedido {
    private static Integer idLineaPedido;
    private Integer cantidad;

    public LineaDePedido(Integer cantidad) {
        this.cantidad = cantidad;
        this.idLineaPedido++;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
