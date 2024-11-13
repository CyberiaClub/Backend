package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class VendedorDAOImpl extends DAOImpl implements VendedorDAO {

    private Vendedor vendedor;

    public VendedorDAOImpl() {
        super("VENDEDOR");
        this.vendedor = null;
    }

    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    @Override
    public Integer insertar(Vendedor vendedor) {
        this.vendedor = vendedor;
        Integer idTrabajador = null;
        Trabajador trabajador = new Trabajador();
        trabajador.setIdUsuario(vendedor.getIdUsuario());
        trabajador.setSueldo(vendedor.getSueldo());
        trabajador.setFechaDeIngreso(vendedor.getFechaDeIngreso());
        trabajador.setIdSede(vendedor.getIdSede());
//        trabajador.setDocumento(vendedor.getDocumento());
//        trabajador.setTelefono(vendedor.getTelefono());
//        trabajador.setNombre(vendedor.getNombre());
//        trabajador.setApellidoPaterno(vendedor.getApellidoPaterno());
//        trabajador.setApellidoMaterno(vendedor.getApellidoMaterno());
//        trabajador.setSexo(vendedor.getSexo());
//        trabajador.setFechaDeNacimiento(vendedor.getFechaDeNacimiento());
//        trabajador.setCorreo(vendedor.getCorreo());
//        trabajador.setContrasena(vendedor.getContrasena());
//        trabajador.setNacionalidad(vendedor.getNacionalidad());
//        trabajador.setDireccion(vendedor.getDireccion());
//        trabajador.setTipoDeDocumento(vendedor.getTipoDeDocumento());
        trabajador.setRol(vendedor.getRol());

        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();
        Integer idVendedor = null;
        Boolean existeTrabajador = trabajadorDAO.existeTrabajador(trabajador);
        Boolean existeVendedor = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeTrabajador) {
                idTrabajador = trabajadorDAO.insertar(trabajador, this.usarTransaccion, this.conexion);
                this.vendedor.setIdTrabajador(idTrabajador);
            } else {
                idTrabajador = trabajador.getIdTrabajador();
                this.vendedor.setIdTrabajador(idTrabajador);
                Boolean abreConexion = false;
                existeVendedor = this.existeVendedor(this.vendedor, abreConexion);
            }
            if (!existeVendedor) {
                this.retornarLlavePrimaria = true;
                idVendedor = super.insertar();
                this.vendedor.setIdVendedor(idVendedor);
                this.vendedor.setIdTrabajador(trabajador.getIdTrabajador());
                this.vendedor.setIdUsuario(trabajador.getIdUsuario());
                this.retornarLlavePrimaria = false;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar Vendedor " + ex);
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
        return idVendedor;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "ID_TRABAJADOR";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.vendedor.getIdTrabajador());
    }

    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Vendedor vendedor) {
        Integer retorno = 0;
        this.vendedor = vendedor;
        Trabajador trabajador = new Trabajador();// traemos la clase padre
        trabajador.setIdTrabajador(vendedor.getIdTrabajador());
        trabajador.setSueldo(vendedor.getSueldo());
        trabajador.setFechaDeIngreso(vendedor.getFechaDeIngreso());
        trabajador.setIdSede(vendedor.getIdSede());
        trabajador.setIdUsuario(vendedor.getIdUsuario());
        trabajador.setDocumento(vendedor.getDocumento());
        trabajador.setTelefono(vendedor.getTelefono());
        trabajador.setNombre(vendedor.getNombre());
        trabajador.setApellidoPaterno(vendedor.getApellidoPaterno());
        trabajador.setApellidoMaterno(vendedor.getApellidoMaterno());
        trabajador.setSexo(vendedor.getSexo());
        trabajador.setFechaDeNacimiento(vendedor.getFechaDeNacimiento());
        trabajador.setCorreo(vendedor.getCorreo());
        trabajador.setContrasena(vendedor.getContrasena());
        trabajador.setNacionalidad(vendedor.getNacionalidad());
        trabajador.setDireccion(vendedor.getDireccion());
        trabajador.setTipoDeDocumento(vendedor.getTipoDeDocumento());

        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            trabajadorDAO.modificar(trabajador, this.usarTransaccion, this.conexion);
            // Este no se modifica a si mismo, porque solo almacena el ID del trabajador el cual no varia
//            retorno = super.modificar();
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
        return "ID_TRABAJADOR=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "ID_VENDEDOR=?";
        } else {
            sql = "AND VEN.ID_VENDEDOR=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.vendedor.getIdVendedor());
        this.incluirParametroInt(2, this.vendedor.getIdTrabajador());
    }

    /*
     * ************************************************************************
     * ELIMINAR
     * Los trabajadadores vendieron su alma al diablo xD
     * ************************************************************************
     */
    @Override
    public Integer eliminar(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * ************************************************************************
     * OBTENER POR ID
     * ************************************************************************
     */
    @Override
    public Vendedor obtenerPorId(Integer idVendedor) {
        this.vendedor = new Vendedor();
        this.vendedor.setIdVendedor(idVendedor);
        super.obtenerPorId();
        return this.vendedor;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" VEN ");
        sql = sql.concat("JOIN TRABAJADOR TR ON VEN.ID_TRABAJADOR = TR.ID_TRABAJADOR ");
        sql = sql.concat("JOIN USUARIO US ON TR.ID_USUARIO = US.ID_USUARIO ");
        sql = sql.concat("JOIN TRABAJADOR_X_SEDE TRXS ON TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR ");
        sql = sql.concat("JOIN SEDE S ON TRXS.ID_SEDE = S.ID_SEDE ");
        sql = sql.concat(" where US.ACTIVO = 1 ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.vendedor.getIdVendedor());
    }

    /*
     * ************************************************************************
     * LISTAR TODOS
     * Los trabajadadores vendieron su alma al diablo xD
     * ************************************************************************
     */
    @Override
    public ArrayList<Vendedor> listarTodos() {
        return (ArrayList<Vendedor>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" VEN ");
        sql = sql.concat("JOIN TRABAJADOR TR ON VEN.ID_TRABAJADOR = TR.ID_TRABAJADOR ");
        sql = sql.concat("JOIN USUARIO US ON TR.ID_USUARIO = US.ID_USUARIO ");
        sql = sql.concat("JOIN TRABAJADOR_X_SEDE TRXS ON TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR ");
        sql = sql.concat("JOIN SEDE S ON TRXS.ID_SEDE = S.ID_SEDE ");
        sql = sql.concat("WHERE US.ACTIVO = 1 ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "VEN.ID_VENDEDOR,TR.ID_TRABAJADOR,US.ID_USUARIO,";
        sql = sql.concat("US.NOMBRE, US.APELLIDO_PATERNO, US.APELLIDO_MATERNO,US.SEXO,US.DOCUMENTO,US.FECHA_NACIMIENTO,");
        sql = sql.concat("US.TELEFONO, US.CORREO, US.NACIONALIDAD,US.TIPO_DOCUMENTO,");
        sql = sql.concat("TR.SUELDO,TR.FECHA_INGRESO,");
        sql = sql.concat("S.NOMBRE as SEDE_NOMBRE");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.vendedor);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.vendedor = new Vendedor();
        this.vendedor.setIdVendedor(this.resultSet.getInt("ID_VENDEDOR"));
        this.vendedor.setIdTrabajador(this.resultSet.getInt("ID_TRABAJADOR"));
        this.vendedor.setIdUsuario(this.resultSet.getInt("ID_USUARIO"));
        this.vendedor.setNombre(this.resultSet.getString("NOMBRE"));
        this.vendedor.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
        this.vendedor.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
        this.vendedor.setSexo(this.resultSet.getString("SEXO").charAt(0));
        this.vendedor.setDocumento(this.resultSet.getString("DOCUMENTO"));
        this.vendedor.setFechaDeNacimiento(this.resultSet.getTimestamp("FECHA_NACIMIENTO"));
        this.vendedor.setTelefono(this.resultSet.getString("TELEFONO"));
        this.vendedor.setCorreo(this.resultSet.getString("CORREO"));
        this.vendedor.setNacionalidad(this.resultSet.getString("NACIONALIDAD"));

        String tipoDocumentoStr = this.resultSet.getString("TIPO_DOCUMENTO");
        TipoDocumento tipoDocumento = TipoDocumento.valueOf(tipoDocumentoStr);
        this.vendedor.setTipoDeDocumento(tipoDocumento);

        this.vendedor.setFechaDeIngreso(this.resultSet.getTimestamp("FECHA_INGRESO"));
        this.vendedor.setSueldo(this.resultSet.getDouble("SUELDO"));
        this.vendedor.setNombreSede(this.resultSet.getString("SEDE_NOMBRE"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.vendedor = null;
    }

    /*
     * ************************************************************************
     * EXISTE CLASE
     * y funciones adicionales
     * ************************************************************************
     */
    @Override
    public Boolean existeVendedor(Vendedor vendedor) {
        Boolean abreConexion = true;
        return existeVendedor(vendedor, abreConexion);
    }

    @Override
    public Boolean existeVendedor(Vendedor vendedor, Boolean abreConexion) {
        this.vendedor = vendedor;
        Integer idVendedor = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_VENDEDOR from VENDEDOR where ";
            sql = sql.concat("ID_TRABAJADOR=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.vendedor.getIdTrabajador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idVendedor = this.resultSet.getInt("ID_VENDEDOR");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe vendedor - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idVendedor != null;
    }
}
