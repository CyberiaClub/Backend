package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.oferta.bo.OfertaBO;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;

@WebService(serviceName = "OfertaWS", targetNamespace = "CyberiaWS")
public class OfertaWS {

    private final OfertaBO ofertaBO;
    private Oferta oferta;

    public OfertaWS() {
        this.ofertaBO = new OfertaBO();
    }

    @WebMethod(operationName = "oferta_insertar")
    public Integer oferta_insertar(@WebParam(name = "oferta") Oferta oferta, @WebParam(name = "productosOferta") ArrayList<Producto> productosOferta) {
        this.oferta = oferta;
        Producto producto;
//        ArrayList<Producto> productosOferta = new ArrayList<Producto>();

//        System.out.println("Longitud del arreglo: " + idProductos.length);

//        for (int j = 0; j < idProductos.length; j++) {
//            producto = new Producto();
//            producto.setIdProducto(idProductos[j]);
//            System.out.println("Id del producto: " + producto.getIdProducto());
//            producto.setOferta(descuentos[j]);
//            System.out.println("oferta: " + producto.getOferta());
//            productosOferta.add(producto);
//        }
        this.oferta.setProductos(productosOferta);

        return ofertaBO.insertar(this.oferta);
    }

    @WebMethod(operationName = "oferta_modificar")
    public Integer oferta_modificar(@WebParam(name = "oferta") Oferta oferta) {
        this.oferta = oferta;
        return ofertaBO.modificar(this.oferta);
    }

    @WebMethod(operationName = "oferta_listar")
    public ArrayList<Oferta> oferta_listar() {
        return ofertaBO.listarTodos();
    }
}
