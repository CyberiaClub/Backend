package pe.edu.pucp.cyberiastore.usuario.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.rol.model.Rol;
import pe.edu.pucp.cyberiastore.usuario.dao.RolXUsuarioDAO;
import pe.edu.pucp.cyberiastore.rol.dao.RolDAO;
import pe.edu.pucp.cyberiastore.rol.daoImpl.RolDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public class RolXUsuarioDAOImpl extends DAOImpl implements RolXUsuarioDAO {
    
    private String idUsuario;
    private int idRol;

    public RolXUsuarioDAOImpl() {
        super("ROL_X_USUARIO");
    }

    @Override
    protected String obtenerListaAtributos() {
        return "ID_USUARIO, ID_ROL";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.idUsuario + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.idRol + "'");
        return sql;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        return "";
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_USUARIO = ");
        sql = sql.concat("'" + this.idUsuario + "'");
        sql = sql.concat(" and ID_ROL = ");
        sql = sql.concat("'" + this.idRol + "'");
        return sql;
    }

    @Override
    public Integer insertar(String idUsuario, int idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        return this.insertar();
    }

    @Override
    public Integer eliminar(String idUsuario, int idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        return this.eliminar();
    }

    @Override
    public Integer eliminarRol(int idRol) {
        String sql = "delete from" + this.nombre_tabla + "where ID_ROL = '" + this.idRol + "'";
        return this.ejecutarTransaccionEnBD(sql);
    }

    @Override
    public Integer eliminarUsuario(String idUsuario) {
        String sql = "delete from" + this.nombre_tabla + "where ID_USUARIO = '" + this.idUsuario + "'";
        return this.ejecutarTransaccionEnBD(sql);
    }

    @Override
    public ArrayList<Rol> buscarRolesPorIdUsuario(String idUsuario) {
        RolDAOImpl rolDAOImpl = new RolDAOImpl();
        String sql = "select R.ID_ROL, R.NOMBRE from ROL R, ROL_X_USUARIO RXU where RXU.ID_USUARIO = '" + idUsuario + "'";
        return rolDAOImpl.listar(sql);
    }

    @Override
    public ArrayList<Usuario> buscarUsuariosPorIdRol(int idRol) {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        String sql = "select U.DOCUMENTO, U.TELEFONO, U.NOMBRE, U.APELLIDO_MATERNO, U.APELLIDO_PATERNO, U.FECHA_NACIMIENTO, U.CORREO, U.DIRECCION, U.ACTIVO, U.CONTRASEÑA, U.NACIONALIDAD, U.TIPO_DOCUMENTO from USUARIO U, ROL_X_USUARIO RXU where RXU.ID_USUARIO = '" + idUsuario + "'";
        return usuarioDAOImpl.listar(sql);
    }
}
