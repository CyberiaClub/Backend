package pe.edu.pucp.cyberiastore.inventario.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Producto {

    private Integer idProducto;
    private String sku;
    private String nombre;
    private String descripcion;
    private Double precio;
    // Estos 2 ultimos atributos son para el insertar
    private Integer cantidad;
    private ArrayList<Producto> productosMiembros;

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

    public Producto(String sku, String nombre, String descripcion, Double precio, ArrayList<Producto> productosMiembros) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.productosMiembros = productosMiembros;
    }

    public Producto(Integer idProducto, String sku, String nombre, String descripcion, Double precio, ArrayList<Producto> productoMiembros) {
        this.idProducto = idProducto;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.productosMiembros = productoMiembros;
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

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Producto> getProductosMiembros() {
        return productosMiembros;
    }

    public void setProductosMiembros(ArrayList<Producto> productosMiembros) {
        this.productosMiembros = productosMiembros;
    }

}
