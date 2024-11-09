package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class AdministradorDAOImpl extends DAOImpl implements AdministradorDAO {

    private Administrador administrador;

    public AdministradorDAOImpl() {
        super("ADMINISTRADOR");
        this.administrador = null;
    }

    /**
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    @Override
    public Integer insertar(Administrador administrador) {
        this.administrador = administrador;
        Integer idTrabajador = null;// el ID de la clase que hereda
        Trabajador trabajador = new Trabajador();// traemos la clase padre
        trabajador.setSueldo(administrador.getSueldo());
        trabajador.setFechaDeIngreso(administrador.getFechaDeIngreso());
        trabajador.setIdSede(administrador.getIdSede());
        trabajador.setDocumento(administrador.getDocumento());
        trabajador.setTelefono(administrador.getTelefono());
        trabajador.setNombre(administrador.getNombre());
        trabajador.setApellidoPaterno(administrador.getApellidoPaterno());
        trabajador.setApellidoMaterno(administrador.getApellidoMaterno());
        trabajador.setSexo(administrador.getSexo());
        trabajador.setFechaDeNacimiento(administrador.getFechaDeNacimiento());
        trabajador.setCorreo(administrador.getCorreo());
        trabajador.setContrasena(administrador.getContrasena());
        trabajador.setNacionalidad(administrador.getNacionalidad());
        trabajador.setDireccion(administrador.getDireccion());
        trabajador.setTipoDeDocumento(administrador.getTipoDeDocumento());

        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();

        Integer idAdministrador = null;

        Boolean existeTrabajador = trabajadorDAO.existeTrabajador(trabajador);
        Boolean existeAdministrador = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeTrabajador) {
                idTrabajador = trabajadorDAO.insertar(trabajador, this.usarTransaccion, this.conexion);
                this.administrador.setIdTrabajador(idTrabajador);
            } else {
                idTrabajador = trabajador.getIdTrabajador();
                this.administrador.setIdTrabajador(idTrabajador);
                Boolean abreConexion = false;
                existeAdministrador = this.existeAdministrador(this.administrador, abreConexion);
            }
            if (!existeAdministrador) {
                this.retornarLlavePrimaria = true;
                idAdministrador = super.insertar();
                this.administrador.setIdAdministrador(idAdministrador);
                this.administrador.setIdTrabajador(trabajador.getIdTrabajador());
                this.administrador.setIdUsuario(trabajador.getIdUsuario());
                this.retornarLlavePrimaria = false;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar Administrador " + ex);
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
        return idAdministrador;
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
        this.incluirParametroInt(1, this.administrador.getIdTrabajador());
    }

    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Administrador administrador) {
        Integer retorno = 0;
        this.administrador = administrador;
        Trabajador trabajador = new Trabajador();// traemos la clase padre
        trabajador.setIdTrabajador(administrador.getIdTrabajador());
        trabajador.setSueldo(administrador.getSueldo());
        trabajador.setFechaDeIngreso(administrador.getFechaDeIngreso());
        trabajador.setIdSede(administrador.getIdSede());
        trabajador.setIdUsuario(administrador.getIdUsuario());
        trabajador.setDocumento(administrador.getDocumento());
        trabajador.setTelefono(administrador.getTelefono());
        trabajador.setNombre(administrador.getNombre());
        trabajador.setApellidoPaterno(administrador.getApellidoPaterno());
        trabajador.setApellidoMaterno(administrador.getApellidoMaterno());
        trabajador.setSexo(administrador.getSexo());
        trabajador.setFechaDeNacimiento(administrador.getFechaDeNacimiento());
        trabajador.setCorreo(administrador.getCorreo());
        trabajador.setContrasena(administrador.getContrasena());
        trabajador.setNacionalidad(administrador.getNacionalidad());
        trabajador.setDireccion(administrador.getDireccion());
        trabajador.setTipoDeDocumento(administrador.getTipoDeDocumento());

        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            trabajadorDAO.modificar(trabajador, this.usarTransaccion, this.conexion);
            // Este no se modifica a si mismo, porque solo almacena el ID del trabajador el cual no puede variar
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
            sql = "id_administrador=?";
        } else {
            sql = "AND AD.id_administrador=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.administrador.getIdAdministrador());
        this.incluirParametroInt(2, this.administrador.getIdTrabajador());
    }

    /*
     * ************************************************************************
     * ELIMINAR
     * Los trabajadadores vendieron su alma al diablo xD
     * ************************************************************************
     */
    @Override
    public Integer eliminar(Administrador administrador) {
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
    public Administrador obtenerPorId(Integer idAdministrador) {
        this.administrador = new Administrador();
        this.administrador.setIdAdministrador(idAdministrador);
        super.obtenerPorId();
        return this.administrador;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" AD ");
        sql = sql.concat("JOIN trabajador TR ON AD.ID_TRABAJADOR = TR.ID_TRABAJADOR ");
        sql = sql.concat("JOIN usuario US ON TR.ID_USUARIO = US.ID_USUARIO ");
        sql = sql.concat("JOIN trabajador_x_sede TRXS ON TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR ");
        sql = sql.concat("JOIN sede S ON TRXS.ID_SEDE = S.ID_SEDE ");
        sql = sql.concat(" where US.activo = 1 ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.administrador.getIdAdministrador());
    }

    /*
     * ************************************************************************
     * LISTAR TODOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Administrador> listarTodos() {
        return (ArrayList<Administrador>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" AD ");
        sql = sql.concat("JOIN trabajador TR ON AD.ID_TRABAJADOR = TR.ID_TRABAJADOR ");
        sql = sql.concat("JOIN usuario US ON TR.ID_USUARIO = US.ID_USUARIO ");
        sql = sql.concat("JOIN trabajador_x_sede TRXS ON TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR ");
        sql = sql.concat("JOIN sede S ON TRXS.ID_SEDE = S.ID_SEDE ");
        sql = sql.concat("WHERE US.activo = 1 ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "AD.ID_ADMINISTRADOR,TR.ID_TRABAJADOR,US.ID_USUARIO,";
        sql = sql.concat("US.NOMBRE, US.APELLIDO_PATERNO, US.APELLIDO_MATERNO,US.SEXO,US.DOCUMENTO,US.FECHA_NACIMIENTO,");
        sql = sql.concat("US.TELEFONO, US.CORREO, US.NACIONALIDAD,US.TIPO_DOCUMENTO,");
        sql = sql.concat("TR.SUELDO,TR.FECHA_INGRESO,");
        sql = sql.concat("S.NOMBRE as SEDE_NOMBRE");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.administrador);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.administrador = new Administrador();
        this.administrador.setIdAdministrador(this.resultSet.getInt("id_administrador"));
        this.administrador.setIdTrabajador(this.resultSet.getInt("id_trabajador"));
        this.administrador.setIdUsuario(this.resultSet.getInt("id_usuario"));
        this.administrador.setNombre(this.resultSet.getString("nombre"));
        this.administrador.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
        this.administrador.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
        this.administrador.setSexo(this.resultSet.getString("SEXO").charAt(0));
        this.administrador.setDocumento(this.resultSet.getString("DOCUMENTO"));
        this.administrador.setFechaDeNacimiento(this.resultSet.getTimestamp("FECHA_NACIMIENTO"));
        this.administrador.setTelefono(this.resultSet.getString("TELEFONO"));
        this.administrador.setCorreo(this.resultSet.getString("CORREO"));
        this.administrador.setNacionalidad(this.resultSet.getString("NACIONALIDAD"));

        String tipoDocumentoStr = this.resultSet.getString("TIPO_DOCUMENTO");
        TipoDocumento tipoDocumento = TipoDocumento.valueOf(tipoDocumentoStr);
        this.administrador.setTipoDeDocumento(tipoDocumento);

        this.administrador.setFechaDeIngreso(this.resultSet.getTimestamp("FECHA_INGRESO"));
        this.administrador.setSueldo(this.resultSet.getDouble("SUELDO"));
        this.administrador.setNombreSede(this.resultSet.getString("SEDE_NOMBRE"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.administrador = null;
    }

    /*
     * *************************************************************************
     * EXISTE ADMINISTRADOR
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeAdministrador(Administrador administrador) {
        Boolean abreConexion = true;
        return existeAdministrador(administrador, abreConexion);
    }

    @Override
    public Boolean existeAdministrador(Administrador administrador, Boolean abreConexion) {
        this.administrador = administrador;
        Integer idAdministrador = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_administrador from administrador where ";
            sql = sql.concat("id_trabajador=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.administrador.getIdTrabajador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idAdministrador = this.resultSet.getInt("id_administrador");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe alumno - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idAdministrador != null;
    }
}
