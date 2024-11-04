package pe.edu.pucp.cyberiastore.pedido.model;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;


public class LineaDePedido {
    private Integer idLineaPedido;
    private ArrayList<Producto> productos;
    private Integer cantidad;

    public LineaDePedido(Integer cantidad) {
        this.cantidad = cantidad;
        this.productos = new ArrayList<>();
    }

    public Integer getIdLineaPedido() {
        return idLineaPedido;
    }

    public void setIdLineaPedido(Integer idLineaPedido) {
        this.idLineaPedido = idLineaPedido;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
