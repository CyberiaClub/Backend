package pe.edu.pucp.cyberiastore.servicios.inventario;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;

@WebService(serviceName = "TipoProductoWS",targetNamespace = "CyberiaWS")
public class TipoProductoWS {

    private final TipoProductoBO tipoProductoBO;
    private TipoProducto tipoProducto;

    public TipoProductoWS() {
        this.tipoProductoBO = new TipoProductoBO();
    }

    @WebMethod(operationName = "tipoProducto_insertar")
    public Integer tipoProducto_insertar(@WebParam(name = "TipoProducto") TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return tipoProductoBO.insertar(this.tipoProducto);
    }

    @WebMethod(operationName = "tipoProducto_modificar")
    public Integer tipoProducto_modificar(@WebParam(name = "TipoProducto") TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return tipoProductoBO.modificar(this.tipoProducto);
    }

    @WebMethod(operationName = "tipoProducto_listar")
    public ArrayList<TipoProducto> tipoProducto_listar() {
        return tipoProductoBO.listarTodos();
    }

    @WebMethod(operationName = "tipoProducto_eliminar")
    public void tipoProducto_eliminar(@WebParam(name = "TipoProducto") TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        tipoProductoBO.eliminar(this.tipoProducto);
    }
}
