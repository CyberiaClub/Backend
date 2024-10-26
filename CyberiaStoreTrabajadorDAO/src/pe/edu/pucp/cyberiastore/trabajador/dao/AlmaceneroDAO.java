package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;

public interface AlmaceneroDAO {

    public Integer insertar(Almacenero almacenero);

    public Integer modificar(Almacenero almacenero);

    public Integer eliminar(Almacenero almacenero);

    public ArrayList<Almacenero> listarTodos();

    public Almacenero obtenerPorId(Integer idAlmacenero);

    public Boolean existeAlmacenero(Almacenero almacenero);

    public Boolean existeAlmacenero(Almacenero almacenero, Boolean abreConexion);
}
