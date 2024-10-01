package pe.edu.pucp.cyberiastore.metodopago.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.metodopago.model.MetodoDePago;


public interface MetodoDePagoDAO {
    public Integer insertar(MetodoDePago metodoDePago);
    
    public Integer modificar(MetodoDePago metodoDePago);
    
    public Integer eliminar(MetodoDePago metodoDePago);
    
    public ArrayList<MetodoDePago> listar(String sql);
    
    public ArrayList<MetodoDePago> listarTodos();
    
    public MetodoDePago obtenerPorId(String idMetodoDePago);
}
