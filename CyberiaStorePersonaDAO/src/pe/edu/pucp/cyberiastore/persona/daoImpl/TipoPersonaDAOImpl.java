package pe.edu.pucp.cyberiastore.persona.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.persona.dao.TipoPersonaDAO;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;

public class TipoPersonaDAOImpl extends DAOImpl implements TipoPersonaDAO {

    private TipoPersona tipoPersona;

    public TipoPersonaDAOImpl() {
        super("TIPO_PERSONA");
        tipoPersona = null;
    }

    /*
     * ************************************************************************
     * Insertar
     * ************************************************************************
     */
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

    /*
     * **************************************************************************
     * MODIFICAR
     * *************************************************************************
     */
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

    /*
     * **************************************************************************
     * ELIMINAR
     * *************************************************************************
     */
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
    public ArrayList<TipoPersona> listarTodos() {
        return (ArrayList<TipoPersona>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return " D_TIPO_PERSONA, NOMBRE ";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.tipoPersona);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tipoPersona = new TipoPersona();
        tipoPersona.setIdTipoPersona(this.resultSet.getInt("ID_TIPO_PERSONA"));
        tipoPersona.setNombre(this.resultSet.getString("NOMBRE"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.tipoPersona = null;
    }

    /*
     * **************************************************************************
     * OBTENER POR ID
     * *************************************************************************
     */
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
