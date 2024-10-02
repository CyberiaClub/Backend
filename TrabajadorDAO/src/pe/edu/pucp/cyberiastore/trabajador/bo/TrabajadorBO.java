package pe.edu.pucp.cyberiastore.trabajador.bo;

//LOGICA DEL NEGOCIO, INCLUYE REGLAS PARA CADA TIPO DE TRABAJADOR

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.TrabajadorDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.bo.UsuarioBO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.UsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;


public class TrabajadorBO {
    private TrabajadorDAO trabajadorDAO;
    
    public TrabajadorBO(){
        this.trabajadorDAO = new TrabajadorDAOImpl();
    }
    
    public Integer insertar(Double sueldo, Date fechaDeIngreso, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Trabajador trabajador=new Trabajador(sueldo, fechaDeIngreso, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        return trabajadorDAO.insertar(trabajador);
    }
    
    public Integer insertar(Trabajador trabajador){
        UsuarioBO  usuarioBO = new UsuarioBO();
        Integer idUsuario = usuarioBO.insertar((Usuario)trabajador);
        if(idUsuario == null ){
            return null;
        }
        trabajador.setIdUsuario(idUsuario);
        Integer idTrabajador = this.trabajadorDAO.insertar(trabajador);
        this.trabajadorDAO.insertarIdTrabajador(idTrabajador);
        TrabajadorXSedeBO sedeTrabajador = new TrabajadorXSedeBO();
        sedeTrabajador.insertar(idTrabajador, trabajador.getIdSede());
        return idTrabajador;
    }
    
    public Integer modificar(Double sueldo, Date fechaDeIngreso,String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Trabajador trabajador = new Trabajador(sueldo, fechaDeIngreso, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        return this.trabajadorDAO.modificar(trabajador);
    }
     
    public ArrayList<Trabajador> listarTodos(){
        ArrayList<Trabajador> trabajadores = this.trabajadorDAO.listarTodosTrabajador();

        //de usuarios        
        return trabajadores;
    }
    
}
