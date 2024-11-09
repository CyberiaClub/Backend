package pe.edu.pucp.cyberiastore.oferta.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Oferta {
    private Integer idOferta ;
    private Date fechaDeInicio;
    private Date fechaDeFin;
    private Integer porcentaje;
    private byte[] imagen;
    private Integer idProducto; //Para la tabla intermedia

    public Oferta(){
        
    }
    
    public Oferta(Date fechaDeInicio, Date fechaDeFin, Integer porcentaje, byte[] imagenBytes) {
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFin = fechaDeFin;
        this.porcentaje = porcentaje;
        this.imagen = imagenBytes;
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

    /**
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
