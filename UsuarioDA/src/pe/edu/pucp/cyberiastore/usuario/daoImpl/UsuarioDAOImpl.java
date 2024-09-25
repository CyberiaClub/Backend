package pe.edu.pucp.cyberiastore.usuario.daoImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.usuario.dao.UsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import java.text.SimpleDateFormat;

public class UsuarioDAOImpl extends DAOImpl implements UsuarioDAO {
    
    private Usuario usuario;
    
    public UsuarioDAOImpl(){
        super("USUARIO");
        this.usuario = null;
    }
    //constructor para el trbajador DAOImpl
    public UsuarioDAOImpl(String nombre){
        super(nombre);
        this.usuario = null;
    }
    
    @Override
    public Integer insertar(Usuario usuario){
        this.usuario = usuario;
        return super.insertar();
    }
    
    @Override
    protected String obtenerListaAtributos(){
        return "DOCUMENTO, TELEFONO, NOMBRE, APELLIDO_MATERNO, APELLIDO_PATERNO, FECHA_NACIMIENTO, CORREO, DIRECCION, ACTIVO, CONTRASEÑA, NACIONALIDAD, TIPO_DOCUMENTO";
    }
    
    @Override
    protected String obtenerListaValoresParaInsertar(){
        String sql = "";
        sql = sql.concat("'" + usuario.getDocumento() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getTelefono() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getNombre() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getApellidoMaterno() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getApellidoPaterno() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("STR_TO_DATE('" + usuario.getFechaNacimientoAsDDMMYYY() + "','%d-%m-%Y')");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getCorreo() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getDireccion() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getActivoAsInt() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getContrasena() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getNacionalidad() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + usuario.getTipoDeDocumento().toString() + "'");
        return sql;
    }

    @Override
    public Integer modificar(Usuario usuario) {
        this.usuario = usuario;
        return super.modificar();
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String sql = "";
        sql = sql.concat("TELEFONO = ");
        sql = sql.concat("'" + usuario.getTelefono() + "'");
        sql = sql.concat(",NOMBRE = ");
        sql = sql.concat("'" + usuario.getNombre() + "'");
        sql = sql.concat(",APELLIDO_MATERNO = ");
        sql = sql.concat("'" + usuario.getApellidoMaterno() + "'");
        sql = sql.concat(",APELLIDO_PATERNO = ");
        sql = sql.concat("'" + usuario.getApellidoPaterno() + "'");
        sql = sql.concat(",FECHA_NACIMIENTO = ");
        sql = sql.concat("'" + usuario.getFechaNacimientoAsDDMMYYY() + "'");
        sql = sql.concat(",CORREO = ");
        sql = sql.concat("'" + usuario.getCorreo() + "'");
        sql = sql.concat(",DIRECCION = ");
        sql = sql.concat("'" + usuario.getDireccion() + "'");
        sql = sql.concat(",ACTIVO = ");
        sql = sql.concat("'" + usuario.getActivoAsInt() + "'");
        sql = sql.concat(",CONTRASEÑA = ");
        sql = sql.concat("'" + usuario.getContrasena() + "'");
        sql = sql.concat(",NACIONALIDAD = ");
        sql = sql.concat("'" + usuario.getNacionalidad() + "'");
        sql = sql.concat(",TIPO_DOCUMENTO = ");
        sql = sql.concat("'" + usuario.getTipoDeDocumento().toString() + "'");
        return sql;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("DOCUMENTO = ");
        sql = sql.concat("'" + usuario.getDocumento() + "'");
        return sql;
    }

    @Override
    public Integer eliminar(Usuario usuario) {
        this.usuario = usuario;
        return super.eliminar();
    }

    @Override
    public ArrayList<Usuario> listar(String sql) {
        ArrayList<Usuario> listaUsuario = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.abrirConexion();
            this.ejecutarConsultaEnBD(sql);
            while(this.resultSet.next()){
                Usuario usuarioTemp = new Usuario(
                        this.resultSet.getString("DOCUMENTO"),
                        this.resultSet.getString("TELEFONO"),
                        this.resultSet.getString("NOMBRE"),
                        this.resultSet.getString("APELLIDO_MATERNO"),
                        this.resultSet.getString("APELLIDO_PATERNO"),
                        sdf.parse(this.resultSet.getString("FECHA_NACIMIENTO")),
                        this.resultSet.getString("CORREO"),
                        (this.resultSet.getInt("ACTIVO") == 1),
                        //dice Jesus que la contraseña no se debe enlistar :) 
                        
                        this.resultSet.getString("CONTRASEÑA"),
                        this.resultSet.getString("NACIONALIDAD"),
                        this.resultSet.getString("DIRECCION"),
                        TipoDocumento.valueOf(this.resultSet.getString("idEspecialidad"))
                );
                listaUsuario.add(usuarioTemp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaUsuario;
    }
    
    @Override
    public ArrayList<Usuario> listarTodos() {
        String sql = this.obtenerListaValoresParaSeleccionar();
        return listar(sql);
    }

    @Override
    public Usuario obtenerPorId(String idUsuario) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat("where DOCUMENTO = '" + idUsuario + "'");
        return listar(sql).getFirst();
    }
}
