package pe.edu.pucp.cyberiastore.servicios.usuario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.model.Rol;
import pe.edu.pucp.cyberiastore.rol.bo.RolBO;

@WebService(serviceName = "RolWS")
public class RolWS {
    
    private final RolBO rolBO;
    private Rol rol;
    
    public RolWS(){
        this.rolBO = new RolBO();
    }
    
    @WebMethod(operationName = "rol_insertar")
    public Integer rol_insertar(@WebParam(name = "rol") Rol rol) {
        this.rol = rol;
        return rolBO.insertar(this.rol);
    }
    
    @WebMethod(operationName = "rol_modificar")
    public Integer rol_modificar(@WebParam(name = "rol") Rol rol) {
        this.rol = rol;
        return rolBO.modificar(this.rol);
    }
    
    @WebMethod(operationName = "rol_listar")
    public ArrayList<Rol> rol_listar() {
        return rolBO.listarTodos();
    }
    
    @WebMethod(operationName = "rol_eliminar")
    public void rol_eliminar(@WebParam(name = "rol") Rol rol) {
        this.rol = rol;
        rolBO.eliminar(this.rol);
    }
    
}
