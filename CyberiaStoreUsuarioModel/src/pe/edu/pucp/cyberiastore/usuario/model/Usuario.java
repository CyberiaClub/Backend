package pe.edu.pucp.cyberiastore.usuario.model;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import pe.edu.pucp.cyberiastore.cifrado.Cifrado;

import pe.edu.pucp.cyberiastore.rol.model.Rol;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;
public class Usuario {
    private Integer idUsuario;
    private String documento;
    private String telefono;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaDeNacimiento;
    private String correo;
    private Boolean activo;
    private String contrasena;
    private String nacionalidad;
    private String direccion;
    private TipoDocumento tipoDeDocumento;
    private ArrayList<Rol> roles;

    /*El generico*/
    public Usuario(){
        this.activo = true;
    }

    public Usuario( String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        this.documento = documento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.tipoDeDocumento = tipoDeDocumento;
        this.activo = true;
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
    
    public int getActivoAsInt(){
        if(this.activo) return 1;
        return 0;
    }
    
    public String getFechaNacimientoAsDDMMYYY(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.fechaDeNacimiento);
    }
    
    public void agregarRol(Rol rol){
        this.roles.add(rol);
    }
    
    public int getCantidadRoles(){
        return this.roles.size();
    }
    
    public Rol getRol(int index){
        Rol rol = new Rol(roles.get(index).getIdRol(),roles.get(index).getNombre());
        for(int i = 0; i < roles.get(index).getCantidadPermisos(); i++){
            Permiso permiso = roles.get(index).getPermiso(i);
            rol.agregarPermiso(permiso);
        }
        return rol;
    }
}