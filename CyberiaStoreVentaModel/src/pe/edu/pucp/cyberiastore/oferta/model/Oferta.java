package pe.edu.pucp.cyberiastore.oferta.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;


public class Oferta {
    private Integer idOferta ;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer porcentaje;
    private byte[] imagen;
    private ArrayList<Producto> productos;

    public Oferta(){
        this.idOferta = null;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.porcentaje = null;
        this.porcentaje = null;
        this.imagen = null;
        this.productos = null;
    }
    
    public Oferta(Integer idOferta, Date fechaInicio, Date fechaFin, Integer porcentaje, byte[] imagen, ArrayList<Producto> productos) {
        this.idOferta = idOferta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.porcentaje = porcentaje;
        this.imagen = imagen;
        this.productos = productos;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }
    
    public Date getFechaDeInicio() {
        return fechaInicio;
    }

    public void setFechaDeInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaDeFin() {
        return fechaFin;
    }

    public void setFechaDeFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }
    public String getFechaInicioAsDDMMYYY(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.fechaInicio);
    }
    
    public String getFechaFinAsDDMMYYY(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.fechaFin);
    }
    public ArrayList<Producto> getProductos(){
        return (ArrayList<Producto>)this.productos.clone();
    }
    
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    public byte[] getImagen() {
        return imagen;
    }
    
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
