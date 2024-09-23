package pe.edu.pucp.cyberiastore.trabajador.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
//import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

//DEFINIR ESTRUCTURAS DE DATOS

public class Trabajador extends Usuario {
    private static Integer idTrabajador = 0;
    private Double sueldo;
    private Date fechaDeIngreso;
    private Date fechaDeSalida;

    public Trabajador(Double sueldo, Date fechaDeIngreso, Date fechaDeSalida) {
        super(documento, telefono, nombre, apellidoPaterno, apelldioMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, tipoDeDocumento);
        this.sueldo = sueldo;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeSalida = fechaDeSalida;
        this.idTrabajador++;
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

    public Date getFechaDeSalida() {
        return fechaDeSalida;
    }
}