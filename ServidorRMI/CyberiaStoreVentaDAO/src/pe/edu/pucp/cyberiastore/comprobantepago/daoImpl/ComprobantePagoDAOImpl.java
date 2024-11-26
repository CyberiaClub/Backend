package pe.edu.pucp.cyberiastore.comprobantepago.daoImpl;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.comprobantepago.model.ComprobantePago;
import pe.edu.pucp.cyberiastore.comprobantepago.dao.ComprobantePagoDAO;
import pe.edu.pucp.cyberiastore.comprobantepago.dao.ComprobantePagoXProductoDAO;
import pe.edu.pucp.cyberiastore.comprobantepago.model.EstadoPedido;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.persona.model.Persona;

public class ComprobantePagoDAOImpl extends DAOImpl implements ComprobantePagoDAO {

    private ComprobantePago comprobantePago;

    public ComprobantePagoDAOImpl() {
        super("COMPROBANTE_DE_PAGO");
        this.comprobantePago = null;
    }

    /*
     * ************************************************************************
     * Insertar
     * ************************************************************************
     */
    @Override
    public Integer insertar(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        //Se insertan las lineas del comprobante de pago
        ComprobantePagoXProductoDAO comprobantePagoXProducto = new ComprobantePagoXProductoDAOImpl();
        Producto[] productos = (Producto[]) this.comprobantePago.getLineaPedido().keySet().toArray();
        for (Producto producto : productos) {
            comprobantePagoXProducto.insertar(id, producto.getIdProducto(), this.comprobantePago.getLineaPedido().get(producto));
        }
        return id;
    }

    @Override
    public Integer insertar(ComprobantePago comprobantePago, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(comprobantePago);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "FECHA, SUBTOTAL, IGV, TOTAL, ACTIVO, ESTADO_PEDIDO, NUMERO, RUC, RAZON_SOCIAL, DIRECCION, ID_TIPO_COMPROBANTE, ID_PERSONA";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroDate(1, this.comprobantePago.getFecha());
        this.incluirParametroDouble(2, this.comprobantePago.getSubtotal());
        this.incluirParametroDouble(3, this.comprobantePago.getIgv());
        this.incluirParametroDouble(4, this.comprobantePago.getTotal());
        this.incluirParametroBoolean(5, this.comprobantePago.getActivo());
        this.incluirParametroString(6, this.comprobantePago.getEstadoPedido().toString());
        this.incluirParametroString(7, this.comprobantePago.getNumero());
        this.incluirParametroString(8, this.comprobantePago.getRuc());
        this.incluirParametroString(9, this.comprobantePago.getRazonSocial());
        this.incluirParametroString(10, this.comprobantePago.getDireccion());
        this.incluirParametroInt(11, this.comprobantePago.getTipoComprobante().getIdTipoComprobante());
        this.incluirParametroInt(12, this.comprobantePago.getPersona().getIdPersona());
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
        return "ID_COMPROBANTE_DE_PAGO=?";
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "ESTADO_PEDIDO=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.comprobantePago.getEstadoPedido().toString());
        this.incluirParametroInt(2, this.comprobantePago.getIdComprobantePago());
    }

    /*
     * **************************************************************************
     * ELIMINIAR
     * *************************************************************************
     */
    @Override
    public Integer eliminar(ComprobantePago comprobantePago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(ComprobantePago comprobantePago, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * LISTAR TODOS
     * *************************************************************************
     */
    @Override
    protected String obtenerProyeccionParaSelect() {
        return "ID_COMPROBANTE_DE_PAGO, FECHA, SUBTOTAL, IGV, TOTAL, ACTIVO, ESTADO_PEDIDO, NUMERO, RUC, RAZON_SOCIAL, DIRECCION, ID_TIPO_TRANSACCION, ID_PERSONA";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.comprobantePago);
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        this.incluirParametroInt(1, this.comprobantePago.getIdComprobantePago());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.comprobantePago = new ComprobantePago();
        this.comprobantePago.setIdComprobantePago(this.resultSet.getInt("ID_COMPROBANTE_DE_PAGO"));
        this.comprobantePago.setFecha(this.resultSet.getDate("FECHA"));
        this.comprobantePago.setSubtotal(this.resultSet.getDouble("SUBTOTAL"));
        this.comprobantePago.setIgv(this.resultSet.getDouble("IGV"));
        this.comprobantePago.setTotal(this.resultSet.getDouble("TOTAL"));
        this.comprobantePago.setActivo(this.resultSet.getBoolean("ACTIVO"));
        this.comprobantePago.setEstadoPedido(EstadoPedido.valueOf(this.resultSet.getString("ESTADO_PEDIDO")));
        this.comprobantePago.setNumero(this.resultSet.getString("NUMERO"));
        this.comprobantePago.setRuc(this.resultSet.getString("RUC"));
        this.comprobantePago.setRazonSocial(this.resultSet.getString("RAZON_SOCIAL"));
        this.comprobantePago.setDireccion(this.resultSet.getString("DIRECCION"));
        this.comprobantePago.setTipoComprobante(new TipoComprobante(this.resultSet.getInt("ID_TIPO_TRANSACCION"), null, null, null));
        this.comprobantePago.setPersona(new Persona(this.resultSet.getInt("ID_PERSONA"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.comprobantePago = null;
    }

    @Override
    public ArrayList<ComprobantePago> listarTodos() {
        return (ArrayList<ComprobantePago>) super.listarTodos(null);
    }

    /*
     * *************************************************************************
     * OBTENER POR ID
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public ComprobantePago obtenerPorId(Integer idComprobantePago) {
        this.comprobantePago = new ComprobantePago();
        this.comprobantePago.setIdComprobantePago(idComprobantePago);
        super.buscar();
        return this.comprobantePago;
    }

    /*
     * *************************************************************************
     * EXISTE COMPROBANTE DE PAGO
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeComprobantePago(ComprobantePago comprobantePago) {
        return false;
    }
}
