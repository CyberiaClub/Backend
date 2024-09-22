package pe.edu.pucp.cyberiastore.usuario.model;

import java.util.Date;


public class Usuario {
    private String documento;
    private String telefono;
    private String nombre;
    private String apellidoPaterno;
    private String apelldioMaterno;
    private Date fechaDeNacimiento;
    private String correo;
    private Boolean activo;
    private String contrasena;
    private String nacionalidad;
    private TipoDocumento tipoDeDocumento;

    public Usuario(String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento) {
        this.documento = documento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apelldioMaterno = apelldioMaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correo = correo;
        this.activo = activo;
        this.contrasena = contrasena;
        this.nacionalidad = nacionalidad;
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApelldioMaterno() {
        return apelldioMaterno;
    }

    public void setApelldioMaterno(String apelldioMaterno) {
        this.apelldioMaterno = apelldioMaterno;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public TipoDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }
    
    
    
}
