package pe.edu.pucp.cyberiastore.oferta.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Oferta {
    private Integer idOferta ;
    private Date fechaDeInicio;
    private Date fechaDeFin;
    private Integer porcentaje;

    public Oferta(){
        
    }
    
    public Oferta(Date fechaDeInicio, Date fechaDeFin, Integer porcentaje) {
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFin = fechaDeFin;
        this.porcentaje = porcentaje;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
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
    public String getFechaDeInicioAsDDMMYYY(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.fechaDeInicio);
    }
    
    public String getFechaDeFinAsDDMMYYY(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.fechaDeFin);
    }
}
