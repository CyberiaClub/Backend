package pe.edu.pucp.cyberiastore.sede.model;

public class Sede {

    private Integer idSede;
    private String descripcion;
    private String nombre;

    public Sede(){
        
    }
    
    public Sede(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
    
    public Integer getIdSede(){
        return this.idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
