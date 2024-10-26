package pe.edu.pucp.cyberiastore.usuario.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.usuario.dao.UsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import java.text.SimpleDateFormat;
import java.util.List;

public class UsuarioDAOImpl extends DAOImpl implements UsuarioDAO {

    private Usuario usuario;

    public UsuarioDAOImpl() {
        super("USUARIO");
        this.usuario = null;
        this.retornarLlavePrimaria = true;
    }

    //constructor para el trabajador DAOImpl
    public UsuarioDAOImpl(String nombre) {
        super(nombre);
        this.usuario = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "DOCUMENTO, TELEFONO, NOMBRE,APELLIDO_PATERNO, APELLIDO_MATERNO , FECHA_NACIMIENTO, CORREO, DIRECCION, ACTIVO, CONTRASEÑA, NACIONALIDAD, TIPO_DOCUMENTO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
//    private String correo;
//    private Boolean activo;
//    private String contrasena;
//    private String nacionalidad;
//    private String direccion;
//    private TipoDocumento tipoDeDocumento;
//    private ArrayList<Rol> roles;
        this.incluirParametroString(1, this.usuario.getDocumento());
        this.incluirParametroString(2, this.usuario.getTelefono());
        this.incluirParametroString(3, this.usuario.getNombre());
        this.incluirParametroString(4, this.usuario.getApellidoPaterno());
        this.incluirParametroString(5, this.usuario.getApellidoMaterno());
        this.incluirParametroDate(6, this.usuario.getFechaDeNacimiento());
        this.incluirParametroString(7, this.usuario.getCorreo());
        this.incluirParametroString(8, this.usuario.getDireccion());
        this.incluirParametroBoolean(9, this.usuario.getActivo());
        this.incluirParametroString(10, this.usuario.getContrasena());
        this.incluirParametroString(11, this.usuario.getNacionalidad());
        this.incluirParametroString(10, this.usuario.getTipoDeDocumento().toString());
        
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
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

    @Override
    public Integer insertar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Integer idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtenerPorId(Integer idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer insertarUsuarioDesdeTrabajador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//
//    @Override
//    public Integer insertar(Usuario usuario) {
//        this.usuario = usuario;
//        Integer id = this.insertar();
//        this.usuario.setIdUsuario(id);
//        return id;
//    }
//
//    @Override
//    protected String obtenerListaAtributos() {
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//
//        sql = sql.concat("'" + this.usuario.getDocumento() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getTelefono() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getNombre() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getApellidoMaterno() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getApellidoPaterno() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("STR_TO_DATE('" + this.usuario.getFechaNacimientoAsDDMMYYY() + "','%d-%m-%Y')");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getCorreo() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getDireccion() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getActivoAsInt() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getContrasena() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getNacionalidad() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.usuario.getTipoDeDocumento().toString() + "'");
//        return sql;
//    }
//
//    @Override
//    public Integer modificar(Usuario usuario) {
//        this.usuario = usuario;
//        return super.modificar();
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String sql = "";
//        sql = sql.concat("TELEFONO = ");
//        sql = sql.concat("'" + usuario.getTelefono() + "'");
//        sql = sql.concat(",NOMBRE = ");
//        sql = sql.concat("'" + usuario.getNombre() + "'");
//        sql = sql.concat(",APELLIDO_MATERNO = ");
//        sql = sql.concat("'" + usuario.getApellidoMaterno() + "'");
//        sql = sql.concat(",APELLIDO_PATERNO = ");
//        sql = sql.concat("'" + usuario.getApellidoPaterno() + "'");
//        sql = sql.concat(",FECHA_NACIMIENTO = ");
//        sql = sql.concat("'" + usuario.getFechaNacimientoAsDDMMYYY() + "'");
//        sql = sql.concat(",CORREO = ");
//        sql = sql.concat("'" + usuario.getCorreo() + "'");
//        sql = sql.concat(",DIRECCION = ");
//        sql = sql.concat("'" + usuario.getDireccion() + "'");
//        sql = sql.concat(",ACTIVO = ");
//        sql = sql.concat("'" + usuario.getActivoAsInt() + "'");
//        sql = sql.concat(",CONTRASEÑA = ");
//        sql = sql.concat("'" + usuario.getContrasena() + "'");
//        sql = sql.concat(",NACIONALIDAD = ");
//        sql = sql.concat("'" + usuario.getNacionalidad() + "'");
//        sql = sql.concat(",TIPO_DOCUMENTO = ");
//        sql = sql.concat("'" + usuario.getTipoDeDocumento().toString() + "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat(" ID_USUARIO = ");
//        sql = sql.concat("'" + this.usuario.getIdUsuario() + "'");
//        return sql;
//    }
//
//    @Override
//    public Integer eliminar(Integer idUsuario) {
//        Integer result;
//        this.usuario = new Usuario();
//        this.usuario.setIdUsuario(idUsuario);
//        result = super.eliminar();
//        return result;
//
//    }
//
//    @Override
//    public ArrayList<Usuario> listar(String sql) {
//        ArrayList<Usuario> listaUsuario = new ArrayList();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(sql);
//            while (this.resultSet.next()) {
//                Usuario usuarioTemp = new Usuario(
//                        this.resultSet.getString("DOCUMENTO"),
//                        this.resultSet.getString("TELEFONO"),
//                        this.resultSet.getString("NOMBRE"),
//                        this.resultSet.getString("APELLIDO_MATERNO"),
//                        this.resultSet.getString("APELLIDO_PATERNO"),
//                        sdf.parse(this.resultSet.getString("FECHA_NACIMIENTO")),
//                        this.resultSet.getString("CORREO"),
//                        (this.resultSet.getInt("ACTIVO") == 1),
//                        this.resultSet.getString("CONTRASEÑA"),
//                        this.resultSet.getString("NACIONALIDAD"),
//                        this.resultSet.getString("DIRECCION"),
//                        TipoDocumento.valueOf(this.resultSet.getString("idEspecialidad"))
//                );
//                listaUsuario.add(usuarioTemp);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                this.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listaUsuario;
//    }
//
//    @Override
//    public ArrayList<Usuario> listarTodos() {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        return listar(sql);
//    }
//
//    @Override
//    public Usuario obtenerPorId(Integer idUsuario) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat("where ID_USUARIO = '" + idUsuario.toString() + "'");
//        return listar(sql).getFirst();
//    }
//
//    @Override
//    public Integer insertarUsuarioDesdeTrabajador() {
//        Integer id = this.insertar();
//        this.usuario.setIdUsuario(id);
//        return id;
//    }
}
