package pe.edu.pucp.cyberiastore.metodopago.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.metodopago.model.Factura;

public interface FacturaDAO {
    public Integer insertar(Factura factura);
    
    public Integer modificar(Factura factura);
    
    public Integer eliminar(Factura factura);
    
    public ArrayList<Factura> listarFactura(String sql);
    
    public ArrayList<Factura> listarTodosFactura();
    
    public Factura obtenerPorId(String idFactura);
}
