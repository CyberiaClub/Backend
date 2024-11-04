package pe.edu.pucp.cyberiastore.servicios.venta;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.comprobantedepago.model.Boleta;
import pe.edu.pucp.cyberiastore.comprobantedepago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.comprobantedepago.daoImpl.BoletaDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;

@WebService(serviceName = "BoletaWS")
public class BoletaWS {

    private final BoletaDAO boletaDAO;
    private Boleta boleta;

    public BoletaWS() {
        this.boletaDAO = new BoletaDAOImpl();
    }

    @WebMethod(operationName = "boleta_insertar")
    public Integer boleta_insertar(@WebParam(name = "numeroBoleta") String numeroBoleta,@WebParam(name = "fecha") Date fecha,@WebParam(name = "subtotal") Double subtotal,
                                    @WebParam(name = "total") Double total,@WebParam(name = "igv") Double igv,
                                    @WebParam(name = "descuentoAplicado") Double descuentoAplicado,@WebParam(name = "cliente") Cliente cliente) {
        this.boleta = new Boleta(numeroBoleta,fecha,subtotal,total,igv,descuentoAplicado);
        this.boleta.setCliente(cliente);
        return boletaDAO.insertar(this.boleta);
    }

    @WebMethod(operationName = "boleta_listar")
    public ArrayList<Boleta> boleta_listar() {
        return boletaDAO.listarTodos();
    }
    
    @WebMethod(operationName = "boleta_eliminar")
    public void boleta_eliminar(@WebParam(name = "idBoleta") Integer idBoleta) {
        this.boleta = new Boleta();
        this.boleta.setIdBoleta(idBoleta);
        boletaDAO.eliminar(this.boleta);
    }
}
