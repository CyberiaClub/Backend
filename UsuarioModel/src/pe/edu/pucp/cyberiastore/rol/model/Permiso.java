package pe.edu.pucp.cyberiastore.rol.model;

public class Permiso {
    private Integer idPermiso;
    private String nombre;
    private String descripcion;

    public Permiso(Integer idPermiso, String nombre, String descripcion) {
        this.nombre = nombre;
        this.idPermiso = idPermiso;
        this.descripcion = descripcion;
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