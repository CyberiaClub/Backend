package pe.edu.pucp.cyberiastore.comprobantedepago.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.BoletaDAOImpl;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Boleta;

public class BoletaBO {

    private BoletaDAO boletaDAO;

    public BoletaBO() {
        this.boletaDAO = new BoletaDAOImpl();
    }
     public Integer insertar(Boleta boleta){
        return this.boletaDAO.insertar(boleta);
    }
    
    public Integer modificar(Boleta boleta){
        return this.boletaDAO.modificar(boleta);
    }

    public Integer eliminar(Boleta boleta){
        return this.boletaDAO.eliminar(boleta);
    }

    public ArrayList<Boleta> listarTodos(){
        ArrayList<Boleta> boletaes = this.boletaDAO.listarTodos();
        return boletaes;
    }

    public Boleta obtenerPorId(Integer idBoleta){
        Boleta boleta = this.boletaDAO.obtenerPorId(idBoleta);
        return boleta;
    }
}
