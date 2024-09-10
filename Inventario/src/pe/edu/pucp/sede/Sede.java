package pe.edu.pucp.sede;

public class Sede {

    private static Integer idSede = 0;
    private String direccion;
    private String nombre;

    public Sede(String direccion, String nombre) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.idSede++;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
