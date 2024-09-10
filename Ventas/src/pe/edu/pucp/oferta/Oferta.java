package pe.edu.pucp.oferta;

import java.util.Date;


public class Oferta {
    private static Integer idOferta = 0;
    private Date fechaDeInicio;
    private Date fechaDeFin;
    private Integer porcentaje;

    public Oferta(Date fechaDeInicio, Date fechaDeFin, Integer porcentaje) {
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFin = fechaDeFin;
        this.porcentaje = porcentaje;
        this.idOferta++;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Date getFechaDeFin() {
        return fechaDeFin;
    }

    public void setFechaDeFin(Date fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
