package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.ProductoDAOImpl;

@WebService(serviceName = "ProductoWS")
public class ProductoWS {
    
    private final ProductoDAO productoDAO;
    private Producto producto;
    
    public ProductoWS(){
        this.productoDAO = new ProductoDAOImpl();
    }
    
    @WebMethod(operationName = "producto_insertar")
    public Integer producto_insertar(@WebParam(name = "sku") String sku, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, 
                                     @WebParam(name = "precio") Double precio, @WebParam(name = "unidad") String unidad,@WebParam(name = "idSede") Integer idSede,
                                     @WebParam(name = "idMarca") Integer idMarca,@WebParam(name = "idProveedor") Integer idProveedor,
                                     @WebParam(name = "idTipoProducto") Integer idTipoProducto, @WebParam(name = "precioProveedor") Double precioProveedor) {
        this.producto = new Producto(sku,nombre,descripcion,precio,unidad);
        this.producto.setIdMarca(idMarca);
        this.producto.setIdSede(idSede);
        this.producto.setIdProveedor(idProveedor);
        this.producto.setIdTipoProducto(idTipoProducto);
        this.producto.setPrecioProveedor(precioProveedor);
        return productoDAO.insertar(this.producto); 
    }
    
    @WebMethod(operationName = "producto_modificar")
    public Integer producto_modificar(@WebParam(name = "sku") String sku, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio") Double precio, @WebParam(name = "unidad") String unidad) {
        this.producto = new Producto(sku,nombre,descripcion,precio,unidad);
        return productoDAO.modificar(this.producto);
    }
    
    @WebMethod(operationName = "producto_listar")
    public ArrayList<Producto> producto_listar() {
        return productoDAO.listarTodos();
    }
}
