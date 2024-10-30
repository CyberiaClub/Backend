package pe.edu.pucp.cyberiastore.pedido.model;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public class Pedido {
    private Integer idPedido;
    private EstadoPedido estadoPedido;
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    private ArrayList<Double> precios;
    
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
     * @return the productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the cantidades
     */
    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    /**
     * @param cantidades the cantidades to set
     */
    public void setCantidades(ArrayList<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    /**
     * @return the precios
     */
    public ArrayList<Double> getPrecios() {
        return precios;
    }

    /**
     * @param precios the precios to set
     */
    public void setPrecios(ArrayList<Double> precios) {
        this.precios = precios;
    }


    
}
