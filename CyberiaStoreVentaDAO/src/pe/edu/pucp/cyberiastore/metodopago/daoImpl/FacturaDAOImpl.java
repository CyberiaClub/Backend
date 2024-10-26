package pe.edu.pucp.cyberiastore.metodopago.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.dao.FacturaDAO;
import pe.edu.pucp.cyberiastore.metodopago.model.Factura;

public class FacturaDAOImpl extends MetodoDePagoDAOImpl implements FacturaDAO {

    private Factura factura;

    public FacturaDAOImpl() {
        super("FACTURA");
        this.factura = null;
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
    public Integer insertar(Factura factura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Factura factura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Factura factura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Factura> listarFactura(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Factura> listarTodosFactura() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Factura obtenerPorId(String idFactura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    protected String obtenerListaAtributos() {
//        return "NUMERO_FACTURA, RUC, RAZON_SOCIAL,DIRECCION, ID_METODO_PAGO";
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//        sql = super.obtenerListaValoresParaInsertar();
//        sql = sql.concat("'" + factura.getNumeroDeFactura() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + factura.getRuc() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + factura.getRazonSocial()+ "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + factura.getDireccionDeFacturacion() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + factura.getIdMetodoDePago() + "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String sql = "";
//        sql = sql.concat("NUMERO_FACTURA = ");
//        sql = sql.concat("'" + factura.getNumeroDeFactura()+ "'");
//        sql = sql.concat("RUC = ");
//        sql = sql.concat("'" + factura.getRuc()+ "'");
//        sql = sql.concat("RAZON_SOCIAL = ");
//        sql = sql.concat("'" + factura.getRazonSocial()+ "'");
//        sql = sql.concat("DIRECCION = ");
//        sql = sql.concat("'" + factura.getDireccionDeFacturacion()+ "'");
//        sql = sql.concat("ID_METODO_PAGO = ");
//        sql = sql.concat("'" + factura.getIdMetodoDePago() + "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and NUMERO_FACTURA = '" + factura.getNumeroDeFactura() + "'");
//        return this.listar(sql).getFirst().toString();// se agrego el toString() para que no de el error xD
//    }
//
//    @Override
//    public Integer insertar(Factura factura) {
//        this.factura = factura;
//        return this.insertar();
//    }
//
//    @Override
//    public Integer modificar(Factura factura) {
//        this.factura = factura;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Factura factura) {
//        this.factura = factura;
//        return this.eliminar();
//    }
//
//    @Override
//    public ArrayList<Factura> listarFactura(String sql) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<Factura> listarTodosFactura() {
//        return null;
//    }
//
//    @Override
//    public Factura obtenerPorId(String idFactura) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and NUMERO_FACTURA = '" + idFactura+ "'");
//        return this.listarFactura(sql).getFirst();
//    }
}
