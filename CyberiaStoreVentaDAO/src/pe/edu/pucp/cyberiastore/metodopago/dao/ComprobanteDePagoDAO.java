package pe.edu.pucp.cyberiastore.metodopago.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.metodopago.model.ComprobanteDePago;

public interface ComprobanteDePagoDAO {

    public Integer insertar(ComprobanteDePago comprobanteDePago);

    public Integer insertar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(ComprobanteDePago comprobanteDePago);

    public Integer modificar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(ComprobanteDePago comprobanteDePago);

    public Integer eliminar(ComprobanteDePago comprobanteDePago, Boolean usarTransaccion, Connection conexion);

    public ArrayList<ComprobanteDePago> listarTodos();

    public ComprobanteDePago obtenerPorId(Integer idComprobanteDePago);

    public Boolean existeComprobanteDePago(ComprobanteDePago comprobanteDePago);
}
