package pe.edu.pucp.cyberiastore.inventario.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.ProductoDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public class ProductoBO {

    ProductoDAO productoDAO;

    public ProductoBO() {
        this.productoDAO = new ProductoDAOImpl();
    }

    public Integer insertar(String sku, String nombre, String descripcion, Double precio, ArrayList<Producto> productoMiembros,byte[] imagenBytes) {
        Producto producto = new Producto(sku, nombre, descripcion, precio, productoMiembros,imagenBytes);
        return this.productoDAO.insertar(producto);
    }

    public Integer insertar(Producto producto) {
        Integer response = this.productoDAO.insertar(producto);

        return response;
    }

    public Integer modificar(String sku, String nombre, String descripcion, Double precio) {
        Producto producto = new Producto(sku, nombre, descripcion, precio);
        return this.productoDAO.modificar(producto);
    }

    public Integer modificar(Producto producto) {
        Integer response = this.productoDAO.modificar(producto);
        return response;
    }

    public Integer eliminar(String sku, String nombre, String descripcion, Double precio) {
        Producto producto = new Producto(sku, nombre, descripcion, precio);
        return this.productoDAO.eliminar(producto);
    }

    public Integer eliminar(Producto producto) {
        Integer response = this.productoDAO.eliminar(producto);
        return response;
    }

    public ArrayList<Producto> listarTodos() {
        ArrayList<Producto> productos = this.productoDAO.listarTodos();
        return productos;
    }

    public Producto buscarPorId(String idProducto) {
        Producto producto = this.productoDAO.obtenerPorId(idProducto);
        return producto;
    }
}
