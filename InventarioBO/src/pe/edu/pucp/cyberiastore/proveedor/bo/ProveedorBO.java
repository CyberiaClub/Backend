package pe.edu.pucp.cyberiastore.proveedor.bo;

import java.util.Date;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;

public class ProveedorBO {
    ProveedorDAO proveedorDAO;
    
    public ProveedorBO(){
        this.proveedorDAO = new ProveedorDAOImpl();
    }
    
    public Integer insertar(String ruc, String nombre, Date fechaRegistro){
        Proveedor proveedor = new Proveedor(ruc, nombre, fechaRegistro);
        return this.proveedorDAO.insertar(proveedor);
    }
    
    public Integer modificar(String ruc, String nombre, Date fechaRegistro){
        Proveedor proveedor = new Proveedor(ruc, nombre, fechaRegistro);
        return this.proveedorDAO.modificar(proveedor);
    }
    
    public Integer eliminar(String ruc, String nombre, Date fechaRegistro){
        Proveedor proveedor = new Proveedor(ruc, nombre, fechaRegistro);
        return this.proveedorDAO.eliminar(proveedor);
    }
    
}
