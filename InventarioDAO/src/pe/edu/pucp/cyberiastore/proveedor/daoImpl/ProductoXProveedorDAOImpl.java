package pe.edu.pucp.cyberiastore.proveedor.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProductoXProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;

public class ProductoXProveedorDAOImpl extends DAOImpl implements ProductoXProveedorDAO {

    private Integer idProducto;
    private Integer idProveedor;
    private Double precioProveedor;

    public ProductoXProveedorDAOImpl() {
        super("PRODUCTO_X_PROVEEDOR");
    }

    @Override
    protected String obtenerListaAtributos() {
        return "ID_PRODUCTO,ID_PROVEEDOR,PRECIO_PROVEEDOR";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.idProducto + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.idProveedor + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.precioProveedor + "'");
        return sql;
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
    public Integer insertar(Integer idProducto, Integer idProveedor, Double precioProveedor) {
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.precioProveedor = precioProveedor;
        return this.insertar();
    }

    @Override
    public Integer eliminar(Integer idProducto, Integer idProveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProveedor(Integer idProveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProducto(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Proveedor> buscarProveedoresPorSku(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> buscarProductoProRuc(Integer idProveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
