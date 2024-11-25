package pe.edu.pucp.cyberiastore.persona.model;

public class TipoPersona {

    private Integer idTipoPersona;
    private String nombre;

    public TipoPersona() {
        this.idTipoPersona = null;
        this.nombre = null;
    }

    public TipoPersona(Integer idTipoPersona, String nombre) {
        this.idTipoPersona = idTipoPersona;
        this.nombre = nombre;
    }

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
