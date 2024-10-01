    package pe.edu.pucp.cyberiastore.inventario.model;

public class Marca {

    private Integer idMarca = 0;
    private String nombre;
    private Boolean activo;
    
    public Marca(String nombre) {  
        this.nombre = nombre;
        this.activo = true;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }
    
    
    
    public Integer getIdMarca(){
        return idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
