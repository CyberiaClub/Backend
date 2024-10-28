package pe.edu.pucp.cyberiastore.comprobantedepago.model;

import java.util.Date;


public class Factura extends ComprobanteDePago {
    
    private Integer idFactura;
    private Integer numeroDeFactura;
    private String ruc;
    private String razonSocial;
    private String direccionDeFacturacion;
    private Boolean activo;
    
    public Factura(){
        this.activo = true;
    }
    
    public Factura(String ruc, String razonSocial, String direccionDeFacturacion, Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        super(fecha, subtotal, total, igv, descuentoAplicado);
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccionDeFacturacion = direccionDeFacturacion;
        this.activo = true;
    }

    /**
     * @return the idFactura
     */
    public Integer getIdFactura() {
        return idFactura;
    }

    /**
     * @param idFactura the idFactura to set
     */
    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * @return the numeroDeFactura
     */
    public Integer getNumeroDeFactura() {
        return numeroDeFactura;
    }

    /**
     * @param numeroDeFactura the numeroDeFactura to set
     */
    public void setNumeroDeFactura(Integer numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    /**
     * @return the ruc
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the direccionDeFacturacion
     */
    public String getDireccionDeFacturacion() {
        return direccionDeFacturacion;
    }

    /**
     * @param direccionDeFacturacion the direccionDeFacturacion to set
     */
    public void setDireccionDeFacturacion(String direccionDeFacturacion) {
        this.direccionDeFacturacion = direccionDeFacturacion;
    }
    
    

}
