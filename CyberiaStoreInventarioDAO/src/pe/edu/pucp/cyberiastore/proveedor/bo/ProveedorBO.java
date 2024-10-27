package pe.edu.pucp.cyberiastore.proveedor.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;

public class ProveedorBO {
    ProveedorDAO proveedorDAO;
    
    public ProveedorBO(){
        this.proveedorDAO = new ProveedorDAOImpl();
    }
}
