package pe.edu.pucp.cyberiastore.sede.model;

public class Sede {

    private Integer idSede;
    private String descripcion;
    private String nombre;
    private byte[] imagen;

    public Sede(){
        
    }
    
    public Sede(String nombre, String descripcion, byte[] imagenBytes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagenBytes;
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

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

}
