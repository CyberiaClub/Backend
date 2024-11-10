package pe.edu.pucp.cyberiastore.usuario.model;

import java.util.Date;

public class Cliente extends Usuario {

    private Integer idCliente;
    private Boolean verificado;

    /*Constructor vacio*/
    public Cliente() {
        this.verificado = false;
        this.setActivo(true);
    }

    public Cliente(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, Date fechaDeNacimiento, String correo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento, Rol rol) {
        super(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, sexo, fechaDeNacimiento, correo, contrasena, nacionalidad, direccion, tipoDeDocumento, rol);
        this.verificado = false;
    }

    /**
     * Este es un constructor que se uso para el modificar
     *
     * @param idCliente
     * @param verificado
     * @param idUsuario
     * @param documento
     * @param telefono
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param sexo
     * @param fechaDeNacimiento
     * @param correo
     * @param activo
     * @param contrasena
     * @param nacionalidad
     * @param direccion
     * @param tipoDeDocumento
     * @param rol
     */
    public Cliente(Integer idCliente, Boolean verificado, Integer idUsuario, String documento, String telefono, String nombre,
            String apellidoPaterno, String apellidoMaterno, char sexo, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena,
            String nacionalidad, String direccion, TipoDocumento tipoDeDocumento, Rol rol) {
        super(idUsuario, documento, telefono, nombre, apellidoPaterno, apellidoMaterno, sexo, fechaDeNacimiento,
                correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento, rol);
        this.idCliente = idCliente;
        this.verificado = verificado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }
}
