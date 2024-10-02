package pe.edu.pucp.cyberiastore.usuario.model;

import java.util.Date;

public class Cliente extends Usuario {

    private Integer idCliente;
    private Boolean verificado;
    
    /*Constructor vacio*/
    public Cliente(){
        this.verificado = false;
        this.setActivo(true);
    }
    
    /*
    Constructor usado para insertar los datos de un nuevo usuario
    */
    public Cliente(Integer idUsuario,String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(idUsuario,documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.verificado = false;
    }
    
    /*Constructor usudo para modificar*/
    public Cliente(String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.verificado = false;
    }
    public Cliente(Boolean verificado, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.verificado = verificado;
    }

    public Cliente(Boolean verificado, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.verificado = verificado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public Integer getVerificadoAsInt() {
        if (this.verificado) {
            return 1;
        } else {
            return 0;
        }
    }
}
