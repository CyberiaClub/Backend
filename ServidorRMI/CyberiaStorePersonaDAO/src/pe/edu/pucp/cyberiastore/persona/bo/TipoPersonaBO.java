package pe.edu.pucp.cyberiastore.persona.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.dao.TipoPersonaDAO;
import pe.edu.pucp.cyberiastore.persona.daoImpl.TipoPersonaDAOImpl;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;

public class TipoPersonaBO {

    private TipoPersonaDAO tipoPersona;

    public TipoPersonaBO() {
        tipoPersona = new TipoPersonaDAOImpl();
    }

    public ArrayList<TipoPersona> listarRolesDeTrabajadores() {
        return this.tipoPersona.listarTipoTrabajadores();
    }

    public TipoPersona listarPaginas(String tipo_persona) {
        return this.tipoPersona.listarPaginas(tipo_persona);
    }
}
