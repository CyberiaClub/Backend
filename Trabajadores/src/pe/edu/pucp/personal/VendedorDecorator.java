package pe.edu.pucp.personal;

import java.util.Date;
import pe.edu.pucp.trabajador.BaseDecoratorTrabajador;
import pe.edu.pucp.usuario.TipoDocumento;


public class VendedorDecorator extends BaseDecoratorTrabajador{

    public VendedorDecorator(Double sueldo, Date fechaDeIngreso, Date fechaDeSalida, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento) {
        super(sueldo, fechaDeIngreso, fechaDeSalida, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, tipoDeDocumento);
    }

}
