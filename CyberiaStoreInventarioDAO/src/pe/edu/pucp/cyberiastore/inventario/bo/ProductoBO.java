package pe.edu.pucp.cyberiastore.inventario.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.ProductoDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.MarcaDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXMarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.ProductoXMarcaDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.TipoProductoDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXTipoDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.ProductoXTipoDAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;
import pe.edu.pucp.cyberiastore.sede.daoImpl.SedeDAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.ProductoXSedeDAO;
import pe.edu.pucp.cyberiastore.sede.daoImpl.ProductoXSedeDAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProductoXProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProductoXProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.ProductoXProductoDAOImpl;

public class ProductoBO {
    ProductoDAO productoDAO;
    ProductoXProductoDAO productoXProductoDAO;
    
    
    public ProductoBO(){
        this.productoDAO = new ProductoDAOImpl();
        this.productoXProductoDAO = new ProductoXProductoDAOImpl();
    }
    
    public Integer insertar(String sku, String nombre, String descripcion, Double precio, String unidad){
        Producto producto = new Producto(sku,nombre,descripcion,precio,unidad);
        return this.productoDAO.insertar(producto);
    }
    
    public Integer insertar(Producto producto){
        Integer response = this.productoDAO.insertar(producto);
        for(Producto miembro : producto.getMiembros().keySet()){
            this.productoXProductoDAO.insertar(producto.getIdProducto(),miembro.getIdProducto(),producto.getMiembros().get(miembro));
        }
        return response;
    }
    
    public Integer modificar(String sku, String nombre, String descripcion, Double precio, String unidad){
        Producto producto = new Producto(sku,nombre,descripcion,precio,unidad);
        return this.productoDAO.modificar(producto);
    }
    
    public Integer modificar(Producto producto){
        Integer response = this.productoDAO.modificar(producto);
        return response;
    }
    
    public Integer eliminar(String sku, String nombre, String descripcion, Double precio, String unidad){
        Producto producto = new Producto(sku,nombre,descripcion,precio,unidad);
        return this.productoDAO.eliminar(producto);
    }
    
    public Integer eliminar(Producto producto){
        Integer response = this.productoDAO.eliminar(producto);
        return response;
    }
    
    public ArrayList<Producto> listarTodos(){
        ArrayList<Producto> productos = this.productoDAO.listarTodos();
        return productos;
    }
    
    public Producto buscarPorId(String idProducto){
        Producto producto = this.productoDAO.obtenerPorId(idProducto);
        return producto;
    }
}
    
