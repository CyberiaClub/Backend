package pe.edu.pucp.trabajador;

import java.util.Date;
import pe.edu.pucp.usuario.TipoDocumento;


public abstract class BaseDecoratorTrabajador extends Trabajador{
    Trabajador wrapper;

    public BaseDecoratorTrabajador(Double sueldo, Date fechaDeIngreso, Date fechaDeSalida, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento) {
        super(sueldo, fechaDeIngreso, fechaDeSalida, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, tipoDeDocumento);
    }
    
    
}
