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
    
    public Integer insertar(int idCliente, Boolean verificado, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Cliente cliente = new Cliente(idCliente,verificado,documento,telefono,nombre,apellidoPaterno,apelldioMaterno,fechaDeNacimiento,correo,activo,contrasena,nacionalidad,direccion,tipoDeDocumento);
        return this.clienteDAO.insertar(cliente);
    }
    
    public Integer insertar(Cliente cliente){
        return this.clienteDAO.insertar(cliente);
    }
    
    public Integer modificar(int idCliente, Boolean verificado, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Cliente cliente = new Cliente(idCliente,verificado,documento,telefono,nombre,apellidoPaterno,apelldioMaterno,fechaDeNacimiento,correo,activo,contrasena,nacionalidad,direccion,tipoDeDocumento);
        return this.clienteDAO.insertar(cliente);
    }
    
    public Integer eliminar(int idCliente, Boolean verificado, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Cliente cliente = new Cliente(idCliente,verificado,documento,telefono,nombre,apellidoPaterno,apelldioMaterno,fechaDeNacimiento,correo,activo,contrasena,nacionalidad,direccion,tipoDeDocumento);
        return this.clienteDAO.insertar(cliente);
    }
    
    public ArrayList<Cliente> listarTodos(){
        ArrayList<Cliente> clientes = this.clienteDAO.listarTodos();
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