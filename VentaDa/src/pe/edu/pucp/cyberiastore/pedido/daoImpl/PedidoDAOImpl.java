package pe.edu.pucp.cyberiastore.pedido.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.pedido.dao.PedidoDAO;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;



public class PedidoDAOImpl extends DAOImpl implements PedidoDAO{
    private Pedido pedido;
    
    public PedidoDAOImpl(){
        super("PEDIDO");
        this.pedido = null;
    }

    @Override
    protected String obtenerListaAtributos() {
        return "ESTADO";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + pedido.getEstadoPedido().toString() + "'");
        return sql;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String sql = "";
        sql = sql.concat("ESTADO = ");
        sql = sql.concat("'" + pedido.getEstadoPedido().toString() + "'");
        return sql;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ESTADO = ");
        sql = sql.concat("'" + pedido.getEstadoPedido().toString() + "'");
        return sql;
    }

    @Override
    public Integer insertar(Pedido pedido) {
        this.pedido = pedido;
        return super.insertar();
    }

    @Override
    public Integer modificar(Pedido pedido) {
        this.pedido = pedido;
        return super.modificar();
    }

    @Override
    public Integer eliminar(Pedido pedido) {
        this.pedido = pedido;
        return super.eliminar();
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
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat("where ID_PEDIDO = '" + idPedido + "'");
        return listar(sql).getFirst();
    }
    
}
