package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class AlmaceneroDAOImpl extends DAOImpl implements AlmaceneroDAO {

    private Almacenero almacenero;

    public AlmaceneroDAOImpl() {
        super("ALMACENERO");
        this.almacenero = null;
    }

    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    @Override
    public Integer insertar(Almacenero almacenero) {
        this.almacenero = almacenero;
        Integer idTrabajador = null;// el ID de la clase que hereda
        Trabajador trabajador = new Trabajador();// traemos la clase padre
        trabajador.setSueldo(almacenero.getSueldo());
        trabajador.setFechaDeIngreso(almacenero.getFechaDeIngreso());
        trabajador.setIdSede(almacenero.getIdSede());
        trabajador.setDocumento(almacenero.getDocumento());
        trabajador.setTelefono(almacenero.getTelefono());
        trabajador.setNombre(almacenero.getNombre());
        trabajador.setApellidoPaterno(almacenero.getApellidoPaterno());
        trabajador.setApellidoMaterno(almacenero.getApellidoMaterno());
        trabajador.setSexo(almacenero.getSexo());
        trabajador.setFechaDeNacimiento(almacenero.getFechaDeNacimiento());
        trabajador.setCorreo(almacenero.getCorreo());
        trabajador.setContrasena(almacenero.getContrasena());
        trabajador.setNacionalidad(almacenero.getNacionalidad());
        trabajador.setDireccion(almacenero.getDireccion());
        trabajador.setTipoDeDocumento(almacenero.getTipoDeDocumento());
        trabajador.setRol(almacenero.getRol());

        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();
        Integer idAlmacenero = null;
        Boolean existeTrabajador = trabajadorDAO.existeTrabajador(trabajador);
        Boolean existeAlmacenero = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeTrabajador) {
                idTrabajador = trabajadorDAO.insertar(trabajador, this.usarTransaccion, this.conexion);
                this.almacenero.setIdTrabajador(idTrabajador);
            } else {
                idTrabajador = trabajador.getIdTrabajador();
                this.almacenero.setIdTrabajador(idTrabajador);
                Boolean abreConexion = false;
                existeAlmacenero = this.existeAlmacenero(this.almacenero, abreConexion);
            }
            if (!existeAlmacenero) {
                this.retornarLlavePrimaria = true;
                idAlmacenero = super.insertar();
                this.almacenero.setIdAlmacenero(idAlmacenero);
                this.almacenero.setIdTrabajador(trabajador.getIdTrabajador());
                this.almacenero.setIdUsuario(trabajador.getIdUsuario());
                this.retornarLlavePrimaria = false;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar Almacenero " + ex);
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
        return idTrabajador;
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
        this.incluirParametroInt(1, this.almacenero.getIdTrabajador());
    }

    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Almacenero almacenero) {
        Integer retorno = 0;
        this.almacenero = almacenero;
        Trabajador trabajador = new Trabajador();// traemos la clase padre
        trabajador.setIdTrabajador(almacenero.getIdTrabajador());
        trabajador.setSueldo(almacenero.getSueldo());
        trabajador.setFechaDeIngreso(almacenero.getFechaDeIngreso());
        trabajador.setIdSede(almacenero.getIdSede());
        trabajador.setIdUsuario(almacenero.getIdUsuario());
        trabajador.setDocumento(almacenero.getDocumento());
        trabajador.setTelefono(almacenero.getTelefono());
        trabajador.setNombre(almacenero.getNombre());
        trabajador.setApellidoPaterno(almacenero.getApellidoPaterno());
        trabajador.setApellidoMaterno(almacenero.getApellidoMaterno());
        trabajador.setSexo(almacenero.getSexo());
        trabajador.setFechaDeNacimiento(almacenero.getFechaDeNacimiento());
        trabajador.setCorreo(almacenero.getCorreo());
        trabajador.setContrasena(almacenero.getContrasena());
        trabajador.setNacionalidad(almacenero.getNacionalidad());
        trabajador.setDireccion(almacenero.getDireccion());
        trabajador.setTipoDeDocumento(almacenero.getTipoDeDocumento());

        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            trabajadorDAO.modificar(trabajador, this.usarTransaccion, this.conexion);
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
        return "ID_TRABAJADOR=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "id_almacenero=?";
        } else {
            sql = "AND AL.id_almacenero=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.almacenero.getIdAlmacenero());
        this.incluirParametroInt(2, this.almacenero.getIdTrabajador());
    }

    /*
     * ************************************************************************
     * ELIMINAR
     * Los trabajadadores vendieron su alma al diablo xD
     * ************************************************************************
     */
    @Override
    public Integer eliminar(Almacenero almacenero) {
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
    public Almacenero obtenerPorId(Integer idAlmacenero) {
        this.almacenero = new Almacenero();
        this.almacenero.setIdAlmacenero(idAlmacenero);
        super.obtenerPorId();
        return this.almacenero;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" AL ");
        sql = sql.concat("JOIN trabajador TR ON AL.ID_TRABAJADOR = TR.ID_TRABAJADOR ");
        sql = sql.concat("JOIN usuario US ON TR.ID_USUARIO = US.ID_USUARIO ");
        sql = sql.concat("JOIN trabajador_x_sede TRXS ON TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR ");
        sql = sql.concat("JOIN sede S ON TRXS.ID_SEDE = S.ID_SEDE ");
        sql = sql.concat(" where US.activo = 1 ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.almacenero.getIdAlmacenero());
    }


    /*
     * ************************************************************************
     * LISTAR TODOS
     * Los trabajadadores vendieron su alma al diablo xD
     * ************************************************************************
     */
    @Override
    public ArrayList<Almacenero> listarTodos() {
        return (ArrayList<Almacenero>) super.listarTodos(null);

    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" AL ");
        sql = sql.concat("JOIN trabajador TR ON AL.ID_TRABAJADOR = TR.ID_TRABAJADOR ");
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
        String sql = "AL.ID_ALMACENERO,TR.ID_TRABAJADOR,US.ID_USUARIO,";
        sql = sql.concat("US.NOMBRE, US.APELLIDO_PATERNO, US.APELLIDO_MATERNO,US.SEXO,US.DOCUMENTO,US.FECHA_NACIMIENTO,");
        sql = sql.concat("US.TELEFONO, US.CORREO, US.NACIONALIDAD,US.TIPO_DOCUMENTO,");
        sql = sql.concat("TR.SUELDO,TR.FECHA_INGRESO,");
        sql = sql.concat("S.NOMBRE as SEDE_NOMBRE");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.almacenero);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.almacenero = new Almacenero();
        this.almacenero.setIdAlmacenero(this.resultSet.getInt("id_almacenero"));
        this.almacenero.setIdTrabajador(this.resultSet.getInt("id_trabajador"));
        this.almacenero.setIdUsuario(this.resultSet.getInt("id_usuario"));
        this.almacenero.setNombre(this.resultSet.getString("nombre"));
        this.almacenero.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
        this.almacenero.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
        this.almacenero.setSexo(this.resultSet.getString("SEXO").charAt(0));
        this.almacenero.setDocumento(this.resultSet.getString("DOCUMENTO"));
        this.almacenero.setFechaDeNacimiento(this.resultSet.getTimestamp("FECHA_NACIMIENTO"));
        this.almacenero.setTelefono(this.resultSet.getString("TELEFONO"));
        this.almacenero.setCorreo(this.resultSet.getString("CORREO"));
        this.almacenero.setNacionalidad(this.resultSet.getString("NACIONALIDAD"));

        String tipoDocumentoStr = this.resultSet.getString("TIPO_DOCUMENTO");
        TipoDocumento tipoDocumento = TipoDocumento.valueOf(tipoDocumentoStr);
        this.almacenero.setTipoDeDocumento(tipoDocumento);

        this.almacenero.setFechaDeIngreso(this.resultSet.getTimestamp("FECHA_INGRESO"));
        this.almacenero.setSueldo(this.resultSet.getDouble("SUELDO"));
        this.almacenero.setNombreSede(this.resultSet.getString("SEDE_NOMBRE"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.almacenero = null;
    }

    /*
     * ************************************************************************
     * EXISTE CLASE
     * y funciones adicionales
     * ************************************************************************
     */
    @Override
    public Boolean existeAlmacenero(Almacenero almacenero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeAlmacenero(Almacenero almacenero, Boolean abreConexion) {
        this.almacenero = almacenero;
        Integer idVendedor = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_almacenero from almacenero where ";
            sql = sql.concat("id_trabajador=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.almacenero.getIdTrabajador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idVendedor = this.resultSet.getInt("id_almacenero");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe almacenero - " + ex);
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
