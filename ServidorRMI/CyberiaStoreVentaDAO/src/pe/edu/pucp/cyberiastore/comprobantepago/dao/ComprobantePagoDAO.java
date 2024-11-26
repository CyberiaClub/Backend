package pe.edu.pucp.cyberiastore.comprobantepago.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantepago.model.ComprobantePago;

public interface ComprobantePagoDAO {

    public Integer insertar(ComprobantePago comprobantePago);

    public Integer insertar(ComprobantePago comprobantePago, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(ComprobantePago comprobantePago);

    public Integer modificar(ComprobantePago comprobantePago, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(ComprobantePago comprobantePago);

    public Integer eliminar(ComprobantePago comprobantePago, Boolean usarTransaccion, Connection conexion);

    public ArrayList<ComprobantePago> listarTodos();

    public ComprobantePago obtenerPorId(Integer idComprobantePago);

    public Boolean existeComprobantePago(ComprobantePago comprobantePago);

    public ArrayList<ComprobantePago> buscarPorSede(Integer idSede);

    public ArrayList<ComprobantePago> buscarPorUsuario(Integer idUsuario);
}
