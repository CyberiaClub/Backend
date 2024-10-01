package pe.edu.pucp.cyberiastore.proveedor.model;

import java.util.Date;

public class Proveedor {
    private Integer idProveedor;
    private String ruc;
    private String nombre;
    private Date fechaRegistro;
    private Integer activo;
    
    public Proveedor(String ruc, String nombre, Date fechaRegistro) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.activo = 1;
    }
    
    public Proveedor(String ruc, String nombre, Date fechaRegistro, Integer activo) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.activo = 1;
        this.activo = activo;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public Integer getIdProveedor() {
        return idProveedor;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
