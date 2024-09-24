package pe.edu.pucp.cyberiastore.sede.daoImpl;

import pe.edu.pucp.cyberiastore.sede.model.Empresa;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.EmpresaDAO;

public class EmpresaDAOImpl extends DAOImpl implements EmpresaDAO{
    private Empresa empresa;

    public EmpresaDAOImpl() {
        super("EMPRESA");
        this.empresa = null;
    }

    @Override
    public Integer insertar(Empresa empresa) {
        this.empresa = empresa;
        return this.insertar();
    }

    @Override
    public Integer modificar(Empresa empresa) {
        this.empresa = empresa;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Empresa empresa) {
        this.empresa = empresa;
        return this.modificar();
    }
}
