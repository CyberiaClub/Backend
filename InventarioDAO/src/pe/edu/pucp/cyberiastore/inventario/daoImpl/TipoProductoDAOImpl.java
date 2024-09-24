package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;

public class TipoTipoProductoDAOImpl extends DAOImpl implements TipoProductoDAO {

    private TipoProducto tipoProducto;

    public TipoProductoDAOImpl() {
        super("TIPOPRODUCTO");
        this.tipoProducto = null;
    }

    @Override
    public Integer insertar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this.insertar();
    }

    @Override
    public Integer modificar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this.modificar();
    }

    @Override
    public Integer eliminar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this.modificar();
    }
}
