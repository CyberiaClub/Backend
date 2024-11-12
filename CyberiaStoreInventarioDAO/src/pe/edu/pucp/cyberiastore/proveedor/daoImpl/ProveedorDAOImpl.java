package pe.edu.pucp.cyberiastore.proveedor.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;

public class ProveedorDAOImpl extends DAOImpl implements ProveedorDAO {

    private Proveedor proveedor;

    public ProveedorDAOImpl() {
        super("PROVEEDOR");
        this.proveedor = null;
    }
    
    @Override
    public Integer insertar(Proveedor proveedor) {
        this.proveedor = proveedor;
        Integer idProveedor = null;

        Boolean existeProveedor = this.existeProveedor(proveedor);
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeProveedor) {
                this.retornarLlavePrimaria = true;
                idProveedor = super.insertar();
                this.retornarLlavePrimaria = false;
                
            } else {
                idProveedor = proveedor.getIdProveedor();
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
        return idProveedor;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "RUC,RAZON_SOCIAL, NOMBRE_DEL_CONTACTO, CORREO, TELEFONO, DIRECCION, DESCRIPCION, ACTIVO";

    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.proveedor.getRuc());

        this.incluirParametroString(2, this.proveedor.getRazonSocial());
        this.incluirParametroString(3, this.proveedor.getNombreContacto());
        this.incluirParametroString(4, this.proveedor.getCorreo());
        this.incluirParametroString(5, this.proveedor.getTelefono());
        this.incluirParametroString(6, this.proveedor.getDireccion());
        this.incluirParametroString(7, this.proveedor.getDescripcion());
        this.incluirParametroBoolean(8, this.proveedor.getActivo());
    }

    @Override
    public Integer modificar(Proveedor proveedor) {
        Integer retorno = 0;
        this.proveedor = proveedor;
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
        return "RUC=?,RAZON_SOCIAL=?, NOMBRE_DEL_CONTACTO=?, CORREO=?, TELEFONO=?, DIRECCION=?, DESCRIPCION=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "ID_PROVEEDOR=?";
        } else {
            sql = "ID_PROVEEDOR=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.proveedor.getRuc());
        this.incluirParametroString(2, this.proveedor.getRazonSocial());
        this.incluirParametroString(3, this.proveedor.getNombreContacto());
        this.incluirParametroString(4, this.proveedor.getCorreo());
        this.incluirParametroString(5, this.proveedor.getTelefono());
        this.incluirParametroString(6, this.proveedor.getDireccion());
        this.incluirParametroString(7, this.proveedor.getDescripcion());
        this.incluirParametroInt(8, this.proveedor.getIdProveedor());
    }

    @Override
    public Integer eliminar(Proveedor proveedor) {
        Integer retorno = 0;
        this.proveedor = proveedor;

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
        this.incluirParametroInt(1, this.proveedor.getIdProveedor());
    }

    @Override
    public ArrayList<Proveedor> listarTodos() {
        return (ArrayList<Proveedor>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "ID_PROVEEDOR, RUC, RAZON_SOCIAL, NOMBRE_DEL_CONTACTO, CORREO, TELEFONO, DIRECCION, DESCRIPCION, ACTIVO";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.proveedor);
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.proveedor.getIdProveedor());
        this.incluirParametroString(2, this.proveedor.getRuc());
        this.incluirParametroString(3, this.proveedor.getRazonSocial());
        this.incluirParametroString(4, this.proveedor.getNombreContacto());
        this.incluirParametroString(5, this.proveedor.getCorreo());
        this.incluirParametroString(6, this.proveedor.getTelefono());
        this.incluirParametroString(7, this.proveedor.getDireccion());
        this.incluirParametroString(8, this.proveedor.getDescripcion());
        this.incluirParametroBoolean(9, this.proveedor.getActivo());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.proveedor = new Proveedor();
        this.proveedor.setIdProveedor(this.resultSet.getInt("ID_PROVEEDOR"));
        this.proveedor.setRuc(this.resultSet.getString("RUC"));
        this.proveedor.setRazonSocial(this.resultSet.getString("RAZON_SOCIAL"));
        this.proveedor.setNombreContacto(this.resultSet.getString("NOMBRE_DEL_CONTACTO"));
        this.proveedor.setCorreo(this.resultSet.getString("CORREO"));
        this.proveedor.setTelefono(this.resultSet.getString("TELEFONO"));
        this.proveedor.setDireccion(this.resultSet.getString("DIRECCION"));
        this.proveedor.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.proveedor.setActivo(this.resultSet.getBoolean("ACTIVO"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.proveedor = null;
    }

    @Override
    public Proveedor obtenerPorId(Integer idProveedor) {
        this.proveedor = new Proveedor();
        this.proveedor.setIdProveedor(idProveedor);
        super.obtenerPorId();
        return this.proveedor;
    }

    @Override
    public Boolean existeProveedor(Proveedor proveedor) {
        Boolean abreConexion = true;
        return existeProveedor(proveedor, abreConexion);
    }

    @Override
    public Boolean existeProveedor(Proveedor proveedor, Boolean abreConexion) {
        this.proveedor = proveedor;
        Integer idProveedor = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_PROVEEDOR from PROVEEDOR where ";
            sql = sql.concat("RUC=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.proveedor.getRuc());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idProveedor = this.resultSet.getInt("ID_PROVEEDOR");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe proveedor - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idProveedor != null;
    }
    
    @Override
    public Integer buscarIdPorNombre(Proveedor proveedor, Boolean abreConexion) {
        this.proveedor = proveedor;
        Integer idProveedor = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_PROVEEDOR from PROVEEDOR where ";
            sql = sql.concat("RAZON_SOCIAL=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.proveedor.getRazonSocial());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idProveedor = this.resultSet.getInt("ID_PROVEEDOR");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe proveedor - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idProveedor;
    }
}