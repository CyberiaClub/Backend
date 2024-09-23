package pe.edu.pucp.cyberiastore.rol.model;

import java.util.ArrayList;

public class Rol {
    private Integer idRol;
    private String nombre;
    private ArrayList<Permiso> permisos;

    public Rol(Integer idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.permisos = new ArrayList<Permiso>();
    }
    
    public Integer getIdRol() {
        return idRol;
    }
    
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarPermiso(Permiso permiso){
        this.permisos.add(permiso);
    }
    
    public int getCantidadPermisos(){
        return this.permisos.size();
    }
    
    public Permiso getPermiso(int index){
        return new Permiso(permisos.get(index).getIdPermiso(),permisos.get(index).getNombre(),permisos.get(index).getDescripcion());
    }
}