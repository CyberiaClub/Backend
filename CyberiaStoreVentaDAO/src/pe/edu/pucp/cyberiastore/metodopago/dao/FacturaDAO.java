package pe.edu.pucp.cyberiastore.metodopago.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.metodopago.model.Factura;

public interface FacturaDAO {

    public Integer insertar(Factura factura);

    public Integer modificar(Factura factura);

    public Integer eliminar(Factura factura);

    public ArrayList<Factura> listarTodos();

    public Factura obtenerPorId(Integer idFactura);

    public Boolean existeFactura(Factura factura);

    public Boolean existeFactura(Factura factura, Boolean abreConexion);
}
