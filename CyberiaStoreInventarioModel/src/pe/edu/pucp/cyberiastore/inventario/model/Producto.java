package pe.edu.pucp.cyberiastore.inventario.model;

import java.util.ArrayList;

public class Producto {

    private Integer idProducto;
    private String sku;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Double precioProveedor;
    private byte[] imagen;
    private ArrayList<Producto> productosMiembros;
    private TipoProducto tipoProducto;
    private Marca marca;
    //Esto es para el insert de las tablas intermedias
    private Integer idSede;
    private Integer cantidad;
    
    public Producto() {
        this.idProducto = null;
        this.sku = null;
        this.nombre = null;
        this.descripcion = null;
        this.precio = null;
        this.precioProveedor = null;
        this.imagen = null;
        this.productosMiembros = null;
        this.tipoProducto = null;
        this.marca = null;
    }

    public Producto(Integer idProducto, String sku, String nombre, String descripcion, Double precio, Double precioProveedor, Double precioDescuento, Boolean activo, ArrayList<Producto> productoMiembros, byte[] imagen, TipoProducto tipoProducto, Marca marca) {
        this.idProducto = idProducto;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioProveedor = precioProveedor;
        this.imagen = imagen;
        this.productosMiembros = productoMiembros;
        this.tipoProducto = tipoProducto;
        this.marca = marca;
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

    public Double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(Double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    public ArrayList<Producto> getProductosMiembros() {
        return productosMiembros;
    }

    public void setProductosMiembros(ArrayList<Producto> productosMiembros) {
        this.productosMiembros = productosMiembros;
    }
    
    public TipoProducto getTipoProducto(){
        return new TipoProducto(this.tipoProducto.getIdTipoProducto(),
                                this.tipoProducto.getTipo(),
                                this.tipoProducto.getActivo(),
                                this.tipoProducto.getImagen());
    }
    
    public void setTipoProducto(TipoProducto tipoProducto){
        this.tipoProducto = tipoProducto;
    }
    
    public Marca getMarca(){
        return new Marca(this.marca.getIdMarca(),
                         this.marca.getNombre(),
                         this.marca.getProveedor(),
                         this.marca.getActivo(),
                         this.marca.getImagen());
    }
    
    public void setMarca(Marca marca){
        this.marca = marca;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
