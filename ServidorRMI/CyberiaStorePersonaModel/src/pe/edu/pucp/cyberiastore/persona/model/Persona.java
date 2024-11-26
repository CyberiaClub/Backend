package pe.edu.pucp.cyberiastore.persona.model;

import java.io.Serializable;
import java.util.Date;
import pe.edu.pucp.cyberiastore.cifrado.Cifrado;

public class Persona implements Serializable {

    private Integer idPersona;
    private String documento;
    private String telefono;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaDeNacimiento;
    private String sexo;
    private String correo;
    private String direccion;
    private Boolean activo;
    private String contrasena;
    private String nacionalidad;
    private TipoDocumento tipoDeDocumento;
    private Integer idTipoPersona;
    private Double sueldo;
    private Date fechaIngreso;
    private Date fechaSalida;
    private Integer idSede;
    private String tipoUsuario;
    public Persona() {
        this.activo = true;
        this.segundoApellido = null;
    }
    
    public Persona(Integer idPersona, String documento, String telefono, String nombre, String primerApellido, String segundoApellido, Date fechaDeNacimiento, String sexo, String correo, String direccion, Boolean activo, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento, Integer idTipoPersona, Double sueldo, Date fechaIngreso, Date fechaSalida, Integer idSede) {
        this.idPersona = idPersona;
        this.documento = documento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexo = sexo;
        this.correo = correo;
        this.direccion = direccion;
        this.activo = (activo == null) ? true:activo;
        this.contrasena = contrasena;
        this.nacionalidad = nacionalidad;
        this.tipoDeDocumento = tipoDeDocumento;
        this.idTipoPersona = idTipoPersona;
        this.sueldo = sueldo;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.idSede = idSede;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    
    public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

  
    public Integer getIdSede() {
        return idSede;
    }

    
    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public Double getSueldo() {
        return sueldo;
    }

    
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

  
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

   
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    
    public Date getFechaSalida() {
        return fechaSalida;
    }

   
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

   
    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
