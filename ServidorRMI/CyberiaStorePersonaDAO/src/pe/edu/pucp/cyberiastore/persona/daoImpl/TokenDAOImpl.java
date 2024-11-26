package pe.edu.pucp.cyberiastore.persona.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.persona.dao.TokenDAO;
import pe.edu.pucp.cyberiastore.persona.model.Token;

public class TokenDAOImpl extends DAOImpl implements TokenDAO {
    
    private Token token;
    private TipoOperacionPersona tipoOperacionPersona;
    public TokenDAOImpl() {
        super("TOKEN");
    }

    @Override
    public Integer insertar(Token token) {
        Integer idToken = null;

        do {
            token.generarToken();
        } while (this.existeToken(token));

        this.token = token;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();

            this.retornarLlavePrimaria = true;
            idToken = super.insertar();
            this.retornarLlavePrimaria = false;

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
        return idToken;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "VALOR, ID_PERSONA";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.token.getValor());
        this.incluirParametroInt(2, this.token.getIdPersona());
    }

    @Override
    public Integer eliminar(Token token) {
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroString(1, this.token.getValor());
    }

    @Override
    public Boolean existeToken(Token token) {
        this.tipo_Operacion = Tipo_Operacion.EXISTE;
        this.token = token;
        super.buscar();
        return this.token != null;
    }

    @Override
    public Token buscarTokenPorValor(Token token) {
        this.tipoOperacionPersona = TipoOperacionPersona.BUSCAR_TOKEN_POR_VALOR;
        this.token = token;
        super.buscar();
        return this.token;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql="";
        switch(this.tipo_Operacion){
            case EXISTE->{
                sql = sql.concat("ID_TOKEN");
            }
        }
        
        switch(this.tipoOperacionPersona){
            case BUSCAR_TOKEN_POR_VALOR->{
                sql = sql.concat("ACTIVO,ID_PERSONA ");
            }
        }
        return sql;
    }
    
        @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql="";
        switch(this.tipo_Operacion){
            case EXISTE->{
                sql = sql.concat("ID_TOKEN=?");
            }
        }
        
        switch(this.tipoOperacionPersona){
            case BUSCAR_TOKEN_POR_VALOR->{
                sql = sql.concat("VALOR=?");
            }
        }
        return sql;
    }
    
    
        @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        switch(this.tipo_Operacion){
            case EXISTE->{
                this.incluirParametroInt(1, this.token.getIdToken());
            }
        }
        
        switch(this.tipoOperacionPersona){
            case BUSCAR_TOKEN_POR_VALOR->{
                this.incluirParametroString(1, this.token.getValor());
            }
        }
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.token = new Token();
        switch(this.tipo_Operacion){
            case EXISTE->{
                this.token.setIdToken(this.resultSet.getInt("ID_TOKEN"));
            }
        }
        switch(this.tipoOperacionPersona){
            case BUSCAR_TOKEN_POR_VALOR->{
                this.token.setActivo(this.resultSet.getInt("ACTIVO")==1);
                this.token.setIdPersona(this.resultSet.getInt("ID_PERSONA"));
            }
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.token=null;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
