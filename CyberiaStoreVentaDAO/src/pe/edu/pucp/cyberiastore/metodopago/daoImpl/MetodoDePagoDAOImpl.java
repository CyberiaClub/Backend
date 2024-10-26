package pe.edu.pucp.cyberiastore.metodopago.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.dao.MetodoDePagoDAO;
import pe.edu.pucp.cyberiastore.metodopago.model.MetodoDePago;

public class MetodoDePagoDAOImpl extends DAOImpl implements MetodoDePagoDAO {

    private MetodoDePago metodoDePago;

    public MetodoDePagoDAOImpl() {
        super("COMPROBANTE_DE_PAGO");
        this.metodoDePago = null;
        this.retornarLlavePrimaria = true;
    }

    public MetodoDePagoDAOImpl(String tabla) {
        super(tabla);
        this.metodoDePago = null;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
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
    public Integer insertar(MetodoDePago metodoDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(MetodoDePago metodoDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(MetodoDePago metodoDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<MetodoDePago> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<MetodoDePago> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MetodoDePago obtenerPorId(String idMetodoDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    protected String obtenerListaAtributos() {
//        String sql = "FECHA, SUBTOTAL, IGV, TOTAL, ID_PEDIDO, ACTIVO";
//        if(this.metodoDePago.getIdOferta() != null){
//            sql = sql.concat(",  DESCUENTO_APLICADO");
//            sql = sql.concat(", ID_OFERTA");
//        }
//        return sql;
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//        sql = sql.concat("STR_TO_DATE('" + this.metodoDePago.getFechaAsDDMMYYY() + "','%d-%m-%Y')");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + metodoDePago.getSubtotal() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + metodoDePago.getIgv()+ "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + metodoDePago.getTotal()+ "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + metodoDePago.getIdPedido()+ "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + metodoDePago.getActivoInt() + "'");
//        if(this.metodoDePago.getIdOferta() != null){
//            sql = sql.concat(", ");
//            sql = sql.concat("'" + metodoDePago.getDescuentoAplicado()+ "'");
//            sql = sql.concat(", ");
//            sql = sql.concat("'" + metodoDePago.getIdOferta() + "'");
//        }
//        return sql;
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String sql = "";
//        sql = sql.concat("FECHA_DATE = ");
//        sql = sql.concat("'" + metodoDePago.getFecha() + "'");
//        sql = sql.concat(",SUBTOTAL = ");
//        sql = sql.concat("'" + metodoDePago.getSubtotal()+ "'");
//        sql = sql.concat(",IGV = ");
//        sql = sql.concat("'" + metodoDePago.getIgv() + "'");
//        sql = sql.concat(",TOTAL = ");
//        sql = sql.concat("'" + metodoDePago.getTotal() + "'");
//        sql = sql.concat(",DESCUENTO_APLICADO = ");
//        sql = sql.concat("'" + metodoDePago.getDescuentoAplicado()+ "'");
//        sql = sql.concat(",ID_PEDIDO = ");
//        sql = sql.concat("'" + metodoDePago.getIdPedido()+ "'");
//        sql = sql.concat(",ID_OFERTA = ");
//        sql = sql.concat("'" + metodoDePago.getIdOferta() +  "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat("ID_METODO_PAGO = ");
//        sql = sql.concat("'" + metodoDePago.getIdMetodoDePago() + "'");
//        return sql;
//    }
//
//    @Override
//    public Integer insertar(MetodoDePago metodoDePago) {
//        this.metodoDePago = metodoDePago;
//        Integer id = this.insertar();
//        this.metodoDePago.setIdMetodoDePago(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(MetodoDePago metodoDePago) {
//        this.metodoDePago = metodoDePago;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(MetodoDePago metodoDePago) {
//        this.metodoDePago = metodoDePago;
//        return this.eliminar();
//    }
//
//    @Override
//    public ArrayList<MetodoDePago> listar(String sql) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<MetodoDePago> listarTodos() {
//        return null;
//    }
//
//    @Override
//    public MetodoDePago obtenerPorId(String idMetodoDePago) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and ID_METODO_PAGO = '" + idMetodoDePago + "'");
//        return this.listar(sql).getFirst();
//    }
//    @Override
//    public void insertarIdMetodoDePago(Integer idMetodoDePago){
//        this.metodoDePago.setIdMetodoDePago(idMetodoDePago);
//    }
}
