package pe.edu.pucp.cyberiastore.metodoDePago.model;

import java.util.Date;


public class Boleta extends MetodoDePago{
    private Integer numeroDeBoleta = 0;

    public Boleta(Date fecha, Double subtotal, Double total, Double igv, Double descuentoAplicado) {
        super(fecha, subtotal, total, igv, descuentoAplicado);
        this.numeroDeBoleta++;
    }
    
}
