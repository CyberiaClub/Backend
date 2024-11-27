package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;

public interface MarcaDAO {

    public Integer insertar(Marca marca);

    public Integer modificar(Marca marca);

    public Integer eliminar(Marca marca);

    public ArrayList<Marca> listarTodos();

    public ArrayList<Marca> listarIdNombre();

    public Marca obtenerPorId(Integer idMarca);

    public Boolean existeMarca(Marca marca);

}
