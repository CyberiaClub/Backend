package pe.edu.pucp.cyberiastore.metodopago.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.metodopago.model.Boleta;

public interface BoletaDAO {

    public Integer insertar(Boleta boleta);

    public Integer modificar(Boleta boleta);

    public Integer eliminar(Boleta boleta);

    public ArrayList<Boleta> listarTodos();

    public Boleta obtenerPorId(Integer idBoleta);

    public Boolean existeBoleta(Boleta boleta);

    public Boolean existeBoleta(Boleta boleta, Boolean abreConexion);
}
