package pe.edu.pucp.cyberiastore.usuario.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.rol.bo.RolBO;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoXRolDAO;
import pe.edu.pucp.cyberiastore.rol.daoImpl.PermisoXRolDAOImpl;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;
import pe.edu.pucp.cyberiastore.rol.model.Rol;
import pe.edu.pucp.cyberiastore.usuario.dao.RolXUsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.dao.UsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.RolXUsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.UsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;
    private RolXUsuarioDAO rolXUsuarioDAO;
    private PermisoXRolDAO permisoXRolDAO;
    private RolBO rolBO;
    
    public UsuarioBO(){
        this.usuarioDAO = new UsuarioDAOImpl();
        this.rolXUsuarioDAO = new RolXUsuarioDAOImpl();
        this.rolBO = new RolBO();
        this.permisoXRolDAO = new PermisoXRolDAOImpl();
    }
    
    public Integer insertar(String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Usuario usuario = new Usuario(documento,telefono,nombre,apellidoPaterno,apelldioMaterno,fechaDeNacimiento,correo,activo,contrasena,nacionalidad,direccion,tipoDeDocumento);
        return this.usuarioDAO.insertar(usuario);
    }
    
    public Integer insertar(Usuario usuario){
        return this.usuarioDAO.insertar(usuario);
    }
    
    public Integer modificar(String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Usuario usuario = new Usuario(documento,telefono,nombre,apellidoPaterno,apelldioMaterno,fechaDeNacimiento,correo,activo,contrasena,nacionalidad,direccion,tipoDeDocumento);
        return this.usuarioDAO.modificar(usuario);
    }
    
    public Integer eliminar(String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        rolXUsuarioDAO.eliminarUsuario(documento);
        Usuario usuario = new Usuario(documento,telefono,nombre,apellidoPaterno,apelldioMaterno,fechaDeNacimiento,correo,activo,contrasena,nacionalidad,direccion,tipoDeDocumento);
        return this.usuarioDAO.eliminar(usuario);
    }
    
    public ArrayList<Usuario> listarTodos(){
        ArrayList<Usuario> usuarios = this.usuarioDAO.listarTodos();
        for(Usuario usuario : usuarios){
            ArrayList<Rol> roles = rolXUsuarioDAO.buscarRolesPorIdUsuario(usuario.getDocumento());
            for(Rol rol : roles){
                ArrayList<Permiso> permisos = permisoXRolDAO.buscarPermisosPorIdRol(rol.getIdRol());
                for (Permiso permiso : permisos) {
                    rol.agregarPermiso(permiso);                
                }
                usuario.agregarRol(rol);
            }
        }
        return usuarios;
    }
    
    public Usuario buscarPorId(String idUsuario){
        Usuario usuario = this.usuarioDAO.obtenerPorId(idUsuario);
        ArrayList<Rol> roles = rolXUsuarioDAO.buscarRolesPorIdUsuario(usuario.getDocumento());
        for(Rol rol : roles){
            ArrayList<Permiso> permisos = permisoXRolDAO.buscarPermisosPorIdRol(rol.getIdRol());
            for (Permiso permiso : permisos) {
                rol.agregarPermiso(permiso);                
            }
            usuario.agregarRol(rol);
        }
        return usuario;
    }
}
