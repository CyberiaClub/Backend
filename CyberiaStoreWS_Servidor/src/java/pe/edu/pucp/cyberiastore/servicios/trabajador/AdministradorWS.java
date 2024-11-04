package pe.edu.pucp.cyberiastore.servicios.trabajador;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.bo.AdministradorBO;

@WebService(serviceName = "AdministradorWS")
public class AdministradorWS {

    private final AdministradorBO administradorBO;
    private Administrador administrador;

    public AdministradorWS() {
        this.administradorBO = new AdministradorBO();
    }

    @WebMethod(operationName = "administrador_insertar")
    public Integer administrador_insertar(@WebParam(name = "administrador") Administrador administrador) {
        this.administrador = administrador;
        return administradorBO.insertar(this.administrador);
    }

    @WebMethod(operationName = "administrador_modificar")
    public Integer administrador_modificar(@WebParam(name = "administrador") Administrador administrador) {
        this.administrador = administrador;
        return administradorBO.modificar(this.administrador);
    }

    @WebMethod(operationName = "administrador_listar")
    public ArrayList<Administrador> administrador_listar() {
        return administradorBO.listarTodos();
    }
}
