package pe.edu.pucp.cyberiastore.inventario.model;

import java.util.ArrayList;
import java.util.Date;

public class Producto {

    private Integer idProducto;
    private String sku;
    private String nombre;
    private String descripcion;
    private Double precio;
    private byte[] imagen;
    private Date fechaInsercion;
    // Estos ultimos atributos son para el insertar
    private Integer cantidad;
    private ArrayList<Producto> productosMiembros;
    private Integer idMarca;
    private Integer idTipo;
    private Integer idProveedor;
    private Double precioProveedor;
    private Integer idSede;

    public Producto() {
        this.productosMiembros = null;
    }

    public Producto(String sku, String nombre, String descripcion, Double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.productosMiembros = null;
    }

    public Producto(String sku, String nombre, String descripcion, Double precio, ArrayList<Producto> productosMiembros, byte[] imagenBytes) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.productosMiembros = productosMiembros;
        this.imagen = imagenBytes;
    }

    public Producto(Integer idProducto, String sku, String nombre, String descripcion, Double precio, ArrayList<Producto> productoMiembros, byte[] imagenBytes) {
        this.idProducto = idProducto;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.productosMiembros = productoMiembros;
        this.imagen = imagenBytes;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Date getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    /*Usados para el insertar*/
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Producto> getProductosMiembros() {
        return productosMiembros;
    }

    public void setProductosMiembros(ArrayList<Producto> productosMiembros) {
        this.productosMiembros = productosMiembros;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(Double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

}
