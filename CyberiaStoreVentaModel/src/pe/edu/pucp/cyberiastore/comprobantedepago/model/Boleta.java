package pe.edu.pucp.cyberiastore.comprobantedepago.model;

import java.util.Date;

public class Boleta extends ComprobanteDePago {

    private Integer idBoleta;
    private Integer numeroDeBoleta;
    private Boolean activo;

    public Boleta() {
        this.activo = true;
    }

    public Boleta(String numeroBoleta, Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        super(fecha, subtotal, total, igv, descuentoAplicado);
        this.numeroDeBoleta = numeroDeBoleta;
    }

    public Integer getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Integer getNumeroDeBoleta() {
        return numeroDeBoleta;
    }

    public void setNumeroDeBoleta(Integer numeroDeBoleta) {
        this.numeroDeBoleta = numeroDeBoleta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getActivoInt() {
        return this.activo ? 1 : 0;
    }
}
