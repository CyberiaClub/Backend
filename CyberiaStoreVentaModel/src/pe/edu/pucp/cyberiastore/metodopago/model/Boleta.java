package pe.edu.pucp.cyberiastore.metodopago.model;

import java.util.Date;


public class Boleta extends MetodoDePago{
    private Integer idBoleta;
    private String numeroDeBoleta;
    private Boolean activo;
    
    public Boleta(){
        this.activo = true;
    }
    public Boleta(Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        super(fecha, subtotal, total, igv, descuentoAplicado);
        
    }

    public Integer getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public String getNumeroDeBoleta() {
        return numeroDeBoleta;
    }

    public void setNumeroDeBoleta(String numeroDeBoleta) {
        this.numeroDeBoleta = numeroDeBoleta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public Integer getActivoInt(){
        return this.activo ? 1 : 0;
    }
    
}
