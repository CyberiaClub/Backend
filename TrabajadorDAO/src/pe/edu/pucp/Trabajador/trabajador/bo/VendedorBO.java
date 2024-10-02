package pe.edu.pucp.Trabajador.trabajador.bo;

import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.Trabajador.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.VendedorDAOImpl;


public class VendedorBO {
    private VendedorDAO vendedorDAO;
    
    public VendedorBO(){
        this.vendedorDAO = new VendedorDAOImpl();
    }
    
    public Integer insertar(Vendedor administrador){
        TrabajadorBO trabajadorBO = new TrabajadorBO();
        Integer idTrabajador = trabajadorBO.insertar((Trabajador)administrador);
        if(idTrabajador == null){
            return null;
        }
        administrador.setIdTrabajador(idTrabajador);
        Integer idVendedor = this.vendedorDAO.insertar(administrador);
        this.vendedorDAO.insertarIdVendedor(idVendedor);
        return idVendedor;
    }
}
