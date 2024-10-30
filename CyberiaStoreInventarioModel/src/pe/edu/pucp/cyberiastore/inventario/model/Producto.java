package pe.edu.pucp.cyberiastore.inventario.model;

import java.util.HashMap;

public class Producto {
    private Integer idProducto;
    private String sku;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Double precioProveedor;
    private String unidad;
    private Integer idSede;
    private Integer idProveedor;
    private Integer idMarca;
    private Integer idTipoProducto;
    
    private HashMap<Producto,Integer> productoMiembros;
    
    public Producto() {
        this.productoMiembros = null;
    }
    
    public Producto(String sku, String nombre, String descripcion, Double precio, String unidad) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidad = unidad;
        this.productoMiembros = null;
    }
    
    public Producto(Integer idProducto, String sku, String nombre, String descripcion, Double precio, String unidad, HashMap<Producto,Integer> productoMiembros) {
        this.idProducto = idProducto;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidad = unidad;
        this.productoMiembros = productoMiembros;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }
    
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public HashMap<Producto,Integer> getMiembros(){
        HashMap<Producto,Integer> copia = (HashMap)this.getProductoMiembros().clone();
        return copia;
    }

    public void setMiembros(HashMap<Producto,Integer> miembros){
        this.setProductoMiembros((HashMap<Producto, Integer>) (HashMap)miembros.clone());
    }

    public Producto getMiembro(int index){
        Producto referencia = (Producto)this.getProductoMiembros().keySet().toArray()[index];
        return new Producto(
            referencia.idProducto,
            referencia.sku,
            referencia.nombre,
            referencia.descripcion,
            referencia.precio,
            referencia.unidad,
            referencia.getMiembros()
        );
    }

    public Integer getMiembroCantidad(int index){
        return (Integer)this.getProductoMiembros().values().toArray()[index];
    }

    public void setMiembro(Producto producto,Integer cantidad){
        this.getProductoMiembros().put(producto,cantidad);
    }

    /**
     * @return the idSede
     */
    public Integer getIdSede() {
        return idSede;
    }

    /**
     * @param idSede the idSede to set
     */
    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    /**
     * @return the idProveedor
     */
    public Integer getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * @return the idMarca
     */
    public Integer getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the idTipoProducto
     */
    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    /**
     * @return the productoMiembros
     */
    public HashMap<Producto,Integer> getProductoMiembros() {
        return productoMiembros;
    }

    /**
     * @param productoMiembros the productoMiembros to set
     */
    public void setProductoMiembros(HashMap<Producto,Integer> productoMiembros) {
        this.productoMiembros = productoMiembros;
    }

    public Double getPrecioProveedor() {
        return precioProveedor;
    }

 
    public void setPrecioProveedor(Double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }
}
