package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXMarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
public class ProductoXMarcaDAOImpl extends DAOImpl implements ProductoXMarcaDAO{
    private Integer idProducto;
    private Integer idMarca;
    
    public ProductoXMarcaDAOImpl() {
        super("PRODUCTO_X_MARCA");
    }

    @Override
    protected String obtenerListaAtributos() {
        return "ID_PRODUCTO,ID_MARCA";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.idProducto + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.idMarca + "'");
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
    public Integer insertar(Integer idProducto, Integer idMarca) {
        this.idProducto = idProducto;
        this.idMarca = idMarca;
        return this.insertar();
    }

    @Override
    public Integer eliminar(Integer idProducto, Integer idMarca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarMarca(Integer idMarca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProducto(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Marca> buscarMarcasPorSku(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> buscarProductosPorIdMarca(Integer idMarca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
