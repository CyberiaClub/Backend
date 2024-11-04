package pe.edu.pucp.cyberiastore.oferta.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;




public interface OfertaDAO {
   public Integer insertar(Oferta oferta);

    public Integer modificar(Oferta oferta);

    public Integer eliminar(Oferta oferta);

    public ArrayList<Oferta> listarTodos();

    public Oferta obtenerPorId(Integer idOferta);

    public Boolean existeOferta(Oferta oferta);

    public Boolean existeOferta(Oferta oferta, Boolean abreConexion);
    
}
