package pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.ComprobanteDePagoDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.ComprobanteDePagoDAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.FacturaDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.FacturaXClienteDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.ComprobanteDePago;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Factura;

public class FacturaDAOImpl extends DAOImpl implements FacturaDAO {

    private Factura factura;

    public FacturaDAOImpl() {
        super("FACTURA");
        this.factura = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    public Integer insertar(Factura factura) {
        this.factura = factura;
        Integer idComprobanteDePago = null;// el ID de la clase que hereda
        ComprobanteDePago comprobanteDePago = new ComprobanteDePago();// traemos la clase padre

        comprobanteDePago.setFecha(factura.getFecha());
        comprobanteDePago.setSubtotal(factura.getSubtotal());
        comprobanteDePago.setTotal(factura.getTotal());
        comprobanteDePago.setIgv(factura.getIgv());
        comprobanteDePago.setDescuentoAplicado(factura.getDescuentoAplicado());
        comprobanteDePago.setActivo(factura.getActivo());
        comprobanteDePago.setIdOferta(factura.getIdOferta());
        comprobanteDePago.setIdPedido(factura.getIdPedido());

        ComprobanteDePagoDAO comprobanteDePagoDAO = new ComprobanteDePagoDAOImpl();
        Integer idFactura = null;

        Boolean existeFactura = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            idComprobanteDePago = comprobanteDePagoDAO.insertar(comprobanteDePago, this.usarTransaccion, this.conexion);
            this.factura.setIdComprobanteDePago(idComprobanteDePago);
            Boolean abreConexion = false;
            existeFactura = this.existeFactura(this.factura, abreConexion);
            
            if (!existeFactura) {
                this.retornarLlavePrimaria = true;
                idFactura = super.insertar();
                this.factura.setIdFactura(idFactura);
                this.factura.setIdComprobanteDePago(comprobanteDePago.getIdComprobanteDePago());
                this.retornarLlavePrimaria = false;
                // pasamos llamar a la clase FACTURAXCLIENTE
                FacturaXClienteDAO facturaXCliente = new FacturaXClienteDAOImpl();
                facturaXCliente.insertar(idFactura, factura.getCliente().getIdCliente(), this.usarTransaccion, this.conexion);
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar Factura " + ex);
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
        return idComprobanteDePago;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NUMERO_FACTURA, RUC, RAZON_SOCIAL, DIRECCION, ACTIVO,ID_COMPROBANTE_DE_PAGO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.factura.getNumeroDeFactura());
        this.incluirParametroString(2, this.factura.getRuc());
        this.incluirParametroString(3, this.factura.getRazonSocial());
        this.incluirParametroString(4, this.factura.getDireccionDeFacturacion());
        this.incluirParametroBoolean(5, this.factura.getActivo());
        this.incluirParametroInt(6, this.factura.getIdComprobanteDePago());
    }

    /**
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Factura factura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "id_factura=?";
        } else {
            sql = "f.id_factura=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.factura.getIdFactura());
        this.incluirParametroInt(2, this.factura.getIdComprobanteDePago());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * ************************************************************************
     * ELIMINAR
     * ************************************************************************
     */
    @Override
    public Integer eliminar(Factura factura) {
        Integer retorno = 0;
        this.factura = factura;
        this.usarTransaccion = false;

        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar modificar - " + ex);
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
        this.incluirParametroInt(1, this.factura.getIdFactura());
    }

    @Override
    public Factura obtenerPorId(Integer idFactura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * ************************************************************************
     * LISTAR TODOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Factura> listarTodos() {
        return (ArrayList<Factura>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" F ");
        sql = sql.concat("JOIN comprobante_de_pago CP ON F.ID_COMPROBANTE_DE_PAGO = CP.ID_COMPROBANTE_DE_PAGO ");
        sql = sql.concat("JOIN factura_x_cliente FXC ON F.ID_FACTURA = FXC.ID_FACTURA ");
        sql = sql.concat("JOIN cliente C ON FXC.ID_CLIENTE = C.ID_CLIENTE ");
        sql = sql.concat("JOIN usuario U ON C.ID_CLIENTE = U.ID_USUARIO ");
//        sql = sql.concat("JOIN pedido p ON CP.ID_PEDIDO = P.ID_PEDIDO");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "F.ID_FACTURA, CP.ID_COMPROBANTE_DE_PAGO,";
        sql = sql.concat("CP.FECHA,CP.SUBTOTAL,CP.IGV,CP.TOTAL,CP.DESCUENTO_APLICADO, ");
        sql = sql.concat("F.NUMERO_FACTURA, F.RUC, F.RAZON_SOCIAL, F.DIRECCION, ");
        sql = sql.concat("U.DOCUMENTO, U.NOMBRE, U.APELLIDO_PATERNO, U.APELLIDO_MATERNO ");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.factura);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.factura = new Factura();

        this.factura.setIdFactura(this.resultSet.getInt("id_factura"));
        this.factura.setIdComprobanteDePago(this.resultSet.getInt("id_comprobante_de_pago"));
        this.factura.setFecha(this.resultSet.getDate("fecha"));
        this.factura.setSubtotal(this.resultSet.getDouble("subtotal"));
        this.factura.setIgv(this.resultSet.getDouble("igv"));
        this.factura.setTotal(this.resultSet.getDouble("total"));
        this.factura.setDescuentoAplicado(this.resultSet.getDouble("descuento_aplicado"));
        this.factura.setNumeroDeFactura(this.resultSet.getInt("numero_factura"));
        this.factura.setRuc(this.resultSet.getString("ruc"));
        this.factura.setRazonSocial(this.resultSet.getString("razon_social"));
        this.factura.setDireccionDeFacturacion(this.resultSet.getString("direccion"));

        this.factura.getCliente().setDocumento(this.resultSet.getString("documento"));
        this.factura.getCliente().setNombre(this.resultSet.getString("nombre"));
        this.factura.getCliente().setApellidoPaterno(this.resultSet.getString("apellido_paterno"));
        this.factura.getCliente().setApellidoMaterno(this.resultSet.getString("apellido_materno"));

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.factura = null;
    }

    /**
     * *************************************************************************
     * EXISTE
     * *************************************************************************
     */
    @Override
    public Boolean existeFactura(Factura factura) {
        Boolean abreConexion = true;
        return existeFactura(factura, abreConexion);
    }

    @Override
    public Boolean existeFactura(Factura factura, Boolean abreConexion) {
        this.factura = factura;
        Integer idFactura = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_factura from factura where ";
            sql = sql.concat("id_comprobante_de_pago=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.factura.getIdComprobanteDePago());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idFactura = this.resultSet.getInt("id_factura");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe factura - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idFactura != null;
    }
}
