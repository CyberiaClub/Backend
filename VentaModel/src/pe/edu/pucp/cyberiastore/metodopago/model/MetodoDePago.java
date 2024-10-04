package pe.edu.pucp.cyberiastore.metodopago.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MetodoDePago {
    private Integer idMetodoDePago;
    private Date fecha;
    private Double subtotal;
    private Double total;
    private Double igv;
    private Double descuentoAplicado;
    // atributos necesarios para hacer las inserciones en la BD
    private Integer idPedido;
    private Integer idOferta;
    private Boolean activo;
    public MetodoDePago(){
        this.igv = 18.0;
        this.idOferta = null;
        this.activo = true;
    }
    
    public MetodoDePago(Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.igv = igv;
        this.descuentoAplicado = descuentoAplicado;
        this.activo = true;
        this.idPedido = null;
        this.idOferta = null;
    }

    public Integer getIdMetodoDePago() {
        return this.idMetodoDePago;
    }

    public void setIdMetodoDePago(Integer idMetodoDePago) {
        this.idMetodoDePago = idMetodoDePago;
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
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer id_pedido) {
        this.idPedido = id_pedido;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer id_oferta) {
        this.idOferta = id_oferta;
    }
    public String getFechaAsDDMMYYY(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.fecha);
    }
    public Integer getActivoInt(){
        return this.activo ? 1 : 0;
    }
}
