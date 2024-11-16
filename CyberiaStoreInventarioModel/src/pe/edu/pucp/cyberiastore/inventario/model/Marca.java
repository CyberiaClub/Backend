package pe.edu.pucp.cyberiastore.inventario.model;

import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;

public class Marca {

    private Integer idMarca;
    private String nombre;
    private Proveedor proveedor;
    private Boolean activo;
    private byte[] imagen;

    public Marca() {
        this.idMarca = null;
        this.nombre = null;
        this.proveedor = null;
        this.activo = true;
        this.imagen = null;
    }

    public Marca(Integer idMarca, String nombre, Proveedor proveedor, Boolean activo, byte[] imagen) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.proveedor = proveedor;
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

    public Proveedor getProveedor() {
        return new Proveedor(this.proveedor.getIdProveedor(),
                             this.proveedor.getRuc(),
                             this.proveedor.getRazonSocial(),
                             this.proveedor.getNombreContacto(),
                             this.proveedor.getCorreo(),
                             this.proveedor.getTelefono(),
                             this.proveedor.getDireccion(),
                             this.proveedor.getDescripcion(),
                             this.proveedor.getActivo());
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
}
