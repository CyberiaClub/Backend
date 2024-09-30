package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXMarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
public class ProductoXMarcaDAOImpl extends DAOImpl implements ProductoXMarcaDAO{
    private String sku;
    private int idMarca;
    
    public ProductoXMarcaDAOImpl() {
        super("PRODUCTO_X_MARCA");
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
    public Integer insertar(String sku, int idMarca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(String sku, int idMarca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarMarca(int idMarca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProducto(String sku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Marca> buscarMarcasPorSku(String sku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> buscarProductosPorIdMarca(int idMarca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
