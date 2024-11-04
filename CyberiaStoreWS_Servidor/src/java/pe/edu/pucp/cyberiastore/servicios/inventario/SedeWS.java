package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.sede.bo.SedeBO;

@WebService(serviceName = "SedeWS")
public class SedeWS {
    
    private final SedeBO sedeBO;
    private Sede sede;
    
    public SedeWS(){
        this.sedeBO = new SedeBO();
    }
    
    @WebMethod(operationName = "sede_insertar")
    public Integer sede_insertar(@WebParam(name = "sede") Sede sede) {
        this.sede = sede;
        return sedeBO.insertar(this.sede);
    }
    
    @WebMethod(operationName = "sede_modificar")
    public Integer sede_modificar(@WebParam(name = "sede") Sede sede) {
        this.sede = sede;
        return sedeBO.modificar(this.sede);
    }
    
    @WebMethod(operationName = "sede_listar")
    public ArrayList<Sede> sede_listar() {
        return sedeBO.listarTodos();
    }
    
    @WebMethod(operationName = "sede_buscarIdPorNombre")
    public Integer sede_buscarIdPorNombre(@WebParam(name = "Sede") Sede sede, @WebParam(name = "abreConexion") Boolean abreConexion) {
        this.sede = sede;
        return sedeBO.buscarIdPorNombre(this.sede, abreConexion);
    }
}
