package pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.model.ComprobanteDePago;
import pe.edu.pucp.cyberiastore.metodopago.dao.ComprobanteDePagoDAO;

public class ComprobanteDePagoDAOImpl extends DAOImpl implements ComprobanteDePagoDAO {

    private ComprobanteDePago comprobanteDePago;

    public ComprobanteDePagoDAOImpl() {
        super("COMPROBANTE_DE_PAGO");
        this.comprobanteDePago = null;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        String sql = "FECHA, SUBTOTAL, IGV, TOTAL, ID_PEDIDO, ACTIVO";
        if (this.comprobanteDePago.getIdOferta() != null) {
            sql = sql.concat(",  DESCUENTO_APLICADO");
            sql = sql.concat(", ID_OFERTA");
        }
        return sql;
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        String sql = "?,?,?,?,?,?";
        if (this.comprobanteDePago.getIdOferta() != null) {
            sql = sql.concat("?,?");
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroDate(1, this.comprobanteDePago.getFecha());
        this.incluirParametroDouble(2, this.comprobanteDePago.getSubtotal());
        this.incluirParametroDouble(3, this.comprobanteDePago.getIgv());
        this.incluirParametroDouble(4, this.comprobanteDePago.getTotal());
        this.incluirParametroInt(5, this.comprobanteDePago.getIdPedido());
        this.incluirParametroBoolean(6, this.comprobanteDePago.getActivo());
        if (this.comprobanteDePago.getIdOferta() != null) {
            this.incluirParametroDouble(7, this.comprobanteDePago.getDescuentoAplicado());
            this.incluirParametroInt(8, this.comprobanteDePago.getIdOferta());
        }
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
    public Integer insertar(ComprobanteDePago comprobanteDePago) {
        this.comprobanteDePago = comprobanteDePago;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    public Integer insertar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(comprobanteDePago);
    }

    @Override
    public Integer modificar(ComprobanteDePago comprobanteDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(ComprobanteDePago comprobanteDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ComprobanteDePago> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComprobanteDePago obtenerPorId(Integer idComprobanteDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeComprobanteDePago(ComprobanteDePago comprobanteDePago) {
        this.comprobanteDePago = comprobanteDePago;
        Integer idComprobanteDePago = null;
        try {
            this.abrirConexion();
            String sql = "select id_comprobante_de_pago from COMPROBANTE_DE_PAGO where ";
            sql = sql.concat("fecha=? ");
            sql = sql.concat("and id_pedido=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroDate(1, this.comprobanteDePago.getFecha());
            this.incluirParametroInt(2, this.comprobanteDePago.getIdPedido());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idComprobanteDePago = this.resultSet.getInt("id_comprobanteDePago");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe comprobanteDePago - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.comprobanteDePago.setIdComprobanteDePago(idComprobanteDePago);
        return idComprobanteDePago != null;
    }
}
