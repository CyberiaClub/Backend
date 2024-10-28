package pe.edu.pucp.cyberiastore.metodopago.model;

import java.text.SimpleDateFormat;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;
import java.util.Date;


public class ComprobanteDePago {
    private Integer idComprobanteDePago;
    private Date fecha;
    private Double subtotal;
    private Double total;
    private Double igv;
    private Double descuentoAplicado;
    // atributos necesarios para hacer las inserciones en la BD
    private Integer idPedido;
    private Integer idOferta;
    private Boolean activo;
    private Usuario cliente; //Para insertar en tabla intermedia
    
    public ComprobanteDePago(){
        this.igv = 18.0;
        this.idOferta = null;
        this.activo = true;
    }
    
    public ComprobanteDePago(Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.igv = igv;
        this.descuentoAplicado = descuentoAplicado;
        this.activo = true;
        this.idPedido = null;
        this.idOferta = null;
    }

    public Integer getIdComprobanteDePago() {
        return this.idComprobanteDePago;
    }

    public void setIdComprobanteDePago(Integer idComprobanteDePago) {
        this.idComprobanteDePago = idComprobanteDePago;
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

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public Boolean getActivo(){
        return this.activo;
    }

    /**
     * @return the cliente
     */
    public Usuario getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}
