package pe.edu.pucp.cyberiastore.comprobantedepago.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.FacturaDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.FacturaDAOImpl;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Factura;

public class FacturaBO {

    private FacturaDAO facturaDAO;

    public FacturaBO() {
        this.facturaDAO = new FacturaDAOImpl();
    }
     public Integer insertar(Factura factura){
        return this.facturaDAO.insertar(factura);
    }
    
    public Integer modificar(Factura factura){
        return this.facturaDAO.modificar(factura);
    }

    public Integer eliminar(Factura factura){
        return this.facturaDAO.eliminar(factura);
    }

    public ArrayList<Factura> listarTodos(){
        ArrayList<Factura> facturaes = this.facturaDAO.listarTodos();
        return facturaes;
    }

    public Factura obtenerPorId(Integer idFactura){
        Factura factura = this.facturaDAO.obtenerPorId(idFactura);
        return factura;
    }
}
