package pe.edu.pucp.cyberiastore.inventario.model;

public class TipoProducto {

    private Integer idTipoProducto;
    private String tipo;
    private Boolean activo;

    public TipoProducto(String tipo) {
        this.tipo = tipo;
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
    
    

}
