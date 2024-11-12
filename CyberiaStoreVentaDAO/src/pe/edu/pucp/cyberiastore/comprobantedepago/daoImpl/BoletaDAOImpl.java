package pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.ComprobanteDePagoDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Boleta;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.ComprobanteDePago;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.BoletaXClienteDAO;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.BoletaXClienteDAOImpl;

public class BoletaDAOImpl extends DAOImpl implements BoletaDAO {

    private Boleta boleta;

    public BoletaDAOImpl() {
        super("BOLETA");
        this.boleta = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    public Integer insertar(Boleta boleta) {
        this.boleta = boleta;
        Integer idComprobanteDePago = null;// el ID de la clase que hereda
        ComprobanteDePago comprobanteDePago = new ComprobanteDePago();// traemos la clase padre

        comprobanteDePago.setFecha(boleta.getFecha());
        comprobanteDePago.setSubtotal(boleta.getSubtotal());
        comprobanteDePago.setTotal(boleta.getTotal());
        comprobanteDePago.setIgv(boleta.getIgv());
        comprobanteDePago.setDescuentoAplicado(boleta.getDescuentoAplicado());
        comprobanteDePago.setActivo(boleta.getActivo());
        comprobanteDePago.setIdOferta(boleta.getIdOferta());
        comprobanteDePago.setIdPedido(boleta.getIdPedido());

        ComprobanteDePagoDAO comprobanteDePagoDAO = new ComprobanteDePagoDAOImpl();
        Integer idBoleta = null;

        Boolean existeBoleta = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            idComprobanteDePago = comprobanteDePagoDAO.insertar(comprobanteDePago, this.usarTransaccion, this.conexion);
            this.boleta.setIdComprobanteDePago(idComprobanteDePago);
            Boolean abreConexion = false;
            existeBoleta = this.existeBoleta(this.boleta, abreConexion);
            
            if (!existeBoleta) {
                this.retornarLlavePrimaria = true;
                idBoleta = super.insertar();
                this.boleta.setIdBoleta(idBoleta);
                this.boleta.setIdComprobanteDePago(comprobanteDePago.getIdComprobanteDePago());
                this.retornarLlavePrimaria = false;
                // pasamos llamar a la clase BOLETAXCLIENTE
                BoletaXClienteDAO boletaXCliente = new BoletaXClienteDAOImpl();
                boletaXCliente.insertar(idBoleta, boleta.getCliente().getIdUsuario(), this.usarTransaccion, this.conexion);
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar Boleta " + ex);
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
        return "NUMERO_BOLETA, ACTIVO, ID_COMPROBANTE_DE_PAGO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.boleta.getNumeroDeBoleta());
        this.incluirParametroBoolean(2, this.boleta.getActivo());
        this.incluirParametroInt(3, this.boleta.getIdComprobanteDePago());
    }

    /**
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Boleta boleta) {
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
            sql = "ID_BOLETA=?";
        } else {
            sql = "b.ID_BOLETA=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.boleta.getIdBoleta());
        this.incluirParametroInt(2, this.boleta.getIdComprobanteDePago());
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
    public Integer eliminar(Boleta boleta) {
        Integer retorno = 0;
        this.boleta = boleta;
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
        this.incluirParametroInt(1, this.boleta.getIdBoleta());
    }

    @Override
    public Boleta obtenerPorId(Integer idBoleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * ************************************************************************
     * LISTAR TODOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Boleta> listarTodos() {
        return (ArrayList<Boleta>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" B ");
        sql = sql.concat("JOIN COMPROBANTE_DE_PAGO CP ON B.ID_COMPROBANTE_DE_PAGO = CP.ID_COMPROBANTE_DE_PAGO ");
        sql = sql.concat("JOIN BOLETA_X_CLIENTE BXC ON B.ID_BOLETA = BXC.ID_BOLETA ");
        sql = sql.concat("JOIN CLIENTE C ON BXC.ID_CLIENTE = C.ID_CLIENTE ");
        sql = sql.concat("JOIN USUARIO U ON C.ID_CLIENTE = U.ID_USUARIO ");
//        sql = sql.concat("JOIN pedido p ON CP.ID_PEDIDO = P.ID_PEDIDO");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "B.ID_BOLETA, CP.ID_COMPROBANTE_DE_PAGO,";
        sql = sql.concat("CP.FECHA,CP.SUBTOTAL,CP.IGV,CP.TOTAL,CP.DESCUENTO_APLICADO, ");
        sql = sql.concat("B.NUMERO_BOLETA, ");
        sql = sql.concat("U.DOCUMENTO, U.NOMBRE, U.APELLIDO_PATERNO, U.APELLIDO_MATERNO ");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.boleta);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.boleta = new Boleta();

        this.boleta.setIdBoleta(this.resultSet.getInt("ID_BOLETA"));
        this.boleta.setIdComprobanteDePago(this.resultSet.getInt("ID_COMPROBANTE_DE_PAGO"));
        this.boleta.setFecha(this.resultSet.getDate("FECHA"));
        this.boleta.setSubtotal(this.resultSet.getDouble("SUBTOTAL"));
        this.boleta.setIgv(this.resultSet.getDouble("IGV"));
        this.boleta.setTotal(this.resultSet.getDouble("TOTAL"));
        this.boleta.setDescuentoAplicado(this.resultSet.getDouble("DESCUENTO_APLICADO"));
        this.boleta.setNumeroDeBoleta(this.resultSet.getInt("NUMERO_BOLETA"));

        this.boleta.getCliente().setDocumento(this.resultSet.getString("DOCUMENTO"));
        this.boleta.getCliente().setNombre(this.resultSet.getString("NOMBRE"));
        this.boleta.getCliente().setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
        this.boleta.getCliente().setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.boleta = null;
    }

    /**
     * *************************************************************************
     * EXISTE
     * *************************************************************************
     */
    @Override
    public Boolean existeBoleta(Boleta boleta) {
        Boolean abreConexion = true;
        return existeBoleta(boleta, abreConexion);
    }

    @Override
    public Boolean existeBoleta(Boleta boleta, Boolean abreConexion) {
        this.boleta = boleta;
        Integer idBoleta = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_BOLETA from BOLETA where ";
            sql = sql.concat("ID_COMPROBANTE_DE_PAGO=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.boleta.getIdComprobanteDePago());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idBoleta = this.resultSet.getInt("ID_BOLETA");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe alumno - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idBoleta != null;
    }
}
