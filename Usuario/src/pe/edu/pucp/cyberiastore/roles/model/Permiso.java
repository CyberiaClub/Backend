
package pe.edu.pucp.cyberiastore.roles.model;



public class Permiso {
    private static Integer idPermiso = 0;
    private String nombre;

    public Permiso(String nombre) {
        this.nombre = nombre;
        this.idPermiso++;
    }
    
    
    
}
