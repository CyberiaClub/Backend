package pe.edu.pucp.cyberiastore.inventario.model;

import java.io.Serializable;

public class TipoProducto implements Serializable {

    private Integer idTipoProducto;
    private String tipo;
    private Boolean activo;
    private byte[] imagen;

    public TipoProducto() {
        this.idTipoProducto = null;
        this.tipo = null;
        this.imagen = null;
        this.activo = true;
    }

    public TipoProducto(Integer idTipoProducto, String tipo, Boolean activo, byte[] imagen) {
        this.idTipoProducto = idTipoProducto;
        this.tipo = tipo;
        this.imagen = imagen;
        this.activo = (activo == null) ? true : activo;
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

    public byte[] getImagen() {
        return this.imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
