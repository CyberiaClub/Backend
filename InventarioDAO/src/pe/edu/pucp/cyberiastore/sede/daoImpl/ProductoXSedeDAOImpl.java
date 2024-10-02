package pe.edu.pucp.cyberiastore.sede.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.sede.dao.ProductoXSedeDAO;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
public class ProductoXSedeDAOImpl extends DAOImpl implements ProductoXSedeDAO{
    private Integer idProducto;
    private Integer idSede;
    private Integer cantidadStock;

    public ProductoXSedeDAOImpl() {
        super("PRODUCTO_X_SEDE");
    }
    
    @Override
    protected String obtenerListaAtributos() {
        return "ID_PRODUCTO,ID_SEDE,STOCK_SEDE";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.idProducto + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.idSede + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.cantidadStock + "'");
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
    public Integer insertar(Integer idProducto, Integer idSede, Integer cantidad) {
        this.idProducto = idProducto;
        this.idSede = idSede;
        this.cantidadStock = cantidad;
        return this.insertar();
    }

    @Override
    public Integer eliminar(Integer idProducto, Integer idSede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProducto(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarSede(Integer isSede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> buscarProcutosPorSede(Integer idSede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Sede> buscarSedePorProducto(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
