package pe.edu.pucp.cyberiastore.persona.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;

public interface TipoPersonaDAO {

    public ArrayList<TipoPersona> listarTipoTrabajadores();

    public TipoPersona listarPaginas(String tipo_persona);
}
