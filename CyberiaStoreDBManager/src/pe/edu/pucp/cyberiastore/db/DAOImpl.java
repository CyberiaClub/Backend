package pe.edu.pucp.cyberiastore.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.config.DBManager;

public abstract class DAOImpl {

    protected String nombre_tabla;
    protected Connection conexion;
    protected Statement statement;
    protected ResultSet resultSet;
    protected Boolean retonarLlavePrimaria;

    public DAOImpl(String nombre_tabla){
        this.nombre_tabla = nombre_tabla;
        this.retonarLlavePrimaria = false;
    }
    
    protected void abrirConexion() throws SQLException {
        this.conexion = DBManager.getInstance().getConnection();
    }
    
    protected void cerrarConexion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.close();
        }
    }

    protected void iniciarTransaccion() throws SQLException {
        this.conexion = DBManager.getInstance().getConnection();
        this.conexion.setAutoCommit(false);
    }

    protected void comitarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.rollback();
        }
    }

    protected Integer ejecutarModificacionesEnBD(String sql) throws SQLException {
        this.statement = this.conexion.createStatement();
        return this.statement.executeUpdate(sql);
    }
    
    protected Integer ejecutarTransaccionEnBD(String sql) {
        Integer resultado = 0;
        try {
            this.iniciarTransaccion();
            resultado = this.ejecutarModificacionesEnBD(sql);
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    protected void ejecutarConsultaEnBD(String sql) throws SQLException {
        this.statement = this.conexion.createStatement();
        this.resultSet = this.statement.executeQuery(sql);
    }

    protected Integer insertar(){
        Integer resultado = 0;
        try{
            this.iniciarTransaccion();
            String sql = this.generarSQLParaInsercion();
            resultado = this.ejecutarModificacionesEnBD(sql);
            if(this.retonarLlavePrimaria){
                Integer id = this.retornarUltimoAutogenerado();
                resultado = id;
            }
            this.comitarTransaccion();
        } catch (SQLException ex){
            try {
                this.rollbackTransaccion();
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    protected String generarSQLParaInsercion() {
        String sql = "insert into ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" (");
        sql = sql.concat(this.obtenerListaAtributos());
        sql = sql.concat(" ) values (");
        sql = sql.concat(this.obtenerListaValoresParaInsertar());
        sql = sql.concat(");");
        return sql;
    }

    protected abstract String obtenerListaAtributos();
    
    protected abstract String obtenerListaValoresParaInsertar();
    
    public Integer modificar() {
        String sql = this.generarSQLParaModificacion();
        return this.ejecutarTransaccionEnBD(sql);
    }

    private String generarSQLParaModificacion() {
        String sql = "update ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" set");
        sql = sql.concat(this.obtenerListaValoresParaModificar());
        sql = sql.concat(" where");
        sql = sql.concat(this.obtenerCondicionPorId());      
        return sql;
    }

    protected abstract String obtenerListaValoresParaModificar();
    
    protected abstract String obtenerCondicionPorId();
    
    public Integer eliminar() {
        String sql = this.generarSQLParaEliminacion();
        return this.ejecutarTransaccionEnBD(sql);
    }

    private String generarSQLParaEliminacion() {
        String sql = "";
        //Se actualiza el atributo activo a 0
        return sql;
    }
    
    protected String obtenerListaValoresParaSeleccionar() {
        String sql = "select ";
        sql = sql.concat(this.obtenerListaAtributos());
        sql = sql.concat("from ");
        sql = sql.concat(this.nombre_tabla);
        return sql;
    }
    
    protected Integer retornarUltimoAutogenerado() throws SQLException{
        Integer resultado = null;
        String sql = "select @@last_insert_id as id";
        this.ejecutarConsultaEnBD(sql);
        if(this.resultSet.next()){
            resultado = this.resultSet.getInt("id");
        }
        return resultado;
    }
    
    protected Integer retonarIdPorAtributo(String sql) throws SQLException{
        Integer resultado = null;
        this.iniciarTransaccion();
        this.ejecutarConsultaEnBD(sql);
        if(this.resultSet.next()){
            resultado = this.resultSet.getInt("id");
        }
        return resultado;
    }
//    /**/
//    protected String returnIdFromTable(){
//        return "";
//    }
}