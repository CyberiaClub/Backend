package pe.edu.pucp.cyberiastore.sede.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.sede.dao.ProductoXSedeDAO;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
public class ProductoXSedeDAOImpl extends DAOImpl implements ProductoXSedeDAO{
    private String sku;
    private int idSede;

    public ProductoXSedeDAOImpl() {
        super("PRODUCTO_X_SEDE");
    }
    
    @Override
    protected String obtenerListaAtributos() {
        return "SKU,ID_SEDE";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.sku + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.idSede + "'");
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
    public Integer insertar(String sku, int idSede) {
        this.sku = sku;
        this.idSede = idSede;
        return this.insertar();
    }

    @Override
    public Integer eliminar(String sku, int idSede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarProducto(String sku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminarSede(String isSede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> buscarProcutosPorSede(int idSede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Sede> buscarSedePorProducto(String sku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
