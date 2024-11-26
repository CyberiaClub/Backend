package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Sede;
import pe.edu.pucp.cyberiastore.inventario.dao.StockSedeDAO;

public class StockSedeDAOImpl extends DAOImpl implements StockSedeDAO {

    private Integer idProducto;
    private Integer idSede;
    private Integer cantidadStock;

    public StockSedeDAOImpl() {
        super("PRODUCTO_X_SEDE");
    }
    
    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    
    @Override
    public Integer insertar(Integer idProducto, Integer idSede, Integer cantidadStock) {
        this.idProducto = idProducto;
        this.idSede = idSede;
        this.cantidadStock = cantidadStock;
        return super.insertar();
    }

    @Override
    public Integer insertar(Integer idProducto, Integer idSede, Integer cantidadStock, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(idProducto, idSede, cantidadStock);
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "ID_PRODUCTO, ID_SEDE, STOCK_SEDE";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.idProducto);
        this.incluirParametroInt(2, this.idSede);
        this.incluirParametroInt(3, this.cantidadStock);
    }
    
    @Override
    public Integer aumentarStock(Integer idProducto, Integer idSede, Integer stock){
        this.idProducto = idProducto;
        this.idSede = idSede;
        this.cantidadStock = stock;
        return super.modificar();
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "STOCK_SEDE=STOCK_SEDE+?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.cantidadStock);
        this.incluirParametroInt(2, this.idProducto);
        this.incluirParametroInt(3, this.idSede);
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "ID_PRODUCTO=? AND ID_SEDE=?";
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
