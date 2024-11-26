package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public class TipoProductoDAOImpl extends DAOImpl implements TipoProductoDAO {

    private TipoProducto tipoProducto;

    public TipoProductoDAOImpl() {
        super("TIPO_PRODUCTO");
        this.tipoProducto = null;
        this.retornarLlavePrimaria = true;
    }
    
    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */

    @Override
    public Integer insertar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        Integer idTipoProducto = null;

        Boolean existeTipoProducto = this.existeTipoProducto(tipoProducto);
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeTipoProducto) {
                this.retornarLlavePrimaria = true;
                idTipoProducto = super.insertar();
                this.retornarLlavePrimaria = false;

            } else {
                idTipoProducto = tipoProducto.getIdTipoProducto();
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
        return idTipoProducto;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "TIPO,IMAGEN";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.tipoProducto.getTipo());
        this.incluirParametroByte(2, this.tipoProducto.getImagen());
    }
    
    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */

    @Override
    public Integer modificar(TipoProducto tipoProducto) {
        Integer retorno = 0;
        this.tipoProducto = tipoProducto;
        this.usarTransaccion = false;

        try {
            this.iniciarTransaccion();
            retorno = super.modificar();
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
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "TIPO=?,IMAGEN=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "ID_TIPO_PRODUCTO=?";
        } else {
            sql = "ID_TIPO_PRODUCTO=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.tipoProducto.getTipo());
        this.incluirParametroByte(2, this.tipoProducto.getImagen());
        this.incluirParametroInt(3, this.tipoProducto.getIdTipoProducto());
    }
    
    /*
     * ************************************************************************
     * ELIMINAR
     * ************************************************************************
     */

    @Override
    public Integer eliminar(TipoProducto tipoProducto) {
        Integer retorno = 0;
        this.tipoProducto = tipoProducto;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
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
        this.incluirParametroInt(1, this.tipoProducto.getIdTipoProducto());
    }
    
    /*
     * ************************************************************************
     * LISTADOS
     * ************************************************************************
     */

    @Override
    public ArrayList<TipoProducto> listarTodos() {
        return (ArrayList<TipoProducto>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "ID_TIPO_PRODUCTO, TIPO, IMAGEN";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.tipoProducto);
    }
    
    

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tipoProducto = new TipoProducto();
        this.tipoProducto.setIdTipoProducto(this.resultSet.getInt("ID_TIPO_PRODUCTO"));
        this.tipoProducto.setTipo(this.resultSet.getString("TIPO"));
        this.tipoProducto.setImagen(this.resultSet.getBytes("IMAGEN"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.tipoProducto = null;
    }
    
    /*
     * ************************************************************************
     * OBTENER POR ID
     * ************************************************************************
     */
    
    @Override
    public TipoProducto obtenerPorId(Integer idTipoProducto) {
        this.tipoProducto = new TipoProducto();
        this.tipoProducto.setIdTipoProducto(idTipoProducto);
        super.obtenerPorId();
        return this.tipoProducto;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.tipoProducto.getIdTipoProducto());
    }
    
    /*
     * *************************************************************************
     * EXISTE TIPO DE PRODUCTO
     * Funciones adicionales
     * *************************************************************************
     */

    @Override
    public Boolean existeTipoProducto(TipoProducto tipoProducto) {
        Boolean abreConexion = true;
        return existeTipoProducto(tipoProducto, abreConexion);
    }

    @Override
    public Boolean existeTipoProducto(TipoProducto tipoProducto, Boolean abreConexion) {
        this.tipoProducto = tipoProducto;
        Integer idTipoProducto = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_TIPO_PRODUCTO from TIPO_PRODUCTO where ";
            sql = sql.concat("TIPO=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.tipoProducto.getTipo());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idTipoProducto = this.resultSet.getInt("ID_TIPO_PRODUCTO");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe tipoProducto - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idTipoProducto != null;
    }
    
    @Override
    public Integer buscarIdPorTipo(TipoProducto tipoProducto, Boolean abreConexion) {
        this.tipoProducto = tipoProducto;
        Integer idTipoProducto = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_TIPO_PRODUCTO from TIPO_PRODUCTO where ";
            sql = sql.concat("TIPO=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.tipoProducto.getTipo());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idTipoProducto = this.resultSet.getInt("ID_TIPO_PRODUCTO");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe tipoProducto - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idTipoProducto;
    }
}
