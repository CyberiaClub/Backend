package pe.edu.pucp.cyberiastore.roles.model;

import java.util.HashSet;
import java.util.Set;



public class Roles {
    private Integer idRol;
    private String nombre;
    private final Set<String> permisos;

    public Roles(Integer idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.permisos = new HashSet<>();
    }

    /**
     * @return the idRol
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
