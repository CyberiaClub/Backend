package pe.edu.pucp.cyberiastore.trabajador.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.VendedorDAOImpl;
import pe.edu.pucp.cyberiastore.persona.model.TipoDocumento;


public class VendedorBO {
    private VendedorDAO vendedorDAO;
    
    public VendedorBO(){
        this.vendedorDAO = new VendedorDAOImpl();
    }
    
     public Integer insertar(Vendedor vendedor){
        return this.vendedorDAO.insertar(vendedor);
    }
    
    public Integer modificar(Vendedor vendedor){
        return this.vendedorDAO.modificar(vendedor);
    }

    public Integer eliminar(Vendedor vendedor){
        return this.vendedorDAO.eliminar(vendedor);
    }

    public ArrayList<Vendedor> listarTodos(){
        ArrayList<Vendedor> vendedores = this.vendedorDAO.listarTodos();
        return vendedores;
    }

    public Vendedor obtenerPorId(Integer idVendedor){
        Vendedor vendedor = this.vendedorDAO.obtenerPorId(idVendedor);
        return vendedor;
    }
}
