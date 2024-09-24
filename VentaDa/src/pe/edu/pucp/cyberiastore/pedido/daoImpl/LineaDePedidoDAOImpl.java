package pe.edu.pucp.cyberiastore.pedido.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.pedido.dao.LineaDePedidoDAO;
import pe.edu.pucp.cyberiastore.pedido.model.LineaDePedido;



public class LineaDePedidoDAOImpl extends DAOImpl implements LineaDePedidoDAO{
    private LineaDePedido lineaDePedido;

    public LineaDePedidoDAOImpl() {
        super("LINEA_PEDIDO");
        this.lineaDePedido = null;
    }
    
    @Override
    protected String obtenerListaAtributos() {
        return "NUM_LINEA, PRODUCTO_SKU, PEDIDO_ID_PEDIDO";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + lineaDePedido.getCantidad() + "'");
        sql = sql.concat(", ");
        return sql;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_LINEA_PEDIDO = ");
        sql = sql.concat("'" + lineaDePedido.getIdLineaPedido());
        return sql;
    }

    @Override
    public Integer insertar(LineaDePedido lineaPedido) {
        this.lineaDePedido = lineaPedido;
        return super.insertar();
    }

    @Override
    public Integer modificar(LineaDePedido lineaPedido) {
        this.lineaDePedido = lineaPedido;
        return super.modificar();
    }

    @Override
    public Integer eliminar(LineaDePedido lineaPedido) {
        this.lineaDePedido = lineaPedido;
        return super.eliminar();
    }

    @Override
    public ArrayList<LineaDePedido> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<LineaDePedido> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LineaDePedido obtenerPorId(String idLineaPedido) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat("where ID_LINEA = '" + idLineaPedido + "'");
        return listar(sql).getFirst();
    }

}
