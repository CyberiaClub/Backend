package pe.edu.pucp.cyberiastore.proveedor.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Proveedor {
    private Integer idProveedor;
    private String ruc;
    private String razonSocial;
    private String nombreContacto;
    private String correo;
    private String telefono;
    private String direccion;
    private String descripcion;
    private Boolean activo;
    
    public Proveedor(){
        this.idProveedor = null;
        this.ruc = null;
        this.razonSocial = null;
        this.nombreContacto = null;
        this.correo = null;
        this.telefono = null;
        this.direccion = null;
        this.descripcion = null;
        this.activo = true;
    }

    public Proveedor(Integer idProveedor, String ruc, String razonSocial, String nombreContacto, String correo, String telefono, String direccion, String descripcion, Boolean activo) {
        this.idProveedor = idProveedor;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.nombreContacto = nombreContacto;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.activo = (activo == null) ? true:activo;
    }
    
    public Integer getIdProveedor() {
        return idProveedor;
    }
    
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public String getRuc() {
        return ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    public String getRazonSocial() {
        return razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public String getNombreContacto() {
        return nombreContacto;
    }
    
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
