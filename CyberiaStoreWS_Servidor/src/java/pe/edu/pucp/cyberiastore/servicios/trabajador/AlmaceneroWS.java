package pe.edu.pucp.cyberiastore.servicios.trabajador;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.trabajador.bo.AlmaceneroBO;

@WebService(serviceName = "AlmaceneroWS")
public class AlmaceneroWS {

    private final AlmaceneroBO almaceneroBO;
    private Almacenero almacenero;

    public AlmaceneroWS() {
        this.almaceneroBO = new AlmaceneroBO();
    }

    @WebMethod(operationName = "almacenero_insertar")
    public Integer almacenero_insertar(@WebParam(name = "almacenero") Almacenero almacenero) {
        this.almacenero = almacenero;
        return almaceneroBO.insertar(this.almacenero);
    }

    @WebMethod(operationName = "almacenero_modificar")
    public Integer almacenero_modificar(@WebParam(name = "almacenero") Almacenero almacenero) {
        this.almacenero = almacenero;
        return almaceneroBO.modificar(this.almacenero);
    }

    @WebMethod(operationName = "almacenero_listar")
    public ArrayList<Almacenero> almacenero_listar() {
        return almaceneroBO.listarTodos();
    }
}
