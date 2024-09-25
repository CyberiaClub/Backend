package pe.edu.pucp.cyberiastore.proveedor.model;

import java.util.Date;

public class Proveedor {
    private String ruc;
    private String nombre;
    private Date fechaRegistro;

    public Proveedor(String ruc, String nombre, Date fechaRegistro) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
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
