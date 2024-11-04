package pe.edu.pucp.cyberiastore.sede.model;

import java.time.LocalTime;

public class Sede {

    private Integer idSede;
    private String descripcion;
    private String nombre;
    private String telefono;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    

    public Sede(){
        
    }
    
    public Sede(String nombre, String descripcion) {
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

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the horarioApertura
     */
    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    /**
     * @param horarioApertura the horarioApertura to set
     */
    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    /**
     * @return the horarioCierre
     */
    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    /**
     * @param horarioCierre the horarioCierre to set
     */
    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

}
