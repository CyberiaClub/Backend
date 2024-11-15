package pe.edu.pucp.cyberiastore.persona.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.cifrado.Cifrado;

public class Persona {

    private Integer idPersona;
    private String documento;
    private String telefono;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaDeNacimiento;
    private char sexo;
    private String correo;
    private String direccion;
    private Boolean activo;
    private String contrasena;
    private String nacionalidad;
    private TipoDocumento tipoDeDocumento;
    private TipoPersona tipoPersona;
    private Double sueldo;
    private Date fechaIngreso;
    private Date fechaSalida;
    private Integer idSede;

    public Persona() {
        this.activo = true;
    }

    /**
     * @return the idPersona
     */
    public Integer getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the fechaDeNacimiento
     */
    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * @param fechaDeNacimiento the fechaDeNacimiento to set
     */
    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the contrasena, return the cifrate contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = Cifrado.cifrarMD5(contrasena);
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the tipoDeDocumento
     */
    public TipoDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    /**
     * @param tipoDeDocumento the tipoDeDocumento to set
     */
    public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    /**
     * @return the idSede
     */
    public Integer getIdSede() {
        return idSede;
    }

    /**
     * @param idSede the idSede to set
     */
    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    /**
     * @return the sueldo
     */
    public Double getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the fechaSalida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}
