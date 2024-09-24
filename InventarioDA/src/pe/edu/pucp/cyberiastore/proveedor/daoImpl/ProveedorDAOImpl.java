package pe.edu.pucp.cyberiastore.proveedor.daoImpl;

import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;

public class ProveedorDAOImpl extends DAOImpl implements ProveedorDAO{
    private Proveedor proveedor;

    public ProveedorDAOImpl() {
        super("PROVEEDOR");
        this.proveedor = null;
    }

    @Override
    public Integer insertar(Proveedor proveedor) {
        this.proveedor = proveedor;
        return this.insertar();
    }

    @Override
    public Integer modificar(Proveedor proveedor) {
        this.proveedor = proveedor;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Proveedor proveedor) {
        this.proveedor = proveedor;
        return this.modificar();
    }
}
