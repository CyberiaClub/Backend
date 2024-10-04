
package pe.edu.pucp.cyberiastore.trabajador.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class Vendedor extends Trabajador {
    
    Integer idVendor;
    
    public Vendedor(){
        
    }
    
    public Vendedor(Double sueldo, Date fechaDeIngreso, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(sueldo, fechaDeIngreso, documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
    }

    public Integer getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(Integer idVendor) {
        this.idVendor = idVendor;
    }
    
}