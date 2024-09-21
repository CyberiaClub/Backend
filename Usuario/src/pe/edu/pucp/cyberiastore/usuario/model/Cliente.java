package pe.edu.pucp.cyberiastore.usuario.model;

import java.util.Date;


public class Cliente extends Usuario {
    private static Integer idCliente = 0;
    private Boolean verificado;

    public Cliente(Boolean verificado, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento) {
        super(documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, tipoDeDocumento);
        this.verificado = verificado;
        this.idCliente++;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }
    
}
