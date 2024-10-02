package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXTipoDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;


public class ProductoXTipoDAOImpl extends DAOImpl implements ProductoXTipoDAO {
    private Integer idProducto;
    private Integer idTipoProducto;
    
    public ProductoXTipoDAOImpl() {
        super("PRODUCTO_X_TIPO");
    }

    @Override
    protected String obtenerListaAtributos() {
        return "ID_PRODUCTO,ID_TIPO_PRODUCTO";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.idProducto + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.idTipoProducto + "'");
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
    public Integer insertar(Integer idProducto, Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        this.idProducto = idProducto;
        return this.insertar();
    }

    @Override
    public Integer eliminar(Integer idProducto, Integer idTipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarTipoProducto(Integer idTipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProducto(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> buscarProductoPorTipo(Integer idTipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TipoProducto> buscarTipoPorProducto(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
