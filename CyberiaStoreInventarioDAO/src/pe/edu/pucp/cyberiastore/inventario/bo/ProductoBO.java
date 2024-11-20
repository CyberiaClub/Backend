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

    public Integer insertar(Producto producto) {
        Integer response = this.productoDAO.insertar(producto);
        return response;
    }

    public Integer modificar(Producto producto) {
        Integer response = this.productoDAO.modificar(producto);
        return response;
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
    
    public Producto buscar_sku(String sku, Integer idSede){
        Producto producto = this.productoDAO.buscar_sku(sku, idSede);
        return producto;
    }
    
    public Integer aumentarStock(Integer idProducto,Integer idSede,Integer cantidad){
        return this.productoDAO.aumentarStock(idProducto, idSede, cantidad);
    }
}
