package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public class ProductoXProductoDAOImpl extends DAOImpl implements ProductoXProductoDAO {

    private Integer idPadre;
    private Integer idHijo;
    private Producto producto;
    private Integer cantidad;

    public ProductoXProductoDAOImpl() {
        super("PRODUCTO_COMPUESTO");
    }
    
    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */

    @Override
    public Integer insertar(Integer idPadre, Integer idHijo, Integer cantidad) {
        this.idPadre = idPadre;
        this.idHijo = idHijo;
        this.cantidad = cantidad;
        return super.insertar();
    }

    /**
     * Esta funcion es utilizada cuando es llamada del propio producto
     *
     * @param idPadre
     * @param idHijo
     * @param cantidad
     * @param usarTransaccion
     * @param conexion
     * @return
     */
    @Override
    public Integer insertar(Integer idPadre, Integer idHijo, Integer cantidad, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(idPadre, idHijo, cantidad);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "ID_PRODUCTO_PADRE,ID_PRODUCTO,CANTIDAD";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.idPadre);
        this.incluirParametroInt(2, this.idHijo);
        this.incluirParametroInt(3, this.cantidad);
    }
    
    /*
     * ************************************************************************
     * LISTADOS
     * ************************************************************************
     */

    @Override
    public ArrayList<Producto> listarPorIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
        return (ArrayList<Producto>)super.listarTodos(null);
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        return "PD.SKU, PD.NOMBRE, PD.DESCRIPCION";
    }
    
    @Override
    protected String obtenerPredicadoParaListado(){
        String sql = "";
        
        sql = sql.concat(" PXP ");
        sql = sql.concat("join PRODUCTO PD on PXP.ID_PRODUCTO = PD.ID_PRODUCTO ");
        sql = sql.concat("where PXP.ID_PRODUCTO_PADRE=?");
        
        return sql;
    }
    
    @Override
    protected void incluirValorDeParametrosParaListado() throws SQLException {
        this.incluirParametroInt(1, this.idPadre);
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.producto);
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.producto = new Producto();
        this.producto.setSku(this.resultSet.getString("PD.SKU"));
        this.producto.setNombre(this.resultSet.getString("PD.NOMBRE"));
        this.producto.setDescripcion(this.resultSet.getString("PD.DESCRIPCION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
