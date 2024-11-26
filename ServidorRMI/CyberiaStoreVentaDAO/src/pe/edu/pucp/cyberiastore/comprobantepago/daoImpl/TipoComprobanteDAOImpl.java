package pe.edu.pucp.cyberiastore.comprobantepago.daoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;
import pe.edu.pucp.cyberiastore.comprobantepago.dao.TipoComprobanteDAO;

public class TipoComprobanteDAOImpl extends DAOImpl implements TipoComprobanteDAO {

    private TipoComprobante tipoComprobante;
    
    public TipoComprobanteDAOImpl() {
        super("TIPO_COMPROBANTE");
        tipoComprobante = null;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
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
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "ID_TIPO_COMPROBANTE, SECUENCIAL, TIPO_COMPROBANTE, ACTIVO";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.tipoComprobante);
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tipoComprobante = new TipoComprobante();
        this.tipoComprobante.setIdTipoComprobante(this.resultSet.getInt("ID_TIPO_COMPROBANTE"));
        this.tipoComprobante.setSecuencial(this.resultSet.getString("SECUENCIAL"));
        this.tipoComprobante.setTipoComprobante(this.resultSet.getString("TIPO_COMPROBANTE"));
        this.tipoComprobante.setActivo(this.resultSet.getBoolean("ACTIVO"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.tipoComprobante = null;
    }

    @Override
    public ArrayList<TipoComprobante> listarTodos() {
        return (ArrayList<TipoComprobante>) super.listarTodos(null);
    }

    @Override
    public Boolean existeComprobantePago(TipoComprobante tipoComprobante) {
        return false;
    }
    
}
