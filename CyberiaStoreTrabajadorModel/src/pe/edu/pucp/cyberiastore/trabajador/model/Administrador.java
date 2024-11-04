package pe.edu.pucp.cyberiastore.trabajador.model;

import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class Administrador extends Trabajador {

    private Integer idAdministrador;

    public Administrador() {

    }

    public Administrador(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno,char sexo, Date fechaDeNacimiento, String correo,
            String direccion, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento, Double sueldo, Date fechaDeIngreso, Integer idSede) {
        super(documento, telefono, nombre, apellidoPaterno, apellidoMaterno,sexo, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento, sueldo, fechaDeIngreso, idSede);
    }

    /**
     * Este constructor usarlo unicamente para las modificaciones
     *
     * @param idAdministrador
     * @param idTrabajador
     * @param sueldo
     * @param fechaDeIngreso
     * @param idUsuario
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
    public Administrador(Integer idAdministrador, Integer idTrabajador, Double sueldo, Date fechaDeIngreso, Integer idUsuario, String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno,char sexo, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(idTrabajador, sueldo, fechaDeIngreso, idUsuario, documento, telefono, nombre, apellidoPaterno, apellidoMaterno,sexo, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.idAdministrador = idAdministrador;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
