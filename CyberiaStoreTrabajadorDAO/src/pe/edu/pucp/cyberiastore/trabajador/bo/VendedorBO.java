package pe.edu.pucp.cyberiastore.trabajador.bo;

import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.VendedorDAOImpl;


public class VendedorBO {
    private VendedorDAO vendedorDAO;
    
    public VendedorBO(){
        this.vendedorDAO = new VendedorDAOImpl();
    }
}
