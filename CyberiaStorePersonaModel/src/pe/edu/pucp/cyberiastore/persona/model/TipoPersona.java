package pe.edu.pucp.cyberiastore.persona.model;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.pagina.Pagina;

public class TipoPersona {

    private Integer idTipoPersona;
    private String nombre;
    private ArrayList<Pagina> paginas;
    public TipoPersona() {
        this.idTipoPersona = null;
        this.nombre = null;
        this.paginas = null;
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

    /**
     * @return the paginas
     */
    public ArrayList<Pagina> getPaginas() {
        return paginas;
    }

    /**
     * @param paginas the paginas to set
     */
    public void setPaginas(ArrayList<Pagina> paginas) {
        this.paginas = paginas;
    }

}
