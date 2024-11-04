package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;

public class MarcaDAOImpl extends DAOImpl implements MarcaDAO {
    
    private Marca marca;

    public MarcaDAOImpl() {
        super("MARCA");
        this.marca = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    public Integer insertar(Marca marca) {
        this.marca = marca;
        Integer idMarca = null;

        Boolean existeMarca = this.existeMarca(marca);
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeMarca) {
                this.retornarLlavePrimaria = true;
                idMarca = super.insertar();
                
                this.retornarLlavePrimaria = false;

            } else {
                idMarca = marca.getIdMarca();
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
        return idMarca;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NOMBRE,ACTIVO,IMAGEN";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.marca.getNombre());
        this.incluirParametroBoolean(2, this.marca.getActivo());
        this.incluirParametroByte(3, this.marca.getImagen());
    }

    @Override
    public Integer modificar(Marca marca) {
        Integer retorno = 0;
        this.marca = marca;
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
        return "nombre=?,activo=?,imagen=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "id_marca=?";
        } else {
            sql = "id_marca=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.marca.getNombre());
        this.incluirParametroBoolean(2, this.marca.getActivo());
        this.incluirParametroByte(3, this.marca.getImagen());
        this.incluirParametroInt(4, this.marca.getIdMarca());
    }

    @Override
    public Integer eliminar(Marca marca) {
        Integer retorno = 0;
        this.marca = marca;

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
        this.incluirParametroInt(1, this.marca.getIdMarca());
    }

    @Override
    public ArrayList<Marca> listarTodos() {
        return (ArrayList<Marca>) super.listarTodos(null);
    }
    
    @Override
    public ArrayList<Marca> listarIdNombre() {
        return null;
    }
    

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "id_marca, nombre,imagen";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.marca);
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.marca.getIdMarca());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.marca = new Marca();
        this.marca.setIdMarca(this.resultSet.getInt("id_marca"));
        this.marca.setNombre(this.resultSet.getString("nombre"));
        this.marca.setImagen(this.resultSet.getBytes("imagen"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.marca = null;
    }

    @Override
    public Marca obtenerPorId(Integer idMarca) {
        this.marca = new Marca();
        this.marca.setIdMarca(idMarca);
        super.obtenerPorId();
        return this.marca;
    }

    @Override
    public Boolean existeMarca(Marca marca) {
        Boolean abreConexion = true;
        return existeMarca(marca, abreConexion);
    }

    @Override
    public Boolean existeMarca(Marca marca, Boolean abreConexion) {
        this.marca = marca;
        Integer idMarca = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_Marca from marca where ";
            sql = sql.concat("nombre=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.marca.getNombre());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idMarca = this.resultSet.getInt("id_Marca");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe marca - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idMarca != null;
    }
    
    @Override
    public Integer buscarIdPorNombre(Marca marca, Boolean abreConexion) {
        this.marca = marca;
        Integer idMarca = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_MARCA from MARCA where ";
            sql = sql.concat("NOMBRE=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.marca.getNombre());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idMarca = this.resultSet.getInt("ID_MARCA");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe marca - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idMarca;
    }
}