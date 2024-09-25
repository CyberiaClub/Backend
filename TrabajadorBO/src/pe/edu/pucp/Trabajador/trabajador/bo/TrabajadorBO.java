package pe.edu.pucp.Trabajador.trabajador.bo;

//LOGICA DEL NEGOCIO, INCLUYE REGLAS PARA CADA TIPO DE TRABAJADOR

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.TrabajadorDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;


public class TrabajadorBO {
    private TrabajadorDAO trabajadorDAO;
    
    public TrabajadorBO(){
        this.trabajadorDAO = new TrabajadorDAOImpl();
    }
    
    public Integer insertar(Double sueldo, Date fechaDeIngreso, Date fechaDeSalida, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){

        Trabajador trabajador=new Trabajador(sueldo, fechaDeIngreso, fechaDeSalida, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        return trabajadorDAO.insertar(trabajador);
    }
    public Integer insertar(Trabajador trabajador){
        return this.trabajadorDAO.insertar(trabajador);
    }
    
    public Integer modificar(Double sueldo, Date fechaDeIngreso, Date fechaDeSalida,String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        Trabajador trabajador = new Trabajador(sueldo, fechaDeIngreso, fechaDeSalida, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        return this.trabajadorDAO.modificar(trabajador);
    }
     
    public Integer eliminar(Double sueldo, Date fechaDeIngreso, Date fechaDeSalida,String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        
        //trabajadorDAO.eliminar()
        Trabajador trabajador = new Trabajador(sueldo, fechaDeIngreso, fechaDeSalida, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        return this.trabajadorDAO.eliminar(trabajador);
    }
    
    public ArrayList<Trabajador> listarTodos(){
        ArrayList<Trabajador> trabajadores = this.trabajadorDAO.listarTodosTrabajador();

        //de usuarios
        
        
        
        
        
        return trabajadores;
    }
    
    
}
