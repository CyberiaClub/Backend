package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.db.DAOImpl;

public class MarcaDAOImpl extends DAOImpl implements MarcaDAO {

    private Marca marca;

    public MarcaDAOImpl() {
        super("MARCA");
        this.marca = null;
    }

    @Override
    public Integer insertar(Marca marca) {
        this.marca = marca;
        return this.insertar();
    }

    @Override
    public Integer modificar(Marca marca) {
        this.marca = marca;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Marca marca) {
        this.marca = marca;
        return this.modificar();
    }
}
