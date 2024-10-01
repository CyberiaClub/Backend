
package pe.edu.pucp.Trabajador.trabajador.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;


public class VendedorBO extends TrabajadorBO {

    @Override
    public Integer insertar(Double sueldo, Date fechaDeIngreso, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        return super.insertar(sueldo, fechaDeIngreso, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
    }

    @Override    
    public Integer insertar(Trabajador trabajador){
        return super.insertar(trabajador);
    }
    
    @Override    
    public Integer modificar(Double sueldo, Date fechaDeIngreso, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento){
        return super.modificar(sueldo, fechaDeIngreso, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, TipoDocumento.PASAPORTE);

    }

    @Override         
    public Integer eliminar(){
        return super.eliminar();
    }
    
    @Override
    public ArrayList<Trabajador> listarTodos(){
        return super.listarTodos();
    }
    
    
    
}
