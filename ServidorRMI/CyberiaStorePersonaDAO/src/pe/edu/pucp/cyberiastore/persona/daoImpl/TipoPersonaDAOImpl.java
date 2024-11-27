package pe.edu.pucp.cyberiastore.persona.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.persona.dao.TipoPersonaDAO;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;
import pe.edu.pucp.cyberiastore.persona.pagina.Pagina;

public class TipoPersonaDAOImpl extends DAOImpl implements TipoPersonaDAO {

    private TipoPersona tipoPersona;
    private TipoOperacionPersona tipoOperacionPersona;

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
        String sql = "";
        switch (this.tipoOperacionPersona) {
            case LISTAR_PAGINAS -> {
                sql = sql.concat(" TP.NOMBRE = ? ");
            }
            default ->
                throw new AssertionError();
        }

        return sql;
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
    public ArrayList<TipoPersona> listarTipoTrabajadores() {
        this.tipoOperacionPersona = TipoOperacionPersona.LISTAR_TIPO_TRABAJADORES;
        return (ArrayList<TipoPersona>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        switch (this.tipoOperacionPersona) {
            case LISTAR_TIPO_TRABAJADORES -> {
                sql = sql.concat(" ID_TIPO_PERSONA, NOMBRE ");
            }
            case LISTAR_PERSONA_POR_DOCUMENTO ->
                sql = sql.concat(" ID_TIPO_PERSONA, NOMBRE ");
            case LISTAR_PAGINAS ->
                sql = sql.concat("P.NOMBRE, P.REFERENCIA ");
            default ->
                throw new AssertionError();
        }

        return sql;
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        String sql = "";
        switch (this.tipoOperacionPersona) {
            case LISTAR_PERSONA_POR_DOCUMENTO ->
                sql = sql.concat(" WHERE NOMBRE NOT IN ('ADMINISTRADOR','CLIENTE') ");
            case LISTAR_PAGINAS -> {
                sql = sql.concat(" TP ");
                sql = sql.concat(" JOIN TIPO_PERSONA_X_PAGINA TPXP ");
                sql = sql.concat(" ON TP.ID_TIPO_PERSONA = TPXP.ID_TIPO_PERSONA ");
                sql = sql.concat(" JOIN PAGINA P ");
                sql = sql.concat(" ON TPXP.ID_PAGINA = P.ID_PAGINA ");
            }
            default ->
                throw new AssertionError();
        }

        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaListado() throws SQLException {
        incluirParametroString(1, this.tipoPersona.getNombre());
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.tipoPersona);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        if (this.tipoOperacionPersona != TipoOperacionPersona.LISTAR_PAGINAS) {
            this.tipoPersona = new TipoPersona();
        }
        switch (this.tipoOperacionPersona) {
            case LISTAR_PERSONA_POR_DOCUMENTO -> {
                tipoPersona.setIdTipoPersona(this.resultSet.getInt("ID_TIPO_PERSONA"));
                tipoPersona.setNombre(this.resultSet.getString("NOMBRE"));
            }
            case LISTAR_PAGINAS -> {
                Pagina pagina = new Pagina();
                pagina.setNombre(this.resultSet.getString("NOMBRE"));
                pagina.setReferencia(this.resultSet.getString("REFERENCIA"));
                this.tipoPersona.getPaginas().add(pagina);
            }
            default ->
                throw new AssertionError();
        }

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
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        switch (this.tipoOperacionPersona) {
            case LISTAR_PAGINAS -> {
                incluirParametroString(1, this.tipoPersona.getNombre());
            }
            default ->
                throw new AssertionError();
        }
    }

    /*Listar las paginas*/
    @Override
    public TipoPersona listarPaginas(String tipo_persona) {
        this.tipoPersona = new TipoPersona();
        ArrayList<Pagina> p = new ArrayList<>();
        this.tipoPersona.setPaginas(p);
        this.tipoPersona.setNombre(tipo_persona);
        this.tipoOperacionPersona = TipoOperacionPersona.LISTAR_PAGINAS;

        super.buscar();
        return this.tipoPersona;
    }
}
