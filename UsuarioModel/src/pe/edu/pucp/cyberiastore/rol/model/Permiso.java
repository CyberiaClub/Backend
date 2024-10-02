package pe.edu.pucp.cyberiastore.rol.model;

public class Permiso {
    private Integer idPermiso;
    private String nombre;
    private String descripcion;
    private Boolean activo;

    public Permiso(Integer idPermiso, String nombre, String descripcion) {
        this.nombre = nombre;
        this.idPermiso = idPermiso;
        this.descripcion = descripcion;
        this.activo = true;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getActivo() {
        return activo;
    }
    
    public Integer getIdPermiso() {
        return idPermiso;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
}