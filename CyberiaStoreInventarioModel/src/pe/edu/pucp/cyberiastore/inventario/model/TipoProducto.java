package pe.edu.pucp.cyberiastore.inventario.model;

public class TipoProducto {

    private Integer idTipoProducto;
    private String tipo;
    private Boolean activo;
    private byte[] imagen;
    
    public TipoProducto(){
        this.activo = true;
    }

    public TipoProducto(String tipo, byte[] imagenBytes) {
        this.tipo = tipo;
        this.imagen = imagenBytes;
        this.activo = true;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
