package pe.edu.pucp.cyberiastore.usuario.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.cifrado.Cifrado;

public class Usuario {

    private Integer idUsuario;
    private String documento;
    private String telefono;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaDeNacimiento;
    private char sexo;
    private String correo;
    private Boolean activo;
    private String contrasena;
    private String nacionalidad;
    private String direccion;
    private TipoDocumento tipoDeDocumento;
    private Rol rol;

//    Byte foto[];
    public Usuario() {
        this.activo = true;
    }

    public Usuario(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, Date fechaDeNacimiento, String correo,
            String direccion, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento, Rol rol) {
        this.documento = documento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexo = sexo;
        this.correo = correo;
        this.contrasena = Cifrado.cifrarMD5(contrasena);
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.tipoDeDocumento = tipoDeDocumento;
        this.activo = true;
        this.rol = rol;
    }

    /**
     * Este constructor sirve para el modificar
     *
     * @param idUsuario
     * @param documento
     * @param telefono
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param sexo
     * @param fechaDeNacimiento
     * @param correo
     * @param activo
     * @param contrasena
     * @param nacionalidad
     * @param direccion
     * @param tipoDeDocumento
     */
    public Usuario(Integer idUsuario, String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno,
            char sexo, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento, Rol rol) {
        this.idUsuario = idUsuario;
        this.documento = documento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correo = correo;
        this.activo = activo;
        this.contrasena = contrasena;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.tipoDeDocumento = tipoDeDocumento;
        this.rol = rol;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
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
        this.contrasena = Cifrado.cifrarMD5(contrasena);
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
