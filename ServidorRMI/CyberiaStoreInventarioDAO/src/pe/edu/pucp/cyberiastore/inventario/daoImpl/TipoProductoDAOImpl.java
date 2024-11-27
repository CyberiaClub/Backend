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
        this.tipoProducto = tipoProducto;
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

        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    sql = "TIPO=?";
                }
                case LISTAR -> {
                    sql = "";
                }
                default -> {
                    sql = "ID_TIPO_PRODUCTO=?";
                }
            }
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
        this.tipo_Operacion = Tipo_Operacion.LISTAR;
        return (ArrayList<TipoProducto>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    sql = "ID_TIPO_PRODUCTO";
                }
                default ->
                    sql = "ID_TIPO_PRODUCTO, TIPO, IMAGEN";
            }
        }
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
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    this.tipoProducto.setIdTipoProducto(this.resultSet.getInt("ID_TIPO_PRODUCTO"));
                }
                default -> {
                    this.tipoProducto.setIdTipoProducto(this.resultSet.getInt("ID_TIPO_PRODUCTO"));
                    this.tipoProducto.setTipo(this.resultSet.getString("TIPO"));
                    this.tipoProducto.setImagen(this.resultSet.getBytes("IMAGEN"));
                }
            }
        }

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
        this.tipo_Operacion = Tipo_Operacion.BUSCAR_POR_ID;
        this.tipoProducto = new TipoProducto();
        this.tipoProducto.setIdTipoProducto(idTipoProducto);
        super.buscar();
        return this.tipoProducto;
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    this.incluirParametroString(1, this.tipoProducto.getTipo());
                }
                case BUSCAR_POR_ID -> {
                    this.incluirParametroInt(1, this.tipoProducto.getIdTipoProducto());
                }
            }
        }

    }

    /*
     * *************************************************************************
     * EXISTE TIPO DE PRODUCTO
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeTipoProducto(TipoProducto tipoProducto) {
        this.tipo_Operacion = Tipo_Operacion.EXISTE;
        Boolean abreConexion = true;
        this.tipoProducto = tipoProducto;
        super.buscar();
        return this.tipoProducto != null;
    }

}
