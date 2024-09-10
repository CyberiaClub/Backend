package pe.edu.pucp.inventario;

public class Marca {

    private static Integer idMarca = 0;
    private String nombre;

    public Marca(String nombre) {
        this.nombre = nombre;
        this.idMarca++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
