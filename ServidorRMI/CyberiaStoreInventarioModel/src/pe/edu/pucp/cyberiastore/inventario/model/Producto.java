package pe.edu.pucp.cyberiastore.inventario.model;

import java.util.ArrayList;
import java.io.Serializable;

public class Producto implements Serializable {

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
    private Integer oferta;
    private Integer idPedido;
    
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
        return this.idProducto;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecioProveedor() {
        return this.precioProveedor;
    }

    public void setPrecioProveedor(Double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public byte[] getImagen() {
        return this.imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    public ArrayList<Producto> getProductosMiembros() {
        return this.productosMiembros;
    }

    public void setProductosMiembros(ArrayList<Producto> productosMiembros) {
        this.productosMiembros = productosMiembros;
    }
    
    public TipoProducto getTipoProducto(){
        return this.tipoProducto;
    }
    
    public void setTipoProducto(TipoProducto tipoProducto){
        this.tipoProducto = tipoProducto;
    }
    
    public Marca getMarca(){
        return this.marca;
    }
    
    public void setMarca(Marca marca){
        this.marca = marca;
    }

    public Integer getIdSede() {
        return this.idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getOferta() {
        return oferta;
    }

    public void setOferta(Integer oferta) {
        this.oferta = oferta;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
}
