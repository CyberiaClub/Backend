
package pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.metodopago.dao.ComprobanteDePagoDAO;
import pe.edu.pucp.cyberiastore.metodopago.model.Boleta;
import pe.edu.pucp.cyberiastore.metodopago.model.ComprobanteDePago;


public class BoletaDAOImpl extends DAOImpl implements BoletaDAO {

    private Boleta boleta;

    public BoletaDAOImpl() {
        super("BOLETA");
        this.boleta = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "ACTIVO, NUMERO_BOLETA, ID_COMPROBANTE_DE_PAGO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroBoolean(1, this.boleta.getActivo());
        this.incluirParametroInt(2, this.boleta.getNumeroDeBoleta());
        this.incluirParametroInt(3, this.boleta.getIdComprobanteDePago());
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
    public Integer insertar(Boleta boleta) {
        this.boleta = boleta;
        Integer idComprobante = null;
        Integer idBoleta = null;
        ComprobanteDePago comprobanteDePago = new ComprobanteDePago();
        comprobanteDePago.setFecha(this.boleta.getFecha());
        comprobanteDePago.setSubtotal(this.boleta.getSubtotal());
        comprobanteDePago.setTotal(this.boleta.getTotal());
        comprobanteDePago.setIdPedido(this.boleta.getIdPedido());
        comprobanteDePago.setDescuentoAplicado(this.boleta.getDescuentoAplicado());
        if (boleta.getIdOferta() != null) {
            comprobanteDePago.setIdOferta(this.boleta.getIdOferta());
            comprobanteDePago.setDescuentoAplicado(this.boleta.getDescuentoAplicado());
        }
        ComprobanteDePagoDAO comprobanteDAO = new ComprobanteDePagoDAOImpl();
        Boolean existeComprobante = comprobanteDAO.existeComprobanteDePago(comprobanteDePago);
        Boolean existeBoleta = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeComprobante) {
                idComprobante = comprobanteDAO.insertar(comprobanteDePago, this.usarTransaccion, this.conexion);
                this.boleta.setIdComprobanteDePago(idComprobante);
            } else {
                idComprobante = comprobanteDePago.getIdComprobanteDePago();
                this.boleta.setIdComprobanteDePago(idComprobante);
                Boolean abreConexion = false;
                existeBoleta = this.existeBoleta(this.boleta, abreConexion);
            }
            if (!existeBoleta) {
                this.retornarLlavePrimaria = true;
                idBoleta = super.insertar();
                this.boleta.setIdBoleta(idBoleta);
                this.boleta.setIdComprobanteDePago(comprobanteDePago.getIdComprobanteDePago());
                this.retornarLlavePrimaria = false;
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
        return idBoleta;
    }

    @Override
    public Integer modificar(Boleta boleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Boleta boleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Boleta> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boleta obtenerPorId(Integer idBoleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeBoleta(Boleta boleta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeBoleta(Boleta boleta, Boolean abreConexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer insertar(Boleta boleta) {
//        this.boleta = boleta;
//        Integer id = super.insertar();
//        boleta.setIdBoleta(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Boleta boleta) {
//        this.boleta = boleta;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Boleta boleta) {
//        this.boleta = boleta;
//        return this.eliminar();
//    }
//
//    @Override
//    public ArrayList<Boleta> listarBoleta(String sql) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<Boleta> listarTodosBoleta() {
//        return null;
//    }
//
//    @Override
//    public Boleta obtenerPorId(String idBoleta) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and NUMERO_BOLETA = '" + idBoleta + "'");
//        return this.listarBoleta(sql).getFirst();
//    }
//
//    @Override
//    public void insertarIdBoleta(Integer idBoleta) {
//        this.boleta.setIdBoleta(idBoleta);
//    }
//    
//    //LOGICA para BD
//    
//    @Override
//    protected String obtenerListaAtributos() {
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//        sql = sql.concat("'" + this.boleta.getActivoInt() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.boleta.getNumeroDeBoleta() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.boleta.getIdMetodoDePago() + "'");
//        return sql;
//    }
}
