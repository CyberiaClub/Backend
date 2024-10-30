package pe.edu.pucp.cyberiastore.sede.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;

public class SedeDAOImpl extends DAOImpl implements SedeDAO {

    private Sede sede;

    public SedeDAOImpl() {
        super("SEDE");
        this.sede = null;
    }

    @Override
    public Integer insertar(Sede sede) {
        this.sede = sede;
        Integer idSede = null;

        Boolean existeSede = this.existeSede(sede);
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeSede) {
                this.retornarLlavePrimaria = true;
                idSede = super.insertar();
                this.retornarLlavePrimaria = false;

            } else {
                idSede = sede.getIdSede();
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
        return idSede;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NOMBRE, DESCRIPCION";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.sede.getNombre());
        this.incluirParametroString(2, this.sede.getDescripcion());
    }

    @Override
    public Integer modificar(Sede sede) {
        Integer retorno = 0;
        this.sede = sede;
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
        return "nombre=?, descripcion=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "id_sede=?";
        } else {
            sql = "per.id_sede=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.sede.getNombre());
        this.incluirParametroString(2, this.sede.getDescripcion());
        this.incluirParametroInt(3, this.sede.getIdSede());

    }

    @Override
    public Integer eliminar(Sede sede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Sede> listarTodos() {
        return (ArrayList<Sede>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "id_sede, nombre, descripcion";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.sede);
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.sede.getIdSede());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.sede = new Sede();
        this.sede.setIdSede(this.resultSet.getInt("id_sede"));
        this.sede.setNombre(this.resultSet.getString("nombre"));
        this.sede.setDescripcion(this.resultSet.getString("descripcion"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.sede = null;
    }

    @Override
    public Sede obtenerPorId(Integer idSede) {
        this.sede = new Sede();
        this.sede.setIdSede(idSede);
        super.obtenerPorId();
        return this.sede;
    }

    @Override
    public Boolean existeSede(Sede sede) {
        Boolean abreConexion = true;
        return existeSede(sede, abreConexion);
    }

    @Override
    public Boolean existeSede(Sede sede, Boolean abreConexion) {
        this.sede = sede;
        Integer idSede = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_Sede from sede where ";
            sql = sql.concat("nombre=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.sede.getNombre());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idSede = this.resultSet.getInt("id_Sede");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe sede - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idSede != null;
    }
    
    @Override
    public Integer buscarIdPorNombre(Sede sede, Boolean abreConexion) {
        this.sede = sede;
        Integer idSede = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_SEDE from SEDE where ";
            sql = sql.concat("NOMBRE=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.sede.getNombre());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idSede = this.resultSet.getInt("ID_SEDE");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe sede - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idSede;
    }


}
