package pe.edu.pucp.inventario;

import java.util.ArrayList;

public class Producto {
    private Integer sku;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String unidad;
    private ArrayList<Producto> productoMiembros;
    
    public Producto(Integer sku, String nombre, String descripcion, Double precio, String unidad, ArrayList<Producto> productoMiembro) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidad = unidad;
        this.productoMiembros = productoMiembro;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
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
