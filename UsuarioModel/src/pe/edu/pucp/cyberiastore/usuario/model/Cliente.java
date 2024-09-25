package pe.edu.pucp.cyberiastore.usuario.model;

import java.util.Date;

public class Cliente extends Usuario {
    private int idCliente;
    private Boolean verificado;

    public Cliente(int idCliente, Boolean verificado, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.verificado = verificado;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }
    
    public int getVerificadoAsInt(){
        if(this.verificado) return 1;
        else return 0;
    }
}