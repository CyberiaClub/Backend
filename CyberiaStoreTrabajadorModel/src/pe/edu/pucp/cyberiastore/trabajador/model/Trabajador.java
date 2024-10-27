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
    
    /**
     * Este constructor sirve para insertar
     * @param documento
     * @param telefono
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param fechaDeNacimiento
     * @param correo
     * @param direccion
     * @param contrasena
     * @param nacionalidad
     * @param tipoDeDocumento
     * @param sueldo
     * @param fechaDeIngreso
     * @param idSede 
     */
    public Trabajador(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo,
            String direccion, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento, Double sueldo, Date fechaDeIngreso, Integer idSede) {
        super(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento);
        this.sueldo = sueldo;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeSalida = null;// siempre es nulo
        this.idSede = idSede;
    }

    /**
     * Este constructor sirve para modificar
     * @param idTrabajador
     * @param sueldo
     * @param fechaDeIngreso
     * @param documento
     * @param telefono
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param fechaDeNacimiento
     * @param correo
     * @param activo
     * @param contrasena
     * @param nacionalidad
     * @param direccion
     * @param tipoDeDocumento 
     */
    public Trabajador(Integer idTrabajador, Double sueldo, Date fechaDeIngreso, Integer idUsuario,String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(idUsuario,documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.idTrabajador = idTrabajador;
        this.sueldo = sueldo;
        this.fechaDeIngreso = fechaDeIngreso;
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
