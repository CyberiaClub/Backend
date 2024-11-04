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

    public ClienteBO() {
        clienteDAO = new ClienteDAOImpl();
    }

    public Integer insertar(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno,
            Date fechaDeNacimiento, String correo, String contraseña, String nacionalidad, String direccion, TipoDocumento tipoDocumento) {
        Cliente cliente = new Cliente(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, contraseña,
                nacionalidad, direccion, tipoDocumento);
        return this.clienteDAO.insertar(cliente);
    }
    
    public Integer modificar(Integer idCliente,Boolean verificado, Integer IdUsuario,String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno,
            Date fechaDeNacimiento, String correo,Boolean activo, String contraseña, String nacionalidad, String direccion, TipoDocumento tipoDocumento){
        Cliente cliente = new Cliente(idCliente,verificado,IdUsuario,documento, telefono, nombre, apellidoPaterno, apellidoMaterno,
                fechaDeNacimiento, correo,activo, contraseña,nacionalidad, direccion, tipoDocumento);
        return this.clienteDAO.modificar(cliente);
    }
    
    public Cliente obtenerPorId(Integer idCliente) {
        return this.clienteDAO.obtenerPorId(idCliente);
    }
    
    public ArrayList<Cliente> listarTodos() {
        return this.clienteDAO.listarTodos();
    }
    
}
