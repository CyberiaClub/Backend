package pe.edu.pucp.cyberiastore.trabajador.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

//DEFINIR ESTRUCTURAS DE DATOS
public class Trabajador extends Usuario {

    private Integer idTrabajador;
    private Double sueldo;
    private Date fechaDeIngreso;
    private Date fechaDeSalida;
    private Integer idSede;

    public Trabajador() {
        this.fechaDeSalida = null;// siempre es nulo
    }
    
    public Trabajador(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo,
            String direccion, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento, Double sueldo, Date fechaDeIngreso, Integer idSede){
        super(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento);
        this.sueldo = sueldo;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeSalida = null;// siempre es nulo
        this.idSede = idSede;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public void setFechaDeSalida(Date fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public Date getFechaDeSalida() {
        return fechaDeSalida;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

}
