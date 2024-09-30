package pe.edu.pucp.cyberiastore.proveedor.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProductoXProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
public class ProductoXProveedorDAOImpl extends DAOImpl implements ProductoXProveedorDAO{
    private String sku;
    private String ruc;

    public ProductoXProveedorDAOImpl() {
        super("PRODUCTO_X_PROVEEDOR");
    }

    @Override
    protected String obtenerListaAtributos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerCondicionPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer insertar(String sku, String ruc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(String sku, String ruc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProveedor(String ruc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProducto(String sku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Proveedor> buscarProveedoresPorSku(String sku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> buscarProductoProRuc(String ruc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
