package pe.edu.pucp.cyberiastore.metodopago.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.metodopago.bo.MetodoDePagoBO;
import pe.edu.pucp.cyberiastore.metodopago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.metodopago.model.Boleta;

public class BoletaDAOImpl extends MetodoDePagoDAOImpl implements BoletaDAO {

    private Boleta boleta;

    public BoletaDAOImpl() {
        super("BOLETA");
        this.boleta = null;
        this.retornarLlavePrimaria = true;
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
    public Integer insertar(Boleta boleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Boleta boleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Boleta boleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Boleta> listarBoleta(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Boleta> listarTodosBoleta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boleta obtenerPorId(String idBoleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarIdBoleta(Integer idBoleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer insertar(Boleta boleta) {
//        this.boleta = boleta;
//        Integer id = super.insertar();
//        boleta.setIdBoleta(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Boleta boleta) {
//        this.boleta = boleta;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Boleta boleta) {
//        this.boleta = boleta;
//        return this.eliminar();
//    }
//
//    @Override
//    public ArrayList<Boleta> listarBoleta(String sql) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<Boleta> listarTodosBoleta() {
//        return null;
//    }
//
//    @Override
//    public Boleta obtenerPorId(String idBoleta) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and NUMERO_BOLETA = '" + idBoleta + "'");
//        return this.listarBoleta(sql).getFirst();
//    }
//
//    @Override
//    public void insertarIdBoleta(Integer idBoleta) {
//        this.boleta.setIdBoleta(idBoleta);
//    }
//    
//    //LOGICA para BD
//    
//    @Override
//    protected String obtenerListaAtributos() {
//        return "ACTIVO, NUMERO_BOLETA, ID_COMPROBANTE_DE_PAGO";
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//        sql = sql.concat("'" + this.boleta.getActivoInt() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.boleta.getNumeroDeBoleta() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.boleta.getIdMetodoDePago() + "'");
//        return sql;
//    }
}
