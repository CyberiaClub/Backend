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

    /**
     * @return the idTipoPersona
     */
    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
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
