package pe.edu.pucp.cyberiastore.metodopago.model;

import java.util.Date;


public class MetodoDePago {
    private static Integer idMetodoDePago = 0;
    private Date fecha;
    private Double subtotal;
    private Double total;
    private Double igv;
    private Double descuentoAplicado;
    // atributos necesarios para hacer las inserciones en la BD
    private Integer id_pedido;
    private Integer id_oferta;

    public MetodoDePago(Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.igv = igv;
        this.descuentoAplicado = descuentoAplicado;
        this.id_pedido = null;
        this.id_oferta = null;
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

    // Valores necesarios para la insercion de la tabla METODO_PAGO
    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(Integer id_oferta) {
        this.id_oferta = id_oferta;
    }
    
}
