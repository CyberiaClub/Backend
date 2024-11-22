package pe.edu.pucp.cyberiastore.persona.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;

public interface TipoPersonaDAO {

    // Unicamentente vamos a listar todos los tipo de trabajadores
    public ArrayList<TipoPersona> listarTodos();

}
