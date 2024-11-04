package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Factura;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.FacturaDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.FacturaDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;

@WebService(serviceName = "FacturaWS")
public class FacturaWS {

    private final FacturaDAO facturaDAO;
    private Factura factura;

    public FacturaWS() {
        this.facturaDAO = new FacturaDAOImpl();
    }

    @WebMethod(operationName = "factura_insertar")
    public Integer factura_insertar(@WebParam(name = "ruc") String ruc, @WebParam(name = "numeroFactura") String numeroFactura,
                                    @WebParam(name = "razonSocial") String razonSocial,@WebParam(name = "direccionFacturacion") String direccionFacturacion,
                                    @WebParam(name = "fecha") Date fecha,@WebParam(name = "subtotal") Double subtotal,
                                    @WebParam(name = "total") Double total,@WebParam(name = "igv") Double igv,
                                    @WebParam(name = "descuentoAplicado") Double descuentoAplicado,@WebParam(name = "cliente") Cliente cliente) {
        this.factura = new Factura(ruc,numeroFactura,razonSocial,direccionFacturacion,fecha,subtotal,total,igv,descuentoAplicado);
        this.factura.setCliente(cliente);
        return facturaDAO.insertar(this.factura);
    }

    @WebMethod(operationName = "factura_listar")
    public ArrayList<Factura> factura_listar() {
        return facturaDAO.listarTodos();
    }
    
    @WebMethod(operationName = "factura_eliminar")
    public void factura_eliminar(@WebParam(name = "idFactura") Integer idFactura) {
        this.factura = new Factura();
        this.factura.setIdFactura(idFactura);
        facturaDAO.eliminar(this.factura);
    }
}
