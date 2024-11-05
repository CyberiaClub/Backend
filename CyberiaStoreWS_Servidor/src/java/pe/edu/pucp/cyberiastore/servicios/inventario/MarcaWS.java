package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;

@WebService(serviceName = "MarcaWS")
public class MarcaWS {
    
    private final MarcaBO marcaBO;
    private Marca marca;
    
    public MarcaWS(){
        this.marcaBO = new MarcaBO();
    }
    
    @WebMethod(operationName = "marca_insertar")
    public Integer marca_insertar(@WebParam(name = "marca") Marca marca) {
        this.marca = marca;
        return marcaBO.insertar(this.marca);
    }
    
    @WebMethod(operationName = "marca_listar")
    public ArrayList<Marca> marca_listar() {
        return marcaBO.listarTodos();
    }
    
    @WebMethod(operationName = "marca_eliminar")
    public void marca_eliminar(@WebParam(name = "marca") Marca marca) {
        this.marca = marca;
        marcaBO.eliminar(this.marca);
    }
    
}
