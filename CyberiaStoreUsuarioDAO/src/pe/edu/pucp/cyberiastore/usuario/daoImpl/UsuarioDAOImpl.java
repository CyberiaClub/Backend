package pe.edu.pucp.cyberiastore.usuario.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.usuario.dao.UsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;
import java.util.List;

public class UsuarioDAOImpl extends DAOImpl implements UsuarioDAO {

    private Usuario usuario;

    public UsuarioDAOImpl() {
        super("USUARIO");
        this.usuario = null;
    }

    /*
     * ************************************************************************
     * Insertar
     * ************************************************************************
     */
    /**
     * Funcion que viene de UsuarioDAO.
     *
     * Aquí también se define si queremos que se retorne la llave primaria o no
     *
     * @param usuario: este tiene que contener todos sus atributos ya cargados
     * @return
     */
    @Override
    public Integer insertar(Usuario usuario) {
        this.usuario = usuario;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    /**
     * Funcion definida en UsuarioDAO Usada para la insersión de datos por medio
     * de herencia.
     *
     * @param usuario
     * @param usarTransaccion
     * @param conexion
     * @return
     */
    @Override
    public Integer insertar(Usuario usuario, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(usuario);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "DOCUMENTO, TELEFONO, NOMBRE,APELLIDO_PATERNO, APELLIDO_MATERNO,SEXO , FECHA_NACIMIENTO, CORREO, DIRECCION, ACTIVO, CONTRASEÑA, NACIONALIDAD, TIPO_DOCUMENTO,ROL";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.usuario.getDocumento());
        this.incluirParametroString(2, this.usuario.getTelefono());
        this.incluirParametroString(3, this.usuario.getNombre());
        this.incluirParametroString(4, this.usuario.getApellidoPaterno());
        this.incluirParametroString(5, this.usuario.getApellidoMaterno());
        this.incluirParametroString(6, this.usuario.getSexo() + "");
        this.incluirParametroDate(7, this.usuario.getFechaDeNacimiento());
        this.incluirParametroString(8, this.usuario.getCorreo());
        this.incluirParametroString(9, this.usuario.getDireccion());
        this.incluirParametroBoolean(10, this.usuario.getActivo());
        this.incluirParametroString(11, this.usuario.getContrasena());
        this.incluirParametroString(12, this.usuario.getNacionalidad());
        this.incluirParametroString(13, this.usuario.getTipoDeDocumento().toString());
        this.incluirParametroString(14, this.usuario.getRol().toString());
    }

    /*
     * **************************************************************************
     * MODIFICAR
     * *************************************************************************
     */
    @Override
    public Integer modificar(Usuario usuario) {
        this.usuario = usuario;
        return super.modificar();
    }

    @Override
    public Integer modificar(Usuario usuario, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(usuario);
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "ID_USUARIO=?";
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "DOCUMENTO=?, TELEFONO=?, NOMBRE=?,APELLIDO_PATERNO=?, APELLIDO_MATERNO =?,SEXO=?, FECHA_NACIMIENTO=?, CORREO=?, DIRECCION=?, ACTIVO=?, CONTRASEÑA=?, NACIONALIDAD=?, TIPO_DOCUMENTO=?,ROL=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.usuario.getDocumento());
        this.incluirParametroString(2, this.usuario.getTelefono());
        this.incluirParametroString(3, this.usuario.getNombre());
        this.incluirParametroString(4, this.usuario.getApellidoPaterno());
        this.incluirParametroString(5, this.usuario.getApellidoMaterno());
        this.incluirParametroString(6, this.usuario.getSexo() + "");
        this.incluirParametroDate(7, this.usuario.getFechaDeNacimiento());
        this.incluirParametroString(8, this.usuario.getCorreo());
        this.incluirParametroString(9, this.usuario.getDireccion());
        this.incluirParametroBoolean(10, this.usuario.getActivo());
        this.incluirParametroString(11, this.usuario.getContrasena());
        this.incluirParametroString(12, this.usuario.getNacionalidad());
        this.incluirParametroString(13, this.usuario.getTipoDeDocumento().toString());
        this.incluirParametroString(14, this.usuario.getRol().toString());
        // este es para la comparacion de id_usuario = ?
        this.incluirParametroInt(15, this.usuario.getIdUsuario());
    }

    /*
     * **************************************************************************
     * ELIMINIAR
     * *************************************************************************
     */
    @Override
    public Integer eliminar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Usuario usuario, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * LISTAR TODOS
     * *************************************************************************
     */
    @Override
    public ArrayList<Usuario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        return (ArrayList<Usuario>) super.listarTodos(null);
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
    protected void instanciarObjetoDelResultSet() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * OBTENER POR ID
     * *************************************************************************
     */
    @Override
    public Usuario obtenerPorId(Integer idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * EXISTE USUARIO
     * y funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeUsuario(Usuario usuario) {
        this.usuario = usuario;
        Integer idUsuario = null;
        try {
            this.abrirConexion();
            String sql = "select id_usuario from usuario where ";
            sql = sql.concat("apellido_paterno=? ");
            sql = sql.concat("and apellido_materno=? ");
            sql = sql.concat("and nombre=? ");
            sql = sql.concat("and documento=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.usuario.getApellidoPaterno());
            this.incluirParametroString(2, this.usuario.getApellidoMaterno());
            this.incluirParametroString(3, this.usuario.getNombre());
            this.incluirParametroString(4, this.usuario.getDocumento());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idUsuario = this.resultSet.getInt("id_usuario");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe usuario - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.usuario.setIdUsuario(idUsuario);
        return idUsuario != null;
    }
}
