package pe.edu.pucp.cyberiastore.oferta.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.oferta.dao.OfertaDAO;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;

public class OfertaDAOImpl extends DAOImpl implements OfertaDAO {

    private Oferta oferta;

    public OfertaDAOImpl() {
        super("OFERTA");
        this.oferta = null;
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
    public Integer insertar(Oferta oferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Oferta oferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Oferta oferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Oferta> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Oferta> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Oferta obtenerPorId(String idOferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerId(Oferta oferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String imprimirId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    protected String obtenerListaAtributos() {
//        return "FECHA_INICIO, FECHA_FIN, PORCENTAJE";
//    }
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//        sql = sql.concat("STR_TO_DATE('" + this.oferta.getFechaDeInicioAsDDMMYYY()+ "','%d-%m-%Y')");
//        sql = sql.concat(", ");
//        sql = sql.concat("STR_TO_DATE('" + this.oferta.getFechaDeFinAsDDMMYYY() + "','%d-%m-%Y')");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + oferta.getPorcentaje() + "'");
//        return sql;
//        
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String sql = "";
//        sql = sql.concat("FECHA_INICIO = ");
//        sql = sql.concat("'" + oferta.getFechaDeInicioAsDDMMYYY()+ "'");
//        sql = sql.concat(",FECHA_FIN = ");
//        sql = sql.concat("'" + oferta.getFechaDeFinAsDDMMYYY()+ "'");
//        sql = sql.concat(",PORCENTAJE = ");
//        sql = sql.concat("'" + oferta.getPorcentaje()+ "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat("ID_OFERTA = ");
//        sql = sql.concat("'" + oferta.getIdOferta() + "'");
//        return sql;
//    }
//
//    @Override
//    public Integer insertar(Oferta oferta) {
//        this.oferta = oferta;
//        Integer id = this.insertar();
//        this.oferta.setIdOferta(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Oferta oferta) {
//        this.oferta = oferta;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Oferta oferta) {
//        this.oferta = oferta;
//        return this.eliminar();
//    }
//
//    @Override
//    public ArrayList<Oferta> listar(String sql) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public ArrayList<Oferta> listarTodos() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Oferta obtenerPorId(String idOferta) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and ID_PERMISO = '" + idOferta + "'");
//        return this.listar(sql).getFirst();
//    }
//    
//    @Override
//    public Integer obtenerId(Oferta oferta) {
//        this.oferta = oferta;
//        try {
//            Integer id = this.retornarUltimoAutogenerado();
//            this.oferta.setIdOferta(id);
//        } catch (SQLException ex) {
//            Logger.getLogger(OfertaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    @Override
//    public String imprimirId(){
//        return "" + this.oferta.getIdOferta();
//    }
}
