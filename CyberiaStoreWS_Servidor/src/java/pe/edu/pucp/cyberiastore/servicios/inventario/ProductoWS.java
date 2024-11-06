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
    
    @WebMethod(operationName = "producto_insertar2")
    public Integer producto_insertar2(@WebParam(name ="producto") Producto producto,
                                     @WebParam(name = "precio") Double precio) {
        this.producto = producto;
        this.producto.setPrecio(precio);
        this.producto.setIdMarca(1);
        this.producto.setIdProveedor(1);
        this.producto.setIdSede(1);
        this.producto.setIdTipo(1);
        this.producto.setCantidad(10);
        this.producto.setPrecioProveedor(11.0);
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
}
