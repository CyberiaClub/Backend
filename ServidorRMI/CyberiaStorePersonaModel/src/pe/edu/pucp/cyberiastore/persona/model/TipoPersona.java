package pe.edu.pucp.cyberiastore.persona.model;

import java.io.Serializable;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.pagina.Pagina;

public class TipoPersona implements Serializable {

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

    public ArrayList<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(ArrayList<Pagina> paginas) {
        this.paginas = paginas;
    }

}
