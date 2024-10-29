package pe.edu.pucp.cyberiastore.pedido.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.pedido.dao.PedidoDAO;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.pedido.daoImpl.ProductoXPedidoDAOImpl;
import pe.edu.pucp.cyberiastore.pedido.dao.ProductoXPedidoDAO;

public class PedidoDAOImpl extends DAOImpl implements PedidoDAO {

    private Pedido pedido;

    public PedidoDAOImpl() {
        super("PEDIDO");
        this.pedido = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    public Integer insertar(Pedido pedido) {
        this.pedido = pedido;
        Integer idPedido = null;

        Boolean existePedido = this.existePedido(pedido);
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            this.retornarLlavePrimaria = true;
            idPedido = super.insertar();
            this.retornarLlavePrimaria = false;
            ProductoXPedidoDAO productoXPedidoDAO = new ProductoXPedidoDAOImpl();
            for (Map.Entry<Producto, Integer> par : this.pedido.getProductosCantidad()) {
                productoXPedidoDAO.insertar(par.getKey().getIdProducto(), this.pedido.getIdPedido(), par.getValue(), usarTransaccion, conexion);
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion = true;
        return idPedido;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "estado";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.pedido.getEstadoPedido().toString());
    }

    @Override
    public Integer modificar(Pedido pedido) {
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
    public Integer eliminar(Pedido pedido) {
        Integer retorno = 0;
        this.pedido = pedido;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion = true;
        return retorno;
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.pedido.getIdPedido());
    }

    @Override
    public ArrayList<Pedido> listarTodos() {
        return (ArrayList<Pedido>) super.listarTodos(null);
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
        this.pedido = null;
    }

    @Override
    public Pedido obtenerPorId(Integer idPedido) {
        this.pedido = new Pedido();
        this.pedido.setIdPedido(idPedido);
        super.obtenerPorId();
        return this.pedido;
    }

    @Override
    public Boolean existePedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existePedido(Pedido pedido, Boolean abreConexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
