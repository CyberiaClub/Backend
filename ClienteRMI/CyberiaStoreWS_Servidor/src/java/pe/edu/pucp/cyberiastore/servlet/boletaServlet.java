package pe.edu.pucp.cyberiastore.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.pucp.cyberiastore.reportes.ReporteUtil;

public class boletaServlet extends HttpServlet {

    private static Integer idComprobante;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReporteUtil.boleta(response, getIdComprobante());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public static Integer getIdComprobante() {
        return idComprobante;
    }

    public static void setIdComprobante(Integer idComprobante) {
        boletaServlet.idComprobante = idComprobante;
    }
}
