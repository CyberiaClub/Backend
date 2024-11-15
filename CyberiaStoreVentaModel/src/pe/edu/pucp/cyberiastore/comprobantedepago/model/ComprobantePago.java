package pe.edu.pucp.cyberiastore.comprobantedepago.model;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import java.util.Date;

public class ComprobantePago {
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
    private Cliente cliente;
    private HashMap<Producto,Integer> lineaPedido;

    public ComprobantePago(){
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
        this.cliente = null;
        this.lineaPedido = null;
    }

    public ComprobantePago(Integer idComprobantePago, Date fecha, Double subtotal, Double igv, Double total, Boolean activo, EstadoPedido estadoPedido, String numero, String ruc, String razonSocial, String direccion, TipoComprobante tipoComprobante, Cliente cliente, HashMap<Producto,Integer> lineaPedido){
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
        this.cliente = cliente;
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
        return new TipoComprobante(this.tipoComprobante.getIdTipoComprobante(),
                                   this.tipoComprobante.getSecuencial(),
                                   this.tipoComprobante.getTipoComprobante(),
                                   this.tipoComprobante.getActivo());
    }
    
    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public HashMap<Producto,Integer> getLineaPedido() {
        return (HashMap<Producto,Integer>)lineaPedido.clone();
    }
    
    public void setLineaPedido(HashMap<Producto,Integer> lineaPedido) {
        this.lineaPedido = lineaPedido;
    }
}
