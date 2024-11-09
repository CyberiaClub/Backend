package pe.edu.pucp.cyberiastore.inventario.model;

public class Marca {

    private Integer idMarca;
    private String nombre;
    private Boolean activo;
    private byte[] imagen;

    public Marca() {
        this.activo = true;
    }

    public Marca(String nombre, byte[] imagenBytes) {
        this.nombre = nombre;
        this.imagen = imagenBytes;
        this.activo = true;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdMarca() {
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
