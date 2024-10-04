package pe.edu.pucp.cyberiastore.usuario.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.rol.bo.RolBO;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoXRolDAO;
import pe.edu.pucp.cyberiastore.rol.daoImpl.PermisoXRolDAOImpl;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;
import pe.edu.pucp.cyberiastore.rol.model.Rol;
import pe.edu.pucp.cyberiastore.usuario.dao.ClienteDAO;
import pe.edu.pucp.cyberiastore.usuario.dao.RolXUsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.dao.UsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.ClienteDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.RolXUsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.UsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public class ClienteBO {
    private ClienteDAO clienteDAO;
    private UsuarioDAO usuarioDAO;
    private RolXUsuarioDAO rolXUsuarioDAO;
    private PermisoXRolDAO permisoXRolDAO;
    private RolBO rolBO;
    
    public ClienteBO(){
        this.usuarioDAO = new UsuarioDAOImpl();
        this.rolXUsuarioDAO = new RolXUsuarioDAOImpl();
        this.rolBO = new RolBO();
        this.permisoXRolDAO = new PermisoXRolDAOImpl();
        this.clienteDAO = new ClienteDAOImpl();
    }
    
    public Integer insertar(Integer idUsuario,String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Cliente cliente = new Cliente(idUsuario,documento,telefono,nombre,apellidoPaterno,apelldioMaterno,fechaDeNacimiento,correo,contrasena,nacionalidad,direccion,tipoDeDocumento);
        return this.clienteDAO.insertar(cliente);
    }
    
    public Integer insertar(Cliente cliente){
        UsuarioBO  usuarioBO = new UsuarioBO();
        Integer idUsuario = usuarioBO.insertar((Usuario)cliente);
        if(idUsuario == null ){
            return null;
        }
        cliente.setIdUsuario(idUsuario);
        Integer idCliente = this.clienteDAO.insertar(cliente);
        this.clienteDAO.insertarIdCliente(idCliente);
        return idCliente;
    }
    
    public Integer modificar( String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Cliente cliente = new Cliente(documento,telefono,nombre,apellidoPaterno,apelldioMaterno,fechaDeNacimiento,correo,contrasena,nacionalidad,direccion,tipoDeDocumento);
        return this.clienteDAO.insertar(cliente);
    }
    
    public Integer eliminar(Boolean activo){
        return this.clienteDAO.eliminar(activo);
    }
    
    public ArrayList<Cliente> listarTodos(){
        ArrayList<Cliente> clientes = this.clienteDAO.listarTodosCliente();
        for(Cliente cliente : clientes){
            ArrayList<Rol> roles = rolXUsuarioDAO.buscarRolesPorIdUsuario(cliente.getDocumento());
            for(Rol rol : roles){
                ArrayList<Permiso> permisos = permisoXRolDAO.buscarPermisosPorIdRol(rol.getIdRol());
                for (Permiso permiso : permisos) {
                    rol.agregarPermiso(permiso);                
                }
                cliente.agregarRol(rol);
            }
        }
        return clientes;
    }
    
    public Usuario buscarPorId(int idCliente){
        Cliente cliente = this.clienteDAO.obtenerPorId(""+idCliente);
        ArrayList<Rol> roles = rolXUsuarioDAO.buscarRolesPorIdUsuario(cliente.getDocumento());
        for(Rol rol : roles){
            ArrayList<Permiso> permisos = permisoXRolDAO.buscarPermisosPorIdRol(rol.getIdRol());
            for (Permiso permiso : permisos) {
                rol.agregarPermiso(permiso);                
            }
            cliente.agregarRol(rol);
        }
        return cliente;
    }
}
