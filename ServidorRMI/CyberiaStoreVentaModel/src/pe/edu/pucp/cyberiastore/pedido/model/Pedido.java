package pe.edu.pucp.cyberiastore.pedido.model;

import pe.edu.pucp.cyberiastore.comprobantepago.model.EstadoPedido;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public class Pedido {

    private Integer idPedido;
    private EstadoPedido estadoPedido;
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    private ArrayList<Double> precios;

    public Pedido() {
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

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(ArrayList<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public ArrayList<Double> getPrecios() {
        return precios;
    }

    public void setPrecios(ArrayList<Double> precios) {
        this.precios = precios;
    }

}
