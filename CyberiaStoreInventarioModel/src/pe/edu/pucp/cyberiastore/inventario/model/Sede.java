package pe.edu.pucp.cyberiastore.inventario.model;

import java.time.LocalTime;
import java.util.Map;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public class Sede {

    private Integer idSede;
    private String nombre;
    private String descripcion;
    private String telefono;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Map<Producto, Integer> stock;

    public Sede(){
        
    }
    
    public Sede(String nombre, String descripcion, byte[] imagenBytes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Integer getIdSede(){
        return this.idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public Map<Producto, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<Producto, Integer> stock) {
        this.stock = stock;
    }

}
