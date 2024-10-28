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
    public Integer insertar(ComprobanteDePago comprobanteDePago) {
        this.comprobanteDePago = comprobanteDePago;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    /**
     * Funcion definida en ComprobanteDePagoDAO Usada para la insersión de datos
     * por medio de herencia.
     *
     * @param comprobanteDePago
     * @param usarTransaccion
     * @param conexion
     * @return
     */
    @Override
    public Integer insertar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(comprobanteDePago);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "FECHA, SUBTOTAL, TOTAL, IGV, DESCUENTO_APLICADO, ACTIVO, ID_PEDIDO, ID_OFERTA, ID_CLIENTE";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroDate(1, this.comprobanteDePago.getFecha());
        this.incluirParametroDouble(2, this.comprobanteDePago.getSubtotal());
        this.incluirParametroDouble(3, this.comprobanteDePago.getTotal());
        this.incluirParametroDouble(4, this.comprobanteDePago.getIgv());
        this.incluirParametroDouble(5, this.comprobanteDePago.getDescuentoAplicado());
        this.incluirParametroBoolean(6, this.comprobanteDePago.getActivo());
        this.incluirParametroInt(7, this.comprobanteDePago.getIdPedido());
        this.incluirParametroInt(8, this.comprobanteDePago.getIdOferta());
    }

    /*
     * **************************************************************************
     * MODIFICAR
     * *************************************************************************
     */
    @Override
    public Integer modificar(ComprobanteDePago comprobanteDePago) {
        this.comprobanteDePago = comprobanteDePago;
        return super.modificar();
    }

    @Override
    public Integer modificar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(comprobanteDePago);
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "id_comprobanteDePago=?";
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
//        this.incluirParametroDate(1, this.comprobanteDePago.getFecha());
//        this.incluirParametroDouble(1, this.comprobanteDePago.getSubtotal());
//        this.incluirParametroDouble(1, this.comprobanteDePago.getTotal());
//        this.incluirParametroDouble(1, this.comprobanteDePago.getIgv());
//        this.incluirParametroDouble(1, this.comprobanteDePago.getDescuentoAplicado());
//        this.incluirParametroBoolean(1, this.comprobanteDePago.getActivo());
//        this.incluirParametroInt(1, this.comprobanteDePago.getIdPedido());
//        this.incluirParametroInt(1, this.comprobanteDePago.getIdOferta());
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
    public Integer eliminar(ComprobanteDePago comprobanteDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ComprobanteDePago> listarTodos() {
        return (ArrayList<ComprobanteDePago>) super.listarTodos(null);
    }

    @Override
    public ComprobanteDePago obtenerPorId(Integer idComprobanteDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeComprobanteDePago(ComprobanteDePago comprobanteDePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
}
