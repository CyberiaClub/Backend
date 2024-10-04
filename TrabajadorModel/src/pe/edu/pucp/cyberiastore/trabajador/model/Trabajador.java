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

    }

    public Trabajador(Double sueldo, Date fechaDeIngreso, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.setActivo(true);
        this.sueldo = sueldo;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeSalida = null; // Siempre nace nulo

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

    public String fechaDeIngresoAsDDMMYYY() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.fechaDeIngreso);
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

}
