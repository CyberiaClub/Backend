package pe.edu.pucp.cyberiastore.inventario.model;

import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;

public class Marca {

    private Integer idMarca;
    private String nombre;
    private Boolean activo;
    private byte[] imagen;
    private Proveedor proveedor;

    public Marca() {
        this.idMarca = null;
        this.nombre = null;
        this.activo = true;
        this.imagen = null;
    }

    public Marca(Integer idMarca, String nombre, Boolean activo, byte[] imagen) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.activo = (activo==null) ? true:activo;
        this.imagen = imagen;
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
    
    public byte[] getImagen() {
        return imagen.clone();
    }
    
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
