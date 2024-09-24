package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.db.DAOImpl;

public class ProductoDAOImpl extends DAOImpl implements ProductoDAO {

    private Producto producto;

    public ProductoDAOImpl() {
        super("PRODUCTO");
        this.producto = null;
    }

    @Override
    public Integer insertar(Producto producto) {
        this.producto = producto;
        return this.insertar();
    }

    @Override
    public Integer modificar(Producto producto) {
        this.producto = producto;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Producto producto) {
        this.producto = producto;
        return this.modificar();
    }
}
