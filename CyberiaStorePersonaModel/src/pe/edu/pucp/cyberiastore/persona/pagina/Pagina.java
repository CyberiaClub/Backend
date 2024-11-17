package pe.edu.pucp.cyberiastore.persona.pagina;

public class Pagina {

    private Integer idPagina;
    private String nombre;
    private String referencia;

    public Pagina() {
    }

    /**
     * @return the idPagina
     */
    public Integer getIdPagina() {
        return idPagina;
    }

    /**
     * @param idPagina the idPagina to set
     */
    public void setIdPagina(Integer idPagina) {
        this.idPagina = idPagina;
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

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
