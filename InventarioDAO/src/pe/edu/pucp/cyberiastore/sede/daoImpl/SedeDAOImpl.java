package pe.edu.pucp.cyberiastore.sede.daoImpl;

import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;

public class SedeDAOImpl extends DAOImpl implements SedeDAO{
    private Sede sede;

    public SedeDAOImpl() {
        super("SEDE");
        this.sede = null;
    }

    @Override
    public Integer insertar(Sede sede) {
        this.sede = sede;
        return this.insertar();
    }

    @Override
    public Integer modificar(Sede sede) {
        this.sede = sede;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Sede sede) {
        this.sede = sede;
        return this.modificar();
    }
}
