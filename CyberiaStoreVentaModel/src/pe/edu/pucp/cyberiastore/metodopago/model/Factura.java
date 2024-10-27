package pe.edu.pucp.cyberiastore.metodopago.model;

import java.util.Date;


public class Factura extends ComprobanteDePago {
    private Integer numeroDeFactura;
    private String ruc;
    private String razonSocial;
    private String direccionDeFacturacion;

    public Factura(String ruc, String razonSocial, String direccionDeFacturacion, Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        super(fecha, subtotal, total, igv, descuentoAplicado);
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccionDeFacturacion = direccionDeFacturacion;
    }
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccionDeFacturacion() {
        return direccionDeFacturacion;
    }

    public void setDireccionDeFacturacion(String direccionDeFacturacion) {
        this.direccionDeFacturacion = direccionDeFacturacion;
    }

    public Integer getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(Integer numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }
    
}
