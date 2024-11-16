package pe.edu.pucp.cyberiastore.comprobantepago.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.comprobantepago.model.ComprobantePago;
import pe.edu.pucp.cyberiastore.comprobantepago.dao.ComprobantePagoDAO;

public class ComprobantePagoDAOImpl extends DAOImpl implements ComprobantePagoDAO {

    private ComprobantePago comprobantePago;

    public ComprobantePagoDAOImpl() {
        super("COMPROBANTE_DE_PAGO");
        this.comprobantePago = null;
    }

    @Override
    public Integer insertar(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    /**
     * Funcion definida en ComprobantePagoDAO Usada para la insersión de datos
     * por medio de herencia.
     *
     * @param comprobantePago
     * @param usarTransaccion
     * @param conexion
     * @return
     */
    @Override
    public Integer insertar(ComprobantePago comprobantePago, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(comprobantePago);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "FECHA, SUBTOTAL, TOTAL, IGV, DESCUENTO_APLICADO, ACTIVO, ID_PEDIDO, ID_OFERTA";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroDate(1, this.comprobantePago.getFecha());
        this.incluirParametroDouble(2, this.comprobantePago.getSubtotal());
        this.incluirParametroDouble(3, this.comprobantePago.getTotal());
        this.incluirParametroDouble(4, this.comprobantePago.getIgv());
        this.incluirParametroDouble(5, this.comprobantePago.getDescuentoAplicado());
        this.incluirParametroBoolean(6, this.comprobantePago.getActivo());
        this.incluirParametroInt(7, this.comprobantePago.getIdPedido());
        this.incluirParametroInt(8, this.comprobantePago.getIdOferta());
    }

    /*
     * **************************************************************************
     * MODIFICAR
     * *************************************************************************
     */
    @Override
    public Integer modificar(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
        return super.modificar();
    }

    @Override
    public Integer modificar(ComprobantePago comprobantePago, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(comprobantePago);
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "id_comprobantePago=?";
    }

    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    protected String obtenerListaDeValoresYAtributosParaModificacion() {
//        return "FECHA=?, SUBTOTAL=?, TOTAL=?, IGV=?, DESCUENTO_APLICADO=?, ACTIVO=?, ID_PEDIDO=?, ID_OFERTA=?";
//    }
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
//        this.incluirParametroDate(1, this.comprobantePago.getFecha());
//        this.incluirParametroDouble(1, this.comprobantePago.getSubtotal());
//        this.incluirParametroDouble(1, this.comprobantePago.getTotal());
//        this.incluirParametroDouble(1, this.comprobantePago.getIgv());
//        this.incluirParametroDouble(1, this.comprobantePago.getDescuentoAplicado());
//        this.incluirParametroBoolean(1, this.comprobantePago.getActivo());
//        this.incluirParametroInt(1, this.comprobantePago.getIdPedido());
//        this.incluirParametroInt(1, this.comprobantePago.getIdOferta());
//    }
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
    public Integer eliminar(ComprobantePago comprobantePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(ComprobantePago comprobantePago, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ComprobantePago> listarTodos() {
        return (ArrayList<ComprobantePago>) super.listarTodos(null);
    }

    @Override
    public ComprobantePago obtenerPorId(Integer idComprobantePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeComprobantePago(ComprobantePago comprobantePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
}
