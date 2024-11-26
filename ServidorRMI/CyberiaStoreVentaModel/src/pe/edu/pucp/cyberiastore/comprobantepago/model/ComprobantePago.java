package pe.edu.pucp.cyberiastore.comprobantepago.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import java.util.Date;
import pe.edu.pucp.cyberiastore.persona.model.Persona;

public class ComprobantePago implements Serializable {

    private Integer idComprobantePago;
    private Date fecha;
    private Double subtotal;
    private Double igv;
    private Double total;
    private Boolean activo;
    private EstadoPedido estadoPedido;
    private String numero;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private TipoComprobante tipoComprobante;
    private Persona persona;
    private HashMap<Producto, Integer> lineaPedido;

    public ComprobantePago() {
        this.idComprobantePago = null;
        this.fecha = null;
        this.subtotal = null;
        this.igv = null;
        this.total = null;
        this.activo = true;
        this.estadoPedido = null;
        this.numero = null;
        this.ruc = null;
        this.razonSocial = null;
        this.direccion = null;
        this.tipoComprobante = null;
        this.persona = null;
        this.lineaPedido = null;
    }

    public ComprobantePago(Integer idComprobantePago, Date fecha, Double subtotal, Double igv, Double total, Boolean activo, EstadoPedido estadoPedido, String numero, String ruc, String razonSocial, String direccion, TipoComprobante tipoComprobante, Persona persona, HashMap<Producto, Integer> lineaPedido) {
        this.idComprobantePago = idComprobantePago;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.activo = activo;
        this.estadoPedido = estadoPedido;
        this.numero = numero;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.tipoComprobante = tipoComprobante;
        this.persona = persona;
        this.lineaPedido = lineaPedido;
    }

    public Integer getIdComprobantePago() {
        return idComprobantePago;
    }

    public void setIdComprobantePago(Integer idComprobantePago) {
        this.idComprobantePago = idComprobantePago;
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

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoComprobante getTipoComprobante() {
        return this.tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public HashMap<Producto, Integer> getLineaPedido() {
        if (this.lineaPedido == null) {
            return null;
        }
        return (HashMap<Producto, Integer>) lineaPedido.clone();
    }

    public void setLineaPedido(HashMap<Producto, Integer> lineaPedido) {
        this.lineaPedido = lineaPedido;
    }
}
