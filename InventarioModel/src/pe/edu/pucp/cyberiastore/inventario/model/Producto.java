package pe.edu.pucp.cyberiastore.inventario.model;

import java.util.ArrayList;

public class Producto {
    private Integer idProducto;
    private String sku;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String unidad;
    private ArrayList<Producto> productoMiembros;
    
    public Producto(String sku, String nombre, String descripcion, Double precio, String unidad) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidad = unidad;
        this.productoMiembros = null;
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

}
