package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;

public class TipoProductoDAOImpl extends DAOImpl implements TipoProductoDAO {

    private TipoProducto tipoProducto;

    public TipoProductoDAOImpl() {
        super("TIPO_PRODUCTO");
        this.tipoProducto = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "TIPO, ACTIVO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.tipoProducto.getTipo());
        this.incluirParametroBoolean(2, this.tipoProducto.getActivo());
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
    protected String obtenerProyeccionParaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
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

    @Override
    public Integer insertar(TipoProducto tipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(TipoProducto tipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(TipoProducto tipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TipoProducto> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TipoProducto> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoProducto obtenerPorId(String idTipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerId(TipoProducto tipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerIdPorTipo(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String imprimirId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer insertar(TipoProducto tipoProducto) {
//        this.tipoProducto = tipoProducto;
//        Integer id = this.insertar();
//        this.tipoProducto.setIdTipoProducto(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(TipoProducto tipoProducto) {
//        this.tipoProducto = tipoProducto;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(TipoProducto tipoProducto) {
//        this.tipoProducto = tipoProducto;
//        return this.eliminar();
//    }
//
//    @Override
//    protected String obtenerListaAtributos() {
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String valores = "";
//        valores = valores.concat("'" + tipoProducto.getTipo() + "'");
//        valores = valores.concat(", ");
//        valores = valores.concat("'" + (tipoProducto.getActivo() ? 1 : 0) + "'");
//        return valores;
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public ArrayList<TipoProducto> listar(String listado) {
//        ArrayList<TipoProducto> listadoTipoProducto = new ArrayList();
//        try {
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(listado);
//            while (this.resultSet.next()) {
//                TipoProducto PlantilaTipoProd = new TipoProducto(
//                        this.resultSet.getString("TIPO")
//                );
//                listadoTipoProducto.add(PlantilaTipoProd);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TipoProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                this.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(TipoProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listadoTipoProducto;
//    }
//
//    @Override
//    public ArrayList<TipoProducto> listarTodos() {
//        String listado = this.obtenerListaValoresParaSeleccionar();
//        return this.listar(listado);
//    }
//
//    @Override
//    public TipoProducto obtenerPorId(String idTipoProducto) {
//        String valores = this.obtenerListaValoresParaSeleccionar();
//        valores = valores.concat(" and ID_TIPO_PRODUCTO = '" + idTipoProducto + "'");
//        return this.listar(valores).getFirst();
//    }
//
//    @Override
//    public Integer obtenerId(TipoProducto tipoProducto) {
//        this.tipoProducto = tipoProducto;
//        try {
//            Integer id = this.retornarUltimoAutogenerado();
//            this.tipoProducto.setIdTipoProducto(id);
//        } catch (SQLException ex) {
//            Logger.getLogger(TipoProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    @Override
//    public Integer obtenerIdPorTipo(String tipo){
//        String sql = "select ID_TIPO_PRODUCTO as id from TIPO_PRODUCTO where TIPO = '"+tipo+"'";
//        try {
//            Integer id = this.retonarIdPorAtributo(sql);
//            return id;
//        } catch (SQLException ex) {
//            Logger.getLogger(TipoProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Override
//    public String imprimirId() {
//        return "" + this.tipoProducto.getIdTipoProducto();
//    }
}
