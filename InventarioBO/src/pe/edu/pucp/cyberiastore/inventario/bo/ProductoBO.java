package pe.edu.pucp.cyberiastore.inventario.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.ProductoDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public class ProductoBO {
    ProductoDAO productoDAO;
    
    public ProductoBO(){
        this.productoDAO = new ProductoDAOImpl();
    }
    
    public Integer insertar(Integer sku, String nombre, String descripcion, Double precio, String unidad, ArrayList<Producto> productoMiembro){
        Producto producto = new Producto(sku, nombre, descripcion, precio, unidad, productoMiembro);
        return this.productoDAO.insertar(producto);
    }
    
    public Integer modificar(Integer sku, String nombre, String descripcion, Double precio, String unidad, ArrayList<Producto> productoMiembro){
        Producto producto = new Producto(sku, nombre, descripcion, precio, unidad, productoMiembro);
        return this.productoDAO.modificar(producto);
    }
    
    public Integer eliminar(Integer sku, String nombre, String descripcion, Double precio, String unidad, ArrayList<Producto> productoMiembro){
        Producto producto = new Producto(sku, nombre, descripcion, precio, unidad, productoMiembro);
        return this.productoDAO.eliminar(producto);
    }
}
