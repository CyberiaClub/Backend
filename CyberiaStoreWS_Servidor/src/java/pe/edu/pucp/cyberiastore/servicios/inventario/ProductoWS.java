package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;

@WebService(serviceName = "ProductoWS", targetNamespace = "CyberiaWS")
public class ProductoWS {

    private final ProductoBO productoBO;
    private Producto producto;

    public ProductoWS() {
        this.productoBO = new ProductoBO();
    }

    @WebMethod(operationName = "producto_insertar")
    public Integer producto_insertar(@WebParam(name = "producto") Producto producto) {
        this.producto = producto;
        System.out.println(this.producto.getPrecio());
        return productoBO.insertar(this.producto);
    }

    @WebMethod(operationName = "producto_modificar")
    public Integer producto_modificar(@WebParam(name = "producto") Producto producto) {
        this.producto = producto;
        return productoBO.modificar(this.producto);
    }

    @WebMethod(operationName = "producto_listar")
    public ArrayList<Producto> producto_listar() {
        return productoBO.listarTodos();
    }

    @WebMethod(operationName = "producto_buscar_sku")
    public Producto producto_buscar_sku(@WebParam(name = "sku") String sku, @WebParam(name = "idSede") Integer idSede) {
        return productoBO.buscar_sku(sku,idSede);
    }
    
    @WebMethod(operationName = "producto_aumentar_stock")
    public Integer producto_aumentar_stock(@WebParam(name = "idProducto") Integer idProducto, @WebParam(name = "idSede") Integer idSede, @WebParam(name = "cantidad") Integer cantidad) {
        return productoBO.aumentarStock(idProducto, idSede, cantidad);
    }
    
    @WebMethod(operationName = "producto_lineas_pedido")
    public ArrayList<Producto> producto_lineas_pedido(@WebParam(name = "idPedido") Integer idPedido) {
        return productoBO.lineasPedido(idPedido);
    }
}
