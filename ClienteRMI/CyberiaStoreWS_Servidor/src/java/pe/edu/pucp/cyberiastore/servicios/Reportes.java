package pe.edu.pucp.cyberiastore.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.cyberiastore.db.DBManager;
import pe.edu.pucp.cyberiastore.reportes.ReporteUtil;
import pe.edu.pucp.cyberiastore.servlet.boletaServlet;
import pe.edu.pucp.cyberiastore.servlet.facturaServlet;

@WebService(serviceName = "Reportes")
public class Reportes {

    @WebMethod(operationName = "boleta")
    public byte[] boleta(@WebParam(name = "id_comprobante") Integer id_comprobante) {
        return ReporteUtil.boleta(null, id_comprobante);
    }

    @WebMethod(operationName = "factura")
    public byte[] factura(@WebParam(name = "id_comprobante") Integer id_comprobante) {
        return ReporteUtil.factura(null, id_comprobante);
    }

    @WebMethod(operationName = "reporteClientes")
    public byte[] reporteClientes(@WebParam(name = "id_sede") Integer id_sede) {
        return ReporteUtil.reporteClientes(null, id_sede);
    }

    @WebMethod(operationName = "reporteStock")
    public byte[] reporteStock(@WebParam(name = "id_sede") Integer id_sede) {
        return ReporteUtil.reporteStock(null, id_sede);
    }
}
