
package pe.edu.pucp.cyberiastore.trabajador.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;


public class Almacenero extends Trabajador {
    private Integer idAlmacenero;

    public Almacenero() {
        
    }
    
    public Almacenero(Double sueldo, Date fechaDeIngreso, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(sueldo, fechaDeIngreso, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
    }  

    public Integer getIdAlmacenero() {
        return idAlmacenero;
    }

    public void setIdAlmacenero(Integer idAlmacenero) {
        this.idAlmacenero = idAlmacenero;
    }
    
    
}
