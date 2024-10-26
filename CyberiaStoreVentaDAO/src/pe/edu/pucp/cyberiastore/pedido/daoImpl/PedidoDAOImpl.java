package pe.edu.pucp.cyberiastore.pedido.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.pedido.dao.PedidoDAO;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;

public class PedidoDAOImpl extends DAOImpl implements PedidoDAO {

    private Pedido pedido;

    public PedidoDAOImpl() {
        super("PEDIDO");
        this.pedido = null;
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
    public Integer insertar(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Pedido> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Pedido> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido obtenerPorId(String idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    protected String obtenerListaAtributos() {
//        return "ESTADO";
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//        sql = sql.concat("'" + pedido.getEstadoPedido().toString() + "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String sql = "";
//        sql = sql.concat("ESTADO = ");
//        sql = sql.concat("'" + pedido.getEstadoPedido().toString() + "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat("ESTADO = ");
//        sql = sql.concat("'" + pedido.getEstadoPedido().toString() + "'");
//        return sql;
//    }
//
//    @Override
//    public Integer insertar(Pedido pedido) {
//        this.pedido = pedido;
//        Integer id = this.insertar();
//        this.pedido.setIdPedido(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Pedido pedido) {
//        this.pedido = pedido;
//        return super.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Pedido pedido) {
//        this.pedido = pedido;
//        return super.eliminar();
//    }
//
//    @Override
//    public ArrayList<Pedido> listar(String sql) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public ArrayList<Pedido> listarTodos() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
//    @Override
//    public Pedido obtenerPorId(String idPedido) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat("where ID_PEDIDO = '" + idPedido + "'");
//        return listar(sql).getFirst();
//    }
}
