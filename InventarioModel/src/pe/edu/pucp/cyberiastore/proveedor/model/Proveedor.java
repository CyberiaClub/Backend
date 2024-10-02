package pe.edu.pucp.cyberiastore.proveedor.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Proveedor {
    private Integer idProveedor;
    private String ruc;
    private String nombre;
    private Date fechaRegistro;
    private Boolean activo;
    
    public Proveedor(String ruc, String nombre, Date fechaRegistro) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.activo = true;
    }
    
    public Proveedor(String ruc, String nombre, Date fechaRegistro, Boolean activo) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public Integer getIdProveedor() {
        return idProveedor;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
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
    
    public String fechaRegistroComoDDMMYYY(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.fechaRegistro);
    }
    
}
