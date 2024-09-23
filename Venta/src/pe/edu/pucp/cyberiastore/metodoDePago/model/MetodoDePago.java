package pe.edu.pucp.cyberiastore.metodoDePago.model;

import java.util.Date;


public class MetodoDePago {
    private static Integer idMetodoDePago = 0;
    private Date fecha;
    private Double subtotal;
    private Double total;
    private Double igv;
    private Double descuentoAplicado;

    public MetodoDePago(Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.igv = igv;
        this.descuentoAplicado = descuentoAplicado;
    }

    public static Integer getIdMetodoDePago() {
        return idMetodoDePago;
    }

    public static void setIdMetodoDePago(Integer idMetodoDePago) {
        MetodoDePago.idMetodoDePago = idMetodoDePago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(Double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }
    
}
