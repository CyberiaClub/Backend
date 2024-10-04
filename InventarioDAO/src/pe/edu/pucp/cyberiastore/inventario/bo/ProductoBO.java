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

public class ProductoBO {
    ProductoDAO productoDAO;
    
    
    public ProductoBO(){
        this.productoDAO = new ProductoDAOImpl();
    }
    
    public Integer insertar(String sku, String nombre, String descripcion, Double precio, String unidad, String tipo, String sede, Integer cantidad, String marca, String rucProveedor, Double precioProveedor){
        Producto producto = new Producto(sku, nombre, descripcion, precio, unidad);
        Integer id = this.productoDAO.insertar(producto);
        
        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
        ProductoXProveedorDAO prodXProvDAO = new ProductoXProveedorDAOImpl();
        Integer id2 = prodXProvDAO.insertar(id,proveedorDAO.obtenerIdPorRuc(rucProveedor), precioProveedor);
        
        MarcaDAO marcaDAO = new MarcaDAOImpl();
        ProductoXMarcaDAO prodXMarcaDAO = new ProductoXMarcaDAOImpl();
        id2 += prodXMarcaDAO.insertar(id, marcaDAO.obtenerIdPorNombre(marca));
        
        TipoProductoDAO tipoProdDAO = new TipoProductoDAOImpl();
        ProductoXTipoDAO prodXTipoDAO = new ProductoXTipoDAOImpl();
        id2+= prodXTipoDAO.insertar(id, tipoProdDAO.obtenerIdPorTipo(tipo));
        
        SedeDAO sedeDAO = new SedeDAOImpl();
        ProductoXSedeDAO prodXSedeDAO = new ProductoXSedeDAOImpl();
        id2+= prodXSedeDAO.insertar(id, sedeDAO.obtenerIdPorNombre(sede), cantidad);
        
        return id;
    }
    
    public Integer modificar(String sku, String nombre, String descripcion, Double precio, String unidad, ArrayList<Producto> productoMiembro){
        Producto producto = new Producto(sku, nombre, descripcion, precio, unidad);
        return this.productoDAO.modificar(producto);
    }
    
    public Integer eliminar(String sku, String nombre, String descripcion, Double precio, String unidad, ArrayList<Producto> productoMiembro){
        Producto producto = new Producto(sku, nombre, descripcion, precio, unidad);
        return this.productoDAO.eliminar(producto);
    }
    
    public ArrayList<Producto> listarTodos(){
        ArrayList<Producto> productos = this.productoDAO.listarTodos();
        
        return productos;
    }
    
    public Producto buscarPorId(Integer idProducto){
        Producto producto = this.productoDAO.obtenerPorId(""+idProducto);
        
        return producto;
    }
}
    
