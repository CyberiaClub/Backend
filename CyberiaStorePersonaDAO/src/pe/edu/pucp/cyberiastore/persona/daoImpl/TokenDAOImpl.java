package pe.edu.pucp.cyberiastore.persona.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.persona.dao.TokenDAO;
import pe.edu.pucp.cyberiastore.persona.model.Token;

public class TokenDAOImpl extends DAOImpl implements TokenDAO {

    private Token token;

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
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "VALOR=?";
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroString(1, this.token.getValor());
    }
    
    @Override
    public Boolean existeToken(Token token) {
        Boolean abreConexion = true;
        return existeToken(token, abreConexion);
    }

    @Override
    public Boolean existeToken(Token token, Boolean abreConexion) {
        this.token = token;
        Integer idToken = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_TOKEN from TOKEN where ";
            sql = sql.concat("VALOR=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.token.getValor());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idToken = this.resultSet.getInt("ID_TOKEN");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe token - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idToken != null;
    }
    
    @Override
    public Token buscarTokenPorValor(Token token) {
        this.token = token;
        Integer idPersona = null;
        try {
            this.abrirConexion();
            String sql = "select ACTIVO,ID_PERSONA from TOKEN where ";
            sql = sql.concat("VALOR=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.token.getValor());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                this.token.setActivo(this.resultSet.getInt("ACTIVO") == 1);
                this.token.setIdPersona(this.resultSet.getInt("ID_PERSONA"));
            }
        } catch (SQLException ex) {
            System.err.println("Error al buscar persona por token - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return this.token;
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

}
