package pe.edu.pucp.cyberiastore.servicios.usuario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.model.Rol;
import pe.edu.pucp.cyberiastore.rol.bo.RolBO;

@WebService(serviceName = "RolWS",targetNamespace = "CyberiaWS")
public class RolWS {
    
    private final RolBO rolBO;
    private Rol rol;
    
    public RolWS(){
        this.rolBO = new RolBO();
    }
    
    @WebMethod(operationName = "rol_listar")
    public ArrayList<Rol> rol_listar() {
        return rolBO.listarTodos();
    }
    
}
